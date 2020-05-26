package com.proiectManu.CreateRoomAndPlayerGameSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class PlayGame extends CreateRoom{

    public PlayGame(WebDriver driver) throws AWTException {
        super(driver);
    }

    public void playButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,2);
        WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[@id='btn-start']"))));
        play.click();
        Thread.sleep(1000);
    }

    public void chooseACard(Enum TypeOfRoom, int cardNumberOrdinal,int estimateValue,boolean nextstoriesORclear) throws InterruptedException {
        if(TypeOfRoom.ordinal() == 0){
            WebElement card = driver.findElement(By.xpath("//li["+ cardNumberOrdinal +"]//button[1]//div[2]"));
            card.click();
        }else if(TypeOfRoom.ordinal() == 1){
            WebElement card = driver.findElement(By.xpath("//li["+ cardNumberOrdinal +"]//button[1]//div[2]"));
            card.click();
        }else if(TypeOfRoom.ordinal() == 2){
            WebElement card = driver.findElement(By.xpath("//li["+ cardNumberOrdinal +"]//button[1]//div[2]"));
            card.click();
        }else if(TypeOfRoom.ordinal() == 3){
            WebElement card = driver.findElement(By.xpath("//li["+ cardNumberOrdinal +"]//button[1]//div[2]"));
            card.click();
        }else{
            WebElement card = driver.findElement(By.xpath("//li["+ cardNumberOrdinal +"]//button[1]//div[2]"));
            card.click();
        }
        Thread.sleep(3000);
        WebElement finalEstimate= driver.findElement(By.xpath("//select[@id='finalEstimate']"));
        Select sel = new Select(finalEstimate);
        int option= estimateValue;
        sel.selectByIndex(option);
        Thread.sleep(3000);

        WebElement finishingVoting = driver.findElement(By.xpath("//button[contains(text(),'Finish')]"));
        finishingVoting.click();
        Thread.sleep(2000);
        if(nextstoriesORclear){
            WebElement next = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
            next.click();
        }else{
            WebElement clear= driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
            clear.click();
            Thread.sleep(2000);
        }

    }

    public void flipCards(boolean flip,Enum TypeOfRoom, int cardNumberOrdinal,int estimateValue,boolean nextstoriesORclear) throws InterruptedException {
        if(flip){
            WebElement flipC =driver.findElement(By.xpath("//button[contains(text(),'Flip Cards')]"));
            flipC.click();
            chooseACard(TypeOfRoom,cardNumberOrdinal,estimateValue,nextstoriesORclear );
        }
    }

    public void resetTimer(boolean reset){
        if(reset) {
            WebElement rst = driver.findElement(By.xpath("//button[contains(text(),'Reset Timer')]"));
            rst.click();
        }
    }
    public void clearVotesButton(boolean clearButton){
        if(clearButton){
            WebDriverWait wait = new WebDriverWait(driver,3);
            WebElement clear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Clear')]")));
            clear.click();
        }
    }

    public void skipStory(boolean skipButton,boolean nextstoriesORclear) throws InterruptedException {
        if(skipButton) {
            WebElement skip = driver.findElement(By.xpath("//button[contains(text(),'Skip')]"));
            executeJs(skip);
            Thread.sleep(3000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.switchTo().defaultContent();

            if(nextstoriesORclear){
                WebElement next = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
                next.click();
            }else{
                WebElement clear= driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
                clear.click();
            }

        }
    }

    public void activeStories(boolean active,boolean updateORclear,String newDetails) throws InterruptedException {
        if(active ) {
            WebElement act = driver.findElement(By.xpath("//section[@class='stories-list']//span[@class='hidden-xs'][contains(text(),'Active Stories')]"));
            executeJs(act);
            WebElement change = driver.findElement(By.cssSelector("div.grayed:nth-child(2) div.container div.row div.col-xs-12 div.ng-scope section.pages-board.ng-scope:nth-child(1) div.page-board-room div.row:nth-child(3) div.col-sm-12.visible-sm.visible-xs section.stories-list div.row:nth-child(1) div.col-xs-12 div.tab-content div.tab-pane.active:nth-child(1) table.table.table-striped.table-hover tbody.active tr.clickable.ng-scope.active:nth-child(1) td.title > img.drag-icon.normal.drag-handle:nth-child(1)"));
            executeJs(change);
            WebElement newtext = driver.findElement(By.xpath("//input[@name='storyTitle']"));
            if(updateORclear) {
                newtext.sendKeys(newDetails);
            }else{
                newtext.clear();
                newtext.sendKeys(newDetails);
            }
            Thread.sleep(1000);
            WebElement save = driver.findElement(By.xpath("//div[@class='col-sm-6']//button[@ng-show='isModerator']"));
            save.click();
        }
    }
    public void completedStories(boolean completeStories){
        if(completeStories){
            WebElement complete = driver.findElement(By.xpath("//section[@class='stories-list hidden-sm hidden-xs']//div[@class='row']//div//span[@class='hidden-xs'][contains(text(),'Completed Stories')]"));
            complete.click();
        }
    }

    public void allStories (boolean changeStoriesDetails,boolean updateORclear ,String newDetails,int estimateValue) throws InterruptedException {

        if( changeStoriesDetails){

            WebElement all = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//li[3]//a//span[@class='hidden-xs'][contains(text(),'All ')]"));
            executeJs(all);
            WebElement change = driver.findElement(By.xpath("//div[@class='col-sm-12 visible-sm visible-xs']//td[1][@ng-if='displayConfig.storyName']"));
            executeJs(change);
            WebElement newtext = driver.findElement(By.xpath("//input[@name='storyTitle']"));
            if(updateORclear) {
                newtext.sendKeys(newDetails);
            }else{
                newtext.clear();
                newtext.sendKeys(newDetails);
            }
            WebElement estimate = driver.findElement(By.xpath("//div[@class='col-sm-8']//select[@id='finalEstimate']//parent::div[@ng-if='isModerator']//select[@id='finalEstimate']"));

            Select sel = new Select(estimate);
            int option= estimateValue;
            sel.selectByIndex(option);

            WebElement save = driver.findElement(By.xpath("//div[@class='col-sm-6']//button[@ng-show='isModerator']"));
            save.click();
        }
    }

    public void addStorie(boolean addStories,String newStory,Enum Click,boolean CSVoooXML) throws InterruptedException {
        if(addStories) {
            WebElement add = driver.findElement(By.xpath("//section[@class='stories-list']//button[@class='btn btn-default btn-new']"));
            executeJs(add);
            createNewStory(newStory, Click,CSVoooXML);
        }
    }

    public void editStories(boolean enable,boolean customize,boolean storyName,boolean finalEstimate,boolean maxEstimate,boolean fastest,
                            boolean timestamp, boolean minEstimate, boolean time, boolean slowest) throws InterruptedException {
       if(enable) {
           WebElement edit = driver.findElement(By.xpath("//section[@class='stories-list']//div[@class='row']//div//button[@class='btn btn-default dropdown-toggle btn-edit']//img[@class='btn-icon normal']"));
           executeJs(edit);
           if (customize) {
               WebElement custom = driver.findElement(By.xpath("//div[@class='btn-group open']//a[contains(text(),'Customize')]"));
               executeJs(custom);
               customizeStoryList(storyName, finalEstimate, maxEstimate, fastest, timestamp, minEstimate, time, slowest);
           } else {
               WebElement exportStories = driver.findElement(By.xpath("//div[@class='btn-group open']//a[contains(text(),'Export Stories')]"));
               executeJs(exportStories);
           }
       }
    }

    public void customizeStoryList(boolean storyName,boolean finalEstimate,boolean maxEstimate,boolean fastest,
                                   boolean timestamp, boolean minEstimate, boolean time, boolean slowest) throws InterruptedException {

        if(!storyName){
            WebElement box1= driver.findElement(By.xpath("//div[@class='row customize-story-row first-row']//span[contains(text(),'Story Name')]//preceding-sibling::span"));
            executeJs(box1);
        }
        if(!finalEstimate){
            WebElement box2 = driver.findElement(By.xpath("//div[@class='row customize-story-row']//span[contains(text(),'Final Estimate')]//preceding-sibling::span"));
            executeJs(box2);
        }
        if(maxEstimate){
            WebElement box3 = driver.findElement(By.xpath("//div[@class='row customize-story-row']//span[contains(text(),'Max. Estimate')]//preceding-sibling::span"));
            executeJs(box3);
        }
        if(fastest){
            WebElement box4 = driver.findElement(By.xpath("//div[@class='row customize-story-row last-row']//span[contains(text(),'Fastest')]//preceding-sibling::span"));
            executeJs(box4);
        }
        if(timestamp){
            WebElement box5 = driver.findElement(By.xpath("//div[@class='col-sm-6 col-md-4']//span[contains(text(),'Timestamp')]//preceding-sibling::span"));
            executeJs(box5);
        }
        if(minEstimate){
            WebElement box6 = driver.findElement(By.xpath("//div[@class='col-sm-6 col-md-4']//span[contains(text(),'Min. Estimate')]//preceding-sibling::span"));
            executeJs(box6);
        }
        if(!time){
            WebElement box6 = driver.findElement(By.xpath("//div[@class='col-sm-6 col-md-4']//span//input[@ng-model='form.time']//parent::span"));
            executeJs(box6);
        }
        if(slowest){
            WebElement box7 = driver.findElement(By.xpath("//div[@class='col-sm-6 col-md-4']//span//input[@ng-model='form.slowest']//parent::span"));
            executeJs(box7);
        }
        WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
        update.click();
    }

    public void undoEditDelete(Enum undoEditDelete,boolean delete,boolean modify,String newName ,Enum TypeOfRoom) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,3);
        WebElement clickImageProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-img")));
        clickImageProfile.click();
        WebElement rooms = driver.findElement(By.xpath("//a[contains(text(),'Rooms')]"));
        rooms.click();

        if(undoEditDelete.ordinal() == 0){
            WebElement undo = driver.findElement(By.xpath("//i[@class='fa fa-undo']"));
            executeJs(undo);
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }else if(undoEditDelete.ordinal()==1){
            WebElement edit = driver.findElement(By.xpath("//i[@class='fa fa-edit']"));
            executeJs(edit);
            if(modify){
            WebElement locatorNameRoom = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]"));
            locatorNameRoom.clear();
            locatorNameRoom.sendKeys(newName);
            String locatorchooseRoom = "//div[2]//div[1]//div[1]//div[1]//div[2]//form[1]//div[1]//div[2]//div[1]";
            createRoom(newName,TypeOfRoom,locatorNameRoom,locatorchooseRoom);
            WebElement save = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
            executeJs(save);
            }
        }else if(undoEditDelete.ordinal() ==2){

            if(delete){
            WebElement del=driver.findElement(By.xpath("//td[@class='delete-icon']//img[@class='normal']"));
            executeJs(del);
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            }
        }
    }

    public void inviteATeammate(boolean invite) throws InterruptedException {
        if(invite) {

            String newUrl = "https://www.planitpoker.com/board/#/room/0e90b527287743ffb072f3bbbbc14737";
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manu si Ligia\\Documents\\lib\\Selenium program\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(newUrl);
            String Url = driver.getWindowHandle();
            driver.switchTo().window(Url);
            Thread.sleep(2000);

            WebElement newPlayer = driver.findElement(By.name("inputName"));
            newPlayer.sendKeys("Ligia");
            Thread.sleep(2000);

            driver.close();

        }

    }

    @Override
    public void createRoom(String roomName, Enum TypeOfRoom,WebElement locatorRoomName,String locatorchooseRoom) throws InterruptedException {
        super.createRoom(roomName, TypeOfRoom,locatorRoomName,locatorchooseRoom);
    }
}
