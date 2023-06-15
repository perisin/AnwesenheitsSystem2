package Gui;

import javax.swing.*;

import Employee.*;

public class ManageWindows {
	
	private Employee currentEmployee;
	
	private Java_GUI javaGUI;
	private BenutzerVerwaltung verwaltung;
	private AdminPanel adminPanel;
	private AdminMenu adminMenu;
	private AdminGUI adminGUI;
	
	public static void main(String[] args) {
		ManageWindows manageWindows = new ManageWindows();
		JFrame frame1 = new JFrame();;
		JFrame frame2 = new JFrame();
		
		JFrame mainFrame = frame1;
		
		JLabel label = new JLabel();
		label.add(new JLabel("test"));
		mainFrame.setVisible(true);
	}
}
