package com.ksyche.tools.util.xml;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;



public class XmlReader {
	 public static final XmlReader single = new XmlReader();
	 private XmlReader (){}
	 private static final DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	 private static final XPathFactory factory = XPathFactory.newInstance();
	 
	 public String getSingleValue(String xml, String strXPath) throws Exception{
		 	domFactory.setNamespaceAware(true); // never forget this!
		    DocumentBuilder builder = domFactory.newDocumentBuilder();
		    StringReader reader = new StringReader(xml);
		    Document doc = builder.parse(new InputSource(reader));
		    XPath xpath = factory.newXPath();
		    XPathExpression expr = xpath.compile(strXPath);

		    Object result = expr.evaluate(doc, XPathConstants.NODESET);
		    NodeList nodes = (NodeList) result;
		    if(nodes != null && nodes.getLength() > 0){
		    	return nodes.item(0).getNodeValue();
		    }
		    return "";
	 }
}
