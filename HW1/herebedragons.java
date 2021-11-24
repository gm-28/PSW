package psw;

import java.util.Scanner;
import java.util.Random;
import static java.lang.StrictMath.abs;

public class herebedragons {
    public static void main(String[] args){

        tabuleiro tab     = new tabuleiro();
        objeto    heroi   = new objeto();
        objeto    dragao  = new objeto();
        objeto    chave   = new objeto();
        Scanner   myObj   = new Scanner(System.in);
        char movimento;

        System.out.println("Here be dragons");
        System.out.println("Usa [WASD] para guiar o heroi até à saida sem que o dragão te apanhe!");
        System.out.println(" ");

        pos_inicial(heroi,dragao,chave);
        atualiza_pos(tab,heroi,dragao,chave);
        print_tab(tab);

        while(true){
            movimento = myObj.next().charAt(0);
            move_heroi(movimento,tab,heroi);

            if (heroi.movimentos == 2) {
                rand_pos(tab,dragao,heroi);
                heroi.movimentos=0;
            }

            if(heroi_morre(heroi,dragao)){
                print_tab(tab);
                System.out.println("FOSTE COMIDO");
                System.out.println("[TENTA OUTRA VEZ]");
                break;
            }

            if(tab.tabuleiro[heroi.l][heroi.c]=='E' && heroi.chave){
                System.out.println("PARABÉNS!!");
                System.out.println("[FIM]");
                break;
            }
            atualiza_pos(tab,heroi,dragao,chave);
            print_tab(tab);
            System.out.println(" ");
        }
    }

    public static void pos_inicial(objeto heroi,objeto dragao,objeto chave){
        heroi.c = 1;
        heroi.l = 1;
        heroi.movimentos = 0;
        chave.c = 1;
        chave.l = 8;
        dragao.c=1;
        dragao.l=3;
    }

    public  static  void atualiza_pos(tabuleiro tab ,objeto heroi,objeto dragao,objeto chave){
        tab.tabuleiro[heroi.l][heroi.c]='H';
        tab.tabuleiro[dragao.l][dragao.c]='D';

        if(heroi.chave) {
            if (heroi.l == chave.l && heroi.c == chave.c)
                tab.tabuleiro[chave.l][chave.c] = 'H';
            else
                tab.tabuleiro[chave.l][chave.c] = ' ';
        }else
            tab.tabuleiro[chave.l][chave.c] = 'K';

    }

    public static void print_tab(tabuleiro tab){
        for(int i=0;i<tab.tabuleiro.length;i++) {
            for (int j = 0; j < tab.tabuleiro[i].length; j++) {
                System.out.print(tab.tabuleiro[i][j]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }
    }

    public static void move_heroi(char movimento,tabuleiro tab,objeto obj) {
        switch (movimento){
            case 'w':
                if(pos_correta_h(tab,obj,obj.l-1,obj.c)){
                    tab.tabuleiro[obj.l][obj.c]=' ';
                    obj.l--;
                    obj.movimentos++;
                }
                break;
            case 'a':
                if(pos_correta_h(tab,obj,obj.l,obj.c-1)){
                    tab.tabuleiro[obj.l][obj.c]=' ';
                    obj.c--;
                    obj.movimentos++;
                }
                break;
            case 's':
                if(pos_correta_h(tab,obj,obj.l+1,obj.c)){
                    tab.tabuleiro[obj.l][obj.c]=' ';
                    obj.l++;
                    obj.movimentos++;
                }
                break;
            case 'd':
                if(pos_correta_h(tab,obj,obj.l,obj.c+1)){
                    tab.tabuleiro[obj.l][obj.c]=' ';
                    obj.c++;
                    obj.movimentos++;
                }
                break;
        }
    }

    public static boolean pos_correta_h(tabuleiro tab,objeto obj,int l,int c){
        if (tab.tabuleiro[l][c] == 'X'){
            return false;
        }else if (tab.tabuleiro[l][c] == 'K'){
            tab.tabuleiro[l][c]=' ';
            obj.chave=true;
            return true;
        }else if (tab.tabuleiro[l][c] == 'E'){
            if(obj.chave){
                return true;
            }else{
                System.out.println("É necessario a chave!");
                return false;
            }
        }else
            return true;
    }

    public static boolean heroi_morre(objeto heroi, objeto dragao) {
        if(abs(heroi.c - dragao.c) <= 1 && abs(heroi.l - dragao.l)==0){
            return true;
        }else return abs(heroi.c - dragao.c) == 0 && abs(heroi.l - dragao.l) <= 1;
    }

    public static void rand_pos(tabuleiro tab, objeto dragao, objeto heroi){
        Random rand = new Random();
        objeto drag = new objeto();
        while(true) {
            drag.l = rand.nextInt(9);
            drag.c = rand.nextInt(9);
            if(pos_correta_d(tab,drag.l,drag.c) && !heroi_morre(heroi,drag)){
                tab.tabuleiro[dragao.l][dragao.c]=' ';
                dragao.l = drag.l;
                dragao.c = drag.c;
                break;
            }
        }
    }

    public static boolean pos_correta_d(tabuleiro tab,int l,int c){
        return tab.tabuleiro[l][c] != 'X' && tab.tabuleiro[l][c] != 'K' && tab.tabuleiro[l][c] != 'E';
    }
}