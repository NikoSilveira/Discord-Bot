package Outfasted.Misaki;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class window extends JPanel {

	/**
	 * Create the panel.
	 */
	public window() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JButton btnNewButton = new JButton("Shut down");
		btnNewButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Action to perform when button is pressed
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
	            		JOptionPane.showConfirmDialog (null, "Are you sure?","WARNING", dialogButton);
	            		if(dialogButton == JOptionPane.YES_OPTION) {
	                		System.exit(0);
	            		if(dialogButton == JOptionPane.NO_OPTION) {
	                  		remove(dialogButton);
	                		}
	              		}
			}
		});
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setBounds(114, 78, 100, 23);
		btnNewButton.setFocusPainted(false);
		add(btnNewButton);
		
		JLabel lblPressToLaunch = new JLabel("Press to launch a rocket (and shut down Misaki)");
		lblPressToLaunch.setFont(new Font("Eras Demi ITC", Font.PLAIN, 13));
		lblPressToLaunch.setForeground(new Color(240, 255, 255));
		lblPressToLaunch.setBounds(20, 28, 298, 14);
		add(lblPressToLaunch);

	}
}
