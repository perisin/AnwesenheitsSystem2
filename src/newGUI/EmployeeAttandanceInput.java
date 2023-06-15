package newGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeAttandanceInput implements State{

	@Override
	public void setPanel() {
		
	}
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("Back Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for the button panel
        JButton backButton = createBackButton();
        buttonPanel.add(backButton);
        
        JPanel attendancePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30)); // Set the preferred size
        
        panel.add(buttonPanel, BorderLayout.NORTH); // Add the button panel to the left side
        panel.add(textField, BorderLayout.CENTER);
        
        frame.getContentPane().add(panel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private static JButton createBackButton() {
        ImageIcon backIcon = new ImageIcon("C:/Users/Administrator/Desktop/AnwesenheitsSystem/arrow.png"); // Replace "arrow.png" with the path to your arrow image
        
        // Resize the image
        Image image = backIcon.getImage();
        Image resizedImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        JButton backButton = new JButton(resizedIcon);
        backButton.setPreferredSize(new Dimension(30, 30)); // Set the size of the button
        backButton.setBorderPainted(false); // Remove the button border
        backButton.setContentAreaFilled(false); // Remove the button background
        backButton.setFocusPainted(false); // Remove the focus border
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle back button click
                // Go back to the original panel
            }
        });
        
        return backButton;
    }
}
