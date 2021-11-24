package cli;

import logic.dragao;
import logic.heroi;
import logic.objeto;
import logic.jogo;
import logic.tabuleiro;
import java.util.Scanner;

public class dragonsbane {
    public static void main(String[] args) {

        tabuleiro tab = new tabuleiro();
        heroi heroi = new heroi();
        dragao dragao = new dragao();
        objeto chave = new objeto();
        Scanner myObj = new Scanner(System.in);
        char movimento;
        System.out.println("Here be dragons");
        System.out.println("Usa [WASD] para guiar o heroi até à saida sem que o dragão te apanhe!");
        System.out.println(" ");
        jogo dragonsbane = new jogo();

        dragonsbane.pos_inicial(heroi, dragao, chave);
        dragonsbane.atualiza_pos(tab, heroi, dragao, chave);
        print_tab(tab);

        while (true) {
            movimento = myObj.next().charAt(0);
            //movimento heroi e atualizacao/verficaçao do estado
            heroi.move_heroi(movimento, tab, heroi,dragao,chave);
            dragonsbane.atualiza_pos(tab, heroi, dragao, chave);
            dragonsbane.estado(tab,heroi,dragao);

            if(dragonsbane.vitoria) {
                System.out.println("PARABÉNS!!");
                System.out.println("[FIM]");
                break;
            }
            if (!heroi.presente){
                System.out.println("FOSTE COMIDO");
                System.out.println("[TENTA OUTRA VEZ]");
                break;
            }

            //movimento dragao e atualizacao/verficaçao do estado
            dragao.dragao_dir(tab,dragao,heroi);
            dragonsbane.atualiza_pos(tab, heroi, dragao, chave);
            dragonsbane.estado(tab,heroi,dragao);

            if(dragonsbane.vitoria) {
                System.out.println("PARABÉNS!!");
                System.out.println("[FIM]");
                break;
            }
            if (!heroi.presente){
                System.out.println("FOSTE COMIDO");
                System.out.println("[TENTA OUTRA VEZ]");
                break;
            }

            print_tab(tab);
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