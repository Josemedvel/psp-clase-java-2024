package ut2.ejercicios.aeropuerto;

import java.util.ArrayList;
import java.util.Random;

public class Aeropuerto {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Permiso despegue = new Permiso("despegue");
        Permiso aterrizaje = new Permiso("aterrizaje");
        ArrayList<Permiso> permisoDespegue = new ArrayList<>();
        permisoDespegue.add(despegue);
        ArrayList<Permiso> permisoAterrizaje = new ArrayList<>();
        permisoAterrizaje.add(aterrizaje);
        ArrayList<Permiso> permisoDespegueAterrizaje = new ArrayList<>();
        permisoDespegueAterrizaje.add(despegue);
        permisoDespegueAterrizaje.add(aterrizaje);

        Pista [] pistasDespegue = new Pista[2];
        Pista [] pistasAterrizaje = new Pista[2];

        for(int i = 0; i < pistasDespegue.length; i++){
            pistasDespegue[i] = new Pista("Pista_desp_"+i, rand.nextInt(1,3) ,permisoDespegue);
        }
        for(int i = 0; i < pistasAterrizaje.length; i++){
            pistasAterrizaje[i] = new Pista("Pista_aterr_"+i, rand.nextInt(1,3) ,permisoAterrizaje);
        }

        Avion[] quierenDespegar = new Avion[10];
        for(int i = 0; i < quierenDespegar.length; i++) {
            quierenDespegar[i] = new Avion("Avion_desp_" + i, despegue, pistasDespegue);
            quierenDespegar[i].start();
        }

        Avion[] quierenAterrizaje = new Avion[10];
        for(int i = 0; i < quierenAterrizaje.length; i++) {
            quierenAterrizaje[i] = new Avion("Avion_aterr_" + i, aterrizaje, pistasAterrizaje);
            quierenAterrizaje[i].start();
        }
    }
}
