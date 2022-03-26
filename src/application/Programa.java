package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Pessoa> pessoaList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int qtd = input.nextInt();

        for(int i = 1; i <= qtd; i ++){
            input.nextLine();
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or Company (i/c)? ");
            char option = input.next().charAt(0);
            input.nextLine();
            System.out.print("Name: ");
            String nome = input.nextLine();

            System.out.print("Anual income: ");
            double ganhoAnual = input.nextDouble();


            if(option == 'i'){

                System.out.print("Health expenditures: ");
                double despesasSaude = input.nextDouble();
                pessoaList.add(new PessoaFisica(nome, ganhoAnual, despesasSaude))   ;

            } else if(option == 'c'){

                System.out.print("Number of employess: ");
                int qtdTrabalhadores = input.nextInt();

                pessoaList.add(new PessoaJuridica(nome, ganhoAnual, qtdTrabalhadores));
            }


        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        for (Pessoa pessoa : pessoaList){
            System.out.println(pessoa.getNome() +": $ " + String.format("%.2f", pessoa.calculaImpostos()) );
        }
    }
}
