package com.javaxplore.objectcreation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorClassExample {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<Employee> constructor = Employee.class.getDeclaredConstructor();
		Employee newInstance = constructor.newInstance();
		System.out.println("Employee object using Constructor class is :" + newInstance);

	}

}
