package com.framework.utils;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.framework.utils.RetryListenerClass;

public class TestNgRun {

	public void runTestNGTest() {

		TestNG myTestNG = new TestNG();

		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("CKM Regression Suite");

     	XmlTest myTest = new XmlTest(mySuite);
     	myTest.setName("CKM Test");
     	
     	XmlClass xmlClass = new XmlClass("com.framework.FrameWorkSelenium.TestRunner");

/*     	List<XmlInclude> includedMethods = new ArrayList<XmlInclude> ();
		includedMethods.add(new XmlInclude("test4"));
		xmlClass.setIncludedMethods(includedMethods);
 */    	
     	List<XmlClass> myClasses = new ArrayList<XmlClass> ();
     	myClasses.add(xmlClass);

     	myTest.setXmlClasses(myClasses);
     
     	List<XmlTest> myTests = new ArrayList<XmlTest>();
     	myTests.add(myTest);

     	mySuite.setTests(myTests);

     	List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
     	mySuites.add(mySuite);
     
   
     	myTestNG.setXmlSuites(mySuites);

/*     	TestListenerAdapter tla = new TestListenerAdapter();
     	myTestNG.addListener(tla);
*/
     	RetryListenerClass retryListenerClass = new RetryListenerClass();
     	myTestNG.addListener(retryListenerClass);
     	
/*     	ExtentReporterNG extentReporterNG = new ExtentReporterNG();
     	myTestNG.addListener(extentReporterNG);
*/     	
     	
     	myTestNG.run();
    }
	
}