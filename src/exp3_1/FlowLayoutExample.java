package exp3_1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FlowLayoutExample extends WindowAdapter {
	JFrame f;
	JLabel lbl1,lbl2,lbl3,lbl4;
	
	FlowLayoutExample() {
		
		f = new JFrame();
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.setSize(500,500);
		f.setTitle("Experiment3");
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		init();
		add_component();
		register();
	}
	
	void init() {
		lbl1 = new JLabel("Label1");
		lbl1.setPreferredSize(new Dimension(70,50));
		lbl1.setOpaque(true);
		lbl1.setBackground(Color.cyan);
		
		lbl2 = new JLabel("Label2");
		lbl2.setOpaque(true);
		lbl2.setPreferredSize(new Dimension(70,50));
		lbl2.setBackground(Color.cyan);
		
		lbl3 = new JLabel("Label3");
		lbl3.setPreferredSize(new Dimension(70,50));
		lbl3.setOpaque(true);
		lbl3.setBackground(Color.cyan);
		
		lbl4 = new JLabel("Label4");
		lbl4.setPreferredSize(new Dimension(70,50));
		lbl4.setOpaque(true);
		lbl4.setBackground(Color.cyan);
		
	}
	
	void add_component() {
		f.add(lbl1);
		f.add(lbl2);
		f.add(lbl3);
		f.add(lbl4);
	}
	
	void register() {
		f.addWindowListener(this);
	}

	public void windowClosing(WindowEvent e) {
		f.dispose();
	}
	
	public static void main(String[] args) {
		new FlowLayoutExample();
	}

}
