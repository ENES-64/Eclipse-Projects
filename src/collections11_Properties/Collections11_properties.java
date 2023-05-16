package collections11_Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Collections11_properties {
	public static void main(String[] args) throws Exception {
		//Properties can only have a String key and a String value.
		Properties p =new Properties();
		//Key value pair.
		p.setProperty("Brand", "MSI");
		p.setProperty("Processor", "AMD 5950X");
		p.setProperty("OS", "Windows 10");
		p.setProperty("Model", "GL65");
		
		p.store(new FileOutputStream("/Users/enesy/MyJava/Eclipse/MyEclipse/src/collections11_Properties/mydata.txt"), "Laptop");
		/* It will be stored in a text file like this:
		#Laptop
		#Tue May 16 14:58:32 EDT 2023
		Brand=MSI
		Model=GL65
		OS=Windows 10
		Processor=AMD 5950X
		*/
		p.storeToXML(new FileOutputStream("/Users/enesy/MyJava/Eclipse/MyEclipse/src/collections11_Properties/mydata.xml"), "Laptop");
		/* It will be stored in an XML file like this:
		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
		<properties>
		<comment>Laptop</comment>
		<entry key="Brand">MSI</entry>
		<entry key="Processor">AMD 5950X</entry>
		<entry key="OS">Windows 10</entry>
		<entry key="Model">GL65</entry>
		</properties>
		*/
		System.out.println(p);
		
		//Reading a property file:
		//Same can be done for text files.
		Properties p2 =new Properties();
		p2.loadFromXML(new FileInputStream("/Users/enesy/MyJava/Eclipse/MyEclipse/src/collections11_Properties/readinganxmlfile.xml"));
		System.out.println(p2);
		//Printing just the name:
		System.out.println(p2.getProperty("Name"));
	}
}