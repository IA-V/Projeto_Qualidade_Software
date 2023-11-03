package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		int qtdAlunos = 22;
		assertEquals(qtdAlunos, Main.inicializar(qtdAlunos));
	}

}
