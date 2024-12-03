package ut2.ejercicios.productor_consumidor;


// Vamos a utilizar 2 semáforos para hacer uso de un hilo productor y otro consumidor
// Habrá un semáforo con 2 huecos que representará la cantidad de elementos disponibles
// para imprimir en un buffer compartido (consumidor)
// Habrá otro semáforo con 5 huecos que representará la cantidad de elementos que se
// pueden crear, o los espacios del buffer que aun se puede llenar (productor)
// El buffer lo vamos a representar usando una ArrayList de enteros, y cada vez que se
// consuma un elemento de la lista, sacaremos la primera posición de la misma.
// Si no hay nada producido
public class Main {
    public static void main(String[] args) {
        BufferCompartido buffer = new BufferCompartido(5, 2);
        Consumidor [] consumidores = new Consumidor[3];
        Productor [] productores = new Productor[5];
        for(int i = 0; i < productores.length; i++) {
            productores[i] = new Productor(buffer);
        }
        for(int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Consumidor(buffer);
        }
        for(int i = 0; i < productores.length; i++) {
            productores[i].start();
        }
        for(int i = 0; i < consumidores.length; i++) {
            consumidores[i].start();
        }
    }
}
