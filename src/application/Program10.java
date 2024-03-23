package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account2;
import exceptions.BusinessException;

public class Program10 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Informe os dados da conta");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo Inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();
		
		Account2 acc = new Account2(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();
		
		
		try {
			acc.withdraw(amount);
			System.out.printf("Novo saldo : %.2f%n" , acc.getBalance());
		}
		
		catch(BusinessException e) {
			System.out.println(e.getMessage());
			
		}
		sc.close();
	}
	
	
}
