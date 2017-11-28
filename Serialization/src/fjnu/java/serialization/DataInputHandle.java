package fjnu.java.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataInputHandle {
	private ArrayList<Student> list = new ArrayList<Student>();
	private boolean flag = true;	

	//read student data from file
	public void readData() {
		Scanner scanner = null;
		try {
			File file = new File("list.txt");
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				long studentID = scanner.nextLong();
				String name = scanner.next();
				String sex = scanner.next();
				Student student = new Student(studentID, name, sex);
				//System.out.println(student);   //print the information
				list.add(student);
			}
			scanner.close();
		} catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	//使用ObjectOutputStream将对象写出到文件
	public void flattenStudent() {
		FileOutputStream fos = null;
		ObjectOutputStream objos = null;
		try {
			fos = new FileOutputStream("student.bin");
			objos = new ObjectOutputStream(fos);
			for(int i=0; i < list.size(); i++) {
				objos.writeObject(list.get(i));
			}
			fos.close();
			objos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//从文件读取对象
	public void inflateStudent() {
		FileInputStream fis = null;
		ObjectInputStream objis = null;
		try {
			fis = new FileInputStream("student.bin");
			objis = new ObjectInputStream(fis);
			while (true == flag) {
				Student student = (Student) objis.readObject();
				System.out.println(student);
			}
		} catch (IOException ex) {
			flag = false;
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
