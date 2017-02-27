
package com.org.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTest {

	/**
	 * @param args
	 * @throws IOException
	 */

	public void getcount(int[] list) {
		int number = -1;
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			number = list[i];
			count = 0;
			for (int j = i; j < list.length; j++) {
				if (list[j] == number && list[j] != -1) {
					list[j] = -1;
					count++;
				}
			}
			if(number!=-1)
			System.out.println("The Number " + number + " is Repeated " + count + " time(s)");
		}

	}

	public static void main(String[] args) throws IOException {
		/*String finalString = "anudeep,donthu,";
		System.out.println(finalString);
		finalString = finalString.substring(0, finalString.length() - 1);
		System.out.println(finalString);*/

		int[] arraylist = { 13, 11, 11, 2, 1,4,6,7,9,2,2,4,5,6,9,9 };
		new StringTest().getcount(arraylist);

	}

}
