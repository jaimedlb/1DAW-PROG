package com.gsd.daw.prog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder( MethodOrderer.DisplayName.class )
public class AppTest 
{
    @Test
    public void siempreFunciona()
    {
        assertTrue( true );
    }
    @Test
    public void MatriculaHonor() {
    	double nota=10;
    	String test = Utilidades.imprimirNota(nota);
    	assertEquals("MH", test);
    }
    @Test
    public void Nota9() {
    	double nota=9;
    	String test = Utilidades.imprimirNota(nota);
    	assertEquals("9,00", test);
    } @Test
    public void NotaDigitosMayores2() {
    	double nota=9.3234874;
    	String test = Utilidades.imprimirNota(nota);
    	assertEquals("9,32", test);
    } @Test
    public void todo10() {
    	String[] args= {"C-10","P-10","A-1","T-1"};
    	String test= Calculadora.calculadora(args);
    	assertEquals("MH", test);
    }
    public void examenMenor3() {
    	String[] args= {"C-2.99","P-10","A-1","T-1"};
    	String test= Calculadora.calculadora(args);
    	assertEquals("0", test);
    }
    public void practicaMenor4() {
    	String[] args= {"C-10","P-3.99","A-1","T-1"};
    	String test= Calculadora.calculadora(args);
    	assertEquals("MH", test);
    }
}
