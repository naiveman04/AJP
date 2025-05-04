package exp2;
import java.awt.*;
import java.awt.event.*;

public class MousePress extends WindowAdapter implements MouseListener{
	
	private static final Color Red = null;
	Frame f;
	Label l1, l2;
	TextArea ta;
	
	MousePress(){
		f = new Frame();
		f.setVisible(true);
		f.setSize(400,280);
		f.setTitle("Mouse Press");
		f.setLayout(null);
		
		init();
		addComponent();
		register();
	}
	
	
	
	public void init() {
		l1 = new Label();
		l1.setBounds(50, 40, 300, 20);
		l1.setText("You will change color of text area with mouse.");
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
	
	
	
	public void mouseClicked(MouseEvent e) {
		l2.setText("Mouse Clicked");
		ta.setBackground(Color.black);
	}

	public void mousePressed(MouseEvent e) {
		l2.setText("Mouse Pressed");
		ta.setBackground(Color.gray);
	}

	public void mouseReleased(MouseEvent e) {
		l2.setText("Mouse Released");
		ta.setBackground(Color.blue);
	}

	public void mouseExited(MouseEvent e) {
		l2.setText("Mouse Exited");
		ta.setBackground(Color.white);
	}
	public void mouseEntered(MouseEvent e) {
		l2.setText("Mouse Entered");
		ta.setBackground(Color.red);
	}
	
	
	
	public void register() {
		f.addWindowListener(this);
		ta.addMouseListener(this);
	}
	
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	
	
	public static void main(String[] args) {
		MousePress obj = new MousePress();
	}

	

}
