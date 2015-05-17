

	package com.example.tests;

//	import static org.testng.Assert.assertEquals;

//import java.util.Collections;



import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;




	public class ContactCreationTests extends TestBase
	
	{
	  @Test(dataProvider="randomValidContactGenerator")
	  public void testValidContactCreation(ContactData contacts) throws Exception {
	  
		//app.navigateTo().mainPage();  
	   
	    
	    // save old
	     SortedListOf<ContactData> oldList=app.getContactHelper().getContacts();
		
	  /*  ContactData contacts = new ContactData();
	    contacts.f_name="IRINA";
	    contacts.l_name= "KOTOVA";
	    contacts.addr= "Москва, ул. Новикова, 2";
	    contacts.e_mail= "olga@mail.ru";
	    contacts.phone="8(495)222-33-44";
	    contacts.b_day="15";
	    contacts.b_month="February";
	    contacts.b_year="1980";    */
	    
	   	     
	  /*   app.getContactHelper()
	    .gotoContactPage()
	    .fillContactForm(contacts,true)
	    .submitContact()
	    .gotoHomePage();   */
	     
	   	    
		     
	     app.getContactHelper().createContacts(contacts);
	    

	    // save new
	     SortedListOf<ContactData> newList=app.getContactHelper().getContacts(); 
	    
	     //compare  
	               
	     //assertEquals(newList.size(),oldList.size()+1); 
	     
	     
	
	      assertThat(newList,equalTo(oldList.withAdded(contacts)));
	     /*oldList.add(contacts); 
	    Collections.sort(oldList);
	    assertEquals(newList,oldList); */
	
	
	    
	  }

	  
	 
	}



