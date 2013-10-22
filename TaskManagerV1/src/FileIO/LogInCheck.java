/**************************************************************
 * Author: Jeremy Loy
 * Date: 10/19/13
 * Project: Software Engineering Term Project Phase 2 Cycle 1
 * File: FileIO.java
 ***********************************************************/
package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/********************************************************
 * The LogInCheck class creates LoginInfo.txt in the UserDocumentation folder if
 * not found. It also creates the UserDocumentation folder if it is not in the
 * same directory as the executable.
 * 
 * This class performs all IO functions related to logging in as well as
 * creating an account.
 * 
 ******************************************************/
public class LogInCheck {

	Scanner reader;
	File loginInfo;

	public LogInCheck() {

		loginInfo = new File("UserDocumentation" + File.separator
				+ "LoginInfo.txt");
		try {
			loginInfo.getParentFile().mkdir();
			loginInfo.createNewFile();
		} catch (IOException e1) {
			// Do Nothing
		}
		try {
			reader = new Scanner(loginInfo);
		} catch (FileNotFoundException e) {
			// Do nothing
		}

	}

	public boolean validateInfo(String userName, String password) {
		boolean goodVal = false;

		while (reader.hasNext()) {
			if (reader.nextLine().equals(userName + " " + password)) {
				goodVal = true;
				break;
			}
		}

		reader.close();
		return goodVal;
	}

	public boolean userNameTaken(String userName) {
		boolean goodVal = false;

		String[] temp;
		while (reader.hasNext()) {
			temp = reader.next().split(" ");
			if (temp[0].equals(userName)) {
				goodVal = true;
			}
		}

		reader.close();
		return goodVal;

	}

	public void createAccount(String userName, String password) {

		try {
			FileWriter writer = new FileWriter(loginInfo, true);
			writer.write("\n" + userName + " " + password);
			writer.close();
		} catch (IOException e) {
			// Do nothing
		}
	}

}
