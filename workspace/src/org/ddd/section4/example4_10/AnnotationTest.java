package org.ddd.section4.example4_10;

public class AnnotationTest {
	public static void main(String[] args) throws Exception {
		AnnotationProcessor processor = new ExtractProcessor();
		processor.process(Person.class);
	}
}
