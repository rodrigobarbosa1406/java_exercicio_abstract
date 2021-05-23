package entities;

public abstract class Contribuinte {
	public String nome;
	public Double rendaAnual;
	
	public Contribuinte() {
	}
	
	public Contribuinte(String nome, Double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getRendaAnual() {
		return rendaAnual;
	}
	
	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	public abstract double TotalImposto();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(nome);
		sb.append(": $ ");
		
		return sb.toString();
	}
}
