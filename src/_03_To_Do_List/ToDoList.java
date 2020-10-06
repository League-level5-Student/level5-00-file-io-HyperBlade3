package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	 /*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	static JFrame frame;
	static JPanel panel;
	static JButton btn1;
	static JButton btn2;
	static JButton btn3;
	static JButton btn4;
	static JButton btn5;
	static ArrayList<String> tasks;
	
	public static void main(String[] args) {
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		btn1 = new JButton("Add Task");	
		btn2 = new JButton("View Task");
		btn3 = new JButton("Remove Task");
		btn4 = new JButton("Save List");
		btn5 = new JButton("Load List");
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		
		ToDoList list = new ToDoList();
		list.setup();
		
		frame.setSize(600, 75);
		frame.setVisible(true);
		
		tasks = new ArrayList<String>();
		
		tasks.clear();
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/list.txt"));
			String line = "";
			try {
				line = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (line != null) {
				tasks.add(line);
				try {
					line = br.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		
	}
	
	public void setup() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btn1) {
			String add = JOptionPane.showInputDialog("Add Task:");
			tasks.add(add);
		}
		else if (e.getSource() == btn2) {
			String out = "";
			for (String x : tasks) {
				out+=x;
				out+="\n";
			}
			
			JOptionPane.showMessageDialog(null, out);
		}
		else if (e.getSource() == btn3) {
			String remove = JOptionPane.showInputDialog("Remove Task: ");
			tasks.remove(remove);
		}
		else if (e.getSource() == btn4) {
			String out = "";
			for (String x : tasks) {
				out+=x;
				out+="\n";
			}
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/list.txt");
				fw.write(out);
				fw.close();
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == btn5) {
			
			tasks.clear();
			try {
				
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/list.txt"));
				String line = "";
				try {
					line = br.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while (line != null) {
					tasks.add(line);
					try {
						line = br.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
			
			
			
		}
	}
}