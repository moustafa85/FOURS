package workers.pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class BulkUpload extends BasePage{
	AllMethods allMethods;

	public BulkUpload() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-upload']")
	WebElement uploadButton;
	
	public  void UploadButton(){
		allMethods.VerifyElementDisplay(uploadButton);
		uploadButton.click();
   }
	
	@FindBy(xpath = "//p[contains(@class,'ant-upload-drag-icon')]")
	WebElement upload;
	
	public  void Upload(){
		allMethods.VerifyElementDisplay(upload);
		upload.click();
   }
	
	@FindBy(xpath = "//span[@class='ant-switch-inner'][contains(.,'Invalid')]")
	WebElement invalidButton;
	
	public  void InvalidButton(){
		allMethods.VerifyElementDisplay(invalidButton);
		invalidButton.click();
   }
	
	@FindBy(xpath = "//span[contains(.,'Next')]")
	WebElement next;
	
	public  Boolean next(){
		if (allMethods.VerifyElementClickable(next)){
			next.click();
			return true;
		}else{
			return false;
		}


   }
	
	@FindBy(xpath = "//button[contains(.,'Upload')]")
	WebElement bulkUploadButton;
	
	public  void BulkUploadButton(){
		allMethods.VerifyElementDisplay(bulkUploadButton);
		bulkUploadButton.click();
   }
   @FindBy(xpath = "//span[@class='ant-modal-close-x']")
   WebElement btnClose;
   public Boolean clickClose(){
		if (!allMethods.VerifyElementClickable(btnClose))
				return false;
		btnClose.click();
		return true;

   }
	

}
