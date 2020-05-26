package com.proiectManu;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static String takeScreenshot(WebDriver driver) throws IOException {
        String fileName = getRandomString(10) + ".png";
        String directory = "D:\\programare\\udemy\\Selenium\\Project-ITPoker\\screenshots\\";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile,new File(directory + fileName));
        String destination = directory +fileName;
        return destination;
    }
    public static String getRandomString(int length){
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        for(int i = 0; i < length;i++){
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
