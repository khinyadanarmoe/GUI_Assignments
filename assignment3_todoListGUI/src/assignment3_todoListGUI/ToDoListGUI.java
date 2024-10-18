package assignment3_todoListGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ToDoListGUI extends JFrame {

	private JPanel inputPanel;
	private JLabel label;
	private JTextArea textArea;
	private StringBuilder input;
	private JButton addTaskBtn;
	private JTextField displayField;
	private JScrollPane scrollPane;
	private JPanel btnPanel;
	private JButton removeBtn;
	private JButton clearBtn;
	private JList<String> taskList;
	private DefaultListModel<String> listModel;

	public ToDoListGUI() {

		initializeComponents();
		addToPanel();
		this.setVisible(true);

	}

	private void initializeComponents() {

		this.setTitle("To-Do List Manager");
		this.setSize(300, 400);
		this.setLayout(new BorderLayout(20, 20));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.inputPanel = new JPanel();
		this.inputPanel.setLayout(new GridLayout(1, 3));
		this.label = new JLabel("Task:");
		this.textArea = new JTextArea();
		this.addTaskBtn = new JButton("Add Task");

		this.listModel = new DefaultListModel<>();
		this.taskList = new JList<>(listModel);

		this.scrollPane = new JScrollPane(taskList);

		this.btnPanel = new JPanel();
		this.btnPanel.setLayout(new GridLayout(1, 2));
		this.removeBtn = new JButton("Remove Task");
		this.clearBtn = new JButton("Clear All");

	}

	private void addToPanel() {

		this.inputPanel.add(this.label);
		this.inputPanel.add(this.textArea);
		this.inputPanel.add(this.addTaskBtn);
		addTaskBtnAction();

		this.add(inputPanel, BorderLayout.NORTH);

		this.add(scrollPane, BorderLayout.CENTER);

		this.btnPanel.add(removeBtn);
		removeBtnAction();
		this.btnPanel.add(clearBtn);
		clearBtnAction();
		this.add(btnPanel, BorderLayout.SOUTH);

	}

	private void addTaskBtnAction() {
		this.addTaskBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String task = textArea.getText();
				listModel.addElement(task);
				textArea.setText("");
			}

		});

	}

	private void clearBtnAction() {
		this.clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				listModel.clear();
			}

		});

	}

	private void removeBtnAction() {
		this.removeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				removeAction();

			}

		});

	}

	private void removeAction() {

		int selectedRow = taskList.getSelectedIndex();
		if (selectedRow != -1) {
			listModel.remove(selectedRow);
		}

		else {
			JOptionPane.showMessageDialog(this, "You haven't selected yet.");
		}

	}

}
