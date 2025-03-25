package ut2.ejercicios.ordinaria;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Abuela abu = new Abuela(mesa);
        Nieto[] nietos = new Nieto[5];
        for(int i = 0; i < nietos.length; i++){
            nietos[i] = new Nieto("Nieto_"+i, mesa);
        }
        abu.start();
        for(int i = 0; i < nietos.length; i++){
            nietos[i].start();
        }
    }
}
