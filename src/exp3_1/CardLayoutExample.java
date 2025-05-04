package exp3_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CardLayoutExample implements ActionListener {
	JFrame f;
	JButton btn1,btn2,btn3,btn4;
	CardLayout crd;
	Container c;
	
	CardLayoutExample() {	
		f = new JFrame();
		crd = new CardLayout();
		c = f.getContentPane();
		c.setLayout(crd);
		f.setSize(500,500);
		f.setTitle("Experiment3");
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		init();
		add_component();
		register();
	}
	
	void init() {
		btn1 = new JButton("Button1");
		btn2 = new JButton("Button2");
		btn3 = new JButton("Button3");
		btn4 = new JButton("Button4");
	}
	
	void add_component() {
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		c.add(btn4);
	}
	
	void register() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		crd.next(c);
	}
	
	public static void main(String[] args) {
		new CardLayoutExample();
	}
}

