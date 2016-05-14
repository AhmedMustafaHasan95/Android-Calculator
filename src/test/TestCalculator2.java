package project;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class calc extends Application   {
	Stage window;
	
	//Scene s1;
public static GenericStack<Character> operatorStack=new GenericStack<Character>();

	public static String text="";
	//////////////////to Operate operation
	public static double operation(String operator,double op1,double op2)
	{
		double result=0.0;
		if (operator.equals("^")){ result=Math.pow(op1,op2);}
			
		if (operator.equals("%")){ result=op1%op2;}
		
		if (operator.equals("+")){ result=op1+op2;}
		
		if (operator.equals("-")){ result=op1-op2;}
		
		if (operator.equals("*")){ result=op1*op2;}

		if (operator.equals("/")){ result=op1/op2;}
/*
		if (operator.equals("/")){ 
			
		
			result=Math.sqrt(op1);}
	*/		 
		
		return result;
	}
	public static double sqr(double op){
		
		return Math.sqrt(op);
	}
	
	////////////////
	
	/////////////////////// to check priorty
	public static boolean  k(char o)
	{
		return( (o=='+'&&(operatorStack.peek()=='-'||operatorStack.peek()=='*'||operatorStack.peek()=='/'||operatorStack.peek()=='%'||operatorStack.peek()=='^'))
				||(o=='-'&&(operatorStack.peek()=='^'||operatorStack.peek()=='+'||operatorStack.peek()=='*'||operatorStack.peek()=='/'||operatorStack.peek()=='%'))
				||(o=='*'&&operatorStack.peek()=='^'||operatorStack.peek()=='/'||operatorStack.peek()=='%')
				||(o=='/'&&operatorStack.peek()=='^'||operatorStack.peek()=='*')||operatorStack.peek()=='%')
				||(o=='%'&&(operatorStack.peek()=='^'||operatorStack.peek()=='%'));
	}
	
	/////////////////
	
	//////////////////////////// to convert from infix to post fix
	public static GenericStack<String> infix_to_postfix(char[] infix)
	{
		String temp="";
		GenericStack<String> postStack=new GenericStack<String>();
		
		for(int i=0;i<infix.length;i++)
		{
			
			if((infix[i]=='^')||(infix[i]=='%')||(infix[i]=='+')||(infix[i]=='*')||(infix[i]=='/')||(infix[i]=='-')||(infix[i]=='(')||(infix[i]==')'))
			{
				postStack.push((String)temp);
				temp="";
				
				if((infix[i]=='('))
				{
					operatorStack.push(infix[i]);
				}
				else if((infix[i]==')'))
				{
					while(operatorStack.peek()!='(')
					{
						postStack.push((String)String.valueOf(operatorStack.pop()));
					}
						operatorStack.pop();
				}
				else 
				{
					while(!operatorStack.isEmpty()&&k(infix[i]))
					{
						postStack.push((String)String.valueOf(operatorStack.pop()));
					}
					operatorStack.push(infix[i]);
				}
				//do something
			}
			else if (infix[i]=='0'||infix[i]=='1'||infix[i]=='2'||infix[i]=='3'||infix[i]=='4'||infix[i]=='5'||infix[i]=='6'||infix[i]=='7'||infix[i]=='8'||infix[i]=='9'||infix[i]=='.'||infix[i]=='~')
			{
				temp=temp.concat((String)String.valueOf(infix[i]));
			}
		}
		if(!temp.isEmpty())
		{
			postStack.push((String)temp);
			temp="";
		}
		
		while(!operatorStack.isEmpty())
		{
			
			postStack.push((String)String.valueOf(operatorStack.pop()));
		}
		for(int i=0;i<postStack.getSize();i++)
		{
			if(postStack.getIndex(i).equals(""))
			{
				postStack.removeIndex(i);
			}
		}
		return postStack;
	}
	
}
