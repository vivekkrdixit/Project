package com.practise.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Person {
	private int id;
	private String mobile;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param mobile
	 * @param address
	 */
	public Person(int id, String mobile, String address) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", mobile=" + mobile + ", address=" + address + "]";
	}

}

public class StreamsLambdaExample {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		Random random = new Random();
		for (int i = 1; i <= 100; i++) {
			Person p = new Person(i, "1000" + i, "Street " + 1);
			persons.add(p);
		}

		List<String> mobileNumbers = persons.stream().filter(p -> p.getId() > 5 && p.getId() < 10).map(p -> p.getMobile()).collect(Collectors.toList());
		System.out.println(mobileNumbers);
	}
}
