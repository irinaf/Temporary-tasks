package com.example.tests;

public class ContactData implements Comparable <ContactData> {
	private String f_name;
	private String l_name;
	private String addr;
	private String phone;
	private String e_mail;
	private String b_day;
	private String b_month;
	private String b_year;

	
	public ContactData() {
		
	}
	
	
	public ContactData(String f_name, String l_name, String addr, String phone,
			String e_mail, String b_day, String b_month, String b_year) {
		this.f_name = f_name;
		this.l_name = l_name;
		this.addr = addr;
		this.phone = phone;
		this.e_mail = e_mail;
		this.b_day = b_day;
		this.b_month = b_month;
		this.b_year = b_year;
	}


		
	

	@Override
	public int compareTo(ContactData other) {
		
			String b=this.l_name.toLowerCase()+ this.f_name.toLowerCase();
			String c=other.l_name.toLowerCase()+ other.f_name.toLowerCase();
			return b.compareTo(c);  
			
		
		}
	
	

	@Override
	public String toString() {
		return "ContactData [f_name=" + f_name + ", l_name=" + l_name
				+ ", addr=" + addr + ", phone=" + phone + ", e_mail=" + e_mail
				+ ", b_day=" + b_day + ", b_month=" + b_month + ", b_year="
				+ b_year + "]";
	}


	@Override
	public int hashCode() {
	//	final int prime = 31;
		int result = 1;
		//result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		//result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		return true;
	} 


	public ContactData withFirstName(String f_name) {
		this.f_name = f_name;
		return this;
	}
	
	
	public ContactData withLastName(String l_name) {
		this.l_name = l_name;
		return this;
	}

	public ContactData  withAddr(String addr) {
		this.addr = addr;
		return this;
	}
	public ContactData  withEmail(String e_mail) {
		this.e_mail = e_mail;
		return this;
	}
	public ContactData  withBirthDay(String b_day) {
		this.b_day = b_day;
		return this;
	}
	
	public ContactData  withBirthMonth(String b_month) {
		this.b_month= b_month;
		return this;
	}
	
	public ContactData  withBirthYear(String b_year) {
		this.b_year = b_year;
		return this;
	}


	public ContactData withPhone(String phone) {
		this.phone = phone;
		return this;
	}


	public String getF_name() {
		return f_name;
	}


	public String getL_name() {
		return l_name;
	}


	public String getAddr() {
		return addr;
	}


	public String getPhone() {
		return phone;
	}


	public String getE_mail() {
		return e_mail;
	}


	public String getB_day() {
		return b_day;
	}


	public String getB_month() {
		return b_month;
	}


	public String getB_year() {
		return b_year;
	}


	
}