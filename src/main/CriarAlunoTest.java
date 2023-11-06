package main;

import static org.junit.Assert.*;

import org.junit.Test;

import modelos.Aluno;

public class CriarAlunoTest {

	@Test
	public void test() {
		assertEquals("A", Main.criarAluno("A", 10, 8, 2).getNome());
		assertEquals("B", Main.criarAluno("B", 0, 0, 0).getNome());
		assertEquals("-1", Main.criarAluno("B", -1, 0, 0).getNome());
		assertEquals("-1", Main.criarAluno("B", 0, -1, 0).getNome());
		assertEquals("-1", Main.criarAluno("B", 0, 0, -1).getNome());
		assertEquals("-1", Main.criarAluno("B", -1, -1, -1).getNome());
		assertEquals("-1", Main.criarAluno("X", 10, 11, 10).getNome());
		assertEquals("-1", Main.criarAluno("X", 10, 10, 11).getNome());
		assertEquals("-1", Main.criarAluno("X", 11, 10, 10).getNome());
		assertEquals("-1", Main.criarAluno("X", 11, 11, 11).getNome());
		assertEquals("X", Main.criarAluno("X", 9.9, 9.9, 9.9).getNome());
		assertEquals("C", Main.criarAluno("C", 10, 10, 10).getNome());
	}

}
