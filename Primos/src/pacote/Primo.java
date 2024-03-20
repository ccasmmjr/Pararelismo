package pacote;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Primo {
    
    private BufferedReader lerarq;
    private FileReader arq;
    public Primo(String arquivo){
        try{
        arq = new FileReader(arquivo);
        lerarq = new BufferedReader(arq);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
          }

    }
    public void verificar() 
     {
        String conteudo="";
     
          String linha="";
          int num=0;
          try{

              linha=lerarq.readLine();
              num=Integer.valueOf(linha);
              while (linha!=null) {
                int i;
                boolean priminho = true;        
                for(i=2;i<num;i++){
                    if(num % i == 0) {
                        priminho = false;
                        break;
                    }
                }
                if(priminho){

                    System.out.println(num);  

                    
                }
                linha=lerarq.readLine();
                num=Integer.valueOf(linha);
              }
              arq.close();
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
