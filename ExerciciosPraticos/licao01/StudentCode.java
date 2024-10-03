package ExerciciosPraticos.licao01;

import java.util.ArrayList;
import java.lang.Math;

public class StudentCode {

    /*
    Calcule o valor de PI a partir de uma série infinita PI = 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + ...
    Quanto mais termos dessa serie voce usar, mais preciso sera o resultado.
    Utilize exclusivamente um laço tipo "do while" para calcular o valor de PI ate que um critério de parada seja alcançado.
    O calculo deve terminar quando (i) a quantidade máxima de termos dessa série (parâmetro maxTermos) tiver sido alcançada
       ou então (ii) o valor do ultimo termo calculado tiver sido menor que a "precisão" passada como parâmetro
     */
    public double calculePi(double precisao, int maxTermos) {
        double Pi = 0;
        double termo;
        double denominador = 1;
        int sinal = 1; 
        int quantDeTermos = 0;
        do {
            termo = 4.0 / denominador * sinal; 
            Pi += termo; 
            sinal *= -1; 
            denominador += 2; 
            quantDeTermos++; 
        } while(Pi < precisao || quantDeTermos < maxTermos);
        
        return Pi;
    }
 
    /*
    Um triângulo retângulo pode ter lados cujos comprimentos são todos inteiros.
    O conjunto de três valores inteiros para os comprimentos dos lados de um triângulo retângulo é chamado de triplo de Pitágoras.
    Os comprimentos dos três lados devem satisfazer a relação de que a soma dos quadrados de dois dos lados (catetos) é igual ao quadrado da hipotenusa.
    Escreva um método que retorna a quantidade de triângulos de Pitágoras (triângulos retângulos) diferentes que existem quando todos os lados estão
         entre um valor mínimo e um valor máximo, passados como parâmetros.
    Utilize um loop "for" triplamente aninhado que tenta todas as possibilidades.
    Assuma que triângulos com o mesmo valor de hipotenusa e os mesmos valores de cateto, mas com os catetos trocados, são o mesmo triângulo e
       não devem ser contados duas vezes.
    Por exemplo, o triângulo com cat1=4, cat2=3 e hipotenusa=5 é o mesmo triângulo que cat1=3, cat2=4 e hipotenusa=5  
    */
    public int calculeNumTriangulosPitagoras(int valorMinimo, int valorMaximo) {
        int contador = 0;
        for (int a = valorMinimo; a <= valorMaximo; a++){
            for(int b = a; b <= valorMaximo; b++){
                for(int c = b+1; c <= valorMaximo; c++){
                    if (Math.pow(c,2) == Math.pow(a,2) + Math.pow(b,2)){
                        contador +=1;
                    }
                }
            }
        }
        return contador;
    }

    /*
    Calcule a média aritmética simples de um conjunto de inteiros de qualquer tamanho, passado como parâmetro.
     */
    public double calculeMediaAritmetica(int[] notas) {
        if (notas == null || notas.length == 0){
            return 0.0;
        }
        double media = 0;
        for (int i = 0; i < notas.length; i++){
            media += notas[i];
        }
        media = media/notas.length; 
        return media;
    }

    /*
    No clássico jogo de xadrez, o cavaleiro (knight) só faz movimentos em forma de L (dois espaços em uma direção e um outro em uma direção perpendicular).
    O tabuleiro de xadrez possui 8 espaços na  horizontal e 8 espaços na vertical, que podem ser numerados de 0 a 7 em cada dimensão.
    Escreva um método que receba a posição  do cavaleiro no tabuleiro de xadrez (coordenadas [x,y] de 0 a 7) e 
         retorne uma lista de posições possíveis para onde o cavaleiro pode ir com um único movimento.
    Uma posição contém um par ordenado de inteiros, x e y, que estão encapsulados na classe IntegerPair.    
    */
    public ArrayList<IntegerPair> calculaMovimentoCavaleiro(IntegerPair posicao){
        ArrayList<IntegerPair> movimentos = new ArrayList<>();
        int x = posicao.x;
        int y = posicao.y;
        
        int[][] possibilidades = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        
        for(int[] possibilidade: possibilidades){
            int novox = x + possibilidade[0];
            int novoy = y + possibilidade[1];
            
            if(novox>=0 && novox<=7 && novoy>=0 && novoy<=7){
                movimentos.add(new IntegerPair(novox, novoy));
            }
        }
        return movimentos;
    }
}