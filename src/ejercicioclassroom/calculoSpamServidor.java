package ejercicioclassroom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class calculoSpamServidor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name: ");

        String nombreArchivo = sc.nextLine();


        double suma = 0;
        int cantidad = 0;

        String remitente = "";

        // esto se crea para que los archivos se pueden ubicar facilmente en el paquete
        String carpeta = "src/ejercicioclassroom/";

        String rutaEntrada = carpeta + nombreArchivo;
        String salidaArchivoSpam = carpeta + "spam_remitente.txt";

        try {
            // lector
            FileReader fr = new FileReader(rutaEntrada);
            BufferedReader buffer = new BufferedReader(fr);

            // escritor
            FileWriter fw = new FileWriter(salidaArchivoSpam);
            PrintWriter salida = new PrintWriter(fw);


            String linea;
            while ((linea = buffer.readLine()) != null) {

                if (linea.indexOf("From:") == 0) {
                    remitente = linea.substring(6).trim();
                }

                if (linea.indexOf("X-DSPAM-Confidence:") == 0) {

                    String valorTexto = linea.substring(19).trim();
                    double valor = Double.parseDouble(valorTexto);

                    suma = suma + valor;
                    cantidad = cantidad + 1;

                        // se visualiza el correo y su X-DSPAM-Confidence
                    if (valor > 0.7) {
                        salida.println(remitente + " " + valor);
                    }
                }


            }

            // cierro lo que abrimos
            buffer.close();
            salida.close();
            sc.close();


            if (cantidad > 0) {
                double promedio = suma / cantidad;
                System.out.println("spam confidence: " + promedio);
            } else {
                System.out.println("No se encontraron valores ");
            }

        } catch (IOException e) {
            System.out.println("Error con el archivo: " + e.getMessage());
        }
    }
}