package exp3_1;

import java.awt.*;
import javax.swing.*;

public class BorderLayoutExample {
	JFrame f;
	JButton btn1,btn2,btn3,btn4,btn5;
	
	BorderLayoutExample() {
		
		f = new JFrame();
		f.setLayout(new BorderLayout(10, 10));
		f.setSize(500,500);
		f.setTitle("Experiment3");
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		init();
		add_component();
	}
	
	void init() {
		btn1 = new JButton("North");
		btn2 = new JButton("South");
		btn3 = new JButton("East");
		btn4 = new JButton("West");
		btn5 = new JButton("Center");
	}
	
	void add_component() {
		f.add(btn1,BorderLayout.NORTH);
		f.add(btn2,BorderLayout.SOUTH);
		f.add(btn3,BorderLayout.EAST);
		f.add(btn4,BorderLayout.WEST);
		f.add(btn5,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new BorderLayoutExample();
	}

}
