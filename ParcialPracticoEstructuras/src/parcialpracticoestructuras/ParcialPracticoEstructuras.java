/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpracticoestructuras;

import java.util.Scanner;
import edu.List;

/**
 *
 * @author User
 */
public class ParcialPracticoEstructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cuantas filas lleva el mapa: ");
        int numero = sc.nextInt();
        List filas = new List();
        System.out.println("Ingrese el mapa: ");
        String perdida = sc.nextLine();
        for (int i = 0; i < numero; i++) {
            filas.add(sc.nextLine());
        }
        Object[] arreglo = filas.toArray();
        List columnas = new List();
        for (int i = 0; i < arreglo.length; i++) {
            String numeros = (String) arreglo[i];
            columnas.add(numeros.split(" "));
        }
        Object[] mapa = columnas.toArray();
        System.out.println("Ingrese el punto de inicio: ");
        String entradaIncio = sc.nextLine();
        System.out.println("Ingrese el punto de fin: ");
        String entradaFin = sc.nextLine();
        int inicioFila = Integer.parseInt(entradaIncio.charAt(1) + "");
        int inicioColumna = Integer.parseInt(entradaIncio.charAt(3) + "");
        int finFila = Integer.parseInt(entradaFin.charAt(1) + "");
        int finColumna = Integer.parseInt(entradaFin.charAt(3) + "");

        String camino = "[" + inicioFila + "," + inicioColumna + "]";
        if (inicioFila - finFila == 0) {
            Object[] fila = (Object[]) mapa[inicioFila];
            if (inicioColumna - finColumna < 0) {
                String siguiente = (String) fila[inicioColumna + 1];
                int columna = inicioColumna + 1;
                while (siguiente.equalsIgnoreCase("e") == false) {
                    if (Integer.parseInt(siguiente) == 0) {
                        camino += "[" + inicioFila + "," + columna + "]";
                        siguiente = (String) fila[++columna];
                    } else {
                        System.out.println("No se puede llegar");
                    }
                }
                camino += "[" + inicioFila + "," + columna + "]";
            } else {
                String siguiente = (String) fila[inicioColumna - 1];
                int columna = inicioColumna - 1;
                while (siguiente.equalsIgnoreCase("e") == false) {
                    if (Integer.parseInt(siguiente) == 0) {
                        camino += "[" + inicioFila + "," + columna + "]";
                        siguiente = (String) fila[--columna];
                    } else {
                        System.out.println("No se puede llegar");
                    }
                }
                camino += "[" + inicioFila + "," + columna + "]";
            }
        } else {
            if (inicioFila - finFila < 0) {
                int fila = inicioFila + 1;
                if (inicioColumna - finColumna == 0) {
                    Object[] colum = (Object[]) mapa[fila];
                    String siguiente = (String) colum[0];
                    while (siguiente.equalsIgnoreCase("e") == false) {
                        if (Integer.parseInt(siguiente) == 0) {
                            camino += "[" + fila + "," + 0 + "]";
                            colum = (Object[]) mapa[++fila];
                            siguiente = (String) colum[0];
                        } else {
                            System.out.println("No se puede llegar");
                        }
                    }
                    camino += "[" + fila + "," + 0 + "]";
                }
            }
        }
        System.out.println("\n" + camino);
    }
}
