package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class ContactModification extends TestBase{

	@Test(dataProvider="randomValidContactGenerator")
	public void modifyContact(ContactData contacts){
	

	 // save old
	 SortedListOf<ContactData> oldList=app.getContactHelper().getContacts();
    Random rnd =new Random();
    int index= rnd.nextInt(oldList.size()-1);
	
	app.getContactHelper().modifySomeContact(index,contacts);
    
    /*app.getContactHelper()
	 .initContactModification(index)   
	 .fillContactForm(contacts,MODIFICATION)
	 .submitContactModification()
	 .gotoHomePage();  */
		
	
	/*ContactData contacts=new ContactData();
    contacts.f_name="Îëÿ";
    contacts.l_name="Ivanova";
    contacts.b_month="January";*/
	
   
	
    // save new
	 SortedListOf<ContactData> newList=app.getContactHelper().getContacts(); 
    
    //compare
	    
    /*  oldList.remove(index);	 
      oldList.add(contacts);
      Collections.sort(oldList);
      assertEquals(newList,oldList);  */
    
	/* oldList=oldList.without(index);
      
	 System.out.println (" NewList   "+ newList);
	 
	 
	 System.out.println (" OLDLIST   "+ oldList); */
	 
	 assertThat(newList,equalTo(oldList.without(index).withAdded(contacts)));
   }
}	
