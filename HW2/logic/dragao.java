package logic;

import java.util.Random;

public class dragao extends objeto{
    public int drag_direcao;            //dragao
    public boolean movimento;
    public void dragao_dir(tabuleiro tab, dragao dragao, heroi heroi){
        Random rand = new Random();
        while(true) {
            if (dragao.movimento){
                switch (dragao.drag_direcao) {
                    case 0: // cima
                        if (pos_correta_d(tab, dragao.l - 1, dragao.c)){
                            if(heroi.movimento) {
                                tab.tabuleiro[dragao.l][dragao.c] = ' ';
                                dragao.l--;
                            }
                        }else
                            dragao.movimento=false;
                        break;
                    case 1: // direita
                        if (pos_correta_d(tab, dragao.l, dragao.c + 1)) {
                            if(heroi.movimento) {
                                tab.tabuleiro[dragao.l][dragao.c] = ' ';
                                dragao.c++;
                            }
                        }else
                            dragao.movimento=false;
                        break;
                    case 2: // esquerda
                        if (pos_correta_d(tab, dragao.l, dragao.c - 1)) {
                            if(heroi.movimento) {
                                tab.tabuleiro[dragao.l][dragao.c] = ' ';
                                dragao.c--;
                            }
                        }else
                            dragao.movimento=false;
                        break;
                    case 3: // baixo
                        if (pos_correta_d(tab, dragao.l + 1, dragao.c)) {
                            if(heroi.movimento) {
                                tab.tabuleiro[dragao.l][dragao.c] = ' ';
                                dragao.l++;
                            }
                        }else
                            dragao.movimento=false;
                        break;
                }
                break;
            }else {
                dragao.drag_direcao = rand.nextInt(4);

                switch (dragao.drag_direcao) {
                    case 0: // cima
                        if (pos_correta_d(tab, dragao.l - 1, dragao.c)) { //ainda falta
                            dragao.movimento = true;
                        }
                        break;
                    case 1: // direita
                        if (pos_correta_d(tab, dragao.l, dragao.c + 1)) {
                            dragao.movimento = true;
                        }
                        break;
                    case 2: // esquerda
                        if (pos_correta_d(tab, dragao.l, dragao.c - 1)) {
                            dragao.movimento = true;                        }
                        break;
                    case 3: // baixo
                        if (pos_correta_d(tab, dragao.l + 1, dragao.c)) {
                            dragao.movimento = true;
                        }
                        break;
                }
            }
        }
    }

    private boolean pos_correta_d(tabuleiro tab,int l,int c){
        return tab.tabuleiro[l][c] != 'X' && tab.tabuleiro[l][c] != 'E';
    }
}