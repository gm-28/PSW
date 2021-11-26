package logic;

import static java.lang.StrictMath.abs;

public class jogo {
    public boolean vitoria;

    public jogo(tabuleiro tab, heroi heroi, dragao dragao,objeto espada){
        this.vitoria=false;
        atualiza_pos(tab, heroi, dragao, espada);
    }

    public void atualizacao(char movimento,tabuleiro tab, heroi heroi, dragao dragao,objeto espada){
        //movimento heroi e atualizacao/verficaçao do estado
        heroi.move_heroi(movimento, tab, heroi,dragao,espada);
        atualiza_pos(tab, heroi, dragao, espada);
        estado(tab,heroi,dragao);

        //movimento dragao e atualizacao/verficaçao do estado
        dragao.dragao_dir(tab,dragao,heroi);
        atualiza_pos(tab, heroi, dragao, espada);
        estado(tab,heroi,dragao);
    }

    private void estado(tabuleiro tab, heroi heroi, dragao dragao) {
        if (heroi.heroi_morre(heroi, dragao)) {
            heroi.presente = false;
        }

        if (tab.tabuleiro[heroi.l][heroi.c] == 'E' && heroi.armado && !dragao.presente) {
            vitoria = true;
        }
    }


    private void atualiza_pos(tabuleiro tab, heroi heroi, dragao dragao, objeto espada) {
        if(heroi.presente) {
            if (heroi.armado){
                espada.presente = false;
                tab.tabuleiro[espada.l][espada.c] = ' ';
                tab.tabuleiro[dragao.l][dragao.c] = ' ';
                if (tab.tabuleiro[heroi.l][heroi.c] != 'E')
                    tab.tabuleiro[heroi.l][heroi.c] = 'A';
            }else{
                tab.tabuleiro[heroi.l][heroi.c] = 'H';
            }
        }else{
            tab.tabuleiro[heroi.l][heroi.c] = ' ';
        }

        if (dragao.presente) {
            tab.tabuleiro[dragao.l][dragao.c] = 'D';
        }

        if (espada.presente) {
            tab.tabuleiro[espada.l][espada.c] = 'S';
            if (tab.tabuleiro[dragao.l][dragao.c] == 'S')
                tab.tabuleiro[dragao.l][dragao.c] = 'F';
        }
    }
}