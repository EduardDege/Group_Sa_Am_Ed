package Reversion;
import javax.swing.JFormattedTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Sinusfunktion extends Application {

	private BorderPane b;
	static String s;
	int cursorX = 0;
	int cursorY = 200;
	
	
	double z0;
	
	static double z1 = 8;  // Amplitude
	double z2 = 0;
	double z3 = 1.99;
	int i = 0;
	
	
	public void sinus(double f) {
		if(i > 600)
			return;
		z0 = z3 * z1 - z2;
		z2 = z1;
		z1 = z0;
	//	System.out.println(i + " " + (int)z0 ); 
		drawLine(i, (int)z0) ;
		i++;
		//z3=f;
		//System.out.println(f);
		//z3=f -= 0.001;
		sinus(f);
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

	void drawLine(int x, int y) {
		int endX =  x;
		int endY =  200 - y;
		Line line = new Line(cursorX, cursorY, endX , endY);
		cursorX = endX;
		cursorY = endY;
		line.setStroke(Color.RED);
		b.getChildren().add(line);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	    TextField a = new TextField ("Amplitude");
	    Button btn = new Button("-0.01");
	    Button btn2= new Button("+0.01");
		btn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				System.out.println(z3);
				z3-=0.01;
				System.out.println(z3);
				
			b.getChildren().clear();
			
			i=0;
			cursorX = 0;
			cursorY = 200;
			
			Rectangle c = new Rectangle(600, 400, Color.BLACK);			
		    b.getChildren().add(c);
		    b.setLeft(a);
			b.setBottom(btn);
			b.setRight(btn2);
			sinus(1.99);
			}
			});
		
		btn2.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				System.out.println(z3);
				z3+=0.01;
				System.out.println(z3);
				
			b.getChildren().clear();
			
			i=0;
			cursorX = 0;
			cursorY = 200;
			
			Rectangle c = new Rectangle(600, 400, Color.BLACK);			
		    b.getChildren().add(c);
		    b.setLeft(a);
			b.setRight(btn2);
			b.setBottom(btn);
			sinus(1.99);
			}
			});
		a.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				
				s = a.getText();
				z1= Double.parseDouble(s);
				a.setText("");
				b.getChildren().clear();
				z2=0;
				i=0;
				cursorX = 0;
				cursorY = 200;
				
				Rectangle c = new Rectangle(600, 400, Color.BLACK);			
			    b.getChildren().add(c);
			    b.setLeft(a);
				b.setBottom(btn);
				b.setRight(btn2);
				sinus(1.99);
				
			}
		});
		
	    
		
		b = new BorderPane();
		Scene scene = new Scene(b, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Scribble");
		
		
		Rectangle panel = new Rectangle(600, 400, Color.BLACK);
		b.getChildren().add(panel);
		
		b.setLeft(a);
		b.setRight(btn2);
		b.setBottom(btn);
		primaryStage.show();		
	    
		sinus(1.99);
		
	}
}
