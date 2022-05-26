package pageobjects;

import config.BaseTestConfiguration;
import org.openqa.selenium.By;

public class CategoriesPage extends BaseTestConfiguration {
    private static final By categoriesPage = By.xpath("//div[@class='container-fluid']");
    private static final By newCategoryBtn = By.xpath("//button[@id='new-category-btn']");
    private static final By editBtnList = By.xpath("//a[@id='category-stage-edit-btn']");
    private static final By deleteBtnList = By.xpath("//a[@id='category-delete-btn']");
    private static final By colorLabelList = By.xpath("//span[@class='label label-lg']");





}
