package algoritmodijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {
        
    public static String Read(String Caminho){
        String conteudo = "";
        
        try{
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha;
                    linha = lerArq.readLine();
                }
                arq.close();
            } catch (IOException ex) {
                conteudo = "Erro: Não foi possivel ler o arquivo.";
            }
        } catch (IOException ex) {
            conteudo = "Erro: Arquivo não encontrado";
        }
        if(conteudo.contains("Erro"))
            return "";
        else{
            return conteudo;
        }       
    }    
}