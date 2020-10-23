package Problem;
import java.util.Random;

public class ProblemGenerator {

	ProblemGenerator(){}
	
	public static Problem Generate(int model) {
		switch(model) {
		case 0:
			return model_0();
		case 1:
			return model_1();
		case 2:
			return model_2();
		case 3:
			return model_3();
		case 4:
			return model_4();
		case 5:
			return model_5();
		case 6:
			return model_6();
		default:
			return null;
		}
	}
	
	private static Problem model_0() {
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		int num1 = Math.abs(rd.nextInt() % 100);
		int num2 = Math.abs(rd.nextInt() % 100);
		int op = Math.abs(rd.nextInt() % 2);
		return new Problem(num1, num2, op);
	}
	
	private static Problem model_1() {
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		int op = Math.abs(rd.nextInt() % 2) + 2;
		int num1, num2;
		if(op == 3) {	//如果是除法
			num2 = Math.abs(rd.nextInt() % 100);
			int mul = Math.abs(rd.nextInt() % 100);
			num1 = num2 * mul;
		}
		else {			//如果是乘法
			num1 = Math.abs(rd.nextInt() % 100);
			num2 = Math.abs(rd.nextInt() % 100);
		}
		return new Problem(num1, num2, op);
	}
	
	private static Problem model_2() {
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		int num1 = Math.abs(rd.nextInt() % 100);
		int num2 = Math.abs(rd.nextInt() % 100);
		return new Problem(num1, num2, 0);
	}
	
	private static Problem model_3() {
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		int num1 = Math.abs(rd.nextInt() % 100);
		int num2 = Math.abs(rd.nextInt() % 100);
		return new Problem(num1, num2, 1);
	}
	
	private static Problem model_4() {
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		int num1 = Math.abs(rd.nextInt() % 100);
		int num2 = Math.abs(rd.nextInt() % 100);
		return new Problem(num1, num2, 2);
	}
	
	private static Problem model_5() {
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		int num2 = Math.abs(rd.nextInt() % 100);
		int mul = Math.abs(rd.nextInt() % 100);
		int num1 = mul * num2;
		return new Problem(num1, num2, 3);
	}
	
	private static Problem model_6() {
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		int op = Math.abs(rd.nextInt() % 4);
		int num1, num2;
		if(op == 3) {	//如果是除法
			num2 = Math.abs(rd.nextInt() % 100);
			int mul = Math.abs(rd.nextInt() % 100);
			num1 = num2 * mul;
		}
		else {			//其他情况
			num1 = Math.abs(rd.nextInt() % 100);
			num2 = Math.abs(rd.nextInt() % 100);
		}
		return new Problem(num1, num2, op);
	}
	
}
