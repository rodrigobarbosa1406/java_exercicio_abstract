package entities;

public final class PessoaJuridica extends Contribuinte{
	public Integer numeroFuncionarios;
	public static final Double aliquotaFaixa1 = 0.16;
	public static final Double aliquotaFaixaDesc = 0.14;
	public static final Integer numFuncDesc = 10;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public static Double getAliquotafaixa1() {
		return aliquotaFaixa1;
	}

	public static Double getAliquotafaixadesc() {
		return aliquotaFaixaDesc;
	}

	public static Integer getNumfuncdesc() {
		return numFuncDesc;
	}

	@Override
	public final double TotalImposto() {
		double impostoPago = 0.0;
		
		if (numeroFuncionarios > numFuncDesc) {
			impostoPago = getRendaAnual() * aliquotaFaixaDesc;
		} else {
			impostoPago = getRendaAnual() * aliquotaFaixa1;
		}
		
		return impostoPago;
	}
}
