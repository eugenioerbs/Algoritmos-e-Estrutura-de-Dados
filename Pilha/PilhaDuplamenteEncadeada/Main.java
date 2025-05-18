/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilinha = new Pilha();

        System.out.println("Digite uma frase: ");
        String frase = sc.nextLine();

        for (int a = 0; a < frase.length(); a++) {
            char caracterPercorrendo = frase.charAt(a);
            pilinha.push(caracterPercorrendo);
        }

        System.out.println(pilinha.exibirInverso());
        System.out.println(pilinha.verificarPalindromo());

        sc.close();

    }// psvd

}// class
