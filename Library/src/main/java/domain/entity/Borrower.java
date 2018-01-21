package domain.entity;


public class Borrower {

    private int ssn;
    private String name;
    private String address;
    private int phone;
    private String mail;
    private boolean status;

    public Borrower(int ssn, String name, String address, int phone, String mail, boolean status)
    {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
    }



    public Borrower() {
    }

    public int getSsn()
    {
        return ssn;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Navn: " + name + ", SSN: " + ssn + ", Adresse: " + address + ", Telefon: " + phone + ", Mail: " + mail + ", Status: " + status; 
    }
    
    

    
    
}
