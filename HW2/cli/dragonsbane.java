package cli;

import logic.dragao;
import logic.heroi;
import logic.objeto;
import logic.jogo;
import logic.tabuleiro;

import java.util.ArrayList;
import java.util.Scanner;

public class dragonsbane{
    public static void main(String[] args) {
        tabuleiro tab = new tabuleiro();
        heroi heroi = new heroi(1,1,true);
        dragao dragao = new dragao( 3,1,true);
        //ArrayList<dragao> dragoes;
        objeto espada = new objeto(8,1,true);
        Scanner myObj = new Scanner(System.in);
        char movimento;

        System.out.println("Here be dragons");
        System.out.println("Usa [WASD] para guiar o heroi até à saida sem que os dragões te apanhem!");
        System.out.println(" ");
        System.out.print("Quantos dragões vai usar? ");

//        int n_drag;
//        while(true){
//            System.out.println("Até 3 dragões!");
//            n_drag= myObj.nextInt();
//            if(n_drag<=3)break;
//        }
        //dragoes = new ArrayList<>(n_drag);

        jogo dragonsbane = new jogo(tab, heroi,dragao, espada);


        System.out.println("--------------------");
        print_tab(tab);
        System.out.println("--------------------");

        while (true) {
            movimento = myObj.next().charAt(0);
            dragonsbane.atualizacao(movimento,tab,heroi,dragao,espada);

            if(dragonsbane.vitoria) {
                System.out.println("PARABÉNS!!");
                System.out.println("[FIM]");
                break;
            }
            if (!heroi.presente){
                System.out.println("FOSTE COMIDO");
                System.out.println("[TENTA OUTRA VEZ]");
                System.out.println("--------------------");
                print_tab(tab);
                System.out.println("--------------------");
                break;
            }
            System.out.println("--------------------");
            print_tab(tab);
            System.out.println("--------------------");
            System.out.println(" ");
        }
    }

   private static void print_tab(tabuleiro tab) {
        for (int i = 0; i < tab.tabuleiro.length; i++) {
            for (int j = 0; j < tab.tabuleiro[i].length; j++) {
                System.out.print(tab.tabuleiro[i][j]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }
    }

}