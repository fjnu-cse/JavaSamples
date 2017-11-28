package fjnu.java.scheduling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class schedules tasks by short job first (SJF).
 * @author ll
 *
 */
public class SjfScheduling {
	private List<Task> tasks = new ArrayList<Task>();
	private List<Task> inQueue = null;
	private List<Task> notInQueue = new ArrayList<Task>();
	
	//处理队列的个数，在实验中，可以是1或者2
	private int mQueues;
	
	public SjfScheduling(String filename) {
		this(filename, 1);
	}
	
	public SjfScheduling(String filename, int queues) {
		this.mQueues = queues;
		tasks = Util.readTasks(filename);
		inQueue = new ArrayList<Task>();
		//print();
	}
	
	public void print() {
		for(Task t : tasks) {
			System.out.print(t);
		}
	}
	
	/*
	private int addTasks(List<Task> tasks) {
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
			}
		}
		return number;
	}*/
	
	public void execute() {
		int currentTime = 0;
		int taskIndex = 0;
		int inQueueIndex = 0;
		int taskSize = tasks.size();
		
		while(true) {
			Task task = null;
			
			do { //将当前时刻已经到达的任务放置到notInQueue队列中
				if(taskIndex >= taskSize)
					break;
				task = tasks.get(taskIndex);
				if(task.getArrivalTime() <= currentTime) {
					notInQueue.add(task);
					taskIndex++;
				} else {
					//taskIndex--;
					break;
				}
			} while (true);
			
			System.out.println("taskIndex: " + taskIndex);
			
			//以服务时间长短排序，短作业在前
			Util.sortByServiceTime(notInQueue);
			
			Iterator<Task> iterator = notInQueue.iterator();
			
			//从notInQueue队列中放置任务到处理队列inQueue中
			while(iterator.hasNext()) {
				//说明当前所有队列中都有任务
				if(inQueueIndex >= mQueues) 
					break;
				
				task = iterator.next();
				inQueue.add(task);
				//notInQueue.remove(task);
				iterator.remove();
				inQueueIndex++;
			}
			
			Iterator<Task> iterInQueue = inQueue.iterator();
			
			//计算在处理队列中的任务的相关时间
			while(iterInQueue.hasNext()) {
				task = iterInQueue.next();
				if(!task.isVisited()) {
					task.setStartingTime(currentTime);
					task.setFinishingTime(task.getStartingTime() + task.getServiceTime());
					task.setTurnAroundTime(task.getFinishingTime() - task.getArrivalTime());
					task.setWeightTurnAround((double)task.getTurnAroundTime() / task.getServiceTime());
					task.setVisited(true);
				}
				
				//任务完成后从队列中删除
				if(task.getFinishingTime() == currentTime) {
					//inQueue.remove(task);
					iterInQueue.remove();
					inQueueIndex--;
				}
			}
					
			//如果有空闲队列,放置新任务
			while(inQueueIndex < mQueues && notInQueue.size() != 0) {
				task = (Task) notInQueue.get(0); //总是获取队首的任务，即最短服务时间的任务
				task.setStartingTime(currentTime);
				task.setFinishingTime(task.getStartingTime() + task.getServiceTime());
				task.setTurnAroundTime(task.getFinishingTime() - task.getArrivalTime());
				task.setWeightTurnAround((double)task.getTurnAroundTime() / task.getServiceTime());
				task.setVisited(true);
				inQueue.add(task);
				notInQueue.remove(0);
				inQueueIndex++;
			} 
			
			if(inQueue.size() == 0 && notInQueue.size() == 0) break;
			
			currentTime++;
		}
		writeResult();
	}
	
	private void writeResult() {
		Util.sortByID(tasks);
		StringBuilder sb = new StringBuilder();
		//Data Title
		sb.append("TaskID" + " " + "ArrivalTime" + " "
				+ "ServiceTime" + " " + "StartingTime" + " "
				+ "FinishingTime" + " " + "TurnAroundTime" + " "
				+ "WeightTurnAround" + "\n");
		for(Task t : tasks) {
			sb.append(t.toString());
		}
		
		//Write results to the file
		try {
			FileWriter writer = new FileWriter("sjf.txt");
			writer.write(sb.toString());
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
