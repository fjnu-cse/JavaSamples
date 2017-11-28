package fjnu.java.serialization;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1234L;
	
	private long studentID;
	private String name;
	private String sex;
	
	public Student(long studentID, String name, String sex) {
		this.studentID = studentID;
		this.name = name;
		this.sex = sex;
	}
	
	/**
	 * Override this method can print the object
	 */
	@Override
	public String toString() {
		return "Student: " + studentID + " " + name
				+ " " + sex;
	}
}
