package studentRegistrationGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentRegistrationGUI extends JFrame {

	private JPanel panel;
	private JPanel btnPanel;
	private JLabel name;
	private JTextField nameValue;
	private JLabel email;
	private JTextField emailValue;
	private JLabel phoneNum;
	private JTextField phoneNumValue;
	private JRadioButton maleBtn;
	private JRadioButton femaleBtn;
	private JCheckBox checkBox;
	private JLabel courseLabel;
	private JComboBox<String> comboBox;
	private JButton submitBtn;

	public StudentRegistrationGUI() {

		initializeComponents();
		addToPanel();
		this.setVisible(true);

	}

	private void initializeComponents() {

		this.setTitle("Student Registration Form");
		this.setSize(300, 300);
		this.setLayout(new BorderLayout(20, 20));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(6, 2));
		this.name = new JLabel("Name");
		this.nameValue = new JTextField();

		this.email = new JLabel("Email");
		this.emailValue = new JTextField();

		this.phoneNum = new JLabel("Phone Number");
		this.phoneNumValue = new JTextField();

		this.maleBtn = new JRadioButton("Male");
		this.femaleBtn = new JRadioButton("Female");

		this.courseLabel = new JLabel("Course");
		String[] courses = { "Python", "Java", "C++" };
		this.comboBox = new JComboBox<>(courses);

		this.checkBox = new JCheckBox("Accept Terms");

		this.btnPanel = new JPanel();
		this.btnPanel.setLayout(new GridLayout(1, 1));
		this.submitBtn = new JButton("Submit");

	}

	private void addToPanel() {

		this.panel.add(this.name);
		this.panel.add(this.nameValue);

		this.panel.add(this.email);
		this.panel.add(this.emailValue);

		this.panel.add(this.phoneNum);
		this.panel.add(this.phoneNumValue);

		this.panel.add(maleBtn);
		this.panel.add(femaleBtn);

		this.panel.add(courseLabel);
		this.panel.add(comboBox);
		this.panel.add(checkBox);

		this.add(panel, BorderLayout.NORTH);

		this.btnPanel.add(submitBtn);
		this.add(btnPanel, BorderLayout.SOUTH);

		submitBtnAction();

	}

	private void submitBtnAction() {

		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				submitAction();

			}

		});

	}

	private void submitAction() {

		if (this.nameValue.getText().isEmpty() || this.emailValue.getText().isEmpty()
				|| this.phoneNumValue.getText().isEmpty() || !(this.maleBtn.isSelected() || this.femaleBtn.isSelected())
				|| !this.checkBox.isSelected()) {

			JOptionPane.showMessageDialog(this, "Please fill in all the required fields.");
		}

		else {
			JOptionPane.showMessageDialog(this, "Submission done!!");
		}

	}
}
