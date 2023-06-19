package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class pmxGroup_Tab_page extends Parent {

    public pmxGroup_Tab_page(){
        PageFactory.initElements(BaseDriver.getDriver(),this); }

    @FindBy(id = "menu-item-254")
    public WebElement pmxGroup_Tab;

    @FindBy(id = "menu-item-2691")
    public WebElement pmxEngineering_Tab;

    @FindBy(css = "a[class*='linkedin footer']")
    public WebElement linkedIn_symbol;








}
