/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public class Inheritance {
    public static void calculateInheritanceMeasurements(ComplexityMeasurements cm) throws IOException, ClassNotFoundException {
		
		BufferedReader buffer = cm.getBr();
		int line_count = 1;
		String statement;
		Map<Integer, String> class_blocks = new HashMap<>();
		Map<Integer, String> parent_class_blocks = new HashMap<>();
		List<String> user_defined_classes = cm.getUser_defined_classes();
		List<String> user_defined_parent_classes = cm.getUser_defined_parent_classes();
		List<String> package_list = cm.getPackages();
		
		while ((statement = buffer.readLine()) != null) {
			
			//getting the imported package names
			if (statement.contains(" ")) {
				String[] parts = statement.split(" ");
				
				if (parts[0].equals(ComplexitySettings.IMPORT)) {
					if (parts[1].contains(".")) {
						String[] package_parts = parts[1].split(Pattern.quote("."));
						int len = package_parts.length;
						String last_part = package_parts[len - 1];
						
						if (last_part.equals("*;")) {
							String[] packages = parts[1].split(Pattern.quote(".*"));
							System.out.println("Package name: " + packages[0]);
							
							//inserting the package name into the list
							if (!package_list.contains(packages[0])) {
								package_list.add(packages[0]);
							}
						}
						
						if (Character.isUpperCase(last_part.charAt(0))) {
							String[] packages = parts[1].split(Pattern.quote("." + last_part.charAt(0)));
							System.out.println("Package name: " + packages[0]);
						}
					}
				}
			}
		
			//checking for user defined classes and parent classes
			if (statement.contains(" ") && !statement.contains("\"")) {
				String[] parts = statement.split(" ");
				int index = 0;
				
				
				for (String part: parts) {
					if (part.equals(ComplexitySettings.CLASS)) {
						String class_name = parts[index + 1];
//						System.out.println("User defined class name: " + class_name);
						
						if (!user_defined_classes.contains(class_name)) {
							user_defined_classes.add(class_name);
							class_blocks.put(line_count, class_name);
						}
						
					}
					
					if (part.equals(ComplexitySettings.EXTENDS) || part.equals(ComplexitySettings.IMPLEMENTS)) {
						String class_name = parts[index + 1];
						System.out.println("Parent class: " + class_name);
						
						user_defined_parent_classes.add(class_name);
						parent_class_blocks.put(line_count, class_name);
					}
					index++;
				}
	
			}
			
			line_count++;
		}
		
		Set<Map.Entry<Integer,String>> set = class_blocks.entrySet();
		
		for (Map.Entry<Integer, String> entries: set) {
			int class_start_point = entries.getKey();
			String class_name = entries.getValue();
//			System.out.println("Key: " + entries.getKey());
//			System.out.println("Value: " + entries.getValue());
			
			int default_inheritance = 2;
			int total_inheritance = 0;
			
		
			int calculated_inheritance = cm.getClassInheritance(class_start_point, class_name, user_defined_classes, parent_class_blocks, package_list);
			total_inheritance = default_inheritance + calculated_inheritance;
			
			
			System.out.println("Inheritance for class " + class_name + ": " + total_inheritance);
		}
		
	}

//end of the 1st method

//calculating the inheritance for a given class----
	
	public int getClassInheritance(int start, String class_name, List<String> user_defined_classes, Map<Integer, String> parent_classes, List<String> package_list) throws ClassNotFoundException {
		
		String parent_class = null;
		String default_package = "java.lang";
		String test_package = "test";
		//get the parent class of the given user defined class
		parent_class = parent_classes.get(start);
		
		boolean isParentUserDefined = user_defined_classes.contains(parent_class);
		System.out.println("Is Parent user defined? " + isParentUserDefined);
		
		//if the parent class is not null and not user defined
		if (parent_class != null && !isParentUserDefined) {
			
			//if the package is java.lang
			if (package_list.size() == 0) {
				
				String qualified_name = default_package + "." + parent_class;
				Class cl = Class.forName(qualified_name);
				
				int cl2 = getNoOfParentClass(cl);
				
				if (cl2 == 0) {
					return 1;
				}

			}
			
			else {
				for (String pk: package_list) {
					String qualified_name = pk + "." + parent_class;
					
					Class cl = Class.forName(qualified_name);
					
					int cl2 = getNoOfParentClass(cl);
					if (cl2 == 0) {
						return 1;
					}

				}
			}	
			
		}
		
		//if the parent class is not null and user defined
		else if (parent_class != null && isParentUserDefined) {
			String qualified_name = test_package + "." + parent_class;
			Class cl = Class.forName(qualified_name);
			
			int cl2 = getNoOfParentClass(cl);
			
			if (cl2 == 0) {
				return 1;
			}
		}
		
		return 0;
	}

//end of the 2nd method

//recursive method to find the number of parent classes for a given class


public int getNoOfParentClass(Class obj) {
		int count= 0;
		
		if (obj != null) {
			Class<?> cl2 = obj.getSuperclass();
			
			if (cl2 != null) {
				return count + getNoOfParentClass(cl2);
			}
			return 0;
		}
		else
			return 0;
	}

//end of the 3rd method
    
}
