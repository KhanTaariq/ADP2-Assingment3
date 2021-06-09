package za.ac.cput.assignment3;
/**Header1.java
 * This is header1 worker class
 *Date 9 June 2021
 * @author Taariq Khan (219231141)
 */
public class Header1
    {
    private String ID;
    private String Name;
    private String ProdType;
    private String ProdDescription;
    
        public Header1()
        {
            
        }

        public Header1(String ID, String Name, String ProdType, String ProdDescription)
        {
            this.ID = ID;
            this.Name = Name;
            this.ProdType = ProdType;
            this.ProdDescription = ProdDescription;
        }

        public String getID()
        {
            return ID;
        }

        public String getName()
        {
            return Name;
        }

        public String getProdType()
        {
            return ProdType;
        }

        public String getProdDescription()
        {
            return ProdDescription;
        }

        public void setID(String ID)
        {
            this.ID = ID;
        }

        public void setName(String Name)
        {
            this.Name = Name;
        }

        public void setProdType(String ProdType)
        {
            this.ProdType = ProdType;
        }

        public void setProdDescription(String ProdDescription)
        {
            this.ProdDescription = ProdDescription;
        }

        @Override
        public String toString()
        {
             return String.format("%-5s\t%-20s\t%-10s\t%-15s",getID(),getName(),getProdType(),getProdDescription());
        }
        
    }
