package com.arthurspirke.jspack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;

public class PropertyFactory {
    private String currentProject;
    private ResourceBundle res;
    
    public PropertyFactory(String currentProject){
    	this.currentProject = currentProject;
    	res = ResourceBundle.getBundle("com.arthurspirke.jspack.prop");
    }
    
    public String[] getFilesToPack(){
    	return res.getString("filesToPack_" + currentProject).split(",");
    }
    
    public File getInputFolder(){
        return new File(res.getString("inputFolder_" + currentProject));
    }
    
    public String getfinalFile(){
    	return res.getString("finalFile_" + currentProject);
    }
    
    public File getOutputFolder(){
    	return new File(res.getString("outputFolder_" + currentProject));
    }
}
