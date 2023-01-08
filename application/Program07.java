package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Produto;

public class Program07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Produto> List = new ArrayList<>();

		String path = sc.nextLine();
		File file = new File(path);
		
		String folder = file.getParent();

		boolean success = new File(folder + "\\out").mkdir();
		
		String targetFileStr = folder + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			int N = sc.nextInt();
			String itemCsv = br.readLine();

			for (int i = 0; i < N; i++) {
				String produto = sc.next();
				double preco = sc.nextDouble();
				int unidade = sc.nextInt();
				Produto itens = new Produto(produto, preco, unidade);
				List.add(itens);
				
				itemCsv = br.readLine();
			}

			for (Produto x : List) {
				System.out.println(x);
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
				for (Produto line : List) {
					bw.write(line.toString());
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();

	}

}
