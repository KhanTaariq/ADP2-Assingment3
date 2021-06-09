package za.ac.cput.assignment3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
/**customerOutFile.java
 * Contains methods to create, write and close file run class
 *Date 9 June 2021
 * @author Taariq Khan (219231141)
 */
public class customerOutFile extends ReadSerializedFileClass
{
    
    public void createFile()
    {
        try 
        {
          File myObj = new File("customerOutFile.txt");
            if (myObj.createNewFile()) 
            {
              System.out.println("File created: " + myObj.getName());
            } 
            else 
            {
              System.out.println("File already exists.");
            }
        } 
        catch (IOException e) 
        {
          System.out.println("An error occurred."+ e);
        }
    }
     public void writeToFile()
    {
        try 
        {
          File myObj = new File("customerOutFile.txt");
          FileWriter fw = new FileWriter(myObj);
          PrintWriter pw = new PrintWriter(fw);
          
            customerData();//calls array list
            customerDataSorted();//calls sorted array list

            Comparator<Customer> bystHolderId = Comparator.comparing(name -> name.getStHolderId());
            Arrays.sort(customers, bystHolderId);
            
            pw.println("=======================CUSTOMERS=======================");
            this.numberOfheader2 = 1;
                //loop for heading2 array
                for (int i = 0; i < numberOfheader2 ;i++) 
                {
                  pw.println(header2[i]);
                }
                //loop for customers array
                for (int i = 0; i < numberOfCustomers ;i++) 
                {
                  pw.println(customers[i]);
                }
                  CanRent();//calls rent method
                  pw.println("Number of customers who can rent: "+count);//uses count variable to count boolean true
                  pw.println("Number of customers who can not rent: "+sum);//takes total objects and subtracts boolean true from totaal to get boolean false
                  System.out.println("Successfully wrote to the file.");
                  pw.close();
        } 
        catch (IOException e) 
        {
          System.out.println("An error occurred."+e);
        }
        
    }  
     
     public static void main(String [] args)
    {
      customerOutFile obj = new customerOutFile();
      obj.createFile();
      obj.writeToFile(); 
    }   
}
