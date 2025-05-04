package exp2_1;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends WindowAdapter implements ActionListener{
	
	Frame f;
	Label l1;
	TextField tf1, tf2, tf3;
	Button b1, b2, b3, b4;
	
	Calculator(){
		f = new Frame();
		f.setVisible(true);
		f.setSize(310,220);
		f.setTitle("Calculator");
		f.setLayout(null);
		
		init();
		addComponent();
		register();
	}
	
	public void init() {
		l1 = new Label();
		l1.setBounds(0, 50, 300, 20);
		l1.setText("A Simple Calculator:");
		l1.setAlignment(Label.CENTER);
		
		tf1 = new TextField();
		tf1.setBounds(30, 90, 100, 20);
		
		tf2 = new TextField();
		tf2.setBounds(30, 130, 100, 20);
		
		tf3 = new TextField();
		tf3.setBounds(105, 170, 100, 20);
		tf3.setEditable(false);
		
		b1 = new Button("+");
		b1.setBounds(160, 90, 40, 20);
		
		b2 = new Button("-");
		b2.setBounds(230, 90, 40, 20);
		
		b3 = new Button("*");
		b3.setBounds(160, 130, 40, 20);
		
		b4 = new Button("/");
		b4.setBounds(230, 130, 40, 20);
	}
	
	public void addComponent() {
		f.add(l1);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
	}
	
	public void register() {
		f.addWindowListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		double num1, num2, result;
		num1 = Double.parseDouble(tf1.getText());
		num2 = Double.parseDouble(tf2.getText());
		
		if(e.getSource() == b1) {
			result = num1 + num2;
			tf3.setText(String.valueOf(result));
		}
		else if(e.getSource() == b2) {
			result = num1 - num2;
			tf3.setText(String.valueOf(result));
		}
		else if(e.getSource() == b3) {
			result = num1 * num2;
			tf3.setText(String.valueOf(result));
		}
		else if(e.getSource() == b4) {
			if(num2 != 0) {
				result = num1 / num2;
				tf3.setText(String.valueOf(result));
			} else {
				tf3.setText("Error");
			}
		}
	}
	
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	
	public static void main(String[] args) {
		Calculator obj1 = new Calculator();
	}
}
