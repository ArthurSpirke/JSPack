package com.arthurspirke.jspack.service.datafactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.arthurspirke.jspack.service.Property;

public class PropertyXML implements Property {
	private File xmlFile;
	private String inputFolder;
	private String finalFileName;
	private String outputFolder;
	private List<String> filesToPack;

	public PropertyXML(String pathToXmlFile) {
		this.xmlFile = new File(pathToXmlFile);
		initData();
	}

	private Document getRootDocument() {
		try {
			DocumentBuilderFactory docBFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFile);

			return doc;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private Element getCurrentProjectElement(NodeList projectsList,
			String currentProjectName) {
		Element element = null;
		for (int i = 0; i < projectsList.getLength(); i++) {
			Element tempElement = (Element) projectsList.item(i);
			if (tempElement.getAttribute("name").equals(currentProjectName)) {
				element = tempElement;
			}
		}

		return element;
	}

	private void initProperties(Node node) {
		if (node.getNodeName().equals("inputFolder")) {
			inputFolder = node.getTextContent();
		} else if (node.getNodeName().equals("filesToPack")) {
			NodeList filesList = node.getChildNodes();
			filesToPack = new ArrayList<>();
            
			for (int a = 0; a < filesList.getLength(); a++) {
				if (filesList.item(a).getNodeName().equals("file")) {
					filesToPack.add(filesList.item(a).getTextContent());
				}
			}
		} else if (node.getNodeName().equals("finalFileName")) {
			finalFileName = node.getTextContent();
		} else if (node.getNodeName().equals("outputFolder")) {
			outputFolder = node.getTextContent();
		} else {

		}
	}

	private void initData() {
		Document doc = getRootDocument();
		doc.getDocumentElement().normalize();

		final String currentProject = doc.getDocumentElement().getAttribute(
				"current");
		NodeList nodeList = doc.getElementsByTagName("project");

		Element currentProjectNode = getCurrentProjectElement(nodeList,
				currentProject);
		NodeList interList = currentProjectNode.getChildNodes();

		for (int i = 0; i < interList.getLength(); i++) {
			initProperties(interList.item(i));
		}

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
