package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.test.TestBase;

public class ScreenShot extends TestBase{
	
	
	public static String takeScreenShot(String filename) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String date = format1.format(cal.getTime());
		String time = new SimpleDateFormat("hh-mm-ss").format(cal.getTime());
	
		File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);
		String path = System.getProperty("user.dir")+"//Files//ScreenShots//"+date+"//"+time+"_filename";
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return path;
	}
	
}
 