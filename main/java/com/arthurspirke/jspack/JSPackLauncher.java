package com.arthurspirke.jspack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class JSPackLauncher {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
       

		Property data = new PropertyXML("C:/Users/Arthur/Documents/mwork/JSPack/JSPack/src/main/resources/com/arthurspirke/jspack/properties.xml");
		
        File outputFolder = new File(data.getOutputFolder());
        String finalFileName = data.getFinalFileName();
        File[] allFiles = new File(data.getInputFolder()).listFiles();
        List<String> allAvilableFiles = data.getFilesToPack();

		PackWriter pw = new PackWriter(finalFileName, outputFolder);

		for (int i = 0; i < allAvilableFiles.size(); i++) {
			String file = allAvilableFiles.get(i);
			System.out.println(file);
			for (int j = 0; j < allFiles.length; j++) {
				if (file.equals(allFiles[j].getName())) {
					pw.writeFileInfo(allFiles[j]);
				}
			}
		}

		pw.createNewFile();

	}

}
