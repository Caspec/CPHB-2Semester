package data;

import domain.entity.Borrower;
import domain.exception.BorrowerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BorrowerMapper {

    public Borrower getBorrower(int id) throws BorrowerException {
        Borrower borrower = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT borrower_ssn, borrower_name, borrower_address, borrower_phone, borrower_mail, borrower_library_status FROM borrower WHERE borrower_ssn = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int borrower_ssn = rs.getInt("borrower_ssn");
                String borrower_name = rs.getString("borrower_name");
                String borrower_address = rs.getString("borrower_address");
                int borrower_phone = rs.getInt("borrower_phone");
                String borrower_mail = rs.getString("borrower_mail");
                boolean borrower_status = rs.getBoolean("borrower_library_status");
                borrower = new Borrower(borrower_ssn, borrower_name, borrower_address, borrower_phone, borrower_mail, borrower_status);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new BorrowerException("Error in getBorrower() " +ex.getMessage());
        }

        return borrower;
    }
    
    public ArrayList<Borrower> getAllBorrowers() throws BorrowerException 
    {
        Borrower borrower = null;
        ArrayList<Borrower> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM borrower";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                int borrower_ssn = rs.getInt("borrower_ssn");
                String borrower_name = rs.getString("borrower_name");
                String borrower_address = rs.getString("borrower_address");
                int borrower_phone = rs.getInt("borrower_phone");
                String borrower_mail = rs.getString("borrower_mail");
                boolean borrower_status = rs.getBoolean("borrower_library_status");
                borrower = new Borrower(borrower_ssn, borrower_name, borrower_address, borrower_phone, borrower_mail, borrower_status);
                al.add(borrower);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new BorrowerException("Error in getAllBorrower() " +ex.getMessage());
        }
        
        return al;
    }
    
    public void createNewUser(int SSN, String name, String address, int phone, String mail) throws BorrowerException
    {
        BorrowerMapper borrower = new BorrowerMapper();
       
            Connection conn = new DB().getConnection();
            try
            {
                //Starter transaktion
                String ins_borrower = "INSERT INTO borrower (borrower_ssn, borrower_name, borrower_address, borrower_phone, borrower_mail, borrower_library_status) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement borrowerStmt = conn.prepareStatement(ins_borrower);

                //Transaction
                conn.setAutoCommit(false);
                //Book reserve
                borrowerStmt.setInt(1, SSN);
                borrowerStmt.setString(2, name);
                borrowerStmt.setString(3, address);
                borrowerStmt.setInt(4, phone);
                borrowerStmt.setString(5, mail);
                borrowerStmt.setBoolean(6, true);
                borrowerStmt.executeUpdate();

                conn.commit();
            } catch (SQLException ex)
            {
                ex.printStackTrace();
                try
                {
                    conn.rollback();
                } catch (SQLException ex1)
                {
                    ex1.printStackTrace();
                    throw new BorrowerException("Error in createNewUser " + ex1.getMessage());
                }
            }
    }
    
    public Borrower login(String name, int SSN) throws BorrowerException {
        Borrower borrower = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM borrower WHERE borrower_name = ? AND borrower_ssn = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, SSN);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int borrower_ssn = rs.getInt("borrower_ssn");
                String borrower_name = rs.getString("borrower_name");
                String borrower_address = rs.getString("borrower_address");
                int borrower_phone = rs.getInt("borrower_phone");
                String borrower_mail = rs.getString("borrower_mail");
                boolean borrower_status = rs.getBoolean("borrower_library_status");
                borrower = new Borrower(borrower_ssn, borrower_name, borrower_address, borrower_phone, borrower_mail, borrower_status);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new BorrowerException("Error in getBorrower() " +ex.getMessage());
        }

        return borrower;
    }
    
    public static void main(String[] args) throws BorrowerException {
        Borrower borrower = new BorrowerMapper().getBorrower(1111);
        System.out.println(borrower);
        ArrayList<Borrower> borrower2 = new BorrowerMapper().getAllBorrowers();
        System.out.println(borrower2);
    }
}
