package AlertMng.Pages.actions;

import java.io.IOException;

import AlertMng.Pages.locators.OpenAlertAssignUserPageLocators;
import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OpenAlertAssignUserPage extends BasePage{
	AllMethods allMethods;
	OpenAlertAssignUserPageLocators openAlertAssignUserPage;

	public OpenAlertAssignUserPage() throws IOException {
		super();
		this.openAlertAssignUserPage = new OpenAlertAssignUserPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.openAlertAssignUserPage);
		allMethods = new AllMethods(driver);
	}

	
	public void Assignbtn() {
		allMethods.VerifyElementDisplay(openAlertAssignUserPage.assignbtn);
		openAlertAssignUserPage.assignbtn.click();
	}

}
