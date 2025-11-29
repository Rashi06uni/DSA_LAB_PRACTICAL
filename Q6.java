// Write a function to convert an infix expression to a postfix expression using a stack. The function should handle parentheses and operator precedence correctly

import java.util.Stack;

public class Q6 {

   
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }

   
    public static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

         
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
          
            else if (ch == '(') {
                stack.push(ch);
            }
    
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); 
            }

            else {
                while (!stack.isEmpty() &&
                       precedence(ch) <= precedence(stack.peek())) {

                    if (ch == '^' && precedence(ch) < precedence(stack.peek())) {
                        break;
                    }

                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String exp = "A+(B*C-(D/E^F)*G)*H";
        System.out.println("Infix Expression : " + exp);
        System.out.println("Postfix Expression : " + infixToPostfix(exp));
    }
}
