package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;

public class CategoriesPage extends BaseTestConfiguration {
    private static final By categoriesPage = By.xpath("//div[@class='container-fluid']");
    private static final By newCategoryBtn = By.xpath("//button[@id='new-category-btn']");
    private static final By firstEditBtn = By.xpath("//tbody/tr[2]/td[3]/a[1]/i[1]");
    private static final By secondEditBtn = By.xpath("//tbody/tr[3]/td[3]/a[1]/i[1]");
    private static final By deleteBtn = By.xpath("//tbody/tr[3]/td[4]/a[1]");
    private static final By fistCategoryInTheList = By.xpath("//tbody/tr[2]/td[1]/a[1]");





}
