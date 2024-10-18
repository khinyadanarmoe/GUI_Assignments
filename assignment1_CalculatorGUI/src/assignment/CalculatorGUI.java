package assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI extends JFrame implements ActionListener {

	private JTextField resultField;
	private StringBuilder currentInput; // to display string , store input
	private double num1, num2;
	private char currentOperator;

	public CalculatorGUI() {

		this.currentInput = new StringBuilder();
		this.num1 = this.num2 = 0;

		this.resultField = new JTextField();
		this.resultField.setPreferredSize(new Dimension(300, 50));
		this.resultField.setEditable(false);
		this.resultField.setHorizontalAlignment(JTextField.RIGHT); // cursor show at the right end

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 5, 5)); // row, column, hor and ver gap

		String[] buttonLabels = {

				"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/", };

		for (String label : buttonLabels) {
			JButton button = new JButton(label);
			button.addActionListener(this); // current pointer: this button action only in this class

			buttonPanel.add(button);
		}

		this.setLayout(new BorderLayout(10, 10));
		this.add(resultField, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);

		this.setTitle("Basic Calculator");
		this.setSize(300, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // terminate the program when click x
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// start working when click the buttons
//		System.out.println("Click" + e.getSource().toString());
//		System.out.println("Clcik" + e.getActionCommand()); // get label in text field

		String command = e.getActionCommand();
		if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
			currentInput.append(command);
			resultField.setText(currentInput.toString());
		} else if (command.equals("C")) {
			currentInput.setLength(0);
			resultField.setText("");
			num1 = num2 = 0;
			currentOperator = ' ';
		} else if (command.equals("=")) {
			if (currentInput.length() > 0 && this.currentOperator != ' ') {
				this.num2 = Double.parseDouble(currentInput.toString());
				double result = 0;

				switch (this.currentOperator) {

				case '+':
					result = this.num1 + this.num2;
					break;
				case '-':
					result = this.num1 - this.num2;
					break;
				case '*':
					result = this.num1 * this.num2;
					break;
				case '/':
					if (this.num2 != 0) {
						result = this.num1 / this.num2;
					} else {
						resultField.setText("Error: Divide By Zero");
					}
					break;

				}

				resultField.setText(String.valueOf(result));
				currentInput.setLength(0);
				num1 = num2 = 0;
				currentOperator = ' ';
			}
		}

		else {
			//for operators => if operators, set num1 and get current operator
			if (currentInput.length() > 0) {
				this.num1 = Double.parseDouble(currentInput.toString());
				this.currentOperator = command.charAt(0);
				this.currentInput.setLength(0); // clear currentInput

			}
		}

	}
}
