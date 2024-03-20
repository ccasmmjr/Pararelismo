package app;

 

import pacote.Primo;
public class Threadprimo {
    public static void main(String[] args)  {
    
        Primo primo = new Primo("local onde esta o seu arquivo txt apra leitura");
     //exemplo C:/Users/seu user/Desktop/AtvSistemaDistribuido/Primos/Entrada01.txt
        for (int i = 0;i< 10;i++){
            
            Thread thread = new Thread(
                () -> primo.verificar(),"thread-"+i
            );
            thread.start();
        }
    }
}
