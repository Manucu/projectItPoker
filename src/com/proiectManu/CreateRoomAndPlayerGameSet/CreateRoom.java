package com.proiectManu.CreateRoomAndPlayerGameSet;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;


public class CreateRoom {
   WebDriver driver;
   Robot robot = new Robot();
   ExtentTest test;


    public CreateRoom(WebDriver driver) throws AWTException {
        this.driver=driver;
    }

    public void createNewRoom(String roomName, Enum TypeOfRoom,String yourStory,Enum Click,boolean CSVoooXML) throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,3);
        WebElement locatorRoomName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='createRoomNameInput']")));
        String locator = "//div[@class='col-sm-4']//div[@class='select-div']";
        createRoom(roomName,TypeOfRoom,locatorRoomName,locator);

        WebElement create = driver.findElement(By.xpath("//button[@class='btn btn-default btn-block btn-ok'][contains(text(),'Create')]"));
        create.click();
        Thread.sleep(2000);

        createNewStory(yourStory,Click,CSVoooXML);
        WebElement end=driver.findElement(By.xpath("//button[contains(text(),'End tour')]"));
        end.click();
        Thread.sleep(3000);

    }

    public void createRoom(String roomName,Enum TypeOfRoom,WebElement locatorRoomName,String locator) throws InterruptedException {

        locatorRoomName.clear();
        locatorRoomName.sendKeys(roomName);

        WebDriverWait wait = new WebDriverWait(driver,3);
        WebElement locatorTypeRoom = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        locatorTypeRoom.click();
        WebElement chooseOne = driver.findElement(By.xpath(locator +"//select"));
        Thread.sleep(2000);


        Select sel = new Select(chooseOne);
        int option= TypeOfRoom.ordinal();
        sel.selectByIndex(option);
        Thread.sleep(1000);

        WebElement customize = driver.findElement(By.className("panel-heading"));
        executeJs(customize);
        Thread.sleep(1000);
        customizeCardValue(TypeOfRoom,true);
        createFormhaveStories(true,true,true,true,false,false);

    }
    public void createNewStory(String yourStory,Enum Click,boolean CSVoooXML) throws InterruptedException {
        WebElement writeSomething = driver.findElement(By.xpath("//textarea[@name='inputName']"));
        writeSomething.sendKeys(yourStory);

        if(Click.ordinal()==0) {
            WebElement saveANDaddNew = driver.findElement(By.xpath("//button[contains(text(),'Save & Add New')]"));
            saveANDaddNew.click();
            Thread.sleep(2000);
            WebElement close = driver.findElement(By.xpath("//form[@name='createStoryForm']//button[@class='btn btn-default btn-block btn-cancel'][contains(text(),'Cancel')]"));
            close.click();
        }else if(Click.ordinal()==1){
            WebElement saveANDclose = driver.findElement(By.xpath("//button[contains(text(),'Save & Close')]"));
            saveANDclose.click();
        }else if(Click.ordinal()==2) {
            WebElement upload = driver.findElement(By.xpath("//span[@class='dropdown-toggle btn btn-default btn-block fileinput-button btn-ok']"));
            upload.click();
            Thread.sleep(2000);

            if(CSVoooXML){
                csvFile();
            }else{
                xmlFile();
            }
            WebElement close = driver.findElement(By.xpath("//form[@name='createStoryForm']//button[@class='btn btn-default btn-block btn-cancel'][contains(text(),'Cancel')]"));
            close.click();
        }else {
            WebElement close = driver.findElement(By.xpath("//form[@name='createStoryForm']//button[@class='btn btn-default btn-block btn-cancel'][contains(text(),'Cancel')]"));
            close.click();
        }
    }
    public void csvFile() throws InterruptedException {
        WebElement csv = driver.findElement(By.xpath("//span[contains(text(),'Upload Simple CSV')]"));
        executeJs(csv);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void xmlFile() throws InterruptedException {
        WebElement xml = driver.findElement(By.xpath("//span[contains(text(),'Upload Jira XML')]"));
        executeJs(xml);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void customizeCardValue( Enum TypeOfRoom,boolean useAllCards) throws InterruptedException {

        if(useAllCards){
            WebElement useAll = driver.findElement(By.xpath("//div[@class='col-sm-12']//label//input[@ng-model='createForm.cardsCustomize.useAll']"));
            executeJs(useAll);
            executeJs(useAll);
        }else if(TypeOfRoom.ordinal() == 0){
            scrumCheckBok(true,false,true,false,true,
                    false,true,false,true,false,true,true,true);
        }else if(TypeOfRoom.ordinal() == 1){
            fibonacciCheckBox(true,false,true,false,true,false,true,
                    false,true,false,true,true,true);
        }else if(TypeOfRoom.ordinal() == 2){
            sequentialCheckBox(false,true,false,true,false,true,
                    false,true,false,true,false,true,true);
        }else if(TypeOfRoom.ordinal() == 3){
            playingCardsCheckBox(true,false,true,false,true,false,true,false);
        }else{
            T_ShirtCheckBox(false,false,true,false,false,false,false,true);
        }
    }



    public void createFormhaveStories(boolean EnterStories,boolean RequestConfirmation,
                                      boolean SeeVotePlayers,boolean AutoReveal,boolean AllowPlayerToChangeVote,
                                      boolean UseCounterDownTimer) throws InterruptedException {
        if(!EnterStories){
        WebElement stories=driver.findElement(By.xpath("//input[@ng-model='createForm.haveStories']//parent::span[@class='custom-checkbox sm-checkbox selected']"));
        executeJs(stories);
        }
        if(!RequestConfirmation){
        WebElement requestConfirmation = driver.findElement(By.xpath("//input[@ng-model='createForm.confirmSkip']//parent::span[@class='custom-checkbox sm-checkbox selected']"));
        executeJs(requestConfirmation);
        }
        if(!SeeVotePlayers){
        WebElement playersVoting = driver.findElement(By.xpath("//input[@ng-model='createForm.showVotingToObservers']//parent::span[@class='custom-checkbox sm-checkbox selected']"));
        executeJs(playersVoting);
        }
        if(!AutoReveal){
        WebElement autoReveal = driver.findElement(By.xpath("//input[@ng-model='createForm.autoReveal']//parent::span[@class='custom-checkbox sm-checkbox selected']"));
        executeJs(autoReveal);
        }
        if(AllowPlayerToChangeVote){
        WebElement allowPlayerToChange = driver.findElement(By.xpath("//input[@ng-model='createForm.changeVote']//parent::span[@class='custom-checkbox sm-checkbox']"));
        executeJs(allowPlayerToChange);
        }
        if(UseCounterDownTimer){
        WebElement countdownTimer = driver.findElement(By.xpath("//input[@ng-model='countdownTimer']//parent::span[@class='custom-checkbox sm-checkbox']"));
        executeJs(countdownTimer);
        }
    }

    public void executeJs(WebElement name) throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", name);
        Thread.sleep(2000);
    }


    /////You don't need to modify something, here you find locators for checkbox
    public void scrumCheckBok(boolean zero, boolean half, boolean one, boolean two, boolean three,
                              boolean five, boolean eight, boolean thirteen, boolean twenty, boolean forty,
                              boolean oneHundred, boolean questionMark, boolean coffee) throws InterruptedException {
        if(zero){
            WebElement use0=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=0]//preceding-sibling::span"));
            executeJs(use0);
        }
        if(half){
            WebElement use1=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=1]//preceding-sibling::span"));
            executeJs(use1);
        }
        if(one){
            WebElement use2=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=2]//preceding-sibling::span"));
            executeJs(use2);
        }
        if(two){
            WebElement use3=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=3]//preceding-sibling::span"));
            executeJs(use3);
        }
        if(three){
            WebElement use4=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=4]//preceding-sibling::span"));
            executeJs(use4);
        }
        if(five){
            WebElement use5=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=5]//preceding-sibling::span"));
            executeJs(use5);
        }
        if(eight){
            WebElement use6=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=6]//preceding-sibling::span"));
            executeJs(use6);
        }
        if(thirteen){
            WebElement use7=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=7]//preceding-sibling::span"));
            executeJs(use7);
        }
        if(twenty){
            WebElement use8=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=8]//preceding-sibling::span"));
            executeJs(use8);
        }
        if(forty){
            WebElement use9=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=9]//preceding-sibling::span"));
            executeJs(use9);
        }
        if(oneHundred){
            WebElement use10=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=10]//preceding-sibling::span"));
            executeJs(use10);
        }
        if(questionMark){
            WebElement use11=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='?']//preceding-sibling::span"));
            executeJs(use11);
        }
        if(coffee){
            WebElement use12=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='Coffee']//preceding-sibling::span"));
            executeJs(use12);
        }
    }

    public void fibonacciCheckBox(boolean zero, boolean one, boolean two, boolean three, boolean five,
                              boolean eight, boolean thirteen, boolean twentyone, boolean thirtyfor, boolean fiftyfive,
                              boolean eightynine, boolean questionMark, boolean coffee) throws InterruptedException {
        if(zero){
            WebElement use0=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=0]//preceding-sibling::span"));
            executeJs(use0);
        }
        if(one){
            WebElement use1=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=1]//preceding-sibling::span"));
            executeJs(use1);
        }
        if(two){
            WebElement use2=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=2]//preceding-sibling::span"));
            executeJs(use2);
        }
        if(three){
            WebElement use3=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=3]//preceding-sibling::span"));
            executeJs(use3);
        }
        if(five){
            WebElement use4=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=4]//preceding-sibling::span"));
            executeJs(use4);
        }
        if(eight){
            WebElement use5=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=5]//preceding-sibling::span"));
            executeJs(use5);
        }
        if(thirteen){
            WebElement use6=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=6]//preceding-sibling::span"));
            executeJs(use6);
        }
        if(twentyone){
            WebElement use7=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=7]//preceding-sibling::span"));
            executeJs(use7);
        }
        if(thirtyfor){
            WebElement use8=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=8]//preceding-sibling::span"));
            executeJs(use8);
        }
        if(fiftyfive){
            WebElement use9=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=9]//preceding-sibling::span"));
            executeJs(use9);
        }
        if(eightynine){
            WebElement use10=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=10]//preceding-sibling::span"));
            executeJs(use10);
        }
        if(questionMark){
            WebElement use11=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='?']//preceding-sibling::span"));
            executeJs(use11);
        }
        if(coffee){
            WebElement use12=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='Coffee']//preceding-sibling::span"));
            executeJs(use12);
        }
    }

    public void sequentialCheckBox(boolean zero, boolean one, boolean two, boolean three, boolean four,
                                  boolean five, boolean six, boolean seven, boolean eight, boolean nine,
                                  boolean ten, boolean questionMark, boolean coffee) throws InterruptedException {
        if(zero){
            WebElement use0=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=0]//preceding-sibling::span"));
            executeJs(use0);
        }
        if(one){
            WebElement use1=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=1]//preceding-sibling::span"));
            executeJs(use1);
        }
        if(two){
            WebElement use2=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=2]//preceding-sibling::span"));
            executeJs(use2);
        }
        if(three){
            WebElement use3=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=3]//preceding-sibling::span"));
            executeJs(use3);
        }
        if(four){
            WebElement use4=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=4]//preceding-sibling::span"));
            executeJs(use4);
        }
        if(five){
            WebElement use5=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=5]//preceding-sibling::span"));
            executeJs(use5);
        }
        if(six){
            WebElement use6=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=6]//preceding-sibling::span"));
            executeJs(use6);
        }
        if(seven){
            WebElement use7=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=7]//preceding-sibling::span"));
            executeJs(use7);
        }
        if(eight){
            WebElement use8=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=8]//preceding-sibling::span"));
            executeJs(use8);
        }
        if(nine){
            WebElement use9=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=9]//preceding-sibling::span"));
            executeJs(use9);
        }
        if(ten){
            WebElement use10=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=10]//preceding-sibling::span"));
            executeJs(use10);
        }
        if(questionMark){
            WebElement use11=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='?']//preceding-sibling::span"));
            executeJs(use11);
        }
        if(coffee){
            WebElement use12=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='Coffee']//preceding-sibling::span"));
            executeJs(use12);
        }
    }

    public void T_ShirtCheckBox(boolean XS, boolean S, boolean M, boolean L, boolean XL,
                                   boolean XXL, boolean questionMark, boolean coffee) throws InterruptedException {
        if(XS){
            WebElement use0=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=0]//preceding-sibling::span"));
            executeJs(use0);
        }
        if(S){
            WebElement use1=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=1]//preceding-sibling::span"));
            executeJs(use1);
        }
        if(M){
            WebElement use2=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=2]//preceding-sibling::span"));
            executeJs(use2);
        }
        if(L){
            WebElement use3=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=3]//preceding-sibling::span"));
            executeJs(use3);
        }
        if(XL){
            WebElement use4=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=4]//preceding-sibling::span"));
            executeJs(use4);
        }
        if(XXL){
            WebElement use5=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=5]//preceding-sibling::span"));
            executeJs(use5);
        }
        if(questionMark){
            WebElement use11=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='?']//preceding-sibling::span"));
            executeJs(use11);
        }
        if(coffee){
            WebElement use12=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='Coffee']//preceding-sibling::span"));
            executeJs(use12);
        }
    }

    public void playingCardsCheckBox(boolean ace, boolean two, boolean three, boolean five, boolean eight,
                                     boolean king, boolean questionMark, boolean coffee) throws InterruptedException {
        if(ace){
            WebElement use0=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=0]//preceding-sibling::span"));
            executeJs(use0);
        }
        if(two){
            WebElement use1=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=1]//preceding-sibling::span"));
            executeJs(use1);
        }
        if(three){
            WebElement use2=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=2]//preceding-sibling::span"));
            executeJs(use2);
        }
        if(five){
            WebElement use3=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=3]//preceding-sibling::span"));
            executeJs(use3);
        }
        if(eight){
            WebElement use4=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=4]//preceding-sibling::span"));
            executeJs(use4);
        }
        if(king){
            WebElement use5=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()=5]//preceding-sibling::span"));
            executeJs(use5);
        }
        if(questionMark){
            WebElement use11=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='?']//preceding-sibling::span"));
            executeJs(use11);
        }
        if(coffee){
            WebElement use12=driver.findElement(By.xpath("//div[@ng-show='createForm.cardSetType == 3']//div//span[text()='Coffee']//preceding-sibling::span"));
            executeJs(use12);
        }
    }


}
