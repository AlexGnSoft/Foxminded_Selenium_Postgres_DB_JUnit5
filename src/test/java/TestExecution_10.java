import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Test;
import pageobjects.OpenPage;

public class TestExecution_10 extends BaseTestConfiguration {
    @Test
    public void CreateNewTicket(){
        // Go to application Login page
        openBrowser();

        //Make log in
        OpenPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on 'New Ticket +' button





    }

}
