package exp3;
import javax.swing.*;

import java.awt.TextArea;
import java.awt.event.*;

public class SwingExample implements ActionListener {

	JFrame fr;
	JLabel l;
	JTextField tf;
	JButton b;
	
	SwingExample() {
		fr = new JFrame();
		fr.setSize(400, 310);
		fr.setVisible(true);
		fr.setLayout(null);
		fr.setTitle("Swing Window");
		
		init();
		addComponent();
		register();
	}
	
	public void init() {
		l = new JLabel();
		l.setBounds(50, 20, 300, 20);
		l.setText("This is a welcome page!");
		
		tf = new JTextField();
		tf.setBounds(50, 60, 300, 140);
		
		b = new JButton();
		b.setBounds(150, 230, 100, 20);
//		b.setAction();
	}
	
	public void addComponent() {
		fr.add(l);
		fr.add(tf);
		fr.add(b);
	}
	
	public void register() {
		b.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		tf.setText("Welcome to Swing!");
	}
		
	public static void main(String[] args) {
		new SwingExample();
	}

}
