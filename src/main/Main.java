package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelos.Aluno;


public class Main {
	
	public static int inicializar(int qtd) { // Definir quantidade de alunos a serem cadastrados
		int qtdAlunos = qtd;
		System.out.println("Quanto alunos serão cadastrados? (Máximo de 10 alunos)");
				
		if (qtdAlunos > 10) {
			System.out.println("Máximo de 10 alunos!");
		} else if(qtdAlunos <= 0){
			System.out.println("A quantidade deve ser um valor maior que 0!");
		} else {
			System.out.println("Quantidade definida com sucesso!");
			return qtdAlunos;
		}
		
		return -1; // Caso a quantidade de alunos não esteja de acordo com a especificação do programa
	}
	
	public static boolean verificarMedia(Aluno aluno) { // Informa se a média precisa ser recalculada ou não
		if (aluno.getMedia() < 7) {
			// aluno.mediaQuartaNota(nota4);
			return true;
		}
		
		return false;
	}
	
	public static Aluno criarAluno(String nome, double nota1, double nota2, double nota3) {
		if (nota1 < 0 || nota1 > 10) {
			return new Aluno("-1", 0, 0, 0);
		}
		
		if (nota2 < 0 || nota2 > 10) {
			return new Aluno("-1", 0, 0, 0);
		}
		
		if (nota3 < 0 || nota3 > 10) {
			return new Aluno("-1", 0, 0, 0);
		}
		
		Aluno aluno = new Aluno(nome, nota1, nota2, nota3);
		
		return aluno;
	}
	
	public static void main(String[] args) {
		int op = 1;
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno alunoAtual = new Aluno("0", 0, 0, 0);
		
		int qtdAlunos = 0;		
		Scanner leitor = new Scanner(System.in);
		
		while(inicializar(leitor.nextInt()) >= 1) {
			qtdAlunos = leitor.nextInt();
			inicializar(qtdAlunos);
		}
		
		for (int i = 0; i < qtdAlunos; i++) {
			double nota1;
			double nota2;
			double nota3;
			String nome;
				
			Aluno aluno = new Aluno("-1", 0, 0, 0);
				
			while(aluno.getNome().equals("-1")) {
				System.out.println("Digite o nome do aluno: ");
				nome = leitor.next();
				
				System.out.println("\nDigite nota 1: ");
				nota1 = leitor.nextDouble();
				/**while (nota1 < 0 || nota1 > 10) {
					System.out.println("A nota deve estar entre 0 e 10!\n");
					nota1 = leitor.nextDouble();
				}*/
				
				System.out.println("\nDigite nota 2: ");
				nota2 = leitor.nextDouble();
				/*while (nota2 < 0 || nota2 > 10) {
					System.out.println("A nota deve estar entre 0 e 10!\n");
					nota2 = leitor.nextDouble();
				}*/
				
				System.out.println("\nDigite nota 3: ");
				nota3 = leitor.nextDouble();
				/*while (nota3 < 0 || nota3 > 10) {
					System.out.println("A nota deve estar entre 0 e 10!\n");
					nota3 = leitor.nextDouble();
				}*/
				aluno = criarAluno(nome, nota1, nota2, nota3);
			}
			alunos.add(aluno);
			
			if (verificarMedia(aluno)) {
				System.out.println("\nDigite a nota 4: ");
				double nota4 = leitor.nextDouble();
				
				aluno.mediaQuartaNota(nota4);
			}
		}
		
		/* do{
			Scanner leitor = new Scanner(System.in);
			if (qtdAlunos <= 0 || qtdAlunos > 10) {
				System.out.println("Quanto alunos serão cadastrados? (Máximo de 10 alunos)");
				try {
					qtdAlunos = leitor.nextInt();
					
					if (qtdAlunos > 10) {
						System.out.println("Máximo de 10 alunos!");
					} else if(qtdAlunos <= 0){
						System.out.println("A quantidade deve ser um valor maior que 0!");
					} else {
						System.out.println("Quantidade definida com sucesso!");
					}
				} catch (InputMismatchException e) {
					System.out.println("O valor da quantidade de alunos deve ser inteiro!\n");
				}
				
				
			}
			
			if (qtdAlunos > 0 && qtdAlunos <= 10) {
				System.out.println("Selecione uma opção: \n"+
						" 1 - Adicionar aluno\n"+
						" 2 - Selecionar aluno\n"+
						" 3 - Cadastrar quarta nota para o aluno atual\n" +
						" 4 - Exibir dados do aluno atual\n" +
						" 5 - Calcular média do aluno atual\n" +
						" 0 - SAIR");
				try {
					op = leitor.nextInt();
					switch(op){
					case 0:
						System.out.println("Obrigado por utilizar o programa!");
						break;
					case 5:
						if (alunoAtual.getNome().equals("0")) {
							System.out.println("Não há aluno selecionado!\n");
						} else {
							System.out.println("Média do aluno selecionado = " + alunoAtual.calcularMedia());
						}
						break;
					case 4:
						if (alunoAtual.getNome().equals("0")) {
							System.out.println("Não há aluno selecionado!\n");
						} else {
							System.out.println(alunoAtual.toString());
						}
						break;
					case 3:
						if (alunoAtual.getNome().equals("0")) {
							System.out.println("Não há aluno selecionado!\n");
						} else {
							if (alunoAtual.calcularMedia() < 7) {
								System.out.println("Digite a nova nota 4: ");
								double nota4 = leitor.nextDouble();
								while (nota4 < 0 || nota4 > 10) {
									System.out.println("A nota deve estar entre 0 e 10!\n");
									nota4 = leitor.nextDouble();
								}
								alunoAtual.mediaQuartaNota(nota4);
								System.out.println("Nova média do aluno atual = " + alunoAtual.getMedia());
							} else {
								System.out.println("A média do aluno é maior ou igual a 7!\n");
							}
							
						}
						break;	
					case 2:
						if (alunos.size() > 0) {
							String nome;
							
							System.out.println("Digite o nome do aluno: ");
							nome = leitor.next();
							
							for(Aluno aluno : alunos) {
								if(nome.equals(aluno.getNome())) {
									alunoAtual = aluno;
									System.out.println("Aluno " + aluno.getNome() + " selecionado!\n");
									break;
								}
							}
							if (alunoAtual.getNome().equals("0")) {
								System.out.println("Aluno não encontrado!\n");
							}
						} else {
							System.out.println("Não há alunos cadastrados!\n");
						}
						break;		
					case 1:	    
						if (alunos.size() < qtdAlunos) {
							double nota1;
							double nota2;
							double nota3;
							String nome;
							
							System.out.println("Digite o nome do aluno: ");
							nome = leitor.next();
							
							System.out.println("\nDigite nota 1: ");
							nota1 = leitor.nextDouble();
							while (nota1 < 0 || nota1 > 10) {
								System.out.println("A nota deve estar entre 0 e 10!\n");
								nota1 = leitor.nextDouble();
							}
							
							System.out.println("\nDigite nota 2: ");
							nota2 = leitor.nextDouble();
							while (nota2 < 0 || nota2 > 10) {
								System.out.println("A nota deve estar entre 0 e 10!\n");
								nota2 = leitor.nextDouble();
							}
							
							System.out.println("\nDigite nota 3: ");
							nota3 = leitor.nextDouble();
							while (nota3 < 0 || nota3 > 10) {
								System.out.println("A nota deve estar entre 0 e 10!\n");
								nota3 = leitor.nextDouble();
							}
							
							alunos.add(new Aluno(nome, nota1, nota2, nota3));
							
						} else {
							System.out.println("Quantidade máxima de alunos atingida!\n");
						}
						break;
					default:
						System.out.println("Opção inválida!\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("O valor da opção deve ser inteiro!\n");
				}
				
			}
			
		} while(op != 0); */
			
	}

}
