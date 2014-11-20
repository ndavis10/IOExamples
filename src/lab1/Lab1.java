/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.*;
import java.util.*;
/**
 *
 * @author viewt_000
 */
public class Lab1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File(File.separatorChar + "temp" + File.separatorChar + "lab1" + File.separatorChar + "test.txt");
        BufferedReader inReader = new BufferedReader(new FileReader(inFile));
        int recordsRead = 0;
        try
        {
            int lineCount = 1;
            List<String[]> record = new ArrayList<>();
            String inputLine = inReader.readLine();
            while(inputLine != null)
            {
                record.add(inputLine.split(" "));
                if(lineCount >= 3)
                {
                    outputRecord(record);
                    recordsRead++;
                    lineCount = 0;
                }
                inputLine = inReader.readLine();
                lineCount++;
            }
        }
        catch(IOException e)
        {
            
        }
        finally
        {
            try
            {
                System.out.println("Records read: " + recordsRead);
                inReader.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    //This is a really lazy but useful subroutine, not good for actual serious stuff, though
    private static void outputRecord(List<String[]> record)
    {
        //Lazy hardcoding of values here
        String fName = record.get(0)[0];
        String lName = record.get(0)[1];
        String address = "";
        //Lazy string concatenation
        for(String s : record.get(1))
        {
            address += s + " ";
        }
        address = address.trim(); //Clears trailing and leading spaces if there are any
        String city = record.get(2)[0].replaceAll(",", ""); //Remove commas from city
        String state = record.get(2)[1];
        String zip = record.get(2)[2];
        System.out.println("First Name: " + fName + "\n" + //Screw multiple printlns,
                "Last Name: " + lName + "\n" +             //that's what '\n' is for
                "Address: " + address + "\n" +
                "City: " + city + "\n" +
                "State: " + state + "\n" +
                "ZIP: " + zip
                );
    }
}
