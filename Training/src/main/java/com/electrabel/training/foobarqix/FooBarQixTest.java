package com.electrabel.training.foobarqix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

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
 * 
 * DataProvider @UseDataProvider / Parameterized  
 * http://www.wakaleo.com/287-junit-kung-fu-getting-more-out-of-your-unit-tests
 * 
 * http://stackoverflow.com/questions/19203730/writing-java-tests-with-data-providers
 * 
 */
public class FooBarQixTest {

	private FooBarQix fooBarQix = new FooBarQix();

	@Test
	public void should_return_number_if_no_other_rules_apply() {
		assertEquals("1", fooBarQix.getOutput(1));
		assertEquals("2", fooBarQix.getOutput(2));
		assertEquals("4", fooBarQix.getOutput(4));
		assertEquals("8", fooBarQix.getOutput(8));
		
		//https://objectpartners.com/2013/09/18/the-benefits-of-using-assertthat-over-other-assert-methods-in-unit-tests/
		assertThat(fooBarQix.getOutput(8), is(equalTo("8")));
		
	}
	
	@Test
	public void should_contain_foo_if_divisable_by_3() {
		assertTrue(fooBarQix.getOutput(3).contains("Foo"));
		assertTrue(fooBarQix.getOutput(9).contains("Foo"));
	}

	@Test
	public void should_contain_bar_if_divisable_by_5() {
		assertTrue(fooBarQix.getOutput(5).contains("Bar"));
		assertTrue(fooBarQix.getOutput(10).contains("Bar"));
	}
	
	@Test
	public void should_contain_qix_if_divisable_by_7() {
		assertTrue(fooBarQix.getOutput(7).contains("Qix"));
		assertTrue(fooBarQix.getOutput(14).contains("Qix"));
	}
	
	@Test
	public void should_contain_one_foo_per_occurrence_of_3() {
		assertStringOccursAtLeast(1, 3, "Foo");
		assertStringOccursAtLeast(2, 33, "Foo");
	}

	@Test
	public void should_contain_one_bar_per_occurrence_of_5() {
		assertStringOccursAtLeast(1, 5, "Bar");
		assertStringOccursAtLeast(2, 55, "Bar");
		assertStringOccursAtLeast(2, 535, "Bar");
	}

	@Test
	public void should_contain_divisable_before_contains() {
		assertTrue(fooBarQix.getOutput(51).startsWith("Foo"));
		assertTrue(fooBarQix.getOutput(51).endsWith("Bar"));
	}
	
	@Test
	public void should_return_divisable_by_in_order_3_5_7() {
		assertTrue(fooBarQix.getOutput(15).startsWith("FooBar"));
		assertTrue(fooBarQix.getOutput(21).startsWith("FooQix"));
		assertTrue(fooBarQix.getOutput(35).startsWith("BarQix"));
	}
	
	@Test
	public void should_return_correct_order_contains() {
		assertTrue(fooBarQix.getOutput(357).endsWith("FooBarQix"));
		assertTrue(fooBarQix.getOutput(375).endsWith("FooQixBar"));
		assertTrue(fooBarQix.getOutput(537).endsWith("BarFooQix"));
		assertTrue(fooBarQix.getOutput(573).endsWith("BarQixFoo"));
		assertTrue(fooBarQix.getOutput(735).endsWith("QixFooBar"));
		assertTrue(fooBarQix.getOutput(753).endsWith("QixBarFoo"));
	}
	
	
	private void assertStringOccursAtLeast(int expected, int number, String testString) {
		int occurrences = getOccurrencesInString(fooBarQix.getOutput(number), testString);
		assertTrue(occurrences >= expected);
		
		//https://objectpartners.com/2013/09/18/the-benefits-of-using-assertthat-over-other-assert-methods-in-unit-tests/
		/*
		Unable to find Hamcrest greaterThan when using matchers in JUnit
		JUnit only includes some matchers when you use

		import static org.hamcrest.CoreMatchers.*;

		To add the missing ones add the hamcrest jar to your build path and then static import the missing matcher.

		e.g.
		import static org.hamcrest.Matchers.greaterThan;

		While using a wild card on the import would be nice this causes a conflict with the ones embedded in JUnit.
		*/
//		assertThat(occurrences, is(greaterThan(8)));
	}
	
	private int getOccurrencesInString(String output, String testString) {
		Pattern pattern = Pattern.compile(testString);
		Matcher matcher = pattern.matcher(output);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}

	//@Test
	public void printNumbers() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " > " + fooBarQix.getOutput(i));
		}
	}
}
