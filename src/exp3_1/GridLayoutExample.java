package exp3_1;

import java.awt.*;
import javax.swing.*;

public class GridLayoutExample {
	JFrame f;
	JButton btn1,btn2,btn3,btn4;
	
	GridLayoutExample() {
		
		f = new JFrame();
		f.setLayout(new GridLayout(2,2,10,10));
		f.setSize(500,500);
		f.setTitle("Experiment3");
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		init();
		add_component();
	}
	
	void init() {
		btn1 = new JButton("Button1");
		btn2 = new JButton("Button2");
		btn3 = new JButton("Button3");
		btn4 = new JButton("Button4");
	}
	
	void add_component() {
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
	}
	
	public static void main(String[] args) {
		new GridLayoutExample();
	}
}

