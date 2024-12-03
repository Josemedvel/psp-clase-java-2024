package ut2.ejercicios.cuentaLineas;

//Haz un programa que reciba por parámetros una serie de rutas a
//archivos, de forma que se cree un hilo por cada uno y se calcule
// el número de filas de cada uno.
// Cada hilo debe imprimir el número de líneas de cada archivo, o
// si ha habido algún problema con la ruta, imprimir el error.
public class Main {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("No hay ningún archivo listado!");
            return;
        }
        for(String archivo: args){
            new HiloCuentaLineas(archivo).start();
        }
    }
}
