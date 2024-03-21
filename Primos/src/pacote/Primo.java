package pacote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Primo {
    
    private BufferedReader lerarq;
    private FileReader arq;
    private FileWriter Resp;
   // private BufferedWriter Wrresp;
   // private PrintWriter prinWresp;
    private int ordem=0;
    private int qtd_thread=0;
    private int finalizado=0;
    private int incializado=0;
    public Primo(){

    }
    public Primo(String arquivo, int qtd_thread){
        this.qtd_thread=qtd_thread;
try{
        try{
        File file = new File( "C:/Users/user-name/Desktop/AtvSistemaDistribuido/Pararelismo/Primos/Resultado.txt" ); 
        file.delete();
        arq = new FileReader(arquivo);
        lerarq = new BufferedReader(arq);
        Resp = new FileWriter("C:/Users/user-name/Desktop/AtvSistemaDistribuido/Pararelismo/Primos/Resultado.txt",true);
       /* Wrresp = new BufferedWriter(Resp);
        prinWresp= new PrintWriter(Wrresp);*/
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
          }
        } catch(IOException e){
            e.printStackTrace();
          }

    }
    public void verificar() 
     {
        String conteudo="";
        int id;
          String linha="";
          int num=0;
          try{ 
                synchronized(this){
                id=incializado;
                incializado=id+1;  
                linha=lerarq.readLine();
                num=Integer.valueOf(linha);    
                }
                
              while(incializado!=qtd_thread){
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
              }
              while (linha!=null) {
                int i;
                boolean priminho = true;        
                for(i=2;i<num;i++){
                    if(num % i == 0) {
                        priminho = false;
                        break;
                    }
                }
                while(ordem!=id){
                    try{
                        Thread.sleep(10);
                         
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                  }
                synchronized(this){
                // if(priminho){
                        System.out.println(id); 
                        System.out.println(linha);  
                        Resp.write(linha+"\n");
                          
                 //}
                 if(ordem!=qtd_thread-1){
                    ordem++;
                    }else{
                    ordem=0;
                    }
                } 
                linha=lerarq.readLine();
                if(linha!=null){
                    num=Integer.valueOf(linha);
                }
              }

            synchronized(this){
                finalizado++;
            }

              while(finalizado!=qtd_thread){
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
              }
              arq.close();
              Resp.close();

          }catch(IOException e){
            e.printStackTrace();
          }
        
       /*
        synchronized(this){
            int valoratual=contador;
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            contador=valoratual+1;
            System.out.println("contador"+contador+"-"+Thread.currentThread().getName());
        }
        */   
    }
    
    
    
}
