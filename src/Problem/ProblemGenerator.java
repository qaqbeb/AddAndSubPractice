package Problem;
import java.util.Random;

public class ProblemGenerator {

	ProblemGenerator(){}
	
	public static Problem Generate() {
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		int num1 = Math.abs(rd.nextInt() % 100);
		int num2 = Math.abs(rd.nextInt() % 100);
		int op = rd.nextInt();
		return new Problem(num1, num2, op);
	}
	
}
