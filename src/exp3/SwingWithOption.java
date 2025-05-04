package exp3;
import javax.swing.*;
import java.awt.event.*;

public class SwingWithOption implements ActionListener {

	JFrame fr;
	JLabel l;
	JTextField tf;
	JButton b;
	
	SwingWithOption() {
		fr = new JFrame();
		fr.setSize(400, 400);
		fr.setVisible(true);
		fr.setLayout(null);
		fr.setTitle("Swing Window Example");
		
		init();
		addComponent();
		register();
	}
	
	public void init() {
		l = new JLabel();
		l.setBounds(50, 20, 300, 20);
		l.setText("This is a Login Page!");
		
		tf = new JTextField();
		tf.setBounds(50, 60, 300, 140);
		
		b = new JButton();
		b.setBounds(160, 230, 80, 20);
		b.setText("Login");
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
		Integer result = JOptionPane.showConfirmDialog(b, "Login was successful.", "Confirmation", 2, 1, null);
		tf.setText(result.toString());
	}
		
	public static void main(String[] args) {
		new SwingWithOption();
	}

}
