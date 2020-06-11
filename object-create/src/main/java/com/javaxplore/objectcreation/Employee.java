/**
 * 
 */
package com.javaxplore.objectcreation;

import java.io.Serializable;

/**
 * @author pranit
 *
 */
public class Employee implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8505915933222519939L;
	private String name;

	/**
	 * @param name
	 */
	public Employee(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 */
	public Employee() {
		name = "Employee 1";
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
