//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Stack;
import java.util.Scanner;
import static java.lang.System.*;

public class PostFix
{
 private Stack<Double> stack;
 private String expression;

 public PostFix()
 {
   stack = new Stack<Double>();
 }

 public PostFix(String exp)
 {
  stack = new Stack<Double>();
       setExpression(exp);
 }

 public void setExpression(String exp)
 {
  this.expression = exp;
 }

 public double calc(double one, double two, char op)
 {
  double result = 0.0;
       switch(op) 
                { 
                    case '+': 
                    result = one + two; 
                    break; 
                      
                    case '-': 
                    result = two - one; 
                    break; 
                      
                    case '/': 
                    result = two/one; 
                    break; 
                      
                    case '*': 
                    result = one * two; 
                    break; 
              } 
        return result;
 }

 public void solve()
 {
   String value[] = this.expression.split(" ");
       for(int i = 0; i < value.length; i++) {
           if(value[i].equals("+") || value[i].equals("-") ||value[i].equals("*") || value[i].equals("/")) {
               double result = calc(stack.pop(), stack.pop(), value[i].charAt(0));
               stack.push(result);
           }
           else {
               stack.push(Double.parseDouble(value[i]));
           }
       }
 }

  public String toString() {
       if(!stack.empty()) {
           return(this.expression + " = " + Double.toString(stack.pop()));
       }
       else {
           return null;
       }
   }
}
