
package com.example.tests;


import org.testng.annotations.Test;


	public class AlsoOfGroupCreationTests extends TestBase {
	 

	 
	  public void testNonEmptygroupCreation() throws Exception {
		/* app.navigateTo().mainPage();
	     app.navigateTo().groupsPage();
	    app.getGroupHelper().initGroupCreation(); 
	    GroupData group = new GroupData();
	    group.name="group name 1";
	    group.header="header 1";
	    group.footer="footer 1"; */
	    
	    GroupData group = new GroupData();
	    app.getGroupHelper().createGroup(group);
		
	/*  app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();  */
	  }
	  
	  
	
	  public void testEmptygroupCreation() throws Exception {
		 app.navigateTo().mainPage();
	     app.navigateTo().groupsPage();
	    app.getGroupHelper().initGroupCreation();
	    app.getGroupHelper().fillGroupForm( new GroupData("", "", ""));
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	  }



	  
	}
