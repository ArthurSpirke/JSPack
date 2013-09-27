package com.arthurspirke.jspack;


import com.arthurspirke.jspack.service.CoreGenerator;
import com.arthurspirke.jspack.service.Property;
import com.arthurspirke.jspack.service.datafactory.PropertyXML;

public class JSPackLauncher {
  private static final String PATH_TO_DATA = "C:/example";
	
	public static void main(String[] args){
       

		Property data = new PropertyXML(PATH_TO_DATA);
		CoreGenerator generator = new CoreGenerator(data);
		
		generator.execute();

	}

}
