package com.arthurspirke.jspack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;

public class JSPackLauncher {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		ResourceBundle res = ResourceBundle.getBundle("com.arthurspirke.jspack.prop");
	    String filesToPack = res.getString("filesToPack");
	    String inputFolder = res.getString("inputFolder");
	    String finalFile = res.getString("finalFile");
	    String outputFolder = res.getString("outputFolder");
	    
	    File fileDirectory = new File(inputFolder);
        File[] listOfAllFiles = fileDirectory.listFiles();
        
        String[] listOfAllAvilableFiles = filesToPack.split(",");
        
        PackWriter pw = new PackWriter(finalFile, outputFolder);
        
        
        for(int i = 0; i < listOfAllAvilableFiles.length; i++){
        	String file = listOfAllAvilableFiles[i];
        	
        	for(int j = 0; j < listOfAllFiles.length; j++){
        		if(file.equals(listOfAllFiles[j].getName())){
        			pw.writeFileInfo(listOfAllFiles[j]);
        		}
        	}
        }
        
        pw.createNewFile();
		
		
	}

}
