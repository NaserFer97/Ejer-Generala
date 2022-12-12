package org.example;
import java.util.Arrays;
public class Dado {
    private int numeroCaras;

    public Dado(){
        this.numeroCaras=6;
    }
    public Dado (int numeroCaras){
        this.numeroCaras=numeroCaras;

    }
    public int tirarDados(){
        return this.generaNumeroAleatorio(1,numeroCaras);
    }
    public int[] tirarDadosNveces(int n){
        int[] valores= new int[n];
        System.out.println(valores);
        Arrays.sort(valores);


        return valores;
    }

    static public boolean full(int [] array){
        int contador1 = 0 , contador2 =0;
        for(int i = 1 ; i<7 ; i++){
            for(int k =0 ; k<5 ; k++)
                if(array[k] == i)
                    contador1++;

            for(int j = 1 ; j<7 ; j++){
                if(i == j)
                    continue;

                for(int k = 0 ; k<5 ; k++)
                    if(array[k] == j)
                        contador2++;
            }
            if((contador2 == 3 && contador1 ==2) || (contador2 ==2 && contador1 ==3))
                return true;
            contador2 = 0;
            contador1 = 0;
        }

        return false;
    }

    private int generaNumeroAleatorio(int minimo,int maximo){

        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;
    }




    public static void main(String[] args) {

        int valoresIguales=0;
        Dado d = new Dado();
        int [] valores= {0,0,0,0,0,};
        System.out.println("Tirar Dado");

        for (int i=0;i<5; i++){
            valores[i]=d.tirarDados();
            System.out.println(valores[i]);
        }
       /* if(full(valores))
            System.out.println("FULL");*/
        for (int x =0; x<5; x++) {
            for (int j = x; j < 4; j++)
                if (valores[x] == valores[j + 1]) {
                    valoresIguales++;

                }
        }

            if (valoresIguales < 1) {
                System.out.println("No tiene ninguna jugada");
            }
            if (valoresIguales == 5) {
                System.out.println("GENERALAA!");
            }


            if (valoresIguales == 3) {
                System.out.println("Tiene una jugada de TRIO");
            }
            if (valoresIguales == 4) {
                System.out.println("POKER");
            }
            if (valoresIguales == 2) {
                System.out.println("No tiene Nada");
            }
            if (valores[0] == valores[1] - 1 && valores[1] == valores[2] - 1 && valores[2] == valores[3] - 1 && valores[3] == valores[4] - 1) {
                System.out.println("Escalera creciente");//escalera
            }
            if (valores[0] == valores[1] + 1 && valores[1] == valores[2] + 1 && valores[2] == valores[3] + 1 && valores[3] == valores[4] + 1) {
                System.out.println("Escalera decreciente");//escalera
            }
        int [] valoresOrdenados;
            valoresOrdenados = valores.clone();
            Arrays.sort(valoresOrdenados);
        if (((valoresOrdenados[0] == valoresOrdenados[1]) && (valoresOrdenados[2] == valoresOrdenados[3] && valoresOrdenados[3] ==
                valoresOrdenados[4])) || (valoresOrdenados[0] == valoresOrdenados[1] && valoresOrdenados[1] == valoresOrdenados[2]) && valoresOrdenados[3] == valoresOrdenados[4]){
            System.out.println("FULL");

        }

    }

}
