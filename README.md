Código em java desenvolvido para a atividade complementar da AV1 da disciplina de Sistemas Distribuídos, com o objetivo de criar um programa que utilize threads para verificar números primos em um arquivo.

# Índice
- [Detalhes da Implementação](#detalhes-da-implementação)
- [Requisitos](#requisitos)
- [Como Utilizar](#como-utilizar)
- [Diferenca entre a utilização de 1, 5 e 10 threads](#diferenca-entre-a-utilização-de-1-5-e-10-threads)
- [Conclusão](#conclusão)

# Detalhes da Implementação
O código foi dividido em dois pacotes: o pacote "app", que contém a classe principal chamada "ThreadPrimo", e o pacote "pacote", que possui a classe "Primo".

## Threadprimo.java

Esta classe é a classe principal do projeto. Ela controla a execução do programa e permite que o usuário selecione o número de threads a serem utilizadas para realizar a verificação dos números primos.

## Primo.java

Esta classe é responsável por ler o arquivo de entrada, contendo números a serem verificados e identicar quais são números primos. E aqui onde é implementado a lógica para à verificação de números primos e também utiliza sincronização para garantir execução correta em múltiplas threads.

# Requisitos

- Java JDK instalado na sua máquina.

# Como utilizar

1. 
    ```
    Dentro da classe "Treadprimo" no pacote "app", deve-se localizar a linha de comando abaixo e substituir o endereço ".txt" do arquivo de entrada onde está o conjunto de teste pelo endereço que sua maquina está utilizando:
    ```
    ![Local para inserir o diretório do arquivo de entrada](https://github.com/ccasmmjr/Pararelismo/blob/main/Diretorio%20Entrada.jpeg)

2. 
    ```
    Dentro da classe "Primo" no pacote "pacote", deve-se se identificar as linhas de comando abaixo e substituir os endereços ".txt" para aonde se deve gravar os resultados da analise:
    ```
    ![Local para inserir o diretório do arquivo de saída.](https://github.com/ccasmmjr/Pararelismo/blob/main/Diretorio%20saida.jpeg)

3. 
    ```
    O arquivo txt deve ter um formato semelhante, exemplo abaixo, ao "Entrada01":
    ```
    ![Exemplo de Entrada aceitável](<Exemplo de Entrada aceitável.png>)


# Diferenca entre a utilização de 1, 5 e 10 threads
![Gráfico de comparação](https://github.com/ccasmmjr/Pararelismo/blob/main/Grafico.jpeg)

# Conclusão

Ao observar o gráfico que compara o desempenho do processo com diferentes quantidades de threads, nota-se que o ponto em que o processo ocorreu de forma mais rápida foi ao utilizar 5 threads. Curiosamente, o tempo de processamento para 1 e 10 threads foi semelhante, sendo ligeiramente mais rápido ao utilizar 10 threads.

Esses resultados indicam que a utilização de múltiplas threads para processamento paralelo pode reduzir significativamente o tempo total necessário para concluir o processo. No entanto, é importante ressaltar que o uso de 5 threads resultou em um tempo total consideravelmente menor em comparação com 10 threads.

Essa discrepância pode ser atribuída a diversas características das threads, destacando-se os seguintes fatores:

1. Concorrência:
    ```
    Devido à intensidade do uso da CPU pelo processo, reduzir o número total de threads permite que o processador distribua mais eficientemente a carga de trabalho entre seus núcleos, evitando a criação de gargalos de processamento.
    ```

2. Overhead:
    ```
    A criação e o gerenciamento de threads possuem um custo de overhead. Um grande número de threads em execução simultânea pode resultar em uma troca constante de contexto e sobrecarga de gerenciamento, afetando negativamente o desempenho.
    ```
3. Escalabilidade:
    ```
    Embora teoricamente um aumento linear no número de threads deva resultar em um aumento proporcional na velocidade de processamento final, as limitações de software e hardware podem impedir esse cenário ideal. Portanto, é essencial encontrar um equilíbrio entre o número de threads e o overhead para garantir o processamento mais rápido possível.
    ```

Essas considerações destacam a importância de uma análise cuidadosa e otimização do número de threads em cenários de processamento paralelo, visando maximizar a eficiência e o desempenho do sistema.

