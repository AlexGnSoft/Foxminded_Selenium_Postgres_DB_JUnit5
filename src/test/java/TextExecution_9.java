import config.BaseTestConfiguration;
import org.junit.jupiter.api.Test;
import pageobjects.MenuDashboard;
import pageobjects.OpenPage;
import pageobjects.TicketsPage;

public class TextExecution_9 extends BaseTestConfiguration{

    @Test
    public void printIdValue(){
        TicketsPage.printValueOfColumn(TicketsPage.idList);
    }

    @Test
    public void printTitleValue(){
        TicketsPage.printValueOfColumn(TicketsPage.titleList);
    }

    @Test
    public void printAssigneeValue(){
        TicketsPage.printValueOfColumn(TicketsPage.assigneeList);
    }

    @Test
    public void printStagesValue(){
        TicketsPage.printValueOfColumn(TicketsPage.stageList);
    }

    @Test
    public void returnTitleByCategoryRazrabotka(){
        openBrowser();
        OpenPage.clickToSignIn();
        MenuDashboard.getToNeedImmediateReactionPage();
        MenuDashboard.returnTitleNameByCategory(MenuDashboard.titleList, MenuDashboard.categoryList, MenuDashboard.razrabotka);

    }

    @Test
    public void returnTitleByCategoryFinance(){
        openBrowser();
        OpenPage.clickToSignIn();
        MenuDashboard.getToNeedImmediateReactionPage();
        MenuDashboard.returnTitleNameByCategory(MenuDashboard.titleList, MenuDashboard.categoryList, MenuDashboard.finance);
    }

    @Test
    public void returnIDsByPriority(){
        openBrowser();
        OpenPage.clickToSignIn();
        MenuDashboard.getToNeedImmediateReactionPage();
        MenuDashboard.returnIDsByPriority(MenuDashboard.priority);
    }
}
