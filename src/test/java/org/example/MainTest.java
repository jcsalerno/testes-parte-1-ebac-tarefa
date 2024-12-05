package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;

class main{

    @Test
    void testFiltrarMulheres() {
        // Lista de entrada simulada
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Maria", "F"));
        pessoas.add(new Pessoa("João", "M"));
        pessoas.add(new Pessoa("Ana", "F"));
        pessoas.add(new Pessoa("Carlos", "M"));
        pessoas.add(new Pessoa("Mariana", "F"));

        // Filtrar apenas mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .toList();

        // Lista esperada de mulheres
        List<String> nomesEsperados = List.of("Maria", "Ana", "Mariana");

        // Verificar se os nomes correspondem ao esperado
        List<String> nomesFiltrados = mulheres.stream()
                .map(Pessoa::getNome)
                .collect(Collectors.toList());

        assertEquals(nomesEsperados, nomesFiltrados);
    }
}
