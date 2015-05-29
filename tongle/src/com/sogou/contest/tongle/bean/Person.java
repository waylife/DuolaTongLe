package com.sogou.contest.tongle.bean;


public class Person {
	private Integer id;
	private String name;
	private Integer balance;

	public Person() {
		super();
	}
	
	public Person(String name, Integer balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public Person(Integer id, String name, Integer balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}
