package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class ZoomPage extends BasePage{
	AllMethods allMethods;

	public ZoomPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//a[@class='leaflet-control-zoom-out'][contains(.,'−')])[1]")
	WebElement zoomOut;
	
	public void ZoomOut() {
		allMethods.VerifyElementDisplay(zoomOut);
		zoomOut.click();
	}
	
	@FindBy(xpath = "//a[@class='leaflet-control-zoom-in'][contains(.,'+')]")
	WebElement zoomIn;
	
	public void ZoomIn() {
		allMethods.VerifyElementDisplay(zoomIn);
		zoomIn.click();
	}

}
