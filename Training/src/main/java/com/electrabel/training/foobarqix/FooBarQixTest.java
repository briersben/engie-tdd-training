package com.electrabel.training.foobarqix;

import static org.junit.Assert.*;

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
 */
public class FooBarQixTest {

	@Test
	public void should_return_Foo_if_number_divisable_by_tree() {
		PrintNumber number = new PrintNumber(6);
		Assert.assertEquals("Foo", number.print());
	}

	@Test
	public void should_return_Bar_if_number_divisable_by_five() {
		PrintNumber number = new PrintNumber(10);
		Assert.assertEquals("Bar", number.print());
	}

	@Test
	public void should_return_Qix_if_number_divisable_by_seven() {
		PrintNumber number = new PrintNumber(14);
		Assert.assertEquals("Qix", number.print());
	}

	@Test
	public void should_return_FooFoo_if_number_divisable_by_three_and_contains_three() {
		PrintNumber number = new PrintNumber(3);
		Assert.assertEquals("FooFoo", number.print());
	}

	@Test
	public void should_return_BarBar_if_number_divisable_by_five_and_contains_five() {
		PrintNumber number = new PrintNumber(5);
		Assert.assertEquals("BarBar", number.print());
	}

	@Test
	public void should_return_QixQix_if_number_divisable_by_seven_and_contains_seven() {
		PrintNumber number = new PrintNumber(7);
		Assert.assertEquals("QixQix", number.print());
	}
	
	@Test
	public void printNumbers() {
		for (int i = 1; i <= 10; i++) {
			PrintNumber number = new PrintNumber(i);
			System.out.println(i + " > " + number.print());
		}
	}
}
