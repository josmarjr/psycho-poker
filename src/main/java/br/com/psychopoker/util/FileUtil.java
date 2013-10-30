package br.com.psychopoker.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {

	
	public static List<String> readFile(String fileName){
		List<String> decks = new LinkedList<String>();
		URL res = ClassLoader.getSystemResource(fileName);
		if (res == null) {  
		    System.err.println("unable to find " + fileName); 
		} else {  
		    InputStream is = null;  
		    try {  
		        is = res.openStream();  
		        BufferedReader br = new BufferedReader(new InputStreamReader(is));  
		        String line;  
		        while ((line = br.readLine()) != null) {  
		        	decks.add(line);  
		        }  
		    } catch (IOException ex) {  
		        ex.printStackTrace();  
		    } finally {  
		        if (is != null) {  
		            try {   
		                is.close();   
		            } catch (IOException ex) {  
		                ex.printStackTrace();  
		            }  
		        }  
		    }  
		}

		return decks;

	}
}
