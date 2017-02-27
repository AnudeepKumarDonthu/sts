/**
 * 
 */
package com.org.practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anudeep Kumar
 *
 */
public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=0;i<=10;){
			System.out.println(i);
			if(i<=10){
				int j=10;
				i++;
				System.out.println(i+" "+j);
			}
		}
		

	}
}
