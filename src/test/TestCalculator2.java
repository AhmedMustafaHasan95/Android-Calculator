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
	







	@Override
	
	public void start(Stage stage) throws
	
		Exception{
		    window=stage;
		
		TextField text = new TextField();
		text.setStyle("-fx-text-fill: Blue;-fx-font-size:12;-fx-border-color:rgb(17,204,78);-fx-border-width:2");
		text.setAlignment(Pos.CENTER_RIGHT);
		text.setEditable(false);
		TextField text1= new TextField();
		String[] operator = new String[1];
		operator[0]="";
		
		double[] ans= new double[1];

				////////////////////////////////////// Buttons & their handling methods
		Button buttonZero = new Button("0");//button 0
		buttonZero.setOnAction(new EventHandler<ActionEvent>()//handling method
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(operator[0]=="=")
				{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"0");
		text.setText(s);}});
		////////////////////////////////////////	1
		Button buttonOne = new Button("1");//button 1
		
		buttonOne.setOnAction(new EventHandler<ActionEvent>()//handling method
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
			{
				text.clear();
			}
			operator[0]="";	
			String s= (text.getText()+"1");
		text.setText(s);}});
		
		////////////////////////////////////////	2
		Button buttonTow = new Button("2");//button 
		buttonTow.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"2");
		text.setText(s);}});
		////////////////////////////////////////	3
		Button buttonThree = new Button("3");
		buttonThree.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";
			String s= (text.getText()+"3");
		text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	4
		Button buttonFour = new Button("4");
		buttonFour.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"4");
			text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	5
		Button buttonFive = new Button("5");
		buttonFive.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(operator[0]=="=")
					{text.clear();}
				operator[0]="";	
				String s= (text.getText()+"5");text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	6
		Button buttonSix = new Button("6");
		buttonSix.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
			{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"6");text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	7
		Button buttonSeven = new Button("7");
		buttonSeven.setOnAction(new EventHandler<ActionEvent>()
		{	
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"7");
			text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	8
		Button buttonEaight = new Button("8");
		buttonEaight.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
			{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"8");
			text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	9
		Button buttonNine = new Button("9");
		buttonNine.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";		
			String s= (text.getText()+"9");
		text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	?
		Button buttonpy = new Button("PI");
		buttonpy.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";
			String s= (text.getText()+"22/7");
		text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	.
		Button buttonpoint = new Button(".");
		buttonpoint.setOnAction(new EventHandler<ActionEvent>()
		{	@Override
			public void handle(ActionEvent e)
			{
			if(operator[0]=="=")
			{text.clear();}
			operator[0]="";	
			
			{String s= (text.getText()+".");
				text.setText(s);}}});
		////////////////////////////////////////		////////////////////////////////////////	+
		Button buttonadd = new Button("+");
		buttonadd.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(!text.getText().isEmpty()&&!text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{operator[0]="";
			text.setText(text.getText()+"+");}}});
		///////////////////////////////////				minus
		Button  bminus= new Button("Mns");
		bminus.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if(text.getText().endsWith("%")|| text.getText().endsWith("*")|| text.getText().endsWith("/")|| text.getText().endsWith("+")|| text.getText().endsWith("-")|| text.getText().isEmpty()|| text.getText().endsWith("("))
				{operator[0]="";
				text.setText(text.getText()+"~");
				}}});
		
		////////////////////////////////////////		////////////////////////////////////////	-
		Button buttonSub = new Button("-");
		buttonSub.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(!text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
				{operator[0]="";
				text.setText(text.getText()+"-");}}});
		////////////////////////////////////////		////////////////////////////////////////	/
		Button buttondiv = new Button("/");
		buttondiv.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(!text.getText().isEmpty() && !text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{
				operator[0]="";
				text.setText(text.getText()+"/");}}});
		////////////////////////////////////////		////////////////////////////////////////	*
		Button buttonmul = new Button("*");
		buttonmul.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{ if(!text.getText().isEmpty()&&!text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-")){
			operator[0]="";
			text.setText(text.getText()+"*");}}});
		////////////////////////////////////////	not handled yet--------------------------------------------->
		Button buttonsqur = new Button("^2");
		buttonsqur.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(!text.getText().isEmpty()&& !text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{ 
				operator[0]="=";
				
				text.setText(text.getText()+"^2");}//End if
			}});
		////////////////////////////////////////		////////////////////////////////////////
		Button buttonrot = new Button("^½");
		buttonrot.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(operator[0]=="=")
			{text.clear();}
		operator[0]="";
		if(!text.getText().isEmpty())
			{text1.setText(text.getText()+"^.5");
			text.setText(text1.getText());}}});
		////////////////////////////////////////		////////////////////////////////////////
		Button buttonPow = new Button("^");
		buttonPow.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
		{
			if(!text.getText().isEmpty())
			{
			text1.setText(text.getText()+"^");
			text.setText(text1.getText());}}});
		/////////////////////////////////////////// 		////////////////////////////////////////	(
		Button buttonTparleft=new Button("(");
		buttonTparleft.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			if(!text.getText().endsWith(")"))
			{operator[0]="";	
			String s= (text.getText()+"(");	text.setText(s);}}});
		////////////////////////////////////////////		////////////////////////////////////////	)
		Button buttonTparright=new Button(")");
		buttonTparright.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				operator[0]="";	
				if(!text.getText().isEmpty() && !text.getText().endsWith("("))
				{String s= (text.getText()+")");
				text.setText(s);}}});
		/////////////////////////////////////////////		////////////////////////////////////////
	
		////////////////////////////////////////		////////////////////////////////////////
		Button buttonEqual = new Button("=");
		buttonEqual.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
		{
			if(!text.getText().isEmpty()&& !text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{
				operator[0]="=";
				operator[0]="";  	
				String s = text.getText();
				try 
				{
					
				String t=	conversion(s.toCharArray());
				text.setText(t);
				ans[0]=Double.valueOf(t);
				} catch (Exception e1) {
				text.setText("MathError");
				}}
			operator[0]="=";	
		}});
		
		////////////////////////////////////////		////////////////////////////////////////
		Button ac = new Button("AC");
		ac.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{ text.clear();}});
		////////////////////////////////////////		////////////////////////////////////////
		Button mod = new Button("%");		
		mod.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{if(!text.getText().isEmpty())
			{ operator[0]="";
			text.setText(text.getText()+"%");}}});
		////////////////////////////////////////		////////////////////////////////////////
		Button del = new Button("<-");
		del.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{ 
			if(!text.getText().isEmpty())
			text.deleteText(text.getText().length()-1, text.getText().length());}});
		////////////////////////////////////////		////////////////////////////////////////
		Button Ans= new Button("Ans");
		Ans.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			
			public void handle(ActionEvent e)
			{
			text.setText(text.getText()+ans[0]);
			}});////////////////////////////////////////		////////////////////////////////////////
		////////////////////////////////////////		the minimum width an height of the Buttons		////////////////////////////////////////
	
		////////////////////////////
		Button close= new Button("Esc");
		close.setOnAction(new EventHandler<ActionEvent>()//handling method
				{
					@Override
					public void handle(ActionEvent e)
					{ 
						window.close();
						
						}});
		////////////////////////////////////////		////////////////////////////////////////		////////////////////////////////////////
	     //style
		
		  close.setStyle("-fx-font-size:12;-fx-background-color:rgb(17,204,78);-fx-text-fill: white");
		  buttonOne.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonEaight.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonsqur.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  Ans.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonTow.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonNine.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonTparright.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  bminus.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonThree.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonadd.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  mod.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonpy.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonFour.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  ac.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonmul.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonFive.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonTparleft.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonpoint.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttondiv.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonSix.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  del.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonrot.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonEqual.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonSeven.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonSub.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonPow.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  buttonZero.setStyle("-fx-font-size:12;-fx-background-color:rgb(30,30,30);-fx-text-fill: white");
		  
		  
		  
		  
		  GridPane pane = new GridPane();
		  Rectangle2D platform=Screen.getPrimary().getVisualBounds();
		  double w=platform.getWidth();
		  double h=platform.getHeight();
		  pane.setPadding(new Insets(6));
		  
		  
		  
		  
		//binding
			buttonadd.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonadd.prefHeightProperty().bind(pane.heightProperty().divide(4));
			close.prefWidthProperty().bind(pane.widthProperty().divide(8));
			close.prefHeightProperty().bind(pane.heightProperty().divide(4));
			ac.prefWidthProperty().bind(pane.widthProperty().divide(8));
			ac.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonTparleft.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonTparleft.prefHeightProperty().bind(pane.heightProperty().divide(4));
			del.prefWidthProperty().bind(pane.widthProperty().divide(8));
			del.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonSub.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonSub.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonSub.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonsqur.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonsqur.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonTparright.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonTparright.prefWidthProperty().bind(pane.widthProperty().divide(8));
			mod.prefHeightProperty().bind(pane.heightProperty().divide(4));
			mod.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonmul.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonmul.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonpoint.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonpoint.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonrot.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonrot.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonPow.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonPow.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonpy.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonpy.prefWidthProperty().bind(pane.widthProperty().divide(8));
			Ans.prefHeightProperty().bind(pane.heightProperty().divide(4));
			Ans.prefWidthProperty().bind(pane.widthProperty().divide(8));
			bminus.prefHeightProperty().bind(pane.heightProperty().divide(4));
			bminus.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttondiv.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttondiv.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonEqual.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonEqual.prefWidthProperty().bind(pane.widthProperty().divide(8));
			
			//number
			buttonZero.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonZero.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonOne.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonOne.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonTow.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonTow.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonThree.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonThree.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonFour.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonFour.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonFive.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonFive.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonSix.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonSix.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonSeven.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonSeven.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonEaight.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonEaight.prefHeightProperty().bind(pane.heightProperty().divide(4));
			buttonNine.prefWidthProperty().bind(pane.widthProperty().divide(8));
			buttonNine.prefHeightProperty().bind(pane.heightProperty().divide(4));
			
			text.prefWidthProperty().bind(pane.widthProperty().divide(8));
			text.prefHeightProperty().bind(pane.heightProperty().divide(5));
			
			GridPane.setMargin(buttonZero,new Insets(3));
			GridPane.setMargin(text,new Insets(3));
			GridPane.setMargin(close,new Insets(3));
			//GridPane.setMargin(on,new Insets(3,3));
		//	GridPane.setMargin(off,new Insets(3,3,3,3));
			GridPane.setMargin(buttonOne,new Insets(3));
			GridPane.setMargin(buttonTow,new Insets(3));
			GridPane.setMargin(buttonThree,new Insets(3));
			GridPane.setMargin(buttonFour,new Insets(3));
			GridPane.setMargin(buttonFive,new Insets(3));
			GridPane.setMargin(buttonSix,new Insets(3));
			GridPane.setMargin(buttonSeven,new Insets(3));
			GridPane.setMargin(buttonEaight,new Insets(3));
			GridPane.setMargin(buttonNine,new Insets(3));
			GridPane.setMargin(buttonadd,new Insets(3));
			GridPane.setMargin(ac,new Insets(3));
			GridPane.setMargin(buttonTparleft,new Insets(3));
			GridPane.setMargin(del,new Insets(3));
			GridPane.setMargin(buttonSub,new Insets(3));
			GridPane.setMargin(buttonsqur,new Insets(3));
			GridPane.setMargin(buttonTparright,new Insets(3));
			GridPane.setMargin(mod,new Insets(3));
			GridPane.setMargin(buttonmul,new Insets(3));
			GridPane.setMargin(buttonpoint,new Insets(3));
			GridPane.setMargin(buttonrot,new Insets(3));
			GridPane.setMargin(buttonPow,new Insets(3));
			GridPane.setMargin(Ans,new Insets(3));
			GridPane.setMargin(bminus,new Insets(3));
			GridPane.setMargin(buttonpy,new Insets(3));
			GridPane.setMargin(buttondiv,new Insets(3));
			GridPane.setMargin(buttonEqual,new Insets(3));

			pane.setStyle("-fx-border-width:2;-fx-border-color:rgb(17,204,78);-fx-background-color: black");//rgb(16,165,182)
			pane.setAlignment(Pos.CENTER);
			
			pane.add( text,0,0,8,1);
			pane.addRow(1,buttonSeven,buttonEaight,buttonNine,buttonadd,del,ac,close);
			pane.addRow(2,buttonFour,buttonFive,buttonSix,buttonSub,buttonsqur,buttonTparleft,buttonTparright);
			pane.addRow(3,buttonOne,buttonTow,buttonThree,buttonmul,buttonrot,buttonPow,bminus);
			pane.addRow(4,buttonZero,mod,buttonpoint,buttondiv,buttonpy,buttonEqual,Ans);
			
			//vboxpane.getChildren().addAll(text,pane);
			Scene scene = new Scene(pane,w,h);
	
		 
		  window.setScene(scene);
		  window.setTitle("my project");
		  window.show();
		  }//end of the start method
	
	
	public static void main(String[] args) {
		launch(args);
	}
}



