package com.arthurspirke.jspack.service.datafactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import com.arthurspirke.jspack.service.Property;

public class PropertyFile implements Property{
    @SuppressWarnings("unused")
    private File file;
    private String inputFolder;
    private String finalFileName;
    private String outputFolder;
    private List<String> filesToPack;
    
    public PropertyFile(String currentProject){
    	this.file = new File(currentProject);
    	initData();
    }
    
    private Properties getProperties(){
    	Properties prop = new Properties();
    	
    	try {
			prop.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return prop;
    }
    
    private void initData(){
       Properties prop = getProperties();
        
       inputFolder = prop.getProperty("inputFolder");
       finalFileName = prop.getProperty("finalFileName");
       outputFolder = prop.getProperty("outputFolder");
       filesToPack = Arrays.asList(prop.getProperty("filesToPack").split(","));
    }

	@Override
	public String getInputFolder() {
          return inputFolder;
	}

	@Override
	public String getFinalFileName() {
          return finalFileName;
	}

	@Override
	public String getOutputFolder() {
          return outputFolder;
	}

	@Override
	public List<String> getFilesToPack() {
          return filesToPack;
	}

}
