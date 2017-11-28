package fjnu.java.scheduling;
/**
 * 
 * @author ll
 *
 */
public class Task {
	private int taskID;
	private int arrivalTime;			//到达时间
	private int serviceTime;			//服务时间
	private int startingTime;			//开始执行时间
	private int finishingTime;			//完成时间
	private int turnAroundTime;			//周转时间; =完成时间-开始时间
	private double weightTurnAround;	//带权周转时间; =周转时间/服务时间
	private boolean visited = false;
	
	public Task(int taskID, int arrivalTime, int serviceTime) {
		this.taskID = taskID;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}
	
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	
	public int getTaskID() {
		return taskID;
	}
	
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	public int getServiceTime() {
		return serviceTime;
	}
	
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	
	public int getStartingTime() {
		return startingTime;
	}
	
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	
	public int getFinishingTime() {
		return finishingTime;
	}
	
	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	
	public void setWeightTurnAround(double weightTurnAround) {
		this.weightTurnAround = weightTurnAround;
	}
	
	public double getWeightTurnAround() {
		return weightTurnAround;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	@Override
	public String toString() {
		return  + taskID + "\t\t\t"
				+ arrivalTime + "\t\t\t"
				+ serviceTime + "\t\t\t"
				+ startingTime + "\t\t\t"
				+ finishingTime + "\t\t\t"
				+ turnAroundTime + "\t\t\t"
				+ weightTurnAround + "\n";
	}
	
}
