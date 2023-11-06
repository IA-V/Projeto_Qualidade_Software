package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class InicializarTest {

	@Test
	public void test() {
		assertEquals(-1, Main.inicializar(11));
		assertEquals(5, Main.inicializar(5));
		assertEquals(1, Main.inicializar(1));
		assertEquals(-1, Main.inicializar(0));
		assertEquals(10, Main.inicializar(10));
	}

}
