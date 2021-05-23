package entities;

public final class PessoaFisica extends Contribuinte {
	public Double gastosComSaude;
	public static final Double aliquotaFaixa1 = 0.15;
	public static final Double limiteGanhoFaixa1 = 20000.0;
	public static final Double aliquotaFaixa2 = 0.25;
	public static final Double abatimentoSaude = 0.50;

	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}
	
	public Double getGastosComSaude() {
		return gastosComSaude;
	}
	
	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}
	
	public static Double getAliquotafaixa1() {
		return aliquotaFaixa1;
	}
	
	public static Double getAliquotafaixa2() {
		return aliquotaFaixa2;
	}
	
	public static Double getAbatimentosaude() {
		return abatimentoSaude;
	}

	@Override
	public final double TotalImposto() {
		double impostoPago = 0.0;
		
		if (getRendaAnual() < limiteGanhoFaixa1) {
			impostoPago = (getRendaAnual() * aliquotaFaixa1) - (gastosComSaude * abatimentoSaude);
		} else if (getRendaAnual() >= limiteGanhoFaixa1) {
			impostoPago = (getRendaAnual() * aliquotaFaixa2) - (gastosComSaude * abatimentoSaude);
		}
		
		return impostoPago;
	}	
}
