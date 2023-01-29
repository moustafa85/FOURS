package AlertMng.Pages.locators;

import fours.base.BasePage;
import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OpenAlertReassignUserPageLocators{

	
	@FindBy(xpath = "//button[contains(text(),'Reassign')]")
	public WebElement reAssignbtn;

}
