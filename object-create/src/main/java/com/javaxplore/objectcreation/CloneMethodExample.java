/**
 * 
 */
package com.javaxplore.objectcreation;

/**
 * @author pranit
 *
 */
public class CloneMethodExample {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee("Clone Employee");
		System.out.println(e1);
		Employee e2 = (Employee) e1.clone();
		System.out.println(e2);

	}

}
