package com.example.tests;

//import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

//import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase{
	
	
	 @Test(dataProvider="randomValidGroupGenerator")
public void modifySomeGroup(GroupData group)
	 
	 {
		
		 app.navigateTo().mainPage();
	     app.navigateTo().groupsPage();
	     
	     // save old
	     SortedListOf<GroupData> oldList=app.getGroupHelper().getGrous();
	     
	     Random rnd =new Random();
	     int index=rnd.nextInt(oldList.size()-1);
	     
	     //actions
	     app.getGroupHelper().modifyGroup(index,group);
	    
	     /*GroupData group=new GroupData();
	     group.name="new name"; 
	     
	     
		app.getGroupHelper().fillGroupForm(group);
	     app.getGroupHelper().submitGroupModification();
	     app.getGroupHelper().returnToGroupPage();*/
		 
	     // save new
	     SortedListOf<GroupData> newList=app.getGroupHelper().getGrous(); 
	    
	     assertThat(newList,equalTo(oldList.without(index).withAdded(group)));
	     
	     //compare
	  /*  oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList); */
	 
	 }


}
