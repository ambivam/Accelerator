package com.accelerator.automation.stepdefs.coachoffice;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

import com.accelerator.automation.libraries.ConfigFileReader;
import com.accelerator.automation.pages.coachoffice.CoachOfficeHomePage;
import com.accelerator.automation.pages.coachoffice.CoachOfficeMyCustomersPage;
import com.accelerator.automation.pages.coachoffice.CoachOfficeMyOrdersPage;
import org.testng.Assert;

import com.accelerator.automation.common.World;
import com.accelerator.automation.pages.coachoffice.CoachOfficeLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoachOfficeCustomerAndOrderDetailsPageSteps {

	private World world;

	public CoachOfficeCustomerAndOrderDetailsPageSteps(World world) {
		this.world = world;
		coachofficeloginpage = new CoachOfficeLoginPage(this.world);
		coomycustomerspage = new CoachOfficeMyCustomersPage(this.world);
		coachofficehomepage = new CoachOfficeHomePage(this.world);
		coomyorderspage = new CoachOfficeMyOrdersPage(this.world);
	}

	CoachOfficeHomePage coachofficehomepage;
	CoachOfficeLoginPage coachofficeloginpage;
	CoachOfficeMyCustomersPage coomycustomerspage;
	CoachOfficeMyOrdersPage coomyorderspage;

	@Given("Launch COO Application")
	public void launch_COO_Application() throws Exception{
		// launching coo on browser
		/*
		 * world.driver.get(ConfigFileReader.getConfigFileReader().getCOOUrl());
		 * world.driver.manage().window().maximize();
		 */
		coachofficeloginpage.navigateToWebPage(ConfigFileReader.getConfigFileReader().getCOOUrl());
		String page_title = "Sign In – Coach Office";
		//Assert.assertEquals(coachofficeloginpage.returnPageTitle(), page_title.trim(), "Not launched COO Application");
		coachofficeloginpage.validatePageTitle(page_title);
//		coachofficeloginpage = new CoachOfficeLoginPage(this.world);
		
	}

	@When("Enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) throws Exception {
		// Entering credentials
		coachofficeloginpage.login(username, password);
	}

	/*
	 * @When("Click on Sign In button") public void click_on_Sign_In_button() throws
	 * InterruptedException { //clicking on sign in button
	 * coachofficehomepage.clickonSignbutton(); }
	 */

	@When("User Clicks on My Customers under Monitor My Business")
	public void user_Clicks_on_My_Customers_under_Monitor_My_Business() throws Exception {
		
		// clicking on my customers button
		coachofficehomepage.clickMyCustomers();
	}

	@Then("Customer Report page should be displayed")
	public void customer_Report_page_should_be_displayed() throws Exception {
		// veifying customers page
		coomycustomerspage.verifyCustomersPageLoaded();
	}

	@When("User Enters Email address {string} and click on search")
	public void user_Enters_Email_address_and_click_on_search(String EmailAddress) throws Exception {
		// entering email address
		coomycustomerspage.enterEmailAddress(EmailAddress);
		// clicking on search button
		coomycustomerspage.clickSearch();
	}

	@Then("Validate {string}, {string}, {string}, {string}, {string}, {string} , {string}, {string} , {string}")
	public void validate(String JoinDate, String FirstName, String LastName, String CustomerID, String CustomerType,
			String CustomerSource, String PhoneNumber, String LastOrderDate, String Email) throws Exception {

		String date = coomycustomerspage.joinDate();
		// validating join date
		Assert.assertEquals(date, JoinDate, "JoinDate not matched");
		String fname = coomycustomerspage.firstName();
		// validating first name
		Assert.assertEquals(fname, FirstName, "FirstName not matched");
		String lname = coomycustomerspage.lastName();
		// validating last name
		Assert.assertEquals(lname, LastName, "LastName not matched");
		String cusid = coomycustomerspage.customerId();
		// validating customer Id
		Assert.assertEquals(cusid, CustomerID, "CustomerID not matched");
		String custype = coomycustomerspage.customerType();
		// validating customer type
		Assert.assertEquals(custype, CustomerType, "CustomerType not matched");
		String cussource = coomycustomerspage.customerSource();
		// validating customer source
		Assert.assertEquals(cussource, CustomerSource, "CustomerSource not matched");
		String phoneno = coomycustomerspage.phoneNumber();
		// validating phone number
		Assert.assertEquals(phoneno, PhoneNumber, "PhoneNumber not matched");
		String Lastorder = coomycustomerspage.lastOrderDate();
		// validating lastorder
		Assert.assertEquals(Lastorder, LastOrderDate, "LastOrderDate not matched");
		String email = coomycustomerspage.verifyEmailId();
		// validating email
		Assert.assertEquals(email, Email, "Email not matched");

	}

	@When("User Clicks on the top arrow near join date field")
	public void user_Clicks_on_the_top_arrow_near_join_date_field() throws Exception {
		// clicking on top join date
		coomycustomerspage.clickonTopJoindate();
	}

	@When("User Clicks on My Personal & Customer Orders under Monitor My Business")
	public void user_Clicks_on_My_Personal_Customer_Orders_under_Monitor_My_Business() throws Exception {
		
		// clicking on my personal and customers orders button
		coachofficehomepage.clickMyPersonalCustomerOrders();
	}

	@Then("Order Report Page should be displayed")
	public void order_Report_Page_should_be_displayed() throws Exception {
		// verifying order report page
		coomyorderspage.verifyOrdersPageLoaded();

	}

	@When("User Enters orderNo {string} and Clicks on Search")
	public void user_Enters_orderNo_and_Clicks_on_Search(String orderNumber) throws Exception {
		// entering order number
		coomyorderspage.enterOrdernumber(orderNumber);
		// clicking on search button
		coomyorderspage.clickSearch();
	}

	@Then("Validate orderDate as {string} customerId as {string} firstName as {string} lastName as {string} orderNumber as {string} homeDirect as {string} emailId as {string} amont as {string} phone as {string} status as {string} volume as {string} trackingNumber as {string}")
	public void validate(String OrderDate, String CustomerID, String FName, String LName, String OrderNo,
			String HomeDirect, String EmailID, String Amount, String Phone, String Status, String Volume,
			String TrackingNumber) throws Exception {
		String date = coomyorderspage.getOrderDate();
		// validating order date
		Assert.assertEquals(date, OrderDate, "OrderDate not matched");
		String cusId = coomyorderspage.getCustomerId();
		// validating customer id
		Assert.assertEquals(cusId, CustomerID, "CustomerID not matched");
		String fname = coomyorderspage.getFirstName();
		// validating first name
		Assert.assertEquals(fname, FName, "FirstName not matched");
		String lname = coomyorderspage.getLastName();
		// validating last name
		Assert.assertEquals(lname, LName, "LastName not matched");
		String orderno = coomyorderspage.getOrderNumber();
		// validating order no
		Assert.assertEquals(orderno, OrderNo, "OrderNumber not matched");
		String homedirec = coomyorderspage.getHomedirect();
		// validating home direct
		Assert.assertEquals(homedirec, HomeDirect, "HomeDirec not matched");
		String emailid = coomyorderspage.getEmail();
		// validating email
		Assert.assertEquals(emailid, EmailID, "EmailID not matched");
		String amount = coomyorderspage.getAmount();
		// validating amount
		Assert.assertEquals(amount, Amount, "Amount not matched");
		String phone = coomyorderspage.getPhonenumber();
		// validating phone number
		Assert.assertEquals(phone, Phone, "Phoneno not matched");
		String staus = coomyorderspage.getStatus();
		// validating status
		Assert.assertEquals(staus, Status, " Status not matched");
		String volume = coomyorderspage.getVolume();
		// validating volume
		Assert.assertEquals(volume, Volume, "Volume not matched");
		String trackingno = coomyorderspage.getTrackingNumber();
		// validating tracking number
		Assert.assertEquals(trackingno, TrackingNumber, " TrackingNumber not matched");
	}

	@When("User Clicks on the top arrow near order date field")
	public void user_Clicks_on_the_top_arrow_near_order_date_field() throws Exception {
		// clicking on top order date
		coomyorderspage.clickonTopJoindate();
	}

	@Then("Validate productName as {string} orderType as {string}")
	public void validate_productName_as_orderType_as(String ProductName, String OrderType) throws Exception {
		String products = coomyorderspage.getProducts();
		// validating product name
		Assert.assertEquals(products, ProductName, "Productname not matched");
		String ordertype = coomyorderspage.getOrderType();
		// validating order type
		Assert.assertEquals(ordertype, OrderType, "OrderType not matched");
	}

	@Given("I am logged in to COO")
	public void i_am_logged_in_to_COO() throws Exception {
		File file = new File("config");
		URL[] urls = { file.toURI().toURL() };
		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle configLib = ResourceBundle.getBundle("config", Locale.getDefault(), loader);
		coachofficeloginpage.navigateToWebPage(configLib.getString("COO_QA3_URL"));
		coachofficeloginpage.login(configLib.getString("COO_Username"), configLib.getString("COO_Password"));
	}

	
	@Given("I am logged in to COO with existing coach")
	public void i_am_logged_in_to_COO_with_existing_coach() throws Exception {
		File file = new File("config");
		URL[] urls = {file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle configLib=ResourceBundle.getBundle("config",Locale.getDefault(),loader);
		//world.driver.manage().deleteAllCookies();
//		world.getDriver();
//		world.driver.get(configLib.getString("COO_QA3_URL"));	
//		world.driver.manage().window().maximize();
//		coachofficeloginpage=new CoachOfficeLoginPage(this.world);
		coachofficeloginpage.navigateToWebPage(configLib.getString("COO_QA3_URL"));
		coachofficeloginpage.loginWith(configLib.getString("Coach_Username"),configLib.getString("Coach_Password"));
	}


	@When("I search for the customer with email in COO")
	public void i_search_for_the_customer_with_email_in_COO() throws Exception {
		
		//clicking on monitor my business button
		coachofficehomepage.clickMonitorMyBusiness();
		// clicking on my customers button
		coachofficehomepage.clickMyCustomers();
		// entering email address
		coomycustomerspage.enterEmailAddress(world.getCustomerDetails().get("Email"));
		// clicking on search button
		coomycustomerspage.clickSearch();
		// Verifying result
		coomycustomerspage.verifyResult();
	}
	@When("I search for the order with order number in COO application")
	public void i_search_for_the_order_with_order_number_in_COO_application() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		//clicking on monitor my business button
		coachofficehomepage.clickMonitorMyBusiness();
		//clicking on my customers button
		coachofficehomepage.clickMyCustomers();
		//entering email address
		//coomycustomerspage.enterEmailAddress(world.getExistingCustomerdetails().get("Email"));
		coomycustomerspage.enterEmailAddress("username8973@yopmail.com");
		//clicking on search button
		coomycustomerspage.clickSearch();
	}

	@Then("I should be able to validate the customer details in COO")
	public void i_should_be_able_to_validate_the_customer_details_in_COO(String text) throws Exception {
		coomycustomerspage.verifyCustomerDetails(text);
	}

	@When("I search for the order with order number in COO")
	public void i_search_for_the_order_with_order_number_in_COO() throws Exception {
//		coomyorderspage = new CoachOfficeMyOrdersPage(world);
		// Navigate to order search
		coachofficehomepage.clickMyPersonalCustomerOrders();
		// entering order number
		coomyorderspage.enterOrdernumber(world.getCustomerDetails().get("Email"));
		// clicking on search button
		coomyorderspage.clickSearch();
	}

	@When("I should be able to validate the order details in COO")
	public void i_should_be_able_to_validate_the_order_details_in_COO() throws Exception {
		String fname=world.getCustomerDetails().get("FirstName");
		String lname=world.getCustomerDetails().get("LastName");
		String orderNumber=world.getOrderNum();
		String emailId=world.getCustomerDetails().get("Email");
		String phone=world.getCustomerDetails().get("Phone");
		String amount=world.getCustomerDetails().get("Total");
		
		coomyorderspage.validateOrderDetails(fname, lname, orderNumber, emailId, phone, amount);
	}

	/*
	 * @When("I should be able to validate the order details in COO") public void
	 * i_should_be_able_to_validate_the_order_details_in_COO() {
	 * coomypersonalcustomerpage.validateOrderDetails(fname, lname, orderNumber,
	 * EmailId, Phone, Amount); }
	 */
	
	@Then("I should validate Billing and Shipping addresses in Coach office")
	public void i_should_validate_Billing_and_Shipping_addresses_in_Coach_office() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
//		coomycustomerspage=new CoachOfficeMyCustomersPage(world);
		coomycustomerspage.clickonTopJoindate();
		String billingAddress=world.getCustomerDetails().get("BillingAddress");
		String billingCity =world.getCustomerDetails().get("BillingCity");
		String billingZip=world.getCustomerDetails().get("BillingZip");
		coomycustomerspage.validateUpdatedBillingAddress(billingAddress,billingCity,billingZip);	
		coomycustomerspage.clickOnCustomerID();
		String shippingAddress=world.getUpdateAccountDetails().get("ShippingAddress");
		String shippingCity =world.getUpdateAccountDetails().get("ShippingCity");
		String shippingZip=world.getUpdateAccountDetails().get("ShippingZip");
		coomycustomerspage.validateshippingaddress(shippingAddress,shippingCity,shippingZip);
	}

}