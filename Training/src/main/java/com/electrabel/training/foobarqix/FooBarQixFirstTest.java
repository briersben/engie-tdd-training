package com.electrabel.training.foobarqix;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * 04 KATA FooBarQix 
 * Le KATA du jour s’appelle « FooBarQix » et les règles sont les suivantes :
 * 
 * Écrivez un programme qui affiche les nombres de 1 à 100. Un nombre par ligne. Respectez les règles suivantes :
 * Si le nombre est divisible par 3 ou contient 3, écrire “Foo” à la place de 3.
 * Si le nombre est divisible par 5 ou contient 5, écrire “Bar” à la place de 5.
 * Si le nombre est divisible par 7 ou contient 7, écrire “Qix” à la place de 7.
 * Voici un exemple de rendu
 * 1
 * 2
 * FooFoo
 * 4
 * BarBar
 * Foo
 * QixQix
 * 8
 * Foo
 * Bar
 * ...
 * Mise à jour : clarifications sur les règles
 * On regarde les diviseurs avant le contenu (ex: 51 -> FooBar)
 * On regarde le contenu dans l'ordre où il apparait (ex: 53 -> BarFoo)
 * On regarde les multiples dans l'ordre Foo, Bar puis Qix (ex: 21 -> FooQix)
 * 13 contient, 3 donc s'écrit, “Foo”
 * 15 est divisible par 3 et 5 et contient un 5 donc s'écrit “FooBarBar”
 * 33 contient deux fois 3 et est divisible par 3 donc s'écrit “FooFooFoo”
 * 
 * Tips unit testing
 * https://github.com/cheubes/foo-bar-qix-java/blob/master/src/test/java/org/hbs/FooBarQixTest.java
 */
public class FooBarQixFirstTest {

	private FooBarQix fooBarQix = new FooBarQix();
	
	private static final Map<Integer, String> testData = new HashMap<Integer, String>();
	static {
		testData.put(1, "1");
		testData.put(2, "2");
		testData.put(3, "FooFoo");
		testData.put(4, "4");
		testData.put(5, "BarBar");
		testData.put(6, "Foo");
		testData.put(7, "QixQix");
		testData.put(8, "8");
		testData.put(9, "Foo");
		testData.put(10, "Bar");
		// should_return_divisable_before_contains
		testData.put(51, "FooBar");
		// should_return_correct_order_contains
		testData.put(53, "BarFoo");
		// should_return_correct_order_divisable
		testData.put(21, "FooQix");
		// should_return_3_times_foo
		testData.put(33, "FooFooFoo");
		// test_output_for_crazy_case
		testData.put(13762560, "FooBarQixFooQixBar");
	}

	@Test
	public void should_return_expected_result() {
		for (Integer number : testData.keySet()) {
			String expected = testData.get(number);
			Assert.assertEquals(expected, fooBarQix.getOutput(number));
		}
	}

	//@Test
	public void printNumbers() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " > " + fooBarQix.getOutput(i));
		}
	}
}
