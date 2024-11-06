package demonios;

public class Main {
    public static void main(String[] args) {
        HiloDemonio h1 = new HiloDemonio("Azazel");
        h1.setDaemon(true);
        HiloDemonio h2 = new HiloDemonio("Behemoth");
        h2.start();
        h1.start();
        try{
            Thread.sleep(5010);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
