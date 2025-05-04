package exp1;
import java.awt.*;
import java.awt.event.*;

public class KeyboardPress extends WindowAdapter implements KeyListener{
	
	Frame f;
	Label l1, l2;
	TextArea ta;
	
	KeyboardPress(){
		f = new Frame();
		f.setVisible(true);
		f.setSize(400,280);
		f.setTitle("Keyboard Press");
		f.setLayout(null);
		
		init();
		addComponent();
		register();
	}
	
	public void init() {
		l1 = new Label();
		l1.setBounds(50, 40, 300, 20);
		l1.setText("Keyboard Press.");
		//l1.setAlignment(0);
		
		ta = new TextArea();
		ta.setBounds(50, 80, 300, 140);
		//ta.setAlignment(0);

		l2 = new Label();
		l2.setBounds(50, 240, 300, 20);
		//l2.setAlignment(0);
	}
	
	public void addComponent() {
		f.add(l1); 
		f.add(ta);
		f.add(l2);
	}
	
	public void keyTyped(KeyEvent e) {
		l2.setText("Key Typed: " + e.getKeyChar());
	}
	
	public void keyReleased(KeyEvent e) {
		l2.setText("Key Pressed: " + e.getKeyChar());
	}
	
	public void keyPressed(KeyEvent e) {
		l2.setText("Key Pressed: " + e.getKeyChar());
	}
	
	public void register() {
		f.addWindowListener(this);
		ta.addKeyListener(this);
	}
	
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	
	public static void main(String[] args) {
		KeyboardPress obj1 = new KeyboardPress();
	}

}
