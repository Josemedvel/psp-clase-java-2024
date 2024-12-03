package ut2.ejercicios.aeropuerto;

public class Permiso{
    private final String nombrePermiso;
    public Permiso(String nombrePermiso) {
        switch (nombrePermiso.toLowerCase()) {
            case "despegue":
            case "aterrizaje":
                this.nombrePermiso = nombrePermiso;
                break;
            default:
                throw new IllegalArgumentException("El nombre del permiso no es valido");
        }
    }
    public String getNombrePermiso(){
        return nombrePermiso;
    }

    public boolean equals(Permiso other) {
        return this.nombrePermiso.equals(other.getNombrePermiso());
    }
}
