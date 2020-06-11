package com.javaxplore.objectcreation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeserializationExample {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Employee e1 = new Employee("Deserialization Employee");
		
		System.out.println("Employee is : " + e1);
		System.out.println("Hashcode of object is: " + e1.hashCode());
		
		serializeObject(e1);
		Employee employee2 = deserializeObject();
		
		System.out.println("Employee post deserialization is : " + employee2);
		System.out.println("Hashcode of deserialized object is: " + employee2.hashCode());

	}

	private static void serializeObject(Employee e1) throws IOException {
		FileOutputStream outputStream = new FileOutputStream("file.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(e1);
		objectOutputStream.close();
	}
	
	private static Employee deserializeObject() throws IOException, ClassNotFoundException {
		FileInputStream inputStream = new FileInputStream("file.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Employee employee = (Employee) objectInputStream.readObject();
		objectInputStream.close();
		return employee;
	}

}
