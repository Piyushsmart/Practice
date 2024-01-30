package ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BusinessLogic.Operation;

public class OrangeHRM_Objects extends Operation {

	@FindBy(xpath = "//input[@placeholder='Username']")
    public static WebElement or_username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public static WebElement or_password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public static WebElement or_login;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']")
    public static WebElement or_dashboard;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")
    public static WebElement pim_option;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item']")
    public static WebElement add_btn;

    @FindBy(xpath = "//a[normalize-space()='Add Employee']")
    public static WebElement add_empl;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
    public static WebElement name;

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    public static WebElement middle_name;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public static WebElement surname;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public static WebElement save;

    @FindBy(xpath = "//a[normalize-space()='Job']")
    public static WebElement job_field;

    @FindBy(xpath = "//label[string()='Employment Status']/parent::div/following-sibling::div/div/div")
    public static WebElement emp_status;

    @FindBy(xpath = "//span[normalize-space()='Full-Time Permanent']")
    public static WebElement per_emp;

//    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
   
    @FindBy(xpath = "//label[text()=\\\"Sub Unit\\\"]/parent::div/following-sibling::div/div/div")
    public static WebElement sub_unit;

    @FindBy(xpath = "//span[normalize-space()='Quality Assurance']")
    public static WebElement qa;

    @FindBy(xpath = "//div[@class='orangehrm-edit-employee-content']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")
    public static WebElement title;

    @FindBy(xpath = "//span[normalize-space()='QA Lead']")
    public static WebElement qa_lead;

    @FindBy(xpath = "//button[@type='submit']")
    public static WebElement submit;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public static WebElement search_name;

    @FindBy(xpath = "//div[@role='listbox']//div[2]//span[1]")
    public static WebElement option_select;

    @FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
    public static WebElement edit_icon;

    @FindBy(xpath = "//span[normalize-space()='Freelance']")
    public static WebElement freelancer;
    
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    public static WebElement logout_option;
    
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public static WebElement logout;
    
    public OrangeHRM_Objects(){    	
    	System.out.println("Child");
    	PageFactory.initElements(driver, this);
    }
}
