package pacote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Primo {
    
    private BufferedReader lerarq;
    private FileReader arq;
    private FileWriter Resp;
    private ArrayList<String> Lerlista = new ArrayList();
    private ArrayList<String> Esclista = new ArrayList();
    private int cont_Lista_tam = 0 ;
    private long inicio=0;
    public Primo(String arquivo, long inicio){
         this.inicio=inicio;
    try{
        try{
            //coloque o diretororio onde deseja que os resultados aparecam
        File file = new File( "C:/Users/ccasmmjr/Desktop/AtvSistemaDistribuido/Pararelismo/Primos/Resultado.txt" ); 
        file.delete();
        arq = new FileReader(arquivo);
        lerarq = new BufferedReader(arq);
        Resp = new FileWriter("C:/Users/ccasmmjr/Desktop/AtvSistemaDistribuido/Pararelismo/Primos/Resultado.txt",true);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
          }
        } catch(IOException e){
            e.printStackTrace();
          }

    }

    public void lerarquivo(){
        try{
        String linha="";
        while(linha!=null){
            linha=lerarq.readLine();
            Lerlista.add(linha);
        }
        arq.close();
    }catch(IOException e){
        e.printStackTrace();
      }
      
    }


    public void escrearquivo(){
        try{
        String linhas="";
        int x;
        for(x=0;x<Esclista.size();x++){
            linhas=Esclista.get(x);
            Resp.write(linhas+"\n"); 
        } 
        Resp.close();
    }catch(IOException e){
        e.printStackTrace();
      }
      
    }


    public void verificar() 
     {
         
            while (Lerlista.get(cont_Lista_tam)!=null) {
            synchronized(this){
                    int i;
                    int num=0;
                    if(Lerlista.get(cont_Lista_tam)!=null){
                        num=Integer.valueOf(Lerlista.get(cont_Lista_tam));
                        boolean priminho = true;
                        if(num <= 1){
                            priminho = false;
                        }
                        if(num == 2){
                            priminho = true;
                        }
                        if(priminho){
    
                            for(i=2;i*i<=num;i++){
                                
                                if(num % i == 0) {
                                    priminho = false;
                                    break;
                                }
                               
                            }
                        }
                         if(priminho){
                            long fim = System.nanoTime();
                            double  time= (fim-inicio)/1000;
                            //microsegundos
                            String resultados=String.valueOf(num)+" "+String.valueOf(time);
                                Esclista.add(String.valueOf(resultados));
                                System.out.println(Thread.currentThread().getName()
                                +" "+resultados);  
                         }
                         cont_Lista_tam++;
                    }
                   
                }
                
              }

            
    }
    
    
    
}
