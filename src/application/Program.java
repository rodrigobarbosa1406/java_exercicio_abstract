package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<>();
		double totalImpostoPago = 0.0;

		System.out.print("Informe o número de contribuintes: ");
		int n = sc.nextInt();
		
		System.out.println();
		
		for (int i=1; i<=n; i++) {
			System.out.println("CONTRIBUINTE #" + i);
			
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			char tipoPessoa = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Renda Anual: ");
			double rendaAnual = sc.nextDouble();
			
			switch (tipoPessoa) {
			case 'f':
				System.out.print("Gastos com saúde: ");
				double gastosComSaude = sc.nextDouble();
				
				list.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));
				break;
			case 'j':
				System.out.print("Número de funcionários: ");
				int numeroFuncionarios = sc.nextInt();
				
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
				break;
			}
			
			System.out.println();
		}
		
		System.out.println("IMPOSTO PAGO POR CONTRIBUINTE:");
		
		for (Contribuinte contribuinte : list) {
			System.out.printf(contribuinte + "%.2f\n", contribuinte.TotalImposto());
			
			totalImpostoPago += contribuinte.TotalImposto();
		}
		
		System.out.println();
		
		System.out.println("TOTAL IMPOSTO PAGO: $ " + String.format("%.2f", totalImpostoPago));
		
		sc.close();
	}

}
