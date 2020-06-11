/**
 * 
 */
package com.practise.general;

/**
 * @author pranit
 *
 */

class A {
	public void show() throws NullPointerException {
		System.out.println("H1");
	}
}

class B extends A {
	public void show() {
		System.out.println("H2");
	}

	public void show(String s) {
		System.out.println("H3" + s);
	}
}

public class MethodHirerarchy {
	public static void main(String[] args) {
		A a = new A();
		a.show();
		B b = new B();
		b.show();
		b.show("2");
	}

}
