package com.proiectManu.FirstPageCommand;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FirstPage {
    WebDriver driver = null;
    Robot robot = new Robot();

    public FirstPage(WebDriver driver) throws AWTException {
        this.driver = driver;
    }

    public void loginButton(){
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='btn btn-primary hidden-xs']"));
        loginButton.click();
    }

    public void login(String email, String password) throws InterruptedException {
        loginButton();
        WebElement emailField = driver.findElement(By.name("inputEmail"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement pwdField = driver.findElement(By.name("inputPassword"));
        pwdField.clear();
        pwdField.sendKeys(password);

        WebElement loginSubmit=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-block btn-login']"));
        loginSubmit.click();

        Thread.sleep(3000);
    }

    public void signUpHeaderButton(){
        WebElement signUp = driver.findElement(By.xpath("//a[@class='btn btn-default btn-one hidden-xs']"));
        signUp.click();
    }

    public void signUpHeaderCreateAccount(String fullName, String email, String password,boolean createAccount) throws InterruptedException {
        signUpHeaderButton();
        createAccountDetails(fullName,email,password,createAccount);

    }
    public void createAccountDetails(String fullName, String email, String password,boolean createAccount) throws InterruptedException {
        WebElement enterName = driver.findElement(By.name("inputName"));
        enterName.sendKeys(fullName);
        WebElement enterEmail =driver.findElement(By.name("inputEmail"));
        enterEmail.sendKeys(email);
        WebElement enterPwd =driver.findElement(By.name("inputPassword"));
        enterPwd.sendKeys(password);
        if(createAccount){
            WebElement signUp = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-sign-up btn-block']"));
            signUp.click();
        }else{
            Thread.sleep(3000);
            driver.quit();
        }
    }

    public void goToHomePage(){
        WebElement homePage = driver.findElement(By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']"));
        homePage.click();
    }

    public void signUpNowButton(){
        WebElement signUp = driver.findElement(By.xpath("//a[@class='btn btn-default btn-lg btn-four']"));
        signUp.click();
    }
    public void signUpNowCreateAccount(String fullName, String email, String password,boolean createAccount) throws InterruptedException {
        signUpNowButton();
        createAccountDetails(fullName,email,password,createAccount);
    }

    public void startAQuickPlay(String userName){
        WebElement start = driver.findElement(By.xpath("//a[@class='btn btn-default btn-lg btn-six']"));
        start.click();
        WebElement enterFullName= driver.findElement(By.name("inputName"));
        enterFullName.sendKeys(userName);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void hireDevelopers(){
        WebElement button = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-default center-block btn-hire']"));
        button.click();
    }

    public void findOutMore(){
        WebElement findButton = driver.findElement(By.xpath("//a[contains(text(),'Find out more >')]"));
        findButton.click();
    }

    public void codeFirstLinkBelowAboutTitle(){
        WebElement link = driver.findElement(By.xpath("//div[@class='link']//a[@href='https://www.codefirst.co.uk/about-codefirst']"));
        link.click();
    }

    public void emailUsCommand(){
        WebElement emailUs=driver.findElement(By.xpath("//a[contains(text(),'Email Us')]"));
        emailUs.click();
    }

    public void codeFirstLinkBelowOurWebsiteTitle(){
        WebElement link = driver.findElement(By.xpath("//div[@class='link']//a[@href='https://www.codefirst.co.uk']"));
        link.click();
    }

    public void topVet(){
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'TopVet')]"));
        link.click();
    }

    public void planItPoker(){
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'PlanITpoker')]"));
        link.click();
    }

    public void goToFacebook(){
        WebElement link = driver.findElement(By.xpath("//a[@class='social-icon facebook-icon']//img[@class='normal']"));
        link.click();
    }

    public void goToTwitter(){
        WebElement link = driver.findElement(By.xpath("//a[@class='social-icon twitter-icon']//img[@class='normal']"));
        link.click();
    }

    public void goToLinkedln(){
        WebElement link = driver.findElement(By.xpath("//a[@class='social-icon']//img[@class='normal']"));
        link.click();
    }

    public void customSoftwareDevelopmentByButton(){
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'CUSTOM SOFTWARE DEVELOPMENT')]"));
        link.click();
    }

    public void codeFirstLogo(){
        WebElement link = driver.findElement(By.xpath("//div[@class='codefirst-logo']//a//img"));
        link.click();
    }

    public void providersofFirstClassDevelopers(){
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Providers of First-Class Developers')]"));
        link.click();
    }
    public void privacyPolicy(){
        WebElement link = driver.findElement(By.xpath("//a[@class='link first-link']"));
        link.click();
    }
    public void termsAndConditions (){
        WebElement link = driver.findElement(By.xpath("//a[@class='link']"));
        link.click();
    }


}
