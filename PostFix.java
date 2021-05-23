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
   expression = "";
   stack = new Stack<Double>();
 }

 public PostFix(String exp)
 {
expression = exp;
   stack = new Stack<Double>();
 }

 public void setExpression(String exp)
 {
expression = exp;
   stack = new Stack<Double>();
 }

 public double calc(double one, double two, char op)
 {
  switch (op) {
  case '+': return two + one;
  case '-': return two - one;
  case '*': return two * one;
  case '/': return two / one;
}
  return 0.0;
 }

 public void solve()
 {
   for(int i = 0; i < expression.length(); i+=2)
   {
     if(Character.isDigit(expression.charAt(i)))
     {
       stack.push((double)Character.getNumericValue(expression.charAt(i)));
     }else{
       double one = stack.pop();
       double two = stack.pop();
       stack.push(calc(one,two,expression.charAt(i)));
     }
   }
 }

  public String toString() {
       String s = expression+" = ";
   s+=stack.pop();
   return s;
   }
}
