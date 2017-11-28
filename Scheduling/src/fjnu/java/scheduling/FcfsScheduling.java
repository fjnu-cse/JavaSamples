package fjnu.java.scheduling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class schedules tasks by first come first served (FCFS).
 * @author ll
 *
 */
public class FcfsScheduling {
	private List<Task> tasks = new ArrayList<Task>();
	private List<Task> inQueue = null;
	private List<Task> notInQueue = new ArrayList<Task>();
	
	//处理队列的个数，在实验中，可以是1或者2
	private int mQueues; 
	
	public FcfsScheduling(String filename) {
		this(filename, 1);
	}
	
	public FcfsScheduling(String filename, int queues) {
		tasks = Util.readTasks(filename);
		this.mQueues = queues;
		inQueue = new ArrayList<Task>(mQueues);
		print();
		addTasks(tasks);
	}
	
	public void print() {
		for(Task t : tasks) {
			System.out.print(t);
		}
	}
	
	/**
	 * Initialization of queues. If the arrival time of a task is 0, put it in the inQueue;
	 * else in notInQueue.
	 * @param tasks
	 */
	private void addTasks(List<Task> tasks) {
		Task t;
		int number = 0;
		for(int i=0; i < tasks.size(); i++) {
			t = tasks.get(i);	
			//first put the task whose arrival time is 0 into the queue
			if(0 == t.getArrivalTime()) { 
				if(number < mQueues) {
					inQueue.add(t);
					number ++;
				}
			} else {
				notInQueue.add(t);
			}
		}
	}
	
	public void execute() {
		Util.sortByArrivalTime(notInQueue);
		int currentTime = 0;
		while(true) {
			Task task = null;
			Task taskNew = null;
			int i;
			for(i=0; i < inQueue.size(); i++) {
				task = inQueue.get(i);
				if(task.getArrivalTime() >= currentTime) {
					if(!task.isVisited()) {
						task.setStartingTime(currentTime);
						task.setFinishingTime(task.getStartingTime() + task.getServiceTime());
						task.setTurnAroundTime(task.getFinishingTime() - task.getArrivalTime());
						task.setWeightTurnAround((double)task.getTurnAroundTime() / task.getServiceTime());
						task.setVisited(true);
					}
				}
				if(task.getFinishingTime() == currentTime) {
					inQueue.remove(i); //remove the element i, and shift subsequent elements to the left
					i--;
				}
			}
			
			//if there are still empty queues and it has still tasks left
			while(i < mQueues && notInQueue.size() != 0) {
				taskNew = notInQueue.get(0);
				if(taskNew.getArrivalTime() <= currentTime) {
					taskNew.setStartingTime(currentTime);
					taskNew.setFinishingTime(taskNew.getStartingTime() + taskNew.getServiceTime());
					taskNew.setTurnAroundTime(taskNew.getFinishingTime() - taskNew.getArrivalTime());
					taskNew.setWeightTurnAround((double)taskNew.getTurnAroundTime() / taskNew.getServiceTime());
					inQueue.add(taskNew);
					notInQueue.remove(0);
					i++;
				} else {
					break;
				}
			}
			
			if(notInQueue.size() == 0)
				break;
			
			currentTime ++;
		}
		
		writeResult();
	}
	
	private void writeResult() {
		Util.sortByID(tasks);
		StringBuilder sb = new StringBuilder();
		//Data title
		sb.append("TaskID" + " " + "ArrivalTime" + " "
				+ "ServiceTime" + " " + "StartingTime" + " "
				+ "FinishingTime" + " " + "TurnAroundTime" + " "
				+ "WeightTurnAround" + "\n");
		for(Task t : tasks) {
			sb.append(t.toString());
		}
		
		//Write results to the file
		try {
			FileWriter writer = new FileWriter("fcfs.txt");
			writer.write(sb.toString());
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
