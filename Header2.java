package za.ac.cput.assignment3;
/**Header2.java
 * This is header2 worker class
 *Date 9 June 2021
 * @author Taariq Khan (219231141)
 */
public class Header2
{
    private String ID;
    private String Name;
    private String Surname;
    private String DateOfBirth;
    private String Age;

    public Header2(String ID, String Name, String Surname, String Dateofbirth, String Age)
    {
        this.ID = ID;
        this.Name = Name;
        this.Surname = Surname;
        this.DateOfBirth = Dateofbirth;
        this.Age = Age;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getSurname()
    {
        return Surname;
    }

    public void setSurname(String Surname)
    {
        this.Surname = Surname;
    }

    public String getDateofbirth()
    {
        return DateOfBirth;
    }

    public void setDateofbirth(String Dateofbirth)
    {
        this.DateOfBirth = Dateofbirth;
    }

    public String getAge()
    {
        return Age;
    }

    public void setAge(String Age)
    {
        this.Age = Age;
    }

    @Override
    public String toString()
    {
        return String.format("%-10s\t%-10s\t%-10s\t%-15s\t%-10s", getID(), getName(),
                getSurname(), getDateofbirth(), getAge());
    }
    
}
