package com.javaxplore.objectcreation;

public class NewInstanceExample {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		/**
		 * This way of object creation is deprecated since java 9 due to below given
		 * reason.
		 * 
		 * The method newInstance() propagates any exception thrown by the nullary
		 * constructor, including a checked exception. Use of this method effectively
		 * bypasses the compile-time exception checking that would otherwise be
		 * performed by the compiler. The
		 * {@link java.lang.reflect.Constructor#newInstance(java.lang.Object...)
		 * Constructor.newInstance} method avoids this problem by wrapping any exception
		 * thrown by the constructor in a (checked)
		 * {@link java.lang.reflect.InvocationTargetException}.
		 */
		Class cls = Class.forName("com.javaxplored.Employee");
		Employee object = (Employee) cls.newInstance();
		System.out.println(object);
	}

}
