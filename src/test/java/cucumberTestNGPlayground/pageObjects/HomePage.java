package cucumberTestNGPlayground.pageObjects;

import cucumberTestNGPlayground.managers.FileReaderManager;
import cucumberTestNGPlayground.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    public static final String UL_ROLE_LISTBOX_LI_ROLE_PRESENTATION_DIV_ROLE_OPTION_SPAN = "//ul[@role='listbox']/li[@role='presentation']//div[@role='option']//span";
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "q")
    private WebElement input_query;

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement button_btnK;

    public boolean isPageTitleEqTo(String string) {
        return driver.getTitle().equals(string);
    }

    public  void navigateToHomePage(){
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void clickOn_Cart() {
        input_query.click();
    }

    public void clickOn_searchButton(){
        button_btnK.click();
        Wait.untilPageLoadComplete(driver);
    }

    public void fillInSearchQuery(String string) {
        input_query.sendKeys(string);
    }

    public List<String> getSuggestedSearchList() {
        List<String> suggestedSearchValues = new ArrayList<>();
        List<WebElement>elements = driver.findElements(By.xpath(UL_ROLE_LISTBOX_LI_ROLE_PRESENTATION_DIV_ROLE_OPTION_SPAN));
        elements.stream().forEach(webElement -> suggestedSearchValues.add(webElement.getText()));
        return  suggestedSearchValues;
    }
}