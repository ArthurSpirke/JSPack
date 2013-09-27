package com.arthurspirke.jspack.service;

import java.util.List;

public interface Property {

	  public String getInputFolder();
	  public String getFinalFileName();
	  public String getOutputFolder();
	  public List<String> getFilesToPack();
}
