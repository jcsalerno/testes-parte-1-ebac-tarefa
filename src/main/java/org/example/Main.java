package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Digite os nomes e sexos separados por vírgula (ex: Maria,F;João,M;Ana,F):");
        String entrada = scanner.nextLine();

        String[] entradas = entrada.split(";");
        for (String item : entradas) {
            String[] dados = item.split(",");
            if (dados.length == 2) {
                String nome = dados[0].trim();
                String sexo = dados[1].trim().toUpperCase();
                pessoas.add(new Pessoa(nome, sexo));
            }
        }

        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .toList();

        System.out.println("Lista de mulheres:");
        mulheres.forEach(System.out::println);

        scanner.close();
    }
}