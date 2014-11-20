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
            List<String> record = new ArrayList<>();
            String inputLine = inReader.readLine().trim();
            while(inputLine != null)
            {
                record.add(inputLine);
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
    private static void outputRecord(List<String> record)
    {
        //Lazy hardcoding of values here
        String[] lineOne = record.get(0).split(" ");
        String fName = lineOne[0];
        String lName = lineOne[1];
        String address = record.get(1);
        String[] lineThree = record.get(2).split(",");
        String city = lineThree[0]; //Remove commas from city
        String[] stateZipArray = lineThree[1].split(" ");
        String state = stateZipArray[0];
        String zip = stateZipArray[1];
        System.out.println("First Name: " + fName + "\n" + //Screw multiple printlns,
                "Last Name: " + lName + "\n" +             //that's what '\n' is for
                "Address: " + address + "\n" +
                "City: " + city + "\n" +
                "State: " + state + "\n" +
                "ZIP: " + zip
                );
    }
}
