import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.GlobalPages;
import pageobjects.OpenPage;
import pageobjects.TicketsPage;

public class TestExecution_10 extends BaseTestConfiguration {
    @Test
    public void verifyThatCreateNewTicketPageIsVisible(){
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        clickOnWebElement(TicketsPage.newTicketBtn);

        //Wait for 'Create New Ticket' page to be interactive
        Assertions.assertTrue(pageIsVisible(TicketsPage.createTicketPage));
    }

    @Test
    public void navigationBackAndForward(){
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        clickOnWebElement(TicketsPage.newTicketBtn);

        //While being on  create new ticker page go back and forward
        GlobalPages.navigateBackAndForth(TicketsPage.createTicketPage);
    }

    @Test
    public void visibilityOfPlaceholders(){
        //Test data
        String expectedPlaceHolder = "Please input your description here...";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        clickOnWebElement(TicketsPage.newTicketBtn);

        //While being on  create new ticker page go back and forward
        GlobalPages.placeHolderInVisible(TicketsPage.descriptionField, expectedPlaceHolder);
    }


    @Test
    public void createNewTicketEndToEnd() throws InterruptedException {
        //Test data
        String titleName = "My ticket from automation 4";
        String description = "My description to the ticket";
        String stage = "IN PROGRESS";
        String departmentName = "Комната добра";
        String contactName = "Drozdh Udahvxadb";
        int indexOfOption = 4;
        String managerName = "Ярослав Коваленко";
        String pathToTheFileOnPc = "/Users/aleksandrgnuskin/Downloads/photo_2022-06-02 08.46.39.jpeg";

        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        clickOnWebElement(TicketsPage.newTicketBtn);
        pageIsVisible(TicketsPage.createTicketPage);

        //Enter title name into title field
        GlobalPages.enterDataToTheField(TicketsPage.titleField, titleName);

        //Enter description into description field
        GlobalPages.enterDataToTheField(TicketsPage.descriptionField, description);

        //Select category by index
        TicketsPage.selectDataFromDropDownListByIndex(TicketsPage.drpCategory, indexOfOption);

        //Select stage by visible text
        TicketsPage.selectFromDropDownListByVisibleText(TicketsPage.drpStage, stage);

        //Select company by index
        TicketsPage.selectDataFromDropDownListByIndex(TicketsPage.drpCompany, 0);

        //Select contact
        TicketsPage.selectFromDropDownListByVisibleText(TicketsPage.drpContact, contactName);

        //Select priority by index
        TicketsPage.selectDataFromDropDownListByIndex(TicketsPage.drpPriority, indexOfOption);

        //Select random, but accessible date in the calendar
        TicketsPage.selectDateInCalendar();

        //Select department by visible option in the drop-down list
        TicketsPage.selectFromDropDownListByVisibleText(TicketsPage.drpDepartment, departmentName);

        //Select department by first option in the drop-down list
        TicketsPage.selectFirstOptionFromDropDownList(TicketsPage.drpDepartment);

        //Select manager
        TicketsPage.selectOptionOneByOne(TicketsPage.drpManager, managerName);

        //Upload file from pc

        TicketsPage.fileUpload(pathToTheFileOnPc);

        //Submit new ticker data
        clickOnWebElement(TicketsPage.submitBtn);

        Thread.sleep(2000);

        TicketsPage.getNamesOfAnyColumns(TicketsPage.titleList).contains(titleName);
    }
}
