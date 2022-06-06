import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.OpenPage;
import pageobjects.TicketsPage;

public class TestExecution_10 extends BaseTestConfiguration {
    @Test
    public void VerifyThatCreateNewTicketPageIsVisible(){
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button
        clickOnWebElement(TicketsPage.newTicketBtn);

        //Wait for 'Create New Ticket' page to be interactive
        Assertions.assertTrue(pageIsVisible(TicketsPage.createTicketPage));
    }


}
