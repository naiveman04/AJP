package exp3;
import javax.swing.*;
import java.awt.event.*;

public class ActualExp3 {

	JFrame fr;
	JLabel main, fullName1, year2, branch3, division4, batch5, marks6, ajp7, cn8, pm9, pdc10;
	JTextField fullName, year, branch, division, batch, ajp, cn, pm, pdc;
	JButton submit, reset;
	
	ActualExp3() {
		fr = new JFrame();
		fr.setSize(480, 620);
		fr.setVisible(true);
		fr.setLayout(null);
		fr.setTitle("Marksheet Info.");
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		addComponent();
		register();
		
	}
	
	public void init() {
		
		// Labels:
		
		main = new JLabel();
		main.setBounds(20, 40, 420, 20);
		main.setText("Enter your student details in the given fields:");
		main.setHorizontalAlignment(SwingConstants.CENTER);
		
		fullName1 = new JLabel();
		fullName1.setBounds(20, 80, 200, 20);
		fullName1.setText("Full Name (Name+Surname):");
		
		year2 = new JLabel();
		year2.setBounds(20, 120, 200, 20);
		year2.setText("Year (FE/SE/TE/BE):");
		
		branch3 = new JLabel();
		branch3.setBounds(20, 160, 200, 20);
		branch3.setText("Branch (CE/IT/EnTC):");
		
		division4 = new JLabel();
		division4.setBounds(20, 200, 200, 20);
		division4.setText("Division (1-11):");
		
		batch5 = new JLabel();
		batch5.setBounds(20, 240, 200, 20);
		batch5.setText("Batch:");
		
		marks6 = new JLabel();
		marks6.setBounds(20, 300, 420, 20);
		marks6.setText("Enter your subject wise marks in the given fields:");
		marks6.setHorizontalAlignment(SwingConstants.CENTER);
		
		ajp7 = new JLabel();
		ajp7.setBounds(20, 340, 200, 20);
		ajp7.setText("AJP:");
		
		cn8 = new JLabel();
		cn8.setBounds(20, 380, 200, 20);
		cn8.setText("CN:");
		
		pm9 = new JLabel();
		pm9.setBounds(20, 420, 200, 20);
		pm9.setText("PM:");
		
		pdc10 = new JLabel();
		pdc10.setBounds(20, 460, 200, 20);
		pdc10.setText("PDC:");
		
		// Text fields:

		fullName = new JTextField();
		fullName.setBounds(240, 80, 200, 20);
				
		year = new JTextField();
		year.setBounds(240, 120, 200, 20);
		
		branch = new JTextField();
		branch.setBounds(240, 160, 200, 20);
		
		division = new JTextField();
		division.setBounds(240, 200, 200, 20);
		
		batch = new JTextField();
		batch.setBounds(240, 240, 200, 20);
		
		ajp = new JTextField();
		ajp.setBounds(240, 340, 200, 20);
		
		cn = new JTextField();
		cn.setBounds(240, 380, 200, 20);
		
		pm = new JTextField();
		pm.setBounds(240, 420, 200, 20);
		
		pdc = new JTextField();
		pdc.setBounds(240, 460, 200, 20);
		
		// Buttons:
		
		submit = new JButton();
		submit.setBounds(100, 520, 80, 20);
		submit.setText("Submit");
		
		reset = new JButton();
		reset.setBounds(280, 520, 80, 20);
		reset.setText("Reset");
	}
	
	public void addComponent() {
		// Labels:
		fr.add(main);
		fr.add(fullName1);
		fr.add(year2);
		fr.add(branch3);
		fr.add(division4);
		fr.add(batch5);
		fr.add(marks6);
		fr.add(ajp7);
		fr.add(cn8);
		fr.add(pm9);
		fr.add(pdc10);
		
		// Text fields:
		fr.add(fullName);
		fr.add(year);
		fr.add(branch);
		fr.add(division);
		fr.add(batch);
		fr.add(ajp);
		fr.add(cn);
		fr.add(pm);
		fr.add(pdc);
		
		// Buttons:
		fr.add(submit);
		fr.add(reset);
	}
	
	public void register() {
	    submit.addActionListener(e -> handleSubmit());
	    reset.addActionListener(e -> handleReset());
	}
	
	public boolean validateInputs() {
	    // Validate Full Name (must not be empty)
	    if (fullName.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(fr, "Full Name cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Validate Year (must be FE, SE, TE, or BE)
	    String yearInput = year.getText().trim();
	    if (!yearInput.matches("FE|SE|TE|BE")) {
	        JOptionPane.showMessageDialog(fr, "Year must be FE, SE, TE, or BE.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Validate Branch (must be CE, IT, or EnTC)
	    String branchInput = branch.getText().trim();
	    if (!branchInput.matches("CE|IT|EnTC")) {
	        JOptionPane.showMessageDialog(fr, "Branch must be CE, IT, or EnTC.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Validate Division (must be a number between 1 and 11)
	    try {
	        int divisionInput = Integer.parseInt(division.getText().trim());
	        if (divisionInput < 1 || divisionInput > 11) {
	            throw new NumberFormatException();
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(fr, "Division must be a number between 1 and 11.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Validate Batch (must not be empty)
	    if (batch.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(fr, "Batch cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Validate Marks (must be integers between 0 and 100)
	    try {
	        int ajpMarks = Integer.parseInt(ajp.getText().trim());
	        int cnMarks = Integer.parseInt(cn.getText().trim());
	        int pmMarks = Integer.parseInt(pm.getText().trim());
	        int pdcMarks = Integer.parseInt(pdc.getText().trim());

	        if (ajpMarks < 0 || ajpMarks > 100 || cnMarks < 0 || cnMarks > 100 ||
	            pmMarks < 0 || pmMarks > 100 || pdcMarks < 0 || pdcMarks > 100) {
	            throw new NumberFormatException();
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(fr, "Marks must be integers between 0 and 100.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // All validations passed
	    return true;
	}


	private void handleSubmit() {
	  
		if (!validateInputs()) {
	        return;
	    }
		
	    // Create a panel to display the information
	    JPanel displayPanel = new JPanel();
	    displayPanel.setLayout(null);
	    displayPanel.setPreferredSize(new java.awt.Dimension(400, 500)); // Adjust size as needed

	    // Convert text fields to integers
        int ajpMarks = Integer.parseInt(ajp.getText());
        int cnMarks = Integer.parseInt(cn.getText());
        int pmMarks = Integer.parseInt(pm.getText());
        int pdcMarks = Integer.parseInt(pdc.getText());

        // Calculate the average
        int finalMarks = (ajpMarks + cnMarks + pmMarks + pdcMarks) / 4;
	    
	    //Labels
	    JLabel mainLabel = new JLabel("Student Details:");
	    mainLabel.setBounds(0, 10, 420, 20);
	    mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    displayPanel.add(mainLabel);

	    JLabel fullNameLabel = new JLabel("Full Name: " + fullName.getText());
	    fullNameLabel.setBounds(0, 40, 420, 20);
	    displayPanel.add(fullNameLabel);

	    JLabel yearLabel = new JLabel("Year: " + year.getText());
	    yearLabel.setBounds(0, 80, 420, 20);
	    displayPanel.add(yearLabel);

	    JLabel branchLabel = new JLabel("Branch: " + branch.getText());
	    branchLabel.setBounds(0, 120, 420, 20);
	    displayPanel.add(branchLabel);

	    JLabel divisionLabel = new JLabel("Division: " + division.getText());
	    divisionLabel.setBounds(0, 160, 420, 20);
	    displayPanel.add(divisionLabel);

	    JLabel batchLabel = new JLabel("Batch: " + batch.getText());
	    batchLabel.setBounds(0, 200, 420, 20);
	    displayPanel.add(batchLabel);

	    // Marks section
	    JLabel marksLabel = new JLabel("Subject-wise Marks:");
	    marksLabel.setBounds(0, 240, 420, 20);
	    marksLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    displayPanel.add(marksLabel);

	    JLabel ajpLabel = new JLabel("AJP: " + ajp.getText());
	    ajpLabel.setBounds(0, 280, 420, 20);
	    displayPanel.add(ajpLabel);

	    JLabel cnLabel = new JLabel("CN: " + cn.getText());
	    cnLabel.setBounds(0, 320, 420, 20);
	    displayPanel.add(cnLabel);

	    JLabel pmLabel = new JLabel("PM: " + pm.getText());
	    pmLabel.setBounds(0, 360, 420, 20);
	    displayPanel.add(pmLabel);

	    JLabel pdcLabel = new JLabel("PDC: " + pdc.getText());
	    pdcLabel.setBounds(0, 400, 420, 20);
	    displayPanel.add(pdcLabel);
	    
	    JLabel finalLabel = new JLabel("Final Percentage: " + finalMarks + "%");
	    finalLabel.setBounds(0, 440, 420, 20);
	    displayPanel.add(finalLabel);
	    
	    // Show the dialog with the custom panel
	    JOptionPane.showMessageDialog(fr, displayPanel, "Submitted Information", JOptionPane.INFORMATION_MESSAGE);
	}

	private void handleReset() {
	    fullName.setText("");
	    year.setText("");
	    branch.setText("");
	    division.setText("");
	    batch.setText("");
	    ajp.setText("");
	    cn.setText("");
	    pm.setText("");
	    pdc.setText("");
	}

		
	public static void main(String[] args) {
		new ActualExp3();
	}

}
