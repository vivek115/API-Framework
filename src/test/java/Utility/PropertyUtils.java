package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties properties(String filepath){
        // we pass filepath as an argument
        // file path is used to load the property
        Properties properties = new Properties();
        //buffer reader is used to read the file
        BufferedReader reader;
        try{
            // here we reading the file
            reader = new BufferedReader(new FileReader(filepath));
            try{
                //load method is used to load the property file it will reads the list in the form key and value pairs
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw  new RuntimeException("failed to load properties file"+ filepath);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("properties file not found at"+filepath);
        }
        // we return the properties which is loaded with key ande value pairs
        return properties;
    }
}
