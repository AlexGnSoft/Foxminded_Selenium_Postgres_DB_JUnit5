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
    public void returnTitleForCategoryRazrabotka(){
        openBrowser();
        OpenPage.clickToSignIn();
        MenuDashboard.click(MenuDashboard.closeButton);
        MenuDashboard.click(MenuDashboard.minimizeSideBarBtn);
        MenuDashboard.click(MenuDashboard.dashboardTab);
        MenuDashboard.click(MenuDashboard.needImmediateReactionButton);
        MenuDashboard.returnTitleNameForCategory(MenuDashboard.titleList, MenuDashboard.categoryList, MenuDashboard.razrabotka);

    }

    @Test
    public void returnTitleForCategoryFinance(){
        openBrowser();
        OpenPage.clickToSignIn();
        MenuDashboard.click(MenuDashboard.closeButton);
        MenuDashboard.click(MenuDashboard.minimizeSideBarBtn);
        MenuDashboard.click(MenuDashboard.dashboardTab);
        MenuDashboard.click(MenuDashboard.needImmediateReactionButton);
        MenuDashboard.returnTitleNameForCategory(MenuDashboard.titleList, MenuDashboard.categoryList, MenuDashboard.finance);
    }
}
