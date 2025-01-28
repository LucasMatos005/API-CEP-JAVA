package br.consultacep;

import java.util.Scanner;

//Classe para teste
public class Principal {

    public static void main(String[] args) throws Exception {
        System.out.println("Informe seu CEP: ");
        String cep = new Scanner(System.in).nextLine();
        Endereco endereco = IntegracaoAPI.buscaCep(cep);

        System.out.println("CEP Consultado: " + cep);
        System.out.println("Logradouro: " + endereco.getLogradouro());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("Localidade: " + endereco.getLocalidade());
        System.out.println("DDD: " + endereco.getDdd());
        System.out.println("IBGE: " + endereco.getIbge());
        System.out.println("UF: " + endereco.getUf());
    }

}
