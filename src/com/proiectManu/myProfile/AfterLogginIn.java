package com.proiectManu.myProfile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class AfterLogginIn {
    WebDriver driver = null;
    Robot robot = new Robot();


    public AfterLogginIn(WebDriver driver) throws AWTException {
        this.driver = driver;
    }

    public String constants(){
        String directory = "D:\\programare\\udemy\\Selenium\\FirstProjectV2\\scripts\\photoUpload.exe";
        return directory;
    }

    public void changePhotoProfile() throws InterruptedException, IOException {

        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        WebElement clickImageProfile=driver.findElement(By.id("profile-img"));
        clickImageProfile.click();
        Thread.sleep(1000);
        WebElement clickMyProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
        clickMyProfile.click();
        Thread.sleep(2000);
        WebElement clickPhoto = driver.findElement(By.xpath("//div[@class='fileUpload']"));
        clickPhoto.click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec(constants());
        Thread.sleep(1000);

        WebElement update = driver.findElement(By.xpath("//button[@class='btn btn-default btn-update btn-block']"));
        update.click();

        WebElement clickHomePage = driver.findElement(By.id("logo-img"));
        clickHomePage.click();
    }

    public void signOut() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement clickImageProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-img")));
        clickImageProfile.click();

        WebElement clickSignOut = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
        clickSignOut.click();
    }

    public void openFeedBackSupportwindow() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(3000);
        WebElement clickFeedback = driver.findElement(By.xpath("//a[@id='uvTabLabel']//img"));
        clickFeedback.click();
        Thread.sleep(4000);

    }

}
