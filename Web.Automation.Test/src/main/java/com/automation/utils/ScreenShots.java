package com.automation.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class ScreenShots {
	public static void takeScreeShot(WebDriver driver, String imgName)throws Exception {
		try {
			TakesScreenshot tss = (TakesScreenshot)driver;
			File source = tss.getScreenshotAs(OutputType.FILE);
			String imgPath = "./ScreenShots" + "/" + imgName + ".jpg";
			File imgFile = new File(imgPath);
			FileHandler.copy(source, imgFile);
		}catch(Exception e) {
			System.out.println("Exception while taking screenshot"+ e.getMessage());
		}
	}
	public static void attachScreenShot(String imgName) {
		try {
			System.setProperty("org.uncommons.reportng.escape-output","false");
			File f = new File("ScreenShots/" + imgName + ".jpg");
			Reporter.log(
                    "<a title= \"ScreenShot\" href=\"" + f.getAbsolutePath() + "\">" +
                            "<img alt='"+f.getName()+"' src=\"./surefile-reports/html/screenshot/"+f+"\" ></a>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
