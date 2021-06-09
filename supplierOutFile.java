package za.ac.cput.assignment3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
/**supplierOutFile.java
 * Contains methods to create, write and close file run class
 *Date 9 June 2021
 * @author Taariq Khan (219231141)
 */
public class supplierOutFile extends ReadSerializedFileClass
{
   
    
    public void createFile()
    {
        try 
        {
          File myObj = new File("supplierOutFile.txt");
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
          File myObj = new File("supplierOutFile.txt");
          FileWriter fw = new FileWriter(myObj);
          PrintWriter pw = new PrintWriter(fw);
          
            System.out.println("==========================SUPPLIERS===============================");
            System.out.println(header1[0] = new Header1 ("ID","Name","Prod Type","Prod Description\n=================================================================="));     
            System.out.println(suppliers[0] = new Supplier ("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan"));
            System.out.println(suppliers[1] = new Supplier ("S400", "Prime Motors", "Lexus", "Luxury sedan"));
            System.out.println(suppliers[2] = new Supplier ("S300", "We got Cars", "Toyota", "10-seater minibus"));
            System.out.println(suppliers[3] = new Supplier ("S350", "Auto Delight", "BMW", "Luxury SUV"));
            System.out.println(suppliers[4] = new Supplier ("S290", "MotorMania", "Hyundai", "compact budget"));
            this.numberOfSuppliers = 5;
            
            Comparator<Supplier> byname = Comparator.comparing(name -> name.getName());//sorting supplier array by name
            Arrays.sort(suppliers, byname); 

            pw.println("==========================SUPPLIERS===============================");
            this.numberOfheader = 1;
            //loop for heading array
                for (int i = 0; i < numberOfheader ;i++) 
                {
                  pw.println(header1[i]);
                }
                //loop for supplier array
                for (int i = 0; i < numberOfSuppliers ;i++) 
                {
                  pw.println(suppliers[i]);
                }
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
      supplierOutFile obj = new supplierOutFile();
      obj.createFile();
      obj.writeToFile(); 
    }   
}
   
