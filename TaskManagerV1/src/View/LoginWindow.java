/**************************************************************
 * Author: Jeremy Loy
 * Date: 10/19/13
 * Project: Software Engineering Term Project Phase 2 Cycle 1
 * File: LoginWindow.java
 ***********************************************************/
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import FileIO.LogInCheck;

/*********************************************************
 * The LoginWindow class creates and displays the window for logging in. It
 * contains two private classes which are ActionListeners. This class will
 * dispose() and open a WorkspaceWindow object when executed successfully.
 * 
 ********************************************************/
public class LoginWindow {

	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 150;

	private JFrame frame;
	private JPanel panel;

	JLabel userNameLabel;
	JTextField userNameTextField;
	JLabel passwordLabel;
	JPasswordField passwordTextField;
	JButton loginButton;
	JButton createButton;

	public LoginWindow() {

		buildWindow();
		buildPanel();
		frame.add(panel);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

	private void buildWindow() {

		frame = new JFrame("Task Manager Login");

		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void buildPanel() {
		panel = new JPanel();

		panel.setLayout(null);

		// Building userNameLabel
		userNameLabel = new JLabel("User Name");
		userNameLabel.setBounds(10, 10, 80, 25);
		panel.add(userNameLabel);

		// Building userNameTextField
		userNameTextField = new JTextField(20);
		userNameTextField.setBounds(100, 10, 160, 25);
		userNameTextField.addActionListener(new LoginButtonListener());
		panel.add(userNameTextField);

		// Building passwordLabel
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		// Building passwordTextField
		passwordTextField = new JPasswordField(20);
		passwordTextField.setBounds(100, 40, 160, 25);
		passwordTextField.addActionListener(new LoginButtonListener());
		panel.add(passwordTextField);

		// Building loginButton
		loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		loginButton.addActionListener(new LoginButtonListener());
		panel.add(loginButton);

		// Building createButton
		createButton = new JButton("Create and Account");
		createButton.setBounds(180, 80, 80, 25);
		createButton.addActionListener(new CreateButtonListener());
		panel.add(createButton);

	}

	private class LoginButtonListener implements ActionListener {

		public LoginButtonListener() {

		}

		public void actionPerformed(ActionEvent arg0) {

			LogInCheck check = new LogInCheck();

			String userName = userNameTextField.getText();
			String password = new String(passwordTextField.getPassword());

			if (check.validateInfo(userName, password)) {
				new WorkspaceWindow(userName);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(frame,
						"Invalid Username or Password");
			}

		}

	}

	private class CreateButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			LogInCheck check = new LogInCheck();

			String userName = userNameTextField.getText();
			String password = new String(passwordTextField.getPassword());

			if (!check.userNameTaken(userName) && userName.length() > 0 && password.length() > 0) {
				check.createAccount(userName, password);
				new WorkspaceWindow(userName);
				frame.dispose();
			} else {
				if(userName.length() <= 0|| password.length() <= 0){
					JOptionPane.showMessageDialog(null, "Please input a username and a password");
				}else
				JOptionPane.showMessageDialog(null, "Username is Taken");
			}

		}
	}

}
