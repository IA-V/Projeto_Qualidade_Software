package main;

import static org.junit.Assert.*;

import org.junit.Test;

import modelos.Aluno;

public class VerificarMediaTest {

	@Test
	public void test() {
		assertEquals(true, Main.verificarMedia(new Aluno("A", 10, 8, 2)));
		assertEquals(false, Main.verificarMedia(new Aluno("A", 7, 7, 7)));
		assertEquals(true, Main.verificarMedia(new Aluno("A", 7, 6, 7)));
		assertEquals(true, Main.verificarMedia(new Aluno("A", 6.9, 6.9, 6.9)));
		assertEquals(false, Main.verificarMedia(new Aluno("A", 10, 10, 10)));
	}

}
