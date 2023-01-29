package AlertMng.Pages.actions;

import java.io.IOException;

import AlertMng.Pages.locators.OpenAlertReassignUserPageLocators;
import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OpenAlertReassignUserPage extends BasePage{
	AllMethods allMethods;
	OpenAlertReassignUserPageLocators openAlertReassignUserPage;

	public OpenAlertReassignUserPage() throws IOException {
		super();
		this.openAlertReassignUserPage = new OpenAlertReassignUserPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.openAlertReassignUserPage);
		allMethods = new AllMethods(driver);
	}
	
	public void Reassignbtn()
	{
		allMethods.VerifyElementDisplay(openAlertReassignUserPage.reAssignbtn);
		openAlertReassignUserPage.reAssignbtn.click();
	}
	
}
