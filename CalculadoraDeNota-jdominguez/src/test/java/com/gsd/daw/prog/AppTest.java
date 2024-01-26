package com.gsd.daw.prog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppTest {
	@Test
	public void siempreFunciona() {
		assertTrue(true);
	}

	@Test
	public void matriculaHonor() {
		double nota = 10;
		String test = Utilidades.imprimirNota(nota);
		assertEquals("MH", test);
	}

	@Test
	public void nota9() {
		double nota = 9;
		String test = Utilidades.imprimirNota(nota);
		assertEquals("9,00", test);
	}

	@Test
	public void notaDigitosMayores2() {
		double nota = 9.3234874;
		String test = Utilidades.imprimirNota(nota);
		assertEquals("9,32", test);
	}

	@Test
	public void todo10() {
		String[] args = { "C-10", "P-10", "A-1", "T-1" };
		String test = Calculadora.calculadora(args);
		assertEquals("MH", test);
	}

	@Test
	public void examenMenor3() {
		String[] args = { "C-2.99", "P-10", "A-1", "T-1" };
		String test = Calculadora.calculadora(args);
		assertEquals("0,00", test);
	}

	@Test
	public void practicaMenor4() {
		String[] args = { "C-10", "P-3.99", "A-1", "T-1" };
		String test = Calculadora.calculadora(args);
		assertEquals("0,00", test);
	}
	@Test
	public void argumentosMenores4() {
		String[] args = { "C-10", "P-3.99", "A-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void argumentosMayores20() {
		String[] args = { "C-10", "P-3.99", "A-1","T-1","C-10", "P-3.99","C-10", "P-3.99","C-10", "P-3.99","C-10", "P-3.99","C-10", "P-3.99","C-10", "P-3.99","C-10", "P-3.99","C-10", "P-3.99","C-10",};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void letraEnArgumentos() {
		String[] args = { "C-1a0", "P-3.99", "A-1","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void notaConUnCaracter() {
		String[] args = { "10", "P-3.99", "A-1","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}@Test
	public void notaConLetraDistinta() {
		String[] args = { "B-10", "P-3.99", "A-1","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}@Test
	public void notaConExamenMayor10() {
		String[] args = { "C-11", "P-3.99", "A-1","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}@Test
	public void notaConPracticaMayor10() {
		String[] args = { "P-11", "C-6", "A-1","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}@Test
	public void notaConActitudMayor1() {
		String[] args = { "C-10", "P-3.99", "A-12","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void notaConAsistenciaMayor1() {
		String[] args = { "C-10", "P-3.99", "A-1","T-12"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void notaSinExamen() {
		String[] args = { "P-6","P-4.99", "A-1","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void notaSinPractica() {
		String[] args = { "C-9","C-4.99", "A-1","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void notaSinActitud() {
		String[] args = { "P-8","C-5","P-4.99","T-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void notaSinAsistencia() {
		String[] args = { "C-9","C-5","P-4.99", "A-1"};
		boolean test = Utilidades.robustez(args);
		assertEquals(false, test);
	}
	@Test
	public void errorEnCalculadora() {
		String[] args = { "C-99","C-5","P-4.99", "A-1"};
		String test = Calculadora.calculadora(args);
		assertEquals("", test);
	}@Test
	public void notaMenor4() {
		String[] args = {"C-3","P-5","A-0","T-0"};
		String test = Calculadora.calculadora(args);
		assertEquals("4,00", test);
	}
}
