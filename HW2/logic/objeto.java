package logic;

public class objeto {
    public int l;              //linhas
    public int c;              //colunas
    public boolean presente;            //todos
    public boolean movimento;

    public objeto(int l, int c, boolean pres){
        this.l=l;
        this.c=c;
        presente=pres;
        movimento=false;
    }
}