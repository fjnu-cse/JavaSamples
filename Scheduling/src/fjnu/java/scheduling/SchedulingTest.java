package fjnu.java.scheduling;

public class SchedulingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DataInput input = new DataInput();
		//input.generateInput("input.txt");
		
		FcfsScheduling fcfs = new FcfsScheduling("input.txt", 2);
		fcfs.execute();	
	}

}
