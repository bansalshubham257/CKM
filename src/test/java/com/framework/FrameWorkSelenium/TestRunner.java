package com.framework.FrameWorkSelenium;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.configure.Configuration;
import com.framework.functions.Loginfn;
import com.framework.functions.RobotClass;
import com.framework.functions.UploadAsset;
import com.framework.functions.UploadPresentation;
import com.framework.functions.KeyMessage;
import com.framework.functions.MetaData;
import com.framework.functions.Wait;
import com.framework.pageAction.AssetViewPageAction;
import com.framework.pageAction.CommentsNotesPageAction;
import com.framework.pageAction.HomePageAction;
import com.framework.pageAction.PresentationViewPageAction;
import com.framework.pageAction.SettingPageAction;
import com.framework.pageAction.UploadPresentationPageAction;
import com.framework.pageAction.VersionPageAction;
import com.framework.pageElement.AssetViewPage;
import com.framework.pageElement.HomePage;
import com.framework.pageElement.PresentationViewPage;
import com.framework.pageElement.UploadPresentationPage;
import com.framework.test.TestBase;
import com.framework.utils.ScreenShot;
import com.framework.utils.TestNgRun;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestRunner{
	
	public String username = "";
	public String password = "";
	ExtentReports report;
	ExtentTest logger;
	String reportPath;
	
	public static void main (String args[])
	{
		TestNgRun testNgRun = new TestNgRun();
		testNgRun.runTestNGTest();
	}
	
	@BeforeClass
	public void createDriver() {
		new Configuration();
		username = Configuration.getProperties("username");
		password = Configuration.getProperties("password");
		reportPath = System.getProperty("user.dir")+"//Files//HtmlReport//LearnAutomation.html";
		report=new ExtentReports(reportPath);
	}
	
	@BeforeMethod
	public void launchApplication(Method method) {
		new TestBase();
		TestBase.launchHomePage();
		logger=report.startTest(method.getName().toString());
		System.out.println("**********"+method.getName().toString()+"****************8");
	}

	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		 
			String screenshot_path=ScreenShot.takeScreenShot(result.getName());
			String image= logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, result.getMethod().getMethodName(), image);
			 
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String screenshot_path=ScreenShot.takeScreenShot(result.getName());
			String image= logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.PASS, result.getMethod().getMethodName(),image);		 
		}
		
		TestBase.closeBrowser();
		 
	}
	
	@AfterClass
	public void tearDown()
	{
		report.endTest(logger);
		report.flush();	
		
	}


	@Test(groups= {"Login","All"}, description="Verify Login Functionality")
	public void test0() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
	}	

 	@Test(groups= {"Settings","All"}, description="To Verify if Settings Section is visible")
	public void test1() {
		
 		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickUserProfile();
		homePageAction.clickUserSettingButton();
		if(!new SettingPageAction().getTitle().equals("Settings")) {
			Assert.fail();
		}	
	}
	
	
	@Test(groups= {"iSPA","All"}, description="To verify if .pptx files uploaded as html files when setting in Multi-Page")
	public void test3() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		Wait.waitElementToBeClickable(new HomePage().ddUserProfile, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickUserProfile();
		homePageAction.clickUserSettingButton();
		SettingPageAction settingPageAction = new SettingPageAction();
		if(!settingPageAction.getTitle().equals("Settings")) {
			Assert.fail();
		}
	
		settingPageAction.selctMultiPage();
		
		settingPageAction.clickSaveBtn();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("pptFileName")+".pptx";
		
		UploadPresentation.loadPresentation(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("pptFileName"));
		
        PresentationViewPage presentationViewPage = new PresentationViewPage();
        Wait.waitElementToBeClickable(presentationViewPage.btnExit, 20);
 
        PresentationViewPageAction presentationViewPageAction = new PresentationViewPageAction();
        
        presentationViewPageAction.clickEditBtn();
        
        if(!presentationViewPageAction.isHtmlPages()) {
        	Assert.fail();
        }
        
        
	}

	
	@Test(groups= {"iSPA","All"}, description="To verify if .pptx files uploaded as image files when setting in iSPA")
	public void test4() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		Wait.waitElementToBeClickable(new HomePage().ddUserProfile, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickUserProfile();
		homePageAction.clickUserSettingButton();
		SettingPageAction settingPageAction = new SettingPageAction();
		if(!settingPageAction.getTitle().equals("Settings")) {
			Assert.fail();
		}
		
		settingPageAction.selectSinglePage();


		settingPageAction.clickSaveBtn();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("pptFileName")+".pptx";
		
		UploadPresentation.loadPresentation(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("pptFileName"));
		
        PresentationViewPage presentationViewPage = new PresentationViewPage();
        Wait.waitElementToBeClickable(presentationViewPage.btnExit, 20);
        
        PresentationViewPageAction presentationViewPageAction = new PresentationViewPageAction();
        
        presentationViewPageAction.clickEditBtn();
        
        if(presentationViewPageAction.isHtmlPages()) {
        	Assert.fail();
        }
        
        
	}
	
	
	@Test(groups= {"Roles","All"}, description="To Verify if User is able to see all the role(s) assigned")
	public void test5() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		Wait.waitElementToBeClickable(new HomePage().ddUserProfile, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickUserProfile();
		homePageAction.clickUserSettingButton();
		SettingPageAction settingPageAction = new SettingPageAction();
		if(!settingPageAction.getTitle().equals("Settings")) {
			Assert.fail();
		}
		
		String roles = settingPageAction.getRoles();
		if(!roles.toLowerCase().contains(Configuration.getProperties("role"))) {
			Assert.fail();
		}
	}
		
	
	@Test(groups= {"Functional","All"}, description="Options Available on Presentation View")
	public void test10() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("pdfFileName")+".pdf";
		
		UploadPresentation.loadPresentation(filePath);
		
		homePageAction.viewPresentation(Configuration.getProperties("pdfFileName"));
        
        PresentationViewPage presentationViewPage = new PresentationViewPage();
        
        Wait.waitElementToBeClickable(presentationViewPage.btnExit, 20);
       
        PresentationViewPageAction presentationViewPageAction = new PresentationViewPageAction();
        
        presentationViewPageAction.clickInfoBtn();
        
        String[] positionGroup = {"Bangalore Position Group","Bengaluru Region","Content Position Group"};
        
        new MetaData().setInfo("Automation Title", "Written by Script", "Setral", "English", positionGroup);
        
        presentationViewPageAction.clickSaveBtn();
             
        presentationViewPageAction.clickEditBtn();
        
        String[] keyMessages = {"Conclusion","Customer Satisfaction"};
        
        new KeyMessage().setKeyMessages("Automation Edit Slide Title", "Written by Script", "Slide2", keyMessages);
        
        presentationViewPageAction.clickAssetsBtn();
        
        presentationViewPageAction.clickCommentsBtn();
        
        CommentsNotesPageAction commentsNotesPageAction = new CommentsNotesPageAction();
        
        commentsNotesPageAction.setComments("Comments by Script");
        commentsNotesPageAction.clickOnCloseComments();
 
        presentationViewPageAction.clickNotesBtn();
        commentsNotesPageAction.setNotes("Notes by Script");
        
        presentationViewPageAction.clickSaveBtn();
              
        Wait.waitForSaveButtonDisabled(50);
        Wait.sleep(3000);
        
        presentationViewPageAction.clickDistributeBtn();
        
        presentationViewPageAction.clickOnWithoutApprovalBtn();
        
        String actualValue = presentationViewPageAction.getApprovalStatus();
 
        Wait.waitInvisibilityOfElementWithText(new PresentationViewPage().approvalProgress, 50, actualValue);

	}
	
// Uploading Presentation Files ..............................	
	
		
	@Test(groups= {"Uploading","All"}, description="Uploading pdf File")
	public void test7() {
		
		new Loginfn().getLogin(username,password);		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("pdfFileName")+".pdf";
		
		UploadPresentation.loadPresentation(filePath);
		
        homePageAction.viewPresentation(Configuration.getProperties("pdfFileName"));
        
        Wait.waitElementToBeClickable(new PresentationViewPage().btnExit, 20);
        new PresentationViewPageAction().clickExitBtn();
        
	}

	@Test(groups= {"Uploading","All"}, description="Uploading zip File")
	public void test8() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("zipFileName")+".zip";
		
		UploadPresentation.loadPresentation(filePath);
		
        homePageAction.viewPresentation(Configuration.getProperties("zipFileName"));
        
        Wait.waitElementToBeClickable(new PresentationViewPage().btnExit, 20);
        new PresentationViewPageAction().clickExitBtn();

	}

	@Test(groups= {"Uploading","All"}, description="Uploading ppt File")
	public void test9() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
			
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("pptFileName")+".pptx";
		
		UploadPresentation.loadPresentation(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("pptFileName"));
        
        Wait.waitElementToBeClickable(new PresentationViewPage().btnExit, 20);
        new PresentationViewPageAction().clickExitBtn();

	}
	
	
	@Test(groups= {"Uploading","All"}, description="Uploading multiple Files")
	public void test11() {
				
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		UploadPresentationPageAction uploadPresentationPageAction = new UploadPresentationPageAction(); 
		uploadPresentationPageAction.clickBrowse();
		
		Wait.sleep(2000);
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\";
		
		RobotClass robotClass = new RobotClass();
		
		robotClass.copyText(filePath);
		robotClass.pasteText();
	    robotClass.clickEnter();
	    Wait.sleep(1000);
	    robotClass.tabBackward();
	    robotClass.tabBackward();
	    robotClass.selectAll();
        robotClass.clickEnter();
	    
	    Wait.sleep(2000);
	    
        String actualValue = uploadPresentationPageAction.getMultipleUploadingStatus();
        
        while(actualValue.toLowerCase().contains("upload")) {
        	System.out.println(actualValue);
        	Wait.waitInvisibilityOfElementWithText(new UploadPresentationPage().multipleUploadingProgress, 1500, actualValue);
        	actualValue = uploadPresentationPageAction.getMultipleUploadingStatus();
        }
      
        if(actualValue.toLowerCase().contains("fail")) {
        	Assert.fail();
        }
        
        Wait.sleep(2000);
        uploadPresentationPageAction.clickClose();
        Wait.sleep(2000);
        
	}
	
// Uploading Asset Files ..........................................................	
	
	@Test(groups= {"Uploading","All"}, description="Uploading Asset Zip File")
	public void test12() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickAssetsLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadAssetButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Assets\\"+Configuration.getProperties("zipAssetFileName")+".zip";
		
		UploadAsset.loadAsset(filePath);
        
        //homePageAction.viewPresentation(Configuration.getProperties("zipAssetFileName"));        
        
	}

	
	@Test(groups= {"Uploading","All"}, description="Uploading Asset PNG File")
	public void test13() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickAssetsLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadAssetButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Assets\\"+Configuration.getProperties("pngAssetFileName")+".png";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("pngAssetFileName"));        
        
	}
	
	@Test(groups= {"Uploading","All"}, description="Uploading Asset JPEG File")
	public void test14() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickAssetsLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadAssetButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Assets\\"+Configuration.getProperties("jpegAssetFileName")+".jpg";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("jpegAssetFileName"));        
        
	}

	@Test(groups= {"Uploading","All"}, description="Uploading Asset MP4 File")
	public void test15() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickAssetsLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadAssetButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Assets\\"+Configuration.getProperties("mp4AssetFileName")+".mp4";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("mp4AssetFileName"));        
        
	}

	@Test(groups= {"Uploading","All"}, description="Uploading Asset WEBM File")
	public void test16() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickAssetsLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadAssetButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Assets\\"+Configuration.getProperties("webmAssetFileName")+".webm";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("webmAssetFileName"));        
        
	}
	
	
	// Uploading Document File ............................
	
	@Test(groups= {"Uploading","All"}, description="Uploading Document .zip File")
	public void test22() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickDocumentLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadDocumentButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Documents\\"+Configuration.getProperties("zipDocumentFileName")+".zip";
		
		UploadAsset.loadAsset(filePath);
        
        //homePageAction.viewPresentation(Configuration.getProperties("zipDocumentFileName"));        
        
	}
	
	@Test(groups= {"Uploading","All"}, description="Uploading Document .docx File")
	public void test23() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickDocumentLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadDocumentButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Documents\\"+Configuration.getProperties("docDocumentFileName")+".docx";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("docDocumentFileName"));        
        
	}

	@Test(groups= {"Uploading","All"}, description="Uploading Document .PDF File")
	public void test24() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickDocumentLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadDocumentButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Documents\\"+Configuration.getProperties("pdfDocumentFileName")+".pdf";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("pdfDocumentFileName"));        
        
	}

	@Test(groups= {"Uploading","All"}, description="Uploading Document .PPT File")
	public void test25() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickDocumentLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadDocumentButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Documents\\"+Configuration.getProperties("pptDocumentFileName")+".pptx";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("pptDocumentFileName"));        
        
	}

	@Test(groups= {"Uploading","All"}, description="Uploading Document .txt File")
	public void test26() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickDocumentLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadDocumentButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Documents\\"+Configuration.getProperties("textDocumentFileName")+".txt";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("textDocumentFileName"));        
        
	}

	@Test(groups= {"Uploading","All"}, description="Uploading Document .Xlsx File")
	public void test27() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickDocumentLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadDocumentButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Documents\\"+Configuration.getProperties("xlsxDocumentFileName")+".xlsx";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("xlsxDocumentFileName"));        
        
	}

	@Test(groups= {"Uploading","All"}, description="Uploading multiple Documents Files")
	public void test28() {
				
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportDocument, 10);
		homePageAction.clickUploadDocumentButton();
		
		UploadPresentationPageAction uploadPresentationPageAction = new UploadPresentationPageAction(); 
		uploadPresentationPageAction.clickBrowse();
		
		Wait.sleep(2000);
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Documents\\";
		
		RobotClass robotClass = new RobotClass();
		
		robotClass.copyText(filePath);
		robotClass.pasteText();
	    robotClass.clickEnter();
	    Wait.sleep(1000);
	    robotClass.tabBackward();
	    robotClass.tabBackward();
	    robotClass.selectAll();
        robotClass.clickEnter();
	    
	    Wait.sleep(2000);
	    
        String actualValue = uploadPresentationPageAction.getMultipleUploadingStatus();
        
        while(actualValue.toLowerCase().contains("upload")) {
        	System.out.println(actualValue);
        	Wait.waitInvisibilityOfElementWithText(new UploadPresentationPage().multipleUploadingProgress, 1500, actualValue);
        	actualValue = uploadPresentationPageAction.getMultipleUploadingStatus();
        }
      
        if(actualValue.toLowerCase().contains("fail")) {
        	Assert.fail();
        }
        
        Wait.sleep(2000);
        uploadPresentationPageAction.clickClose();
        Wait.sleep(2000);
        
	}
	

	@Test(groups= {"Functional","All"}, description="Options available on Asset View File")
	public void test17() {
				
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		
		homePageAction.clickAssetsLink();
		
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadAssetButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Assets\\"+Configuration.getProperties("pngAssetFileName")+".png";
		
		UploadAsset.loadAsset(filePath);
        
        homePageAction.viewPresentation(Configuration.getProperties("pngAssetFileName"));  
        
        Wait.waitElementToBeClickable(new AssetViewPage().btnExit, 20);
       
        AssetViewPageAction assetViewPageAction = new AssetViewPageAction();
        
        assetViewPageAction.clickInfoBtn();
       
        new MetaData().setInfo("Automation Title", "Description Written by Script", "Setral", "English");
        
        assetViewPageAction.clickCommentsBtn();
        
        CommentsNotesPageAction commentsNotesPageAction = new CommentsNotesPageAction();
    
        commentsNotesPageAction.setComments("Comments by Script");
        commentsNotesPageAction.clickOnAssetCloseComments();
 
        assetViewPageAction.clickDistributeBtn();
        
        assetViewPageAction.clickOnWithoutApprovalBtn();
        
        String actualValue = assetViewPageAction.getApprovalStatus();
 
        Wait.waitInvisibilityOfElementWithText(new PresentationViewPage().approvalProgress, 50, actualValue);

	}
	
	
	@Test(groups= {"Functional","All"}, description="Validation of New Version created")
	public void test18() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("pdfFileName")+".pdf";
		
		UploadPresentation.loadPresentation(filePath);
		
		homePageAction.viewPresentation(Configuration.getProperties("pdfFileName"));
        
        PresentationViewPage presentationViewPage = new PresentationViewPage();
        
        Wait.waitElementToBeClickable(presentationViewPage.btnExit, 20);
       
        PresentationViewPageAction presentationViewPageAction = new PresentationViewPageAction();
        
        presentationViewPageAction.clickInfoBtn();
        
        String[] positionGroup = {"Bangalore Position Group","Bengaluru Region","Content Position Group"};
        
        new MetaData().setInfo("Automation Title", "Written by Script", "Setral", "English", positionGroup);
        
        presentationViewPageAction.clickVersionBtn();
        
        VersionPageAction  versionPageAction = new VersionPageAction();
        int oldVersionCount = versionPageAction.totalVersionCount();
        
        presentationViewPageAction.clickSaveBtn();
        
        Wait.waitForSaveButtonDisabled(50);
        Wait.sleep(5000);
                 
        if(versionPageAction.totalVersionCount()!=(oldVersionCount+1)) {
        	Assert.fail();
        }
        else {
        	oldVersionCount = versionPageAction.totalVersionCount();
        }
        
        presentationViewPageAction.clickEditBtn();
        
        String[] keyMessages = {"Conclusion","Customer Satisfaction"};
        
        new KeyMessage().setKeyMessages("Automation Edit Slide Title", "Written by Script", "Slide2", keyMessages);
          
        presentationViewPageAction.clickSaveBtn();
              
        Wait.waitForSaveButtonDisabled(50);
        Wait.sleep(5000);
        
        presentationViewPageAction.clickVersionBtn();
        
        if(versionPageAction.totalVersionCount()!=(oldVersionCount+1)) {
        	Assert.fail();
        }

	}
		
	
	@Test(groups= {"Functional","All"}, description="Validation of Save Button Enable and disable")
	public void test19() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("pdfFileName")+".pdf";
		
		UploadPresentation.loadPresentation(filePath);
		
		homePageAction.viewPresentation(Configuration.getProperties("pdfFileName"));
        
        PresentationViewPage presentationViewPage = new PresentationViewPage();
        
        Wait.waitElementToBeClickable(presentationViewPage.btnExit, 20);
       
        PresentationViewPageAction presentationViewPageAction = new PresentationViewPageAction();
        
        presentationViewPageAction.clickInfoBtn();
        
        String[] positionGroup = {"Bangalore Position Group","Bengaluru Region","Content Position Group"};
        
        new MetaData().setInfo("Automation Title", "Written by Script", "English");
        
        if(!presentationViewPageAction.isSaveBtnDisabled()) {
        	Assert.fail("Save Button is Enabled");
        }
        
        new MetaData().setInfo("Setral");
        
        if(presentationViewPageAction.isSaveBtnDisabled()) {
        	Assert.fail("Save Button is Disabled");
        }
        
        presentationViewPageAction.clickSaveBtn();
        
        Wait.waitForSaveButtonDisabled(50);
        Wait.sleep(4000);

        new MetaData().setInfo(positionGroup);
        
        if(presentationViewPageAction.isSaveBtnDisabled()) {
        	Assert.fail("Save Button is Disabled");
        }
        
        presentationViewPageAction.clickSaveBtn();
        
        Wait.waitForSaveButtonDisabled(50);
        Wait.sleep(5000);

        presentationViewPageAction.clickEditBtn();
        
        String[] keyMessages = {"Conclusion","Customer Satisfaction"};
        
        new KeyMessage().setKeyMessages("Automation Edit Slide Title", "Written by Script", "Slide2", keyMessages);
          
        presentationViewPageAction.clickSaveBtn();
          

	}


	
	@Test(groups= {"Functional","All"}, description="Validation of presentation count if less than or equal to 24")
	public void test20() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		Wait.waitPresenceOfElementLocated(new HomePage().presentationDiv, 30);
		Wait.sleep(2000);
		if(new HomePageAction().countPresentationHomePage()>25) {
			Assert.fail("More Than 24 Presentations on Home Page");
		}

	}

	
	@Test(groups= {"Functional","All"}, description="Validation of Rename, Duplicate, Delete shortcuts")
	public void test21() {
		
		new Loginfn().getLogin(username,password);
		Wait.waitElementToBeClickable(new HomePage().ddImport, 20);
		HomePageAction homePageAction = new HomePageAction();
		homePageAction.clickImport();
		Wait.waitElementToBeClickable(new HomePage().btnImportPresentation, 10);
		homePageAction.clickUploadPresentationButton();
		
		String filePath = System.getProperty("user.dir")+"\\Files\\TestData\\Presentations\\"+Configuration.getProperties("pdfFileName")+".pdf";
		
		UploadPresentation.loadPresentation(filePath);
		
		String fileName = Configuration.getProperties("pdfFileName");
		
		homePageAction.clickShortcutDropDown(fileName);
		homePageAction.clickRenameShortcut(fileName);
		homePageAction.setRenameTitle("RenameByAutomation");
		homePageAction.clickRenameSave();
		Wait.sleep(2000);
		homePageAction.clickShortcutDropDown("RenameByAutomation");
		homePageAction.clickDuplicateShortcut("RenameByAutomation");
		homePageAction.clickDuplicateSave();
		Wait.sleep(2000);
		homePageAction.clickShortcutDropDown("Copy of RenameByAutomation");
		homePageAction.clickDeleteShortcut("Copy of RenameByAutomation");
		Wait.sleep(4000);
		homePageAction.viewPresentation("RenameByAutomation");
	}



}
