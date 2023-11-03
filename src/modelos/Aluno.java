package modelos;

public class Aluno {
	private String nome;
	
	private double nota1;
	private double nota2;
	private double nota3;
	
	private double media;
	
	public Aluno(String nome, double nota1, double nota2, double nota3) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.media = (this.nota1 + this.nota2 + this.nota3) / 3;
	}
	
	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public double calcularMedia() {
		this.media = (this.nota1 + this.nota2 + this.nota3) / 3;
		return this.media;
	}
	
	public double getMedia() {
		return this.media;
	}
	
	public double mediaQuartaNota(double nota4) {
		double menorNota = Math.min(Math.min(this.nota1, this.nota2), this.nota3);
		if(nota4 >= menorNota) {
			if (menorNota == nota1) {
				this.nota1 = nota4;
			} else if (menorNota == nota2) {
				this.nota2 = nota4;
			} else {
				this.nota3 = nota4;
			}
		}
		
		this.media = this.calcularMedia();
		return this.media;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + "\nNota 1 = " + this.nota1 + "\nNota 2 = " + this.nota2 + "\nNota 3 = " + this.nota3 + "\nMedia = " + this.media;
	}
}
