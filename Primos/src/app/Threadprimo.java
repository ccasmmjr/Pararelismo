package app;

 

import java.util.Scanner;

import pacote.Primo;
public class Threadprimo {
    public static void main(String[] args)  {
    
        Scanner scan = new Scanner(System.in);
        Primo primo = new Primo("C:/Users/user_name/Desktop/AtvSistemaDistribuido/Pararelismo/Primos/Entrada01.txt");
      //escreva o diretorio do arquivo como ta no exemplo
        int num_thread=0;
        int escolha=0;
        int conf=0;
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
        
        if(conf==1){
            System.out.println("A seguir exibira os numeros primos \n");

            for (int i = 0;i< num_thread;i++){
            
                Thread thread = new Thread(
                    () -> primo.verificar(),"thread-"+i
                );
                thread.start();
            }
        }
        
    }
}
