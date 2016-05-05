//import javafx.scene.layout.BorderPane;
package test;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane.Divider;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import java.lang.String;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

public class TestCalculator2 extends Application   {
	Stage window;
	Scene s1;
	@Override
	public void start(Stage stage) throws
	
		Exception{
		    ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    window=stage;
		boolean bcombool[]=new boolean[1];
		//BorderPane bord = new BorderPane();
		GridPane pane = new GridPane();
		TextField text = new TextField();
		TextField text1= new TextField();
		String[] operator = new String[1];
		operator[0]="";
		double[] ans= new double[1];
		
		////////////////////////////////////// Buttons & their handling methods
		Button b0 = new Button("0");//button 0
		b0.setOnAction(new EventHandler<ActionEvent>()//handling method
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
		Button b1 = new Button("1");//button 1
		
		b1.setOnAction(new EventHandler<ActionEvent>()//handling method
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
		Button b2 = new Button("2");//button 
		b2.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"2");
		text.setText(s);}});
		////////////////////////////////////////	3
		Button b3 = new Button("3");
		b3.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";
			String s= (text.getText()+"3");
		text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	4
		Button b4 = new Button("4");
		b4.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"4");
			text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	5
		Button b5 = new Button("5");
		b5.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(operator[0]=="=")
					{text.clear();}
				operator[0]="";	
				String s= (text.getText()+"5");text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	6
		Button b6 = new Button("6");
		b6.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
			{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"6");text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	7
		Button b7 = new Button("7");
		b7.setOnAction(new EventHandler<ActionEvent>()
		{	
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"7");
			text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	8
		Button b8 = new Button("8");
		b8.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
			{text.clear();}
			operator[0]="";	
			String s= (text.getText()+"8");
			text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	9
		Button b9 = new Button("9");
		b9.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";		
			String s= (text.getText()+"9");
		text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	PI
		Button bpy = new Button("π");
		bpy.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			operator[0]="";
			String s= (text.getText()+"π");
		text.setText(s);}});
		////////////////////////////////////////		////////////////////////////////////////	.
		Button bpoint = new Button(".");
		bpoint.setOnAction(new EventHandler<ActionEvent>()
		{	@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
			{text.clear();}
			operator[0]="";	
			if(!text.getText().isEmpty()&& !text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{String s= (text.getText()+".");
				text.setText(s);}}});
		////////////////////////////////////////		////////////////////////////////////////	+
		Button badd = new Button("+");
		badd.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(!text.getText().isEmpty()&&!text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{operator[0]="";
			text.setText(text.getText()+"+");}}});
		////////////////////////////////////////		////////////////////////////////////////	-
		Button bsub = new Button("-");
		bsub.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(!text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
				{operator[0]="";
				text.setText(text.getText()+"-");}}});
		////////////////////////////////////////		////////////////////////////////////////	/
		Button bdiv = new Button("/");
		bdiv.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(!text.getText().isEmpty() && !text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{
				operator[0]="";
				text.setText(text.getText()+"/");}}});
		////////////////////////////////////////		////////////////////////////////////////	*
		Button bmul = new Button("*");
		bmul.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{ if(!text.getText().isEmpty()&&!text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-")){
			operator[0]="";
			text.setText(text.getText()+"*");}}});
		////////////////////////////////////////	not handled yet--------------------------------------------->
		Button bsqur = new Button("^2");
		bsqur.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(!text.getText().isEmpty()&& !text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{ 
				operator[0]="=";
				double d= Double.parseDouble(text.getText());
				text.setText(d*d+"");}//End if
			}});
		////////////////////////////////////////	SquareRoot	////////////////////////////////////////
		Button rot = new Button("√( ");
		rot.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(operator[0]=="=")
			{text.clear();}
		operator[0]="";	
			text1.setText(text.getText()+"√(");
			text.setText(text1.getText());}});
		////////////////////////////////////////		////////////////////////////////////////
		Button pow = new Button("pow( ");
		pow.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
		{
			bcombool[0]=true;
			text1.setText(text.getText()+"Math.pow(");
			text.setText(text1.getText());}});
		/////////////////////////////////////////// 		////////////////////////////////////////	(
		Button btparleft=new Button("(");
		btparleft.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{if(operator[0]=="=")
				{text.clear();}
			if(!text.getText().endsWith(")"))
			{operator[0]="";	
			String s= (text.getText()+"(");	text.setText(s);}}});
		////////////////////////////////////////////		////////////////////////////////////////	)
		Button btparright=new Button(")");
		btparright.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(operator[0]=="=")
					{text.clear();}
				operator[0]="";	
				if(!text.getText().isEmpty() && !text.getText().endsWith("(")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("%"))
				{String s= (text.getText()+")");
				text.setText(s);}}});
		/////////////////////////////////////////////		////////////////////////////////////////
		Button bcomma=new Button(",");
		bcomma.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(operator[0]=="=")
					{text.clear();}
				operator[0]="";	
				if(bcombool[0]==true)
				{
					String s= (text.getText()+",");
					bcombool[0]=false;
					text.setText(s);}}});
		////////////////////////////////////////		////////////////////////////////////////
		Button bequal = new Button("=");
		bequal.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
		{
			if(!text.getText().isEmpty()&& !text.getText().endsWith("(")&& !text.getText().endsWith("%")&& !text.getText().endsWith("*")&& !text.getText().endsWith("/")&& !text.getText().endsWith("+")&& !text.getText().endsWith("-"))
			{
				
			//	operator[0]="";  	
				String s = text.getText();
				try 
				{
					if(s.contains("√"))
					{
						s = s.replaceAll( "√", "Math.sqrt" );

					}
					
					if(s.contains("sin"))
					{
						s = s.replaceAll( "sin", "Math.sin" );

					}
					if(s.contains("cos"))
					{
						s = s.replaceAll( "cos", "Math.cos" );

					}
					if(s.contains("tan"))
					{
						s = s.replaceAll( "tan", "Math.tan" );

					}

				//	Math.tanh(arg0)
					
					if(s.contains("π"))
					{
						s = s.replaceAll( "π", "Math.PI" );

					}
					Object b= engine.eval(s);
					String g =	b.toString();
					ans[0] = Double.parseDouble(g);
					text.setText(g);
				} catch (Exception  e1) {
				text.setText("MathError");}
			}
			operator[0]="=";	
		}});
		////////////////////////////////////////		////////////////////////////////////////
		Button ac = new Button("AC");
		ac.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{ operator[0]="";
			text.setText("");}});
		////////////////////////////////////////		////////////////////////////////////////
		Button mod = new Button("%");		
		mod.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{if(!text.getText().isEmpty())
			{ 
			text.setText(text.getText()+"%");}}});
		////////////////////////////////////////		////////////////////////////////////////
		Button del = new Button("del");
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
			{text.setText(text.getText()+ans[0]);}});
		////////////////////////////////////////		////////////////////////////////////////
		Button Sin= new Button("Sin");
		Sin.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(!text.getText().endsWith(".")&&!text.getText().endsWith(")"))
			{text.setText(text.getText()+"sin(");}}});
		Button tan= new Button("tan");
		tan.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(!text.getText().endsWith(".")&&!text.getText().endsWith(")"))
			{text.setText(text.getText()+"tan(");}}});
		Button cos= new Button("cos");
		cos.setOnAction(new EventHandler<ActionEvent>()
		{@Override
			public void handle(ActionEvent e)
			{
			if(!text.getText().endsWith(".")&&!text.getText().endsWith(")"))
			{text.setText(text.getText()+"cos(");}}});
		///////////////////////////////////////the minimum width an height of the Buttons///////////////////////////////////////
		/*
		  b1.setMinSize(30,20);b8.setMinSize(30,20);bsqur.setMinSize(50,20);Ans.setMinSize(50,20);
		  b2.setMinSize(30,20);b9.setMinSize(30,20);btparright.setMinSize(50,20);Sin.setMinSize(50,20);
		  b3.setMinSize(30,20);badd.setMinSize(30,20);mod.setMinSize(50,20);bpy.setMinSize(50,20);
		  b4.setMinSize(30,20);ac.setMinSize(50,20);bmul.setMinSize(30,20);bcomma.setMinSize(50,20);
		  b5.setMinSize(30,20);btparleft.setMinSize(50,20);bpoint.setMinSize(30,20);bdiv.setMinSize(30,20);
		  b6.setMinSize(30,20);del.setMinSize(50,20);rot.setMinSize(50,20);bequal.setMinSize(30,20);
		  b7.setMinSize(30,20);bsub.setMinSize(30,20);pow.setMinSize(50,20);b0.setMinSize(30,20);
		 */
////////////////////////////////////////////
	
	badd.prefWidthProperty().bind(pane.widthProperty().divide(8));
	badd.prefHeightProperty().bind(pane.heightProperty().divide(4));
	ac.prefWidthProperty().bind(pane.widthProperty().divide(8));
	ac.prefHeightProperty().bind(pane.heightProperty().divide(4));
	btparleft.prefWidthProperty().bind(pane.widthProperty().divide(8));
	btparleft.prefHeightProperty().bind(pane.heightProperty().divide(4));
	del.prefWidthProperty().bind(pane.widthProperty().divide(8));
	del.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bsub.prefWidthProperty().bind(pane.widthProperty().divide(8));
	bsub.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bsub.prefWidthProperty().bind(pane.widthProperty().divide(8));
	bsqur.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bsqur.prefWidthProperty().bind(pane.widthProperty().divide(8));
	btparright.prefHeightProperty().bind(pane.heightProperty().divide(4));
	btparright.prefWidthProperty().bind(pane.widthProperty().divide(8));
	mod.prefHeightProperty().bind(pane.heightProperty().divide(4));
	mod.prefWidthProperty().bind(pane.widthProperty().divide(8));
	bmul.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bmul.prefWidthProperty().bind(pane.widthProperty().divide(8));
	bpoint.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bpoint.prefWidthProperty().bind(pane.widthProperty().divide(8));
	rot.prefHeightProperty().bind(pane.heightProperty().divide(4));
	rot.prefWidthProperty().bind(pane.widthProperty().divide(8));
	pow.prefHeightProperty().bind(pane.heightProperty().divide(4));
	pow.prefWidthProperty().bind(pane.widthProperty().divide(8));
	bpy.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bpy.prefWidthProperty().bind(pane.widthProperty().divide(8));
	Ans.prefHeightProperty().bind(pane.heightProperty().divide(4));
	Ans.prefWidthProperty().bind(pane.widthProperty().divide(8));
	Sin.prefHeightProperty().bind(pane.heightProperty().divide(4));
	Sin.prefWidthProperty().bind(pane.widthProperty().divide(8));
	bcomma.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bcomma.prefWidthProperty().bind(pane.widthProperty().divide(8));
	bdiv.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bdiv.prefWidthProperty().bind(pane.widthProperty().divide(8));
	bequal.prefHeightProperty().bind(pane.heightProperty().divide(4));
	bequal.prefWidthProperty().bind(pane.widthProperty().divide(8));
	tan.prefHeightProperty().bind(pane.heightProperty().divide(4));
	tan.prefWidthProperty().bind(pane.widthProperty().divide(8));
	cos.prefHeightProperty().bind(pane.heightProperty().divide(4));
	cos.prefWidthProperty().bind(pane.widthProperty().divide(8));
	
	b0.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b0.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b1.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b1.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b2.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b2.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b3.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b3.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b4.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b4.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b5.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b5.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b6.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b6.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b7.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b7.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b8.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b8.prefHeightProperty().bind(pane.heightProperty().divide(4));
	b9.prefWidthProperty().bind(pane.widthProperty().divide(8));
	b9.prefHeightProperty().bind(pane.heightProperty().divide(4));
	
	text.prefWidthProperty().bind(pane.widthProperty().divide(12));
	text.prefHeightProperty().bind(pane.heightProperty().divide(6));
	b0.setStyle("-fx-border-width:0;-fx-border-color:white;-fx-background-color:cyan");
	pane.add( text,0,0,8,1);
	pane.addRow(1,b1,b2,b3,badd,ac,del,mod,tan);
		  pane.addRow(2,b4,b5,b6,bsub,bsqur,btparleft,btparright,cos);
		  pane.addRow(3,b7,b8,b9,bmul,rot,pow,Sin);
		  pane.addRow(4,b0,bequal,bpoint,bdiv,bpy,bcomma,Ans);
 pane.setPadding(new Insets(10,10,10,10)); 
		  pane.setStyle("-fx-border-width:2;-fx-border-color:cyan;-fx-background-color:white");
		  pane.setAlignment(Pos.CENTER);
		  
		  //------from this site------>> http://docs.gluonhq.com/javafxports/#_javafx_application
		  
		  Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
	        Scene scene = new Scene(pane,
	                bounds.getWidth(), bounds.getHeight());
	        
	      //consume let the programmer to choose how to close the program onClosing 
	        
		  window.setOnCloseRequest(e->{e.consume();closeProgram();});//to close the program
		  
		  window.setScene(scene);
		  window.setTitle("my project");
		  window.show();
		  }
	//end of the start method
	
	private void closeProgram(){window.close();}//closing the window
	
	public static double parseDouble(String ss) throws NumberFormatException
	{	
		double a =Double.parseDouble(ss);
	return a;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
