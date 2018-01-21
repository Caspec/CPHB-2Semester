package data;

import domain.entity.User;
import domain.exception.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper {

    // Get one user, used in "visbruger.jsp"
    public User getUser(int id) throws UserException {
        User user = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_name = rs.getString("user_name");
                String user_password = rs.getString("user_password");
                String user_email = rs.getString("user_email");
                String user_adress = rs.getString("user_adress");
                String user_phone = rs.getString("user_phone");
                int user_zip = rs.getInt("user_zip");
                String user_img = rs.getString("user_img");
                int FK_role_id = rs.getInt("FK_role_id");
                int FK_department_id = rs.getInt("FK_Department_id");
                user = new User(user_id, user_name, user_password, user_email, user_adress, user_phone, user_zip, user_img, FK_role_id, FK_department_id);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new UserException("Error in getUser() " + ex.getMessage());
        }

        return user;
    }

    /**
     * This method is used in step-wizard. Used in ControlInsertUserData
     *
     * @param email paramter
     * @return returns a user
     * @throws domain.exception.UserException
     */
    public User getUserByEmail(String email) throws UserException {
        User user = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User WHERE user_email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_name = rs.getString("user_name");
                String user_password = rs.getString("user_password");
                String user_email = rs.getString("user_email");
                String user_adress = rs.getString("user_adress");
                String user_phone = rs.getString("user_phone");
                int user_zip = rs.getInt("user_zip");
                String user_img = rs.getString("user_img");
                int FK_role_id = rs.getInt("FK_role_id");
                int FK_department_id = rs.getInt("FK_Department_id");
                user = new User(user_id, user_name, user_password, user_email, user_adress, user_phone, user_zip, user_img, FK_role_id, FK_department_id);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new UserException("Error in getUser() " + ex.getMessage());
        }

        return user;
    }

    // getUserByZipCode for jtest
    public User getZip(int Zip) throws UserException {
        User user = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User WHERE User_zip = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Zip);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_name = rs.getString("user_name");
                String user_password = rs.getString("user_password");
                String user_email = rs.getString("user_email");
                String user_adress = rs.getString("user_adress");
                String user_phone = rs.getString("user_phone");
                int user_zip = rs.getInt("user_zip");
                String user_img = rs.getString("user_img");
                int FK_role_id = rs.getInt("FK_role_id");
                int FK_department_id = rs.getInt("FK_Department_id");
                user = new User(user_id, user_name, user_password, user_email, user_adress, user_phone, user_zip, user_img, FK_role_id, FK_department_id);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new UserException("Error in getZip() " + ex.getMessage());
        }

        return user;
    }

    /**
     * This method is used in the login form at login.jsp
     *
     * @param email paramter
     * @param password
     * @return returns a user
     * @throws domain.exception.UserException
     */
    public User login(String email, String password) throws UserException {
        User user = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User WHERE user_email = ? AND user_password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_name = rs.getString("user_name");
                String user_password = rs.getString("user_password");
                String user_email = rs.getString("user_email");
                String user_adress = rs.getString("user_adress");
                String user_phone = rs.getString("user_phone");
                int user_zip = rs.getInt("user_zip");
                String user_img = rs.getString("user_img");
                int FK_role_id = rs.getInt("FK_role_id");
                int FK_department_id = rs.getInt("FK_Department_id");
                user = new User(user_id, user_name, user_password, user_email, user_adress, user_phone, user_zip, user_img, FK_role_id, FK_department_id);
            } else {
                throw new UserException("Du har indtastet et forkert navn eller password!!!!");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new UserException("Du har indtastet et forkert navn eller password.");
        }

        return user;
    }

    // Insert a new user, used in ControlInsertUserData
    public void insertNewUser(String name, String email, String adress, String phone, int zip) throws UserException {

        try {
            Connection conn = new DB().getConnection();
            String sql = "INSERT INTO `fogdb`.`User` (`User_name`,`User_img`,`FK_role_id`,`FK_Department_id`,`User_email`,`User_adress`,`User_phone`,`User_zip`,`User_password`) VALUES (?, 'noimgperson.png', '1', '1', ?, ?, ?, ?, '1234')";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, adress);
            pstmt.setString(4, phone);
            pstmt.setInt(5, zip);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new UserException("Error in getUser() " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws UserException {
        User user = new UserMapper().getUser(1);
        System.out.println(user);
    }
}
