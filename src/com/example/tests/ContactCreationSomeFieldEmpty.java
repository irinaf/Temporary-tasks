package com.example.tests;

	import org.testng.annotations.Test;




public class ContactCreationSomeFieldEmpty extends TestBase{
	
	
	
	  @Test
	  public void testEmptyContact() throws Exception {
	  
	    app.navigateTo().mainPage();  
	    app.getContactHelper().initContactCeation();
	   ContactData contacts = new ContactData("", "12345666***", "", "8(495)345-25-44", "irina@mail.ru", "12", "-", "-");
		
	 /*  ContactData contacts = new ContactData();
	    contacts.f_name="";
	    contacts.l_name= "";
	    contacts.addr= "";
	    contacts.e_mail= "irina@gmail.com";
	    contacts.phone="+7(912)345-25-44";
	    contacts.b_day="12";
	    contacts.b_month="June";
	    contacts.b_year="1970";   */
	    
	    
	    app.getContactHelper().fillContactForm(contacts);
	    app.getContactHelper().submitContact();
	    app.getContactHelper().gotoHomePage();
	  }
	}

