package com.example.fw;


import java.util.List;






import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;




public class ContactHelper extends HelperBase {

	public static boolean CREATION=true;
	public static boolean MODIFICATION =false; 
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}
   

	private SortedListOf<ContactData> cachedContacts; 
	
	public SortedListOf<ContactData> getContacts() {
		
		if (cachedContacts==null){
			rebuildCache();
		}
		return cachedContacts; 
	}	
	
	private void rebuildCache() {

		//List<ContactData> contacts= new ArrayList<ContactData>();
		cachedContacts=new SortedListOf<ContactData>();	
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes=driver.findElements(By.name("selected[]"));
		for(WebElement checkbox: checkboxes)
		{
			//ContactData contact= new ContactData();
			String title= checkbox.getAttribute("title");
			title=title.substring("Select (".length(),title.length()-")".length());
			String f_name=title.substring(0,title.lastIndexOf(" "));
			String l_name=title.substring(title.lastIndexOf(" ")+1);
			//ContactData contact= new ContactData().withFirstName(f_name).withLastName(l_name);
			cachedContacts.add(new ContactData().withFirstName(f_name).withLastName(l_name));
			
		}
			
	
		
	}
		


	
	public ContactHelper createContacts(ContactData contacts) {
		manager.navigateTo().contactPage();
		//gotoContactPage();
		fillContactForm(contacts,CREATION);
	    submitContact();
	    gotoHomePage(); 
	    rebuildCache();
	    return this;
		
	}
	
	
	
public  ContactHelper deleteContact(int index) {
		
	    selectContactByIndex(index);
		submitContactDeletion();
		gotoHomePage();
	    rebuildCache();
		return this;
		
	}



public ContactHelper modifySomeContact(int index, ContactData contacts){
	initContactModification(index) ;  
	fillContactForm(contacts,MODIFICATION);
	submitContactModification();
	gotoHomePage();
	 rebuildCache();
	return this;
}

//--------------------------------------------------------------------------------------------	
	
	public ContactHelper initContactCeation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm( ContactData contacts,boolean formType) {
	/* type(By.name("firstname"), contacts.f_name);	    
	   type(By.name("lastname"), contacts.l_name);  
	   type(By.name("address"), contacts.addr);
	   type(By.name("home"), contacts.phone);
	   type(By.name("email"), contacts.e_mail);	    
	   selectByText(By.name("bday"), contacts.b_day);
	   selectByText(By.name("bmonth"), contacts.b_month);
	   type(By.name("byear"), contacts.b_year);  */
		type(By.name("firstname"), contacts.getF_name());
	    type(By.name("lastname"), contacts.getL_name());  
	    type(By.name("address"), contacts.getAddr());
	    type(By.name("home"), contacts.getPhone());
	    type(By.name("email"), contacts.getE_mail());	
	    selectByText(By.name("bday"), contacts.getB_day());
	    selectByText(By.name("bmonth"), contacts.getB_month());
	    type(By.name("byear"), contacts.getB_year());
	  if (formType==CREATION){
		  
	  }
	  else {
		  if (driver.findElements(By.name("new_group" )).size()!=0)
			  throw new Error ("Group selector exists in contact modification form");
	  }
	  
	  return this;
	} 

	
	public ContactHelper submitContact() {
		click(By.name("submit"));
		cachedContacts=null;
		return this;
	}

	public ContactHelper gotoHomePage() {
		click(By.linkText("home"));
		return this;
	}

	


	private ContactHelper selectContactByIndex(int index) {
		
		index++;
		click(By.xpath("//tr["+(index+1)+"]/td[7]/a/img"));
		return this;
		
		
	}

	public ContactHelper initContactModification(int index) {
		selectContactByIndex(index);
		return this;
		
		
	}

	public ContactHelper submitContactModification()  {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts=null;
		return this;
		
	}


	private void submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts=null;
	}

	
	

}
