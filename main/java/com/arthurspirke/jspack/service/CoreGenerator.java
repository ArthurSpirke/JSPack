package com.arthurspirke.jspack.service;

import java.io.File;
import java.util.List;

public class CoreGenerator {
   Property data;
   File outputFolder;
   String finalFileName;
   File[] allFiles;
   List<String> allAvilableFiles;
   
   public CoreGenerator(Property data){
	   this.data = data;
   }
   
   public void execute(){
	   init();
	   
	   PackWriter pw = new PackWriter(finalFileName, outputFolder);
	   
		for (int i = 0; i < allAvilableFiles.size(); i++) {
			String file = allAvilableFiles.get(i);

			for (int j = 0; j < allFiles.length; j++) {
				if (file.equals(allFiles[j].getName())) {
					pw.writeFileInfo(allFiles[j]);
				}
			}
		}

		pw.createNewFile();
   }
   
   private void init(){
       
       allFiles = new File(data.getInputFolder()).listFiles();
       outputFolder = new File(data.getOutputFolder()); 
       finalFileName = data.getFinalFileName();
       allAvilableFiles = data.getFilesToPack();
   }
   
}
