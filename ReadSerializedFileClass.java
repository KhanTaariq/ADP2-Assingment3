
package za.ac.cput.assignment3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
/**ReadSerialziedFile.java
 * Contains methods and calls methods in static main Run class
 *Date 9 June 2021
 * @author Taariq Khan (219231141)
 */
public class ReadSerializedFileClass extends Stakeholder
{
    private ObjectInputStream input;
    Stakeholder stakeholder;
    Stakeholder [] stakeholderArray = new Stakeholder[12];
    
    Customer[] customers = new Customer[6];
    int numberOfCustomers = 0;
    Supplier[] suppliers = new Supplier[5];
    int numberOfSuppliers = 0;
    Header1 [] header1 = new Header1[1];
    int numberOfheader = 0;
    Header2 [] header2 = new Header2[1];
    int numberOfheader2 = 0;
    
    int count = 0;
    int sum = 0;
            
    
    public void openFile()
    {
        try
        {
            input = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
            System.out.println("ser file opened for reading");
        }
        catch(IOException ioe)
        {
            System.out.println("error opening ser file"+ioe.getMessage());
        }
        
    }
    
    public void closeFile()
    {
        try
        {
        input.close();
        }
         catch(IOException ioe)
        {
            System.out.println("error closing ser file"+ioe);
        }
    }
    
    public void readFromFile()
    {
        try 
        {  
         for(int i = 0; 0<stakeholderArray.length; i++)
         {
             stakeholderArray[i] = (Stakeholder) input.readObject();
             System.out.println(stakeholderArray[i]);
         }       
        }
        catch(EOFException eofe)
        {
            System.out.println("EOF reached");
        }
        catch(ClassNotFoundException ioe)
        {
            System.out.println("class error reading ser file"+ ioe);
        }
         catch(IOException ioe)
        {
            System.out.println("error reading ser file"+ioe);
        }
        finally
        {
            closeFile();
            System.out.println("File has been closed");
        }
    
    }
    public void customerData()
    {        
        //Customer array objects
        customers[0] = new Customer ("C150", "Luke", "Atmyass", "Bellville", "1981-01-27", 1520.50, false);
        customers[1] = new Customer ("C130", "Stu", "Padassol", "Sea Point", "1987-05-18", 645.25, true);
        customers[2] = new Customer ("C100", "Mike", "Rohsopht", "Bellville", "1993-01-24", 975.10, true);
        customers[3] = new Customer ("C300", "Ivana.B", "Withew", "Langa", "1998-07-16", 1190.50, false);
        customers[4] = new Customer ("C250", "Eileen", "Sideways", "Nyanga", "1999-11-27", 190.85, true);
        customers[5] = new Customer ("C260", "Ima", "Stewpidas", "Atlantis", "2001-01-27", 1890.70, true);
        this.numberOfCustomers = 6;
        
        System.out.println("=======================CUSTOMERS=======================");
        System.out.println("--------------------");
        for (int i = 0; i < numberOfCustomers ;i++) 
        {
            System.out.println(customers[i]);
            System.out.println("-------------------------");
        }
    }
    public void supplierData()
    {
        suppliers[0] = new Supplier ("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan");
        suppliers[1] = new Supplier ("S400", "Prime Motors", "Lexus", "Luxury sedan");
        suppliers[2] = new Supplier ("S300", "We got Cars", "Toyota", "10-seater minibus");
        suppliers[3] = new Supplier ("S350", "Auto Delight", "BMW", "Luxury SUV");
        suppliers[4] = new Supplier ("S290", "MotorMania", "Hyundai", "compact budget");
        this.numberOfSuppliers = 5;
        
        System.out.println("=============================SUPPLIERS==================================");
        header1[0] = new Header1 ("ID","Name","Prod Type","Prod Description\n==================================================================");
        this.numberOfheader = 1;
        //loop for heading array
        for (int i = 0; i < numberOfheader ;i++) 
        {
            System.out.println(header1[i]);
        }
        //loop for supplier array
        for (int i = 0; i < numberOfSuppliers ;i++) 
        {
            System.out.println(suppliers[i]);
            System.out.println("-------------------------");
        }
    }
    public void customerDataSorted()
   {
        //Sorting customer array by stakeholder
        Comparator<Customer> bystHolderId = Comparator.comparing(name -> name.getStHolderId());
        Arrays.sort(customers, bystHolderId);
        
        System.out.println("=======================CUSTOMERS=======================");
        header2[0] = new Header2 ("ID","Name","Surname","Date of Birth","Age\n==================================================================");
        this.numberOfheader2 = 1;
        //loop for heading array
        for (int i = 0; i < numberOfheader2 ;i++) 
        {
            System.out.println(header2[i]);
        }
        for (int i = 0; i < numberOfCustomers ;i++) 
        {
            System.out.println(customers[i]);
            System.out.println("-------------------------");
        }

   }
    public void supplierDataSorted()
   {
        Comparator<Supplier> byname = Comparator.comparing(name -> name.getName());
        Arrays.sort(suppliers, byname);
        
        System.out.println("=============================SUPPLIERS==================================");
        header1[0] = new Header1 ("ID","Name","Prod Type","Prod Description\n==================================================================");
        this.numberOfheader = 1;
        //loop for heading array
        for (int i = 0; i < numberOfheader ;i++) 
        {
            System.out.println(header1[i]);
        }
        //loop foe supplier array
        for (int i = 0; i < numberOfSuppliers ;i++) 
        {
            System.out.println(suppliers[i]);
        }
   }
    public void customerAge() 
    {
        try
        {
            for(int i = 0; 0<numberOfCustomers; i++)
            {
            String s = "1981/01/27";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date d = sdf.parse(s);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int date = c.get(Calendar.DATE);
            LocalDate l1 = LocalDate.of(year, month, date);
            LocalDate now1 = LocalDate.now();
            Period diff1 = Period.between(l1, now1);
            System.out.println("age:" + diff1.getYears() + "years");
            break;
            }
          
            //using Calendar Object
           
        }
        catch(ParseException e)
        {
          System.out.println("error calculating customer age"+e);
        }
    }
    public void dateReFormat()
    {
        try
        {
            //using Calendar Object
            String s = "1981/01/27";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date d = sdf.parse(s);            
            System.out.println(s);
            
            System.out.println("Formatted Date: " + s);
            
        }
        catch(ParseException e)
        {
          System.out.println("error calculating customer age"+e);
        }
        
    }
     public void CanRent()
     {
        for (Customer b : this.customers)//Calculating customers able to rent and not able to rent
            {
             if (b.getCanRent()) count++;
             sum = numberOfCustomers - count;
            }
     }
      public static void main(String [] args)
    {
       ReadSerializedFileClass obj = new ReadSerializedFileClass();
       obj.openFile();
       obj.readFromFile();
       obj.customerData();
       obj.supplierData();
       obj.customerDataSorted();
       obj.customerAge();
       obj.dateReFormat();
       obj.supplierDataSorted();
       obj.CanRent();
    }

}
   


