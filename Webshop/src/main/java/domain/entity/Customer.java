package domain.entity;


public class Customer {

    private int id;
    private String name;
    private String password;
    private int role;
    private double balance;

    public Customer(int id, String name, String password, int role, double balance)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public Customer()
    {
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }

    public double getBalance()
    {
        return balance;
    }


    
    
    @Override
    public String toString()
    {
        return "Name: " + name + ", Password: " + password + ", Balance: " + balance; 
    }

}
