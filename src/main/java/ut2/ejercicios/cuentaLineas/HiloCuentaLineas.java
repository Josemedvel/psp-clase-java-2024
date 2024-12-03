package ut2.ejercicios.cuentaLineas;

import java.io.*;

public class HiloCuentaLineas extends Thread {
    private final String path;

    public HiloCuentaLineas(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        String resultado = path + ":\t";
        File archivo = new File(path);
        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            long lineas = bf.lines().count(); // Contamos las líneas del archivo
            resultado += lineas + " líneas";
        } catch (FileNotFoundException notFound) {
            resultado += "Archivo no encontrado: " + notFound.getMessage();
        } catch (IOException ioex) {
            resultado += "Error de lectura: " + ioex.getMessage();
        }
        System.out.println(resultado);
    }
}
