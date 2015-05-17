package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected ApplicationManager app;
	

	@BeforeTest
		public void setUp() throws Exception {
	    app=new ApplicationManager();
		
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }

	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]>list= new ArrayList<Object[]>();
	 		
		for( int i =0;i<3;i++){
			GroupData group = new GroupData()
			.withName(generateRandomString())	
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			/*group.name=generateRandomString();							
			group.header=generateRandomString();
			group.footer=generateRandomString(); */
			list.add(new Object[]{group});
		}
			
		return list.iterator();
	}
	

	public String generateRandomString(){
		
		Random rnd =new Random();
		if(rnd.nextInt(3)==0){
			return"";
		}
		
		else return "test"+ rnd.nextInt();
		
	}


	
public String generateRandomDay(){
		
		Random rnd =new Random();
		if(rnd.nextInt(3)==0){
			return"-";
			
		}
		else return "1"+ rnd.nextInt(3);
		
	}
	
 public String generateRandomMonths(){
	 
	 Random rnd =new Random();
	 String months[] = { "January", "February", "June", "July",
	           "December"};
	   int mon=rnd.nextInt(months.length);
	   return months[mon];
 }

	
public String generateRandomYear(){
	 
	 Random rnd =new Random();
	 
	 return "198"+ rnd.nextInt(3);
}

 
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]>list= new ArrayList<Object[]>();
	 		
		for( int i =0;i<2;i++){
			ContactData contacts = new ContactData()
			.withFirstName(generateRandomString())	
			.withLastName(generateRandomString())
			.withAddr(generateRandomString())
			.withEmail(generateRandomString())
			.withPhone(generateRandomString())
			.withBirthDay(generateRandomDay())
			.withBirthMonth(generateRandomMonths())
			.withBirthYear(generateRandomYear());
						
			list.add(new Object[]{contacts});
		}
			
		return list.iterator();
	}


	
	
}
