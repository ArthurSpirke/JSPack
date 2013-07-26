package com.arthurspirke.jspack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.attribute.standard.PDLOverrideSupported;

import com.arthurspirke.jspack.utils.ServiceUtils;

public class JSPackLauncher {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
       
		PropertyFactory pf = new PropertyFactory(ServiceUtils.getCurrentProject());

		File[] allFiles = pf.getInputFolder().listFiles();
        String[] allAvilableFiles = pf.getFilesToPack();        

		PackWriter pw = new PackWriter(pf.getfinalFile(), pf.getOutputFolder());

		for (int i = 0; i < allAvilableFiles.length; i++) {
			String file = allAvilableFiles[i];
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
