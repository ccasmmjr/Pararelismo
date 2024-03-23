package app;

 

import java.util.Scanner;

import pacote.Primo;
public class Threadprimo {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
      //escreva o diretorio do arquivo como ta no exemplo
        int num_thread=0;
        int escolha=0;
        int conf=0;
        long tempoInicial = System.nanoTime();
        System.out.println("Digite 1 ser que 1 thread, 2 se sao 5 e 3 se sao 10\n");
        System.out.println("Digite quaquer outro numero se quiser encerra \n");
        escolha=scan.nextInt();
            switch(escolha){
                case 1 :
                num_thread=1;
                conf=1;
                break;
                case 2 :
                num_thread=5;
                conf=1;
                break;
                case 3 :
                conf=1;
                num_thread=10; 
                break;
                default :                
            }
            Primo primo = new Primo("C:/Users/ccasmmjr/Desktop/AtvSistemaDistribuido/Pararelismo/Primos/Entrada01.txt", tempoInicial);
          
        if(conf==1){
            System.out.println("A seguir exibira os numeros primos \n");
            primo.lerarquivo();
            Thread threads[]= new Thread[num_thread];
            for (int i = 0;i< num_thread;i++){
            
                threads[i]= new Thread(() -> primo.verificar(),"thread-"+i);
                threads[i].start();
                 
            }
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            primo.escrearquivo();
            
        }
      
    }
}
