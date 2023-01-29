package workers.pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class DeactivateWorkerPage extends BasePage {
	AllMethods allMethods;

	public DeactivateWorkerPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[7]") 
	private WebElement deactivate;
	
	public void Deactivate() {
		allMethods.VerifyElementDisplay(deactivate);
		deactivate.click();
	}

}
