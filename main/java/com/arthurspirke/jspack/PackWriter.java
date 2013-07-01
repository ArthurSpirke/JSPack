package com.arthurspirke.jspack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class PackWriter {
   private String nameOfFinalFile;
   private String nameOfFinalFolder;
   private StringBuffer sb;
   
   public PackWriter(String finalFile, String finalFolder){
	   this.nameOfFinalFile = finalFile;
	   this.nameOfFinalFolder = finalFolder;
	   this.sb = new StringBuffer();
   }
   
   
   public void writeFileInfo(File file){
	   String fileName = file.getName();
	   
	   BufferedReader bf = null;
	   
	   sb.append("//----------- " + fileName + " -----------");
	   sb.append("\r\n");
	   sb.append("\r\n");
	   sb.append("\r\n");
	   
	   try{
		   bf = new BufferedReader(new FileReader(file));
		   
		   String line = "";
		   while((line = bf.readLine()) != null){
			   sb.append(line);
			   sb.append("\r\n");
		   }
		   
		   sb.append("\r\n");
		   sb.append("\r\n");
		   sb.append("\r\n");
		   
	   } catch (IOException ex){
		   ex.printStackTrace();
	   }
   }
   
   
   public void createNewFile(){
	   OutputStream out = null;
	   File newFile = new File(nameOfFinalFolder + nameOfFinalFile);
	   String allContent = sb.toString();
	   
	   try{
		   out = new FileOutputStream(newFile);
		   byte[] contentInBytes = allContent.getBytes();
		   
		   out.write(contentInBytes);
		   out.flush();
		   out.close();
	   } catch (IOException ex){
		   ex.printStackTrace();
	   } finally {
		   try{
			   if(out != null){
				   out.close();
			   }
		   } catch(IOException ex){
			   //NOP
		   }
	   }
   }
   
   
	
}
