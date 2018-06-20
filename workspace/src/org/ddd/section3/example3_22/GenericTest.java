package org.ddd.section3.example3_22;



public class GenericTest {
	public static void main(String[] args) {
		Bird bird = new Bird();
		Animal<String> animal = bird;
		animal.set("bird");
}}

