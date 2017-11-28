package fjnu.java.scheduling;
/**
 * 测试短作业优先算法
 * @author ll
 *
 */
public class SjfSchedulingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SjfScheduling sjf = new SjfScheduling("input.txt", 2);
		sjf.execute();
	}

}
