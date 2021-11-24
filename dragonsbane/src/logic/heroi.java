package logic;

import static java.lang.StrictMath.abs;

public class heroi extends objeto{
    public boolean armado;              //heroi
    public boolean movimento;          //heroio e dragao


    public void move_heroi(char movimento, tabuleiro tab, heroi obj, dragao dragao, objeto espada) {
        switch (movimento) {
            case 'w':
                if (pos_correta_h(tab, obj, obj.l - 1, obj.c, dragao, espada)) {
                    tab.tabuleiro[obj.l][obj.c] = ' ';
                    obj.l--;
                    obj.movimento = true;
                }
                break;
            case 'a':
                if (pos_correta_h(tab, obj, obj.l, obj.c - 1, dragao, espada)) {
                    tab.tabuleiro[obj.l][obj.c] = ' ';
                    obj.c--;
                    obj.movimento = true;
                }
                break;
            case 's':
                if (pos_correta_h(tab, obj, obj.l + 1, obj.c, dragao, espada)) {
                    tab.tabuleiro[obj.l][obj.c] = ' ';
                    obj.l++;
                    obj.movimento = true;
                }
                break;
            case 'd':
                if (pos_correta_h(tab, obj, obj.l, obj.c + 1, dragao, espada)) {
                    tab.tabuleiro[obj.l][obj.c] = ' ';
                    obj.c++;
                    obj.movimento = true;
                }
                break;
        }
    }

    public boolean pos_correta_h(tabuleiro tab, heroi obj, int l, int c, dragao dragao, objeto espada) {
        if (tab.tabuleiro[l][c] == 'X') {
            obj.movimento = false;
            return false;
        } else if (tab.tabuleiro[l][c] == 'S') {
            tab.tabuleiro[l][c] = ' ';
            obj.armado = true;
            espada.presente = false;
            return true;
        }
        if (tab.tabuleiro[l][c] == 'E' && dragao.presente) {
            obj.movimento = false;
            return false;
        } else
            return true;
    }

    public boolean heroi_morre(heroi heroi, dragao dragao) {
        if (abs(heroi.c - dragao.c) <= 1 && abs(heroi.l - dragao.l) == 0) {
            if (heroi.armado) dragao.presente = false;
            return !heroi.armado;
        } else if (abs(heroi.c - dragao.c) == 0 && abs(heroi.l - dragao.l) <= 1) {
            if (heroi.armado) dragao.presente = false;
            return !heroi.armado;
        } else
            return false;
    }
}