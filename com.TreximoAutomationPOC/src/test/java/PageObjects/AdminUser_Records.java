package PageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;

import Commons.GoClinicTest;
import jxl.read.biff.BiffException;

public class AdminUser_Records extends BasePages {

	// Objects from Application
	// Records
	String WorkOrderNumber;
	
	@FindBy(xpath = "//li//a[@href='/records' and text()='Records']")
	public WebElement lnk_Records;

	@FindBy(xpath = "//div[@id='records_index']//h1")
	public WebElement readonly_RecordsHeader;
	
	public WebElement readonly_LatestRecord(String WorkOrder, String Protocol, String PatientId,
			String Visit, String RecordCreatedDate) {
		return driver.findElement(By.xpath("//td[text()='"+WorkOrder+"']//..//td[text()='"+Protocol+"']//..//td[text()='"+PatientId+"']//..//td[text()='"+Visit+"']//..//td[text()='"+RecordCreatedDate+"']//..//td[text()='REVIEW']//..//td//a[contains(@href,'/records/')]"));

	}
	
	public WebElement Lnk_ViewLatestRecord(String WorkOrder, String Protocol, String PatientId,
			String Visit, String RecordCreatedDate) {
		return driver.findElement(By.xpath("//td[text()='"+WorkOrder+"']//..//td[text()='"+Protocol+"']//..//td[text()='"+PatientId+"']//..//td[text()='"+Visit+"']//..//td[text()='"+RecordCreatedDate+"']//..//td[text()='REVIEW']//..//td//a[contains(@href,'/records/') and text()='View']"));

	}
	
	@FindBy(xpath = "//a[@href='/records?page=2' and text()='Next ›']")
	public WebElement Lnk_Next2;
	
	@FindBy(xpath = "//a[@href='/records?page=3' and text()='Next ›']")
	public WebElement Lnk_Next3;
	
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody//tr[2]//th[text()='Record ID:']//..//td")
	public WebElement readonly_RecordID;
	
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody//tr[3]//th[text()='Work Order ID:']//..//td")
	public WebElement readonly_WorkOrdersID;
	
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody//tr[4]//th[text()='Patient ID:']//..//td")
	public WebElement readonly_PatientID;
	
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody//tr[5]//th[text()='Study Visit:']//..//td")
	public WebElement readonly_StudyVisit;
	
	@FindBy(xpath = "//input[@id='password' and @type='password']")
	public WebElement txt_Password;
	
	@FindBy(xpath = "//input[@value='Send to Study Site' and @type='submit']")
	public WebElement btn_SendToStudySite;
	
	@FindBy(xpath = "//h2[text()='Vital Signs']//..//td[contains(text(),'Blood Pressure (Systolic mm Hg)')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_BloodPressure_Systolic_mm_Hg;
	
	@FindBy(xpath = "//h2[text()='Vital Signs']//..//td[contains(text(),'Blood Pressure (Diastolic mm Hg)')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_BloodPressure_Diastolic_mm_Hg;
	
	@FindBy(xpath = "//h2[text()='Vital Signs']//..//td[contains(text(),'Heart Rate')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_HeartRate;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[contains(text(),'Text Field 1')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_TextField1;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[contains(text(),'Number Field 1')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_NumberField1;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[contains(text(),'File Field 1')]//..//td[2]//a[contains(text(),'')]")
	public WebElement readonly_FileField1;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[contains(text(),'Date Field 1')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_DateField1;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[contains(text(),'Time Field 1')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_TimeField1;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td//strong[contains(text(),'Descriptive Text 1')]//..//..//td[2][contains(text(),'')]")
	public WebElement readonly_DescriptiveText1;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[contains(text(),'Drop Down 1')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_Dropdown1;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td[contains(text(),'Radio 1')]//..//td[2][contains(text(),'')]")
	public WebElement readonly_Radio1;
	
	@FindBy(xpath = "//div[@class='notice']//p")
	public WebElement readonly_RecordSubmittedMsg;
	
	@FindBy(xpath = "//section[@class='version-history']//td[text()='Status']//..//td[text()='REVIEW']//..//td[4]")
	public WebElement readonly_AuditTrailStatus;
	

	// Each Object Performance Method
		// Records
		
		public void ClickRecords(int row) throws IOException, BiffException {	
			try {
				clickOnLink(lnk_Records, "Records ");
				WriteTestReportinExcel("Click Records link", "Create Records link should be clicked successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Click Records link", "Create Records link should be clicked successfully", "FAIL", row);
			}
			
		}
		
		public void ValidateRecordsHeader(int row, String ExpectedRecordsHeader) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_RecordsHeader, ExpectedRecordsHeader, "Validate records header");
				WriteTestReportinExcelWithScreenShot("Verify Records Header: " + ExpectedRecordsHeader, "Records Header should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Records Header: " + ExpectedRecordsHeader, "Records Header should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateLatestRecord(int row, String WorkOrder, String Protocol, String PatientId,
				String Visit, String RecordCreatedDate, String ExpectedLatestRecord) throws IOException, BiffException {
			try {
				if(driver.findElements(By.xpath("//td[text()='"+WorkOrder+"']//..//td[text()='"+Protocol+"']//..//td[text()='"+PatientId+"']//..//td[text()='"+Visit+"']//..//td[text()='"+RecordCreatedDate+"']//..//td[text()='REVIEW']//..//td//a[contains(@href,'/records/')]")).size() != 0)
				{
				scrollElementIntoView(readonly_LatestRecord(WorkOrder, Protocol, PatientId,
						Visit, RecordCreatedDate));
				verifyTextEqual(readonly_LatestRecord(WorkOrder, Protocol, PatientId,
						Visit, RecordCreatedDate), ExpectedLatestRecord, "Validate latest record");
				}
				else {
				scrollElementIntoView(Lnk_Next2);
				clickOnLink(Lnk_Next2, "Next");
				if(driver.findElements(By.xpath("//td[text()='"+WorkOrder+"']//..//td[text()='"+Protocol+"']//..//td[text()='"+PatientId+"']//..//td[text()='"+Visit+"']//..//td[text()='"+RecordCreatedDate+"']//..//td[text()='REVIEW']//..//td//a[contains(@href,'/records/')]")).size() != 0) {
					scrollElementIntoView(readonly_LatestRecord(WorkOrder, Protocol, PatientId,
							Visit, RecordCreatedDate));
					verifyTextEqual(readonly_LatestRecord(WorkOrder, Protocol, PatientId,
							Visit, RecordCreatedDate), ExpectedLatestRecord, "Validate latest record");
				}
				else {
					scrollElementIntoView(Lnk_Next3);
					clickOnLink(Lnk_Next3, "Next");
					if(driver.findElements(By.xpath("//td[text()='"+WorkOrder+"']//..//td[text()='"+Protocol+"']//..//td[text()='"+PatientId+"']//..//td[text()='"+Visit+"']//..//td[text()='"+RecordCreatedDate+"']//..//td[text()='REVIEW']//..//td//a[contains(@href,'/records/')]")).size() != 0)
					{
						scrollElementIntoView(readonly_LatestRecord(WorkOrder, Protocol, PatientId,
								Visit, RecordCreatedDate));
					verifyTextEqual(readonly_LatestRecord(WorkOrder, Protocol, PatientId,
							Visit, RecordCreatedDate), ExpectedLatestRecord, "Validate latest record");
					}
					}
				}
				WriteTestReportinExcelWithScreenShot("Verify Latest Record", "Latest Record should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Latest Record", "Latest Record should be verified successfully", "FAIL", row);
			}
			

		}
		public void ClickViewLatestRecord(int row, String WorkOrder, String Protocol, String PatientId,
				String Visit, String RecordCreatedDate) throws IOException, BiffException {		
			try {
				scrollElementIntoView(Lnk_ViewLatestRecord(WorkOrder, Protocol, PatientId,
						Visit, RecordCreatedDate));
				clickOnLink(Lnk_ViewLatestRecord(WorkOrder, Protocol, PatientId,
						Visit, RecordCreatedDate), "View");
				WriteTestReportinExcelWithScreenShot("Click Latest Record View link", "Latest Record View link should be clicked successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Click Latest Record View link", "Latest Record View link should be clicked successfully", "FAIL", row);
			}
			
		}
		
		public void EnterPassword(int row) throws IOException, BiffException {
			try {
				enterText(txt_Password, "Password", GoClinicTest.TestSettingsObjects.getProperty("AdminUserPassword"));
				WriteTestReportinExcelWithScreenShot("Enter Password", "Password should be entered successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Enter Password", "Password should be entered successfully", "FAIL", row);
			}
			
		}
		
		public void ClickSendToStudySite(int row) throws IOException, BiffException {	
			try {
				scrollElementIntoView(btn_SendToStudySite);
				clickOnButton(btn_SendToStudySite, "Send to Study Site");
				WriteTestReportinExcel("Click Send to Study Site button", "Send to Study Site button should be clicked successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Click Send to Study Site button", "Send to Study Site button should be clicked successfully", "FAIL", row);
			}
			
		}
		
			
		// Each Object Performance Method
			// Verification Section
		
		public void ValidateRecordID(int row, String ExpectedRecordID) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_RecordID, ExpectedRecordID, "Record ID is ");
				WriteTestReportinExcel("Verify Record ID value: " + ExpectedRecordID, "Record ID value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Record ID value: " + ExpectedRecordID, "Record ID value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateWorkOrdersID(int row, String ExpectedWorkOrderID) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_WorkOrdersID, ExpectedWorkOrderID,	"Work Order Number is ");
				WriteTestReportinExcel("Verify Work Orders ID value: " + ExpectedWorkOrderID, "Work Orders ID value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Work Orders ID value: " + ExpectedWorkOrderID, "Work Orders ID value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidatePatientID(int row, String ExpectedPatientID) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_PatientID, ExpectedPatientID, "Patient ID is ");
				WriteTestReportinExcel("Verify Patient ID value: " + ExpectedPatientID, "Patient ID value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Patient ID value: " + ExpectedPatientID, "Patient ID value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateStudyVisit(int row, String ExpectedStudyVisit) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_StudyVisit, ExpectedStudyVisit, "Visit Value is ");
				WriteTestReportinExcel("Verify Visit value: " + ExpectedStudyVisit, "Visit value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Visit value: " + ExpectedStudyVisit, "Visit value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateBloodPressureSystolic(int row, String ExpectedBPSystolic) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_BloodPressure_Systolic_mm_Hg, ExpectedBPSystolic, "Blood Pressure Systolic Value is ");
				WriteTestReportinExcelWithScreenShot("Verify Blood Pressure Systolic value: " + ExpectedBPSystolic, "Blood Pressure Systolic value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Blood Pressure Systolic value: " + ExpectedBPSystolic, "Blood Pressure Systolic value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateBloodPressureDiastolic(int row, String ExpectedBPDiastolic) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_BloodPressure_Diastolic_mm_Hg, ExpectedBPDiastolic, "Blood Pressure Diastolic Value is");
				WriteTestReportinExcel("Verify Blood Pressure Diastolic value: " + ExpectedBPDiastolic, "Blood Pressure Diastolic value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Blood Pressure Diastolic value: " + ExpectedBPDiastolic, "Blood Pressure Diastolic value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateHeartRate(int row, String ExpectedHeartRate) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_HeartRate, ExpectedHeartRate, "Heart Rate Value is");
				WriteTestReportinExcel("Verify Heart Rate value: " + ExpectedHeartRate, "Heart Rate value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Heart Rate value: " + ExpectedHeartRate, "Heart Rate value should be verified successfully", "FAIL", row);
			}
			

		}		
		
		public void ValidateTextField1(int row, String ExpectedTextField1) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_TextField1, ExpectedTextField1, "Text Field 1 Value is ");
				WriteTestReportinExcel("Verify Text Field 1 value: " + ExpectedTextField1, "Text Field 1 value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Text Field 1 value: " + ExpectedTextField1, "Text Field 1 value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateNumberField1(int row, String ExpectedNumberField1) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_NumberField1, ExpectedNumberField1, "Number Field 1 Value is ");
				WriteTestReportinExcel("Verify Number Field 1 value: " + ExpectedNumberField1, "Number Field 1 value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Number Field 1 value: " + ExpectedNumberField1, "Number Field 1 value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateFileField1(int row, String ExpectedFileField1) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_FileField1, ExpectedFileField1, "Number Field 1 Value is ");
				WriteTestReportinExcel("Verify File Field 1 value: " + ExpectedFileField1, "File Field 1 value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify File Field 1 value: " + ExpectedFileField1, "File Field 1 value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateDateField1(int row, String ExpectedDateField1) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_DateField1, ExpectedDateField1, "Date Field 1 Value is ");
				WriteTestReportinExcel("Verify Date Field 1 value: " + ExpectedDateField1, "Date Field 1 value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Date Field 1 value: " + ExpectedDateField1, "Date Field 1 value should be verified successfully", "FAIL", row);
			}
			

		}
		
		
		public void ValidateTimeField1(int row, String ExpectedTimeField1) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_TimeField1, ExpectedTimeField1, "Time Field 1 Value is ");
				WriteTestReportinExcel("Verify Time Field 1 value: " + ExpectedTimeField1, "Time Field 1 value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Time Field 1 value: " + ExpectedTimeField1, "Time Field 1 value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateDescriptiveText1(int row, String ExpectedDescriptiveText1) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_DescriptiveText1, ExpectedDescriptiveText1, "Descriptive Text 1 Value is ");
				WriteTestReportinExcel("Verify Descriptive Text 1 value: " + ExpectedDescriptiveText1, "Descriptive Text 1 value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Descriptive Text 1 value: " + ExpectedDescriptiveText1, "Descriptive Text 1 value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateDropDown1(int row, String ExpectedDropDownField1) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_Dropdown1, ExpectedDropDownField1, "Drop Down 1 Value is ");
				WriteTestReportinExcel("Verify Drop Down 1 value: " + ExpectedDropDownField1, "Drop Down 1 value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Drop Down 1 value: " + ExpectedDropDownField1, "Drop Down 1 value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateRadio1(int row, String ExpectedRadio1) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_Radio1, ExpectedRadio1, "Radio 1 Value is ");
				WriteTestReportinExcel("Verify Radio 1 value: " + ExpectedRadio1, "Radio 1 value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Radio 1 value: " + ExpectedRadio1, "Radio 1 value should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateRecordSubmittedMsg(int row, String ExpectedRecordSubmitted) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_RecordSubmittedMsg, ExpectedRecordSubmitted, "Validate Record Submitted Message");
				WriteTestReportinExcelWithScreenShot("Verify Record Submitted Message: "+ ExpectedRecordSubmitted, "Record Submitted Message should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Record Submitted Message: " + ExpectedRecordSubmitted, "Record Submitted Message should be verified successfully", "FAIL", row);
			}
			

		}
		
		public void ValidateAuditTrailStatus(int row, String ExpectedAuditTrailStatus) throws IOException, BiffException {
			try {
				verifyTextEqual(readonly_AuditTrailStatus, ExpectedAuditTrailStatus, "Validate Audit Trail Status");
				WriteTestReportinExcel("Verify Audit Trail Status value: " + ExpectedAuditTrailStatus, "Audit Trail Status value should be verified successfully", "PASS", row);
			} catch (Exception e) {
				// TODO: handle exception
				WriteTestReportinExcelWithScreenShot("Verify Audit Trail Status value: " + ExpectedAuditTrailStatus, "Audit Trail Status value should be verified successfully", "FAIL", row);
			}
			

		}


}