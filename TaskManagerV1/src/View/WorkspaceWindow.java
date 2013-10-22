/**************************************************************
 * Author: Jeremy Loy
 * Date: 10/19/13
 * Project: Software Engineering Term Project Phase 2 Cycle 1
 * File: WorkspaceWindow.java
 ***********************************************************/
package View;

import javax.swing.*;

/************************************************************
 * The WorkspaceWindow class currently displays an under construction message.
 * 
 *******************************************************/
public class WorkspaceWindow {

	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 400;

	private JFrame frame;
	private JPanel panel;

	public WorkspaceWindow(String userName) {

		buildWindow();
		buildPanel();
		frame.add(panel);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

	private void buildWindow() {

		frame = new JFrame("Workspace");

		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void buildPanel() {

		panel = new JPanel();
		JTextField construction = new JTextField("Workspaces Coming in V2.0!");
		construction.setEditable(false);
		panel.add(construction);

	}
}
