package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import Constants.SourcePath;

public class Utils {
public static String getConfigProperty(String propertyName) {
	
	Properties properties = new Properties();
	String filePath=SourcePath.config_properties_path;
    FileInputStream inputfile =null;
    try {
    	inputfile=new FileInputStream (filepath);
    } catch(FileNotFoundException e)
    { //e.printStackTrace;

}
    String value = null;
    
    try { properties.load(inputfile);;
    value= properties.getProperty(propertyName);
    System.out.println("file loaded" +value);
    
    }catch(IOException e) {
    	//e.printStackTrace;
    }
    	finally {
    		try { inputfile.close();
    	}catch(IOException e) {
        	//e.printStackTrace;
    }
    	}
    return value;
}
}
