package com.viettel.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


import com.viettel.core.dto.AdminUser;

public class ManageFile {
	public static void WriteFile(List<AdminUser> list) {
		boolean isError = false;
		try {
			FileOutputStream fos = new FileOutputStream("d://test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			isError = false;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			isError = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isError = true;
		}

		if (isError) {
			System.out.println("Fail");
		} else {
			System.out.println("Success");
		}
	}

	public static void ReadFile() {
		File f = new File("d://test.txt");
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			// ois.readObject();
			// ois.close();

			ArrayList<AdminUser> deserializeAdmnUser = (ArrayList<AdminUser>) ois.readObject();
			System.out.println(deserializeAdmnUser);
			ois.close();

			for (AdminUser user : deserializeAdmnUser) {
				System.out.println("UserID: " + user.getUserID() + ", " + "DepID: " + user.getDepID() + ", "
						+ "LoginName: " + user.getLoginName());

			}
			System.out.println("Sucess");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}