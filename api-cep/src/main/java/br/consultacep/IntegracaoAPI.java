package br.consultacep;

import utilitarios.Util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IntegracaoAPI {

    //Faz a requisição na web com o cep informado
    public static Endereco buscaCep (String cep) throws Exception {
        String enderecoURL = "https://viacep.com.br/ws/" + cep + "/json/";
        URL url = new URL(enderecoURL);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setDoInput(true);

        //bloco try para converter o json recebido em String
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader((conexao.getInputStream()), "utf-8"));

            //convertendo o buff recebido no input de json para string
            String convertJsonString = Util.converteJsonEmString(buff);
            //biblioteca externa para conversao de objetos java para json
            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(convertJsonString, Endereco.class);
            return endereco;

        } catch (Exception msgErro) {
            throw  new Exception("O cep digitado não corresponde a nenhuma busca - status Code [" + conexao.getResponseCode() + "]. " + msgErro.toString());
        }
    }
}
