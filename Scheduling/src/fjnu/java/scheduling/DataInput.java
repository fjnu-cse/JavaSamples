package fjnu.java.scheduling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataInput {
	private int[] value = {6, 2, 1, 3,9};
	private int taskNumber = 100; //number of task
	
	public void generateInput(String filename) {
		try {
			FileWriter writer = new FileWriter(filename);
			StringBuilder sb = new StringBuilder();
			int id = 1;
			Random random = new Random();
			for(int i=0; i < taskNumber; i++) {
				sb.append(id);
				sb.append("\t");
				//arrival time
				sb.append(i);
				sb.append("\t");
				//service time
				sb.append(value[random.nextInt(5)]);
				sb.append("\n");
				id++;
			}
			writer.write(sb.toString());
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
