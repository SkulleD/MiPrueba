// Bol8_Ejercicio2 - Álvaro Rodríguez Vila

import java.io.*;
import java.util.*;

public class Bol8_Ejercicio2 implements java.lang.AutoCloseable {
    private static boolean FileWriter(String archivo1) {
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int menu = 6;
        String archivo1 = "archivodeejemplo.txt";
        String sobreescribir = "no";
        String texto;
        File file;

        do {
            try {
                System.out.println("----Elige una opción----");
                System.out.println(
                        "1- Cambiar archivo a gestionar\n2- Crear archivo\n3- Mostrar archivo\n4- Añadir contenido\n5- Borrar archivo\n6- Finalizar programa");
                menu = sc.nextInt();
                sc.nextLine();

                switch (menu) {
                    case 1:
                        System.out.printf("Introduce la ruta del archivo o directorio: ");
                        archivo1 = sc.nextLine();
                        file = new File(archivo1);
                        if (file.exists() == false) {
                            System.out.printf("No existe ningún archivo con la ruta: \"%s\"", file);
                        }
                        break;
                    case 2:
                        try {
                            System.out.printf("Nombre del archivo a crear: ");
                            archivo1 = sc.nextLine();
                            archivo1 = archivo1 + ".txt";

                            PrintWriter f = new PrintWriter(new FileWriter(archivo1), false); // Cómo hago para poder
                                                                                              // preguntar si lo quiere
                                                                                              // sobreescribir antes de
                                                                                              // que se cree el
                                                                                              // archivo??
                            if (FileWriter(archivo1) == false) {
                                // do {
                                System.out.printf(
                                        "Ya existe un archivo con ese nombre, ¿desea sobreescribirlo? (escriba \"sí\" o \"no\".): ");
                                sobreescribir = sc.nextLine();
                                switch (sobreescribir) {
                                    case "sí":
                                        System.out.println("Se ha sobreescrito el archivo.");
                                        break;
                                    case "si":
                                        System.out.println("Se ha sobreescrito el archivo.");
                                        break;
                                    case "no":
                                        System.out.println("No se ha sobreescrito el archivo.");
                                        break;
                                }
                                // } while (!sobreescribir.equals("sí") || !sobreescribir.equals("si")
                                // || !sobreescribir.equals("no"));
                            }
                            f.close();
                        } catch (FileNotFoundException e) {
                            System.err.println("Error de acceso al archivo");
                        } catch (NoSuchElementException e) {
                            System.err.println("Línea no encontrada");
                        }
                        break;
                    case 3:
                        try (Scanner f = new Scanner(new File(archivo1))) {
                            while (f.hasNext()) {
                                texto = f.nextLine();
                                System.out.println(texto);
                            }
                        } catch (Exception e) {
                            System.out.println("Error de acceso a archivo:" + e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            PrintWriter f = new PrintWriter(new FileWriter(archivo1, true));
                            f.println("Texto añadido");
                            f.println("Y otra línea más");
                            f.close();
                        } catch (FileNotFoundException e) {
                            System.err.println("Error de acceso al archivo");
                        }
                        break;
                    case 5:
                        file = new File(archivo1);
                        if ((file.delete())) {
                            System.out.println("Archivo borrado sin problemas");
                        } else {
                            System.out.println("No se pudo eliminar el archivo");
                        }
                        break;
                    case 6:
                        System.out.println("Finalizando el programa...");
                        break;

                    default:
                        System.out.println("Debe ser un número del 1 al 6");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("¡Debe ser un número del 1 al 6!");
            }
        } while (menu != 6);
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub

    }
}