/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author HP
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComplexitySettings {
	public static final List<String> JAVA_KEYWORDS = new ArrayList<>(
				Arrays.asList(
							"abstract","assert","boolean","break ","byte",
							"case","catch","char","const","continue",
							"default","do","double","enum",
							"extends","final","finally","float","for",
							"goto","if","implements","instanceof",
							"int","interface","long","native","new",
							"private","protected","short",
							"strictfp","super","switch","synchronized",
							"this","throw","throws","transient","void",
							"volatile","while","true","false","null"
						)
			);
	
	public static final List<String> RETURN_TYPES = new ArrayList<>(
			Arrays.asList(
					"boolean","byte","double","float","int","long","short", "void"
					)
			);
	
	public static final List<String> PRIMITIVE_TYPES = new ArrayList<>(
			Arrays.asList(
					"boolean","byte","double","float","int","long","short"
					)
			);
	
	public static final List<String> METHOD_DEFINITIONS = new ArrayList<>(
			Arrays.asList(
					"public", "static"
					)
			);
	
	public static final List<String> ARITHMETIC_OPERATORS = new ArrayList<>(
			Arrays.asList(
					"+","-","*","/","%","++","--"
					)
			);
	
	public static final List<String> RELATION_OPERATORS = new ArrayList<>(
			Arrays.asList(
					"==","!=",">","<",">=","<="
					)
			);
	
	public static final List<String> LOGICAL_OPERATORS = new ArrayList<>(
			Arrays.asList(
					"&&","||","!"
					)
			);
	
	public static final List<String> CONDITIONAL_LOGICAL_OPERATORS = new ArrayList<>(
			Arrays.asList(
					"&&","||"
					)
			);
	
	public static final List<String> BITWISE_OPERATORS = new ArrayList<>(
			Arrays.asList(
					"|","^","~","<<",">>",">>>","<<<"
					)
			);
	
	public static final List<String> MISCELLANEOUS_OPERATORS = new ArrayList<>(
			Arrays.asList(
					",","->",".","::"
					)
			);
	
	public static final List<String> ASSIGNMENT_OPERATORS = new ArrayList<>(
			Arrays.asList(
					"+=","-=","*=","/=","=",">>>=","|=","&=","%=","<<=",">>=","^="
					)
			);
	
	public static final List<String> MANIPULATORS = new ArrayList<>(
			Arrays.asList(
					"\n","\t","\b","\r","\f","\'","\"","\\"
					)
			);
	
	public static final String DOT = ".";
	public static final String PUBLIC = "public";
	public static final String STATIC = "static";
	public static final String CLASS = "class";
	public static final String EXTENDS = "extends";
	public static final String IMPLEMENTS = "implements";
	public static final String IMPORT = "import";
	public static final String FOR = "for";
	public static final String IF = "if";
	public static final String WHILE = "while";
	public static final String DO = "do";
	public static final String RETURN = "return";

	public ComplexitySettings(List<String> keywords) {
		super();
	}
	
		
				
				
				
				
				
				
				
				
				
				
				
			 	 
	
	
	
}


