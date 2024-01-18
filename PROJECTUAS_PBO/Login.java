package com.perpus;

import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		user = new JTextField();
		user.setColumns(10);
		
		password = new JPasswordField();
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Get the entered username and password
		            String enteredUsername = user.getText();
		            char[] enteredPasswordChars = password.getPassword();
		            String enteredPassword = new String(enteredPasswordChars);

		            // Check if the username and password are correct
		            boolean loginSuccessful = checkLogin(enteredUsername, enteredPassword);

		            if (loginSuccessful) {
		                // Open Kelola_buu frame if login is successful
		                Kelola_buu kelolaFrame = new Kelola_buu();
		                kelolaFrame.setVisible(true);
		                dispose(); // Close the Login frame
		            } else {
		                JOptionPane.showMessageDialog(null, "Invalid username or password");
		            }
		        } catch (Exception e1) {
		            System.out.println(e1);
		        }
		    }
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addComponent(user, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
								.addComponent(password)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addComponent(lblNewLabel)))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(user, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(password, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	// Method to check if the username and password are correct
	private boolean checkLogin(String enteredUsername, String enteredPassword) {
	    try (
	    		Connection connection = new Connection_DB().connect();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?")) {
	        preparedStatement.setString(1, enteredUsername);
	        preparedStatement.setString(2, enteredPassword);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            return resultSet.next(); // Returns true if there is a matching record
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public boolean loginSuccessful() {
	    try {
	        // Get the entered username and password
	        String enteredUsername = user.getText();
	        char[] enteredPasswordChars = password.getPassword();
	        String enteredPassword = new String(enteredPasswordChars);

	        // Check if the username and password are correct
	        return checkLogin(enteredUsername, enteredPassword);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
