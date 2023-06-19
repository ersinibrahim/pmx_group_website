package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.pmxGroup_Tab_page;
import utilities.BaseDriver;

import java.util.ArrayList;

public class pmxGroup_Tab_Steps {

    pmxGroup_Tab_page pmxGroup_tab_page;
    WebDriver driver= BaseDriver.getDriver();
    String linkedIn_Link;
    Actions action= new Actions(driver);


    public pmxGroup_Tab_Steps(pmxGroup_Tab_page pmxGroup_tab_page) {
        this.pmxGroup_tab_page=pmxGroup_tab_page;


    }
    @Given("^Navigate to pmx_group Website$")
    public void navigate_to_pmx_group_Website() {

        driver.get("https://company-de.pmx-group.com/");
        driver.manage().window().maximize();

    }

    @When("^Click pmx_group Tab and select pmxGroup_Engineering$")
    public void click_pmx_group_Tab_and_select_pmxGroup_Engineering()  {
        pmxGroup_tab_page.waitUntilVisible(pmxGroup_tab_page.pmxGroup_Tab);
        action.moveToElement(pmxGroup_tab_page.pmxGroup_Tab);
        action.release().perform();
        pmxGroup_tab_page.pmxEngineering_Tab.click();

    }

    @Then("^Scroll down the page and click LinkedIn symbol$")
    public void scroll_down_the_page_and_click_LinkedIn_symbol()  {

        pmxGroup_tab_page.scrollToElement(pmxGroup_tab_page.linkedIn_symbol);
        pmxGroup_tab_page.waitUntilClickable(pmxGroup_tab_page.linkedIn_symbol);
        linkedIn_Link=pmxGroup_tab_page.linkedIn_symbol.getAttribute("href");
        System.out.println("linkedIn_Link = " + linkedIn_Link);
        pmxGroup_tab_page.linkedIn_symbol.click();

    }

    @Then("^Check Page Url$")
    public void check_Page_Url() {
        ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String linkedIn_Page= driver.getCurrentUrl();
        System.out.println("linkedIn_Page = " + linkedIn_Page);
        Assert.assertTrue(linkedIn_Link.contains(linkedIn_Page));

    }



}
