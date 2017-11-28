package fjnu.java.serialization;

public class SerializableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputHandle handler = new DataInputHandle();
		handler.readData();
		handler.flattenStudent();
		handler.inflateStudent();
	}

}
