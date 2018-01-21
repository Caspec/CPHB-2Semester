package domain.entity;


public class User {

    private int id;
    private String name;
    private String password;
    private String email;
    private String adress;
    private String phone;
    private int zip;
    private String img;
    private int role;
    private int department;

    
    public User(int id, String name, String password, String email, String adress, String phone, int zip, String img, int role, int department)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.phone = phone;
        this.zip = zip;
        this.img = img;
        this.role = role;
        this.department = department;
    }

    public User()
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public int getZip()
    {
        return zip;
    }

    public void setZip(int zip)
    {
        this.zip = zip;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }

    public int getDepartment()
    {
        return department;
    }

    public void setDepartment(int department)
    {
        this.department = department;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", adress=" + adress + ", phone=" + phone + ", zip=" + zip + ", img=" + img + ", role=" + role + ", department=" + department + '}';
    }

    
   

}
