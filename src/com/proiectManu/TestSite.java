package com.proiectManu;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.proiectManu.CreateRoomAndPlayerGameSet.CreateRoom;
import com.proiectManu.CreateRoomAndPlayerGameSet.PlayGame;
import com.proiectManu.Enum.Click;
import com.proiectManu.Enum.TypeOfRoom;
import com.proiectManu.Enum.undoEditDelete;
import com.proiectManu.FirstPageCommand.FirstPage;
import com.proiectManu.myProfile.AfterLogginIn;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestSite {

    private WebDriver driver;
    private FirstPage command;
    private AfterLogginIn myAccount;
    private String baseUrl;
    private int yourchoice;
    private CreateRoom createRoom;
    private PlayGame playGame;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void setUp() throws AWTException {
        baseUrl = "https://www.planitpoker.com/";
        report = new ExtentReports("D:\\programare\\udemy\\Selenium\\Project-ITPoker\\reports\\reportItPoker.html");
        test = report.startTest("Verify Welcome Test");
        yourchoice = 28;
        String text = "Hi! Can you test this website?" +
                "\nChoose one command:" +
                "\n\t1. Go to home page!" +     //------------------------------------//
                "\n\t2. Click on login button !" +                                    //
                "\n\t3. Click on login and loggin in!" +                              //
                "\n\t4. Click on signUpHeader button!" +                              //
                "\n\t5. Click on signUpHeader and create an account!" +               //
                "\n\t6. Click on signUpNow button!" +                                 //
                "\n\t7. Click on signUpNow and create an account!" +                  //
                "\n\t8. Click on Start a quickplay!" +                                //
                "\n\t9. Click on Hire Developers!" +                                  //
                "\n\t10.Click on Find out more!" +                                    //
                "\n\t11.Click on CodeFirst below About column!" +                     // Test first page!
                "\n\t12.Click on Email Us!" +                                         //
                "\n\t13.Click on CodeFirst below Our Website column!" +               //
                "\n\t14.Click on TopVet!" +                                           //
                "\n\t15.Click on PlanItPoker!" +                                      //
                "\n\t16.Go to Facebook website!" +                                    //
                "\n\t17.Go to Twitter website!" +                                     //
                "\n\t18.Go to Linkedln!" +                                            //
                "\n\t19.Click on Custom Software Development!" +                      //
                "\n\t20.Click on CodeFirst Logo!" +                                   //
                "\n\t21.Click on Providers of First-Class Developers!" +              //
                "\n\t22.Click on Privacy Policy!" +                                   //
                "\n\t23.Click on Terms and Conditions!" +   //------------------------//
                "\n\t24.Change Profile Photo!" +
                "\n\t25.Sign out!" +
                "\n\t26.Feedback&Support" +
                "\n\t27.Create new Room" +
                "\n\t28.Playground" +       // If you choose Playground to test please go to
                // the testSite method(a little bit down) and choose
                // what do you want to test. If you want to test multiple
                // methods such a stream , please put your preferences in order, and
                // don't forget to activate a specific method by choosing true
                // Check the first parameter of the method
                "\n You chose command number: " + yourchoice;
        System.out.println(text);
//        System.setProperty("webdriver.gecko.driver","C:\\Users\\Manu si Ligia\\Documents\\lib\\Selenium program\\geckodriver-mozilla\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Manu si Ligia\\Documents\\lib\\Selenium program\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        test.log(LogStatus.INFO,"Browser Started...");

        command = new FirstPage(driver);
        myAccount = new AfterLogginIn(driver);
        createRoom = new CreateRoom (driver);
        playGame = new PlayGame(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        test.log(LogStatus.INFO,"Browser Maximized...");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO,"Web Application Opened...");

    }

    @Test
    public void testSite() throws InterruptedException, IOException {

        switch (yourchoice){
            case 1:
                command.goToHomePage();
                test.log(LogStatus.PASS,"\"Go to homePage\" test done!");
                break;
            case 2:
                command.loginButton();      // just loginButton
                test.log(LogStatus.PASS,"\"Click to login button\" test done!");
                break;
            case 3:
                command.login("testITPoker@email.com","123456");

                try{
                    WebElement welcomeText = driver.findElement(By.id("profile-img"));
                    test.log(LogStatus.PASS,"\"Click to login button\" test done!");
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage());
                    String path = com.proiectManu.Screenshot.takeScreenshot(driver);
                    String imagepath=test.addScreenCapture(path);
                    test.log(LogStatus.FAIL,"Test failed.Incorrect email!",imagepath);
                }
                break;
            case 4:
                command.signUpHeaderButton();
                test.log(LogStatus.PASS,"\"SignUp Header button\" test done!");
                break;
            case 5:
                command.signUpHeaderCreateAccount("Full Name","test@email.com","123456",false);
                test.log(LogStatus.PASS,"\"SignUp Header and create account\" test done!");
                break;
            case 6:
                command.signUpNowButton();
                test.log(LogStatus.PASS,"\"SignUpNow button\" test done!");
                break;
            case 7:
                command.signUpNowCreateAccount("Full Name","test@email.com","123456",false);
                test.log(LogStatus.PASS,"\"SignUpNow button and create account\" test done!");
                break;
            case 8:
                command.startAQuickPlay("Emanuel");
                test.log(LogStatus.PASS,"\"StartAQuickPlay\" test done!");
                break;
            case 9:
                command.hireDevelopers();
                test.log(LogStatus.PASS,"\"Hire Developers\" test done!");
                break;
            case 10:
                command.findOutMore();
                test.log(LogStatus.PASS,"\"Find out More\" test done!");
                break;
            case 11:
                command.codeFirstLinkBelowAboutTitle();
                test.log(LogStatus.PASS,"\"Code first link\" test done!");
                break;
            case 12:
                command.emailUsCommand();
                test.log(LogStatus.PASS,"\"Email Us\" test done!");
                break;
            case 13:
                command.codeFirstLinkBelowOurWebsiteTitle();
                test.log(LogStatus.PASS,"\"Code first link\" test done!");
                break;
            case 14:
                command.topVet();
                test.log(LogStatus.PASS,"\"Top Vet\" test done!");
                break;
            case 15:
                command.planItPoker();
                test.log(LogStatus.PASS,"\"Plan iTPoker\" test done!");
                break;
            case 16:
                command.goToFacebook();
                test.log(LogStatus.PASS,"\"Go to Facebook\" test done!");
                break;
            case 17:
                command.goToTwitter();
                test.log(LogStatus.PASS,"\"Go to Twitter\" test done!");
                break;
            case 18:
                command.goToLinkedln();
                test.log(LogStatus.PASS,"\"Go to Linkedln\" test done!");
                break;
            case 19:
                command.customSoftwareDevelopmentByButton();
                test.log(LogStatus.PASS,"\"Custom Software Development\" test done!");
                break;
            case 20:
                command.codeFirstLogo();
                test.log(LogStatus.PASS,"\"Code first logo\" test done!");
                break;
            case 21:
                command.providersofFirstClassDevelopers();
                test.log(LogStatus.PASS,"\"Providers of First class Developers\" test done!");
                break;
            case 22:
                command.privacyPolicy();
                test.log(LogStatus.PASS,"\"Privacy Policy\" test done!");
                break;
            case 23:
                command.termsAndConditions();
                test.log(LogStatus.PASS,"\"Terms and Conditions\" test done!");
                break;
            case 24:
                command.login("testITPoker@email.com","123456");
                try{
                    WebElement welcomeText = driver.findElement(By.id("profile-img"));
                    test.log(LogStatus.PASS,"\"Click to login button\" test done!");
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage());
                    String path = com.proiectManu.Screenshot.takeScreenshot(driver);
                    String imagepath=test.addScreenCapture(path);
                    test.log(LogStatus.FAIL,"Test failed.Incorrect email!",imagepath);
                }
                myAccount.changePhotoProfile();
                test.log(LogStatus.PASS,"\"Change profile photo\" test done!");
                break;
            case 25:
                command.login("testITPoker@email.com","123456");
                try{
                    WebElement welcomeText = driver.findElement(By.id("profile-img"));
                    test.log(LogStatus.PASS,"\"Click to login button\" test done!");
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage());
                    String path = com.proiectManu.Screenshot.takeScreenshot(driver);
                    String imagepath=test.addScreenCapture(path);
                    test.log(LogStatus.FAIL,"Test failed.Incorrect email!",imagepath);
                }
                myAccount.signOut();
                test.log(LogStatus.PASS,"\"Sign out account\" test done!");
                break;
            case 26:
                command.login("testITPoker@email.com","123456");
                try{
                    WebElement welcomeText = driver.findElement(By.id("profile-img"));
                    test.log(LogStatus.PASS,"\"Click to login button\" test done!");
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage());
                    String path = com.proiectManu.Screenshot.takeScreenshot(driver);
                    String imagepath=test.addScreenCapture(path);
                    test.log(LogStatus.FAIL,"Test failed.Incorrect email!",imagepath);
                }
                myAccount.openFeedBackSupportwindow();
                test.log(LogStatus.PASS,"\"Open Feedback&Support window\" test done!");
                break;
            case 27:
                command.startAQuickPlay("Emanuel");
                test.log(LogStatus.PASS,"\"Start a quick play button\" test done!");
                createRoom.createNewRoom("newRoom", TypeOfRoom.Scrum,"Hi! I'm new here!", Click.save_And_Close,true);
                test.log(LogStatus.PASS,"\"Create room\" test done!");
                break;
            case 28:
                command.startAQuickPlay("Emanuel");
                test.log(LogStatus.PASS,"\"Start a quick play button\" test done!");
                try {
                    createRoom.createNewRoom("newRoom", TypeOfRoom.Fibonacci, "Hi! I'm new here!", Click.save_And_Close, true);
                    // if you want to upload
                    // a CSV file choose true,if not choose false
                    test.log(LogStatus.PASS,"\"Create new Room\" test done!");
                }catch (NoSuchElementException e){
                    String path = com.proiectManu.Screenshot.takeScreenshot(driver);
                    String imagepath=test.addScreenCapture(path);
                    test.log(LogStatus.FAIL,"Test failed.Creating the camera was not possible!",imagepath);
                }

                try {
                    playGame.playButton();
                    test.log(LogStatus.PASS, "Play game!");
                }catch (NoSuchElementException e){
                    String path = com.proiectManu.Screenshot.takeScreenshot(driver);
                    String imagepath=test.addScreenCapture(path);
                    test.log(LogStatus.FAIL,"Test failed.The Play button has not been pressed!",imagepath);
                }
                try {
                    playGame.chooseACard(TypeOfRoom.Fibonacci, 4, 5, false);//===> if you want to go to the next story choose true
                    // if you want to clear story choose false
                    test.log(LogStatus.PASS, "Choose a card!");
                }catch (NoSuchElementException e) {
                    String path = com.proiectManu.Screenshot.takeScreenshot(driver);
                    String imagepath = test.addScreenCapture(path);
                    test.log(LogStatus.FAIL, "Test failed.The choice of a playing card was not made!", imagepath);
                }
                playGame.addStorie(false,"Is another story",Click.save_And_Close,true); // if you want to upload
                //a CSV file choose true,if not choose false
                playGame.activeStories(false,false,"New story");

                playGame.skipStory(false,false); //===> if you want to go to the next story choose true
                // if you want to clear story choose false
                playGame.inviteATeammate(false);
                playGame.editStories(false,true,true,true,false,false,false,false,true,false);
                playGame.allStories(false,false,"Story modified",4);
                playGame.completedStories(false);
                playGame.clearVotesButton(false);
                playGame.resetTimer(false);
                playGame.flipCards(false,TypeOfRoom.Playing_cards,4,4,false);
                // ===> if you want to go to the next story choose true
                // if you want to clear story choose false
                try {
                    playGame.undoEditDelete(undoEditDelete.undo, false, false, "New modify", TypeOfRoom.Sequential);
                    test.log(LogStatus.PASS, "Undo/edit/delete done!");

                }catch (NoSuchElementException e) {
                    String path = com.proiectManu.Screenshot.takeScreenshot(driver);
                    String imagepath = test.addScreenCapture(path);
                    test.log(LogStatus.FAIL, "Test failed.Undo/edit/delete wasn't realized!", imagepath);
                }
                myAccount.signOut();
                test.log(LogStatus.PASS, "Sign out done!");

                break;
            default:
                driver.quit();
                break;
        }
    }

    @AfterClass
    public void cleanUp() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
        report.endTest(test);
        report.flush();
    }

}