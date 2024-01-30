package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import BusinessLogic.Operation;
import ObjectRepo.OrangeHRM_Objects;

public class OrangeHRM extends Operation {

	OrangeHRM_Objects oo;

	@Test(priority = '1')
	public void OrangeHRM_Login() throws IOException {
		oo = new OrangeHRM_Objects();
		try {

			openurl();
			Thread.sleep(5000);
			sendText(OrangeHRM_Objects.or_username, "Admin");
			sendText(OrangeHRM_Objects.or_password, "admin123");
			click(OrangeHRM_Objects.or_login);
			verifyText(OrangeHRM_Objects.or_dashboard, "Dashboard");
			Operation.ExtentReportTest("Login into Orange HRM website", "Passed", "Login");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Operation.ExtentReportTest("Login into Orange HRM website", "Failed", "Issues : " + e + "");
			Assert.assertFalse(true);
		}
	}

	@Test(priority = '2')
	public void pim() throws IOException {

		try {
			click(OrangeHRM_Objects.pim_option);
			click(OrangeHRM_Objects.add_btn);
			click(OrangeHRM_Objects.add_empl);
			verifyText(OrangeHRM_Objects.pim_option, "PIM");
			Operation.ExtentReportTest("PIM option clicked", "Passed", "PIM Menu");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Operation.ExtentReportTest("PIM option clicked", "Failed", "Issues : " + e + "");
			Assert.assertFalse(true);
		}
	}

	@Test(priority = '3')

	public void add() throws Exception {

		try {
			sendText(OrangeHRM_Objects.name, "Om");
			sendText(OrangeHRM_Objects.middle_name, "Jay");
			sendText(OrangeHRM_Objects.surname, "Jagdish");
			Thread.sleep(2000);
			click(OrangeHRM_Objects.save);
			Operation.ExtentReportTest("Adding a new Employee", "Passed", "Add Employee");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Operation.ExtentReportTest("Adding a new Employee", "Failed", "Issues : " + e + "");
			Assert.assertFalse(true);
		}
	}

	@Test(priority = '4')

	public void details() throws Exception {

		try {
			click(OrangeHRM_Objects.job_field);
			click(OrangeHRM_Objects.emp_status);
			click(OrangeHRM_Objects.per_emp);
			click(OrangeHRM_Objects.sub_unit);
			click(OrangeHRM_Objects.qa);
			click(OrangeHRM_Objects.title);
			click(OrangeHRM_Objects.qa_lead);
			click(OrangeHRM_Objects.submit);
			Operation.ExtentReportTest("Adding employee details", "Passed", "Details");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Operation.ExtentReportTest("Adding employee details", "Failed", "Issues : " + e + "");
			Assert.assertFalse(true);

		}
	}

	@Test(priority = '5')

	public void search() throws Exception {

		try {
			click(OrangeHRM_Objects.pim_option);
			sendText(OrangeHRM_Objects.search_name, "Om");
			click(OrangeHRM_Objects.option_select);
			click(OrangeHRM_Objects.submit);
			Thread.sleep(2000);
			scrolldown(350);
			Operation.ExtentReportTest("Searching for employee", "Passed", "Search Employee");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Operation.ExtentReportTest("Searching for employee", "Failed", "Issues : " + e + "");
			Assert.assertFalse(true);

		}
	}

	@Test(priority = '6')
	public void edit() throws Exception {

		try {
			click(OrangeHRM_Objects.edit_icon);
			click(OrangeHRM_Objects.job_field);
			click(OrangeHRM_Objects.emp_status);
			click(OrangeHRM_Objects.freelancer);
			Thread.sleep(3000);
			click(OrangeHRM_Objects.save);
			Operation.ExtentReportTest("Updating the employee details", "Passed", "Edit Employee");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Operation.ExtentReportTest("Updating the employee details", "Failed", "Issues : " + e + "");
			Assert.assertFalse(true);
		}
	}

	@Test(priority = '7')
	public void find() throws Exception {

		try {
			click(OrangeHRM_Objects.pim_option);
			sendText(OrangeHRM_Objects.search_name, "Om");
			click(OrangeHRM_Objects.option_select);
			click(OrangeHRM_Objects.submit);
			Thread.sleep(2000);
			scrolldown(350);
			Operation.ExtentReportTest("Searching the employee", "Passed", "Find Employee");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Operation.ExtentReportTest("Searching the employee", "Failed", "Issues : " + e + "");
			Assert.assertFalse(true);

		}

	}

	@Test(priority = '8')

	public void logout() throws Exception {

		try {
			click(OrangeHRM_Objects.logout_option);
			click(OrangeHRM_Objects.logout);
			Operation.ExtentReportTest("Logigng Out from website", "Passed", "Logout");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Operation.ExtentReportTest("Loging Out from website", "Failed", "Issue :" + e + "");
			Assert.assertFalse(true);
		}
	}

}
