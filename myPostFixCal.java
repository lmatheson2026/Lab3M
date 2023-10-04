public class myPostFixCal implements IPostFixCal {
/***
 * 
 * author dean casbay
 * 
 * subtask #2
 * 
 */
    @Override
    public int calculate(IStack stack, String postFixString) {

        if (postFixString == null || postFixString.isEmpty()) {
            System.err.print("Invalid input: Postfix expression is empty.");
            return 0;
        }

        for (int i = 0; i < postFixString.length(); i++) {
            char c = postFixString.charAt(i);

            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                stack.push((char) digit);
            } else if (isOperator(c)) {
                if (stack.isEmpty()) {
                    System.err.println("Invalid input: Not enough operands for operator " + c);
                    return 0;
                }

                char operand2 = stack.pop();

                if (stack.isEmpty()) {
                    System.err.println("Invalid input: Not enough operands for operator " + c);
                    return 0; 
                }

                char operand1 = stack.pop();

                char result = 0;

                switch (c) {
                    case '+':
                        result = (char) (operand1 + operand2);
                        break;
                    case '-':
                        result = (char) (operand1 - operand2);
                        break;
                    case '*':
                        result = (char) (operand1 * operand2);
                        break;
                    case '/':
                        if (operand2 == 0) {
                            System.err.println("Division by zero.");
                            return 0; 
                        }
                        result = (char) (operand1 / operand2);
                        break;
                    default:
                        System.err.println("Invalid operator: " + c);
                        return 0; 
                }

                stack.push(result);
            }
        }

        if (stack.isEmpty()) {
            System.err.println("Invalid input: Too many operators.");
            return 0;
        }

        char finalResult = stack.pop();

        if (!stack.isEmpty()) {
            System.err.println("Invalid input: Too many operands.");
            return 0;
        }

        return Character.getNumericValue(finalResult);
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
