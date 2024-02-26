package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.ImportedProduct;
import entities.Product2;
import entities.UsedProduct;

public class Program6 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product2> list =  new ArrayList<>();
		
		System.out.println("Enter the number of products: ");

		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (ch == 'c') {
				list.add(new Product2(name, price));
			}
			else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			}
			else {
				System.out.print("Customs fee: ");	
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product2 prd : list) {
			System.out.println(prd.priceTag());
		}
		sc.close();
		
		}

	}

