package AlertMng.Pages.locators;

import fours.base.BasePage;
import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ResolveAlertPageLocators{
	
	@FindBy(xpath = "//button[contains(text(),'Resolve')]")
	public WebElement resolvebtn;

	
	@FindBy(xpath = "//textarea[@id='basic_resolvedText']")
	public WebElement resolvemsg;
	

	@FindBy(xpath = "//button[@type='submit'][contains(.,'Resolve')]")
	public WebElement resolve;


}
