package fjnu.java.scheduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Util {
	/**
	 * Read tasks from file, which includes id, arrival time and service time.
	 * @param file
	 * @return
	 */
	public static List<Task> readTasks (String filePath) {
		List<Task> tasks = new ArrayList<Task> ();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filePath));
			while(scanner.hasNext()) {
				int taskID = scanner.nextInt();
				int arrivalTime = scanner.nextInt();
				int serviceTime = scanner.nextInt();
				tasks.add(new Task(taskID, arrivalTime, serviceTime));
			}
			scanner.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return tasks;	
	}
	
	public static void sortByID(List<Task> tasks) {
		Collections.sort(tasks, new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				if(t1.getTaskID() > t2.getTaskID()) {
					return 1;
				} else if (t1.getTaskID() == t2.getTaskID()){
					return 0;
				} else {
					return -1;
				}
			}
		});
	}
	
	public static void sortByArrivalTime(List<Task> tasks) {
		Collections.sort(tasks, new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				if(t1.getArrivalTime() > t2.getArrivalTime()) {
					return 1;
				} else if (t1.getArrivalTime() == t2.getArrivalTime()) {
					return 0;
				} else {
					return -1;
				}
			}
		});
	}
	
	public static void sortByServiceTime(List<Task> tasks) {
		Collections.sort(tasks, new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				if(t1.getServiceTime() > t2.getServiceTime()) {
					return 1;
				} else if (t1.getServiceTime() == t2.getServiceTime()) {
					return 0;
				} else {
					return -1;
				}
			}		
		});
	}
}
