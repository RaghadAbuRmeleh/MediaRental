    package application;

import java.util.ArrayList;

public class Customer implements Comparable <Customer>{

	private String id;
	private String name;
	private String address;
	private String mobile;
	private String plan;
	private ArrayList <String> interested = new ArrayList <>();
	private ArrayList <String> rented = new ArrayList <>();
	private int limited;
	public Customer() {
	}

	public Customer(String id, String name, String address,String mobile, String plan) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.plan = plan;
		if (this.plan.equalsIgnoreCase("limited"))
			limited = 2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public ArrayList<String> getInterested() {
		return interested;
	}

	public void setInterested(ArrayList<String> interested) {
		this.interested = interested;
	}

	public ArrayList<String> getRented() {
		return rented;
	}

	public void setRented(ArrayList<String> rented) {
		this.rented = rented;
	}

	public int getLimited() {
		return limited;
	}

	public void setLimited(int limitedvalue) {
		limited = limitedvalue;
	}

	@Override
	public String toString() {
		return "Customer [ID = "+ id + ", Name = " + name + ", Address = " + address + ", Plan = " + plan + ", Interested = " + interested
				+ ", Rented = " + rented + ", Limited Value = " + limited + "]";
	}

	@Override
	public int compareTo(Customer o) {
		if (name.compareTo(o.getName()) > 0 )
			return 1;
		else if (name.compareTo(o.getName()) < 0 )
			return -1;
		else 
			return 0;
	}

		
}

    
