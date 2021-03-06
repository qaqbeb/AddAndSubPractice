package Problem;

public class Problem {
	private int num1;
	private int num2;
	private char op;
	
	Problem(int num1, int num2, int op){
		this.num1 = num1;
		this.num2 = num2;
		this.op = (op%2 == 0)?'+':'-';
	}
	
	public int getnum1(){
		return num1;
	}
	
	public int getnum2(){
		return num2;
	}
	
	public char getop() {
		return op;
	}
	
	public int Calculate() {
		if(op == '+')
			return num1 + num2;
		else
			return num1 - num2;
	}
	
	@Override
	public String toString() {
		return "num1 = " + num1 + "\tnum2 = " + num2 + "\top = " + op; 
	}
}
