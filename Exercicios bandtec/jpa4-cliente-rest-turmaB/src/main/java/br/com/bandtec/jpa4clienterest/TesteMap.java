package br.com.bandtec.jpa4clienterest;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

import static javax.swing.JOptionPane.*;

public class TesteMap {

    public static void main(String[] args) {
        Map<String, Double> operacoes = new LinkedHashMap<>();
        while (true) {
            String op = showInputDialog("Operação");
            if (op==null) {
                break;
            }
            double valor = Double.valueOf(showInputDialog("Qual valor"));
            operacoes.put(op, valor);
        }
        System.out.println(operacoes);
    }
}
