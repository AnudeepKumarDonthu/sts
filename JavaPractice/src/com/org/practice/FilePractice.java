/**
 * 
 */
package com.org.practice;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Anudeep Kumar
 *
 */
public class FilePractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir= new File("C:/Users/Anudeep Kumar/Desktop/Entertainment/Videos/Telugu");
		File dir1= new File("C:/Users/Anudeep Kumar/Desktop/Entertainment/Videos/Telugu/anudeep");
		System.out.println(dir1.list()[0]);
		File dir2= new File("C:/Users/Anudeep Kumar/Desktop/Entertainment/Videos/Telugu/donthu/"+dir1.list()[0]+".txt");
			try {
				dir2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		/*File createFile= new File("C:/Users/Anudeep Kumar/Desktop/Entertainment/Videos/Telugu/anudeep/javafile.csv");
		try {
			createFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createFile.delete();
		System.out.println(createFile.exists());
		System.out.println(dir.getAbsolutePath());
		System.out.println(dir.lastModified());
		System.out.println(dir.isDirectory());
		System.out.println(dir1.exists());
		dir1.mkdir();
		System.out.println(dir1.isDirectory());
		String[] fileNames = dir.list();
		for(String s:fileNames){
			System.out.println(s);
		}*/

	}

}
