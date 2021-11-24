package logic;

import static java.lang.StrictMath.abs;

public class jogo {
    public boolean vitoria;

    public void estado(tabuleiro tab, heroi heroi, dragao dragao) {
        if (heroi.heroi_morre(heroi, dragao)) {
            heroi.presente = false;
        }

        if (tab.tabuleiro[heroi.l][heroi.c] == 'E' && heroi.armado && !dragao.presente) {
            vitoria = true;
        }
    }

    public void pos_inicial(heroi heroi, dragao dragao, objeto espada) {
        heroi.c = 1;
        heroi.l = 1;
        heroi.presente = true;
        heroi.armado = false;
        espada.c = 1;
        espada.l = 8;
        espada.presente = true;
        dragao.c = 1;
        dragao.l = 3;
        dragao.presente = true;
        dragao.movimento = false;
    }

    public void atualiza_pos(tabuleiro tab, heroi heroi, dragao dragao, objeto espada) {
        if (heroi.armado) {
            espada.presente = false;
            tab.tabuleiro[espada.l][espada.c] = ' ';
            tab.tabuleiro[dragao.l][dragao.c] = ' ';
            if (tab.tabuleiro[heroi.l][heroi.c] != 'E')
                tab.tabuleiro[heroi.l][heroi.c] = 'A';
        } else {
            tab.tabuleiro[heroi.l][heroi.c] = 'H';
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