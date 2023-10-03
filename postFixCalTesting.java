import java.util.Stack;

public class postFixCalTesting {
	public double precision(IStack stack, IPostFixCal calculator) {
		int correctResults = 0;
		//passing strings from the stack to calculator
		while(!stack.isEmpty()) {
			String e = Stack.pop();
			double result = calculator(e);
			if (result >= 0 && result == (int) result) {
				correctResults++;
			}
		}	
		return (double) correctResults/5;
	}//End of Precision Method
}//End of postFixCalTesting class
