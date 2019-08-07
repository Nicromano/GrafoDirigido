package Grafo;

import Grafo.ListaConPI;
import Pilas.Pila;

import estructuras.LEGListaConPI;
import java.util.Stack;

public class GrafoD extends Grafo {

    protected int numV, numA;
    protected ListaConPI<Adyacente>[] ElArray;
    protected String camino = "";

    public GrafoD() {

    }

    public GrafoD(int nVertices) {
        numV = nVertices;
        numA = 0;
        ElArray = new ListaConPI[nVertices];
        for (int i = 0; i < numV; i++) {
            ElArray[i] = new LEGListaConPI<Adyacente>();
        }
    }

    @Override
    public int numVertice() {
        return numV;
    }

    @Override
    public int numArista() {
        return numA;
    }

    @Override
    public boolean existeArista(int i, int j) {
        ListaConPI<Adyacente> l = ElArray[i];
        boolean esta = false;
        for (l.inicio(); !l.esFin() && !esta; l.siguiente()) {
            if (l.recuperar().destino == j) {
                esta = true;
            }
        }
        return esta;
    }

    @Override
    public double pesoArista(int i, int j) {

        ListaConPI< Adyacente> l = ElArray[i];

        for (l.inicio(); !l.esFin(); l.siguiente()) {
            if (l.recuperar().destino == j) {
                return l.recuperar().peso;
            }
        }
        return 0.0;
    }

    @Override
    public void insertarArista(int i, int j) {

        if (!existeArista(i, j)) {
            ElArray[i].insertar(new Adyacente(j, 1));
            numA++;
        }
    }

    @Override
    public void insertarArista(int i, int j, double p) {
        if (!existeArista(i, j)) {
            ElArray[i].insertar(new Adyacente(j, p));
            numA++;
        }
    }

    @Override
    public ListaConPI<Adyacente> adyacenteDe(int i) {
        return ElArray[i];
    }

    @Override
    public int[][] matrizAdyacencia() {
        int[][] matriz = new int[numVertice()][numVertice()];

        for (int i = 0; i < numVertice(); i++) {
            for (int j = 0; j < numVertice(); j++) {
                matriz[i][j] = 0;
            }
        }
        for (int i = 0; i < numVertice(); i++) {

            ListaConPI<Adyacente> l = adyacenteDe(i);
            for (l.inicio(); !l.esFin(); l.siguiente()) {

                matriz[i][l.recuperar().destino] = 1;
            }
        }
        return matriz;
    }

    @Override
    public double[][] matrizPesoAdyacencia() {
        double[][] matrizP = new double[numVertice()][numVertice()];

        for (int i = 0; i < numVertice(); i++) {
            for (int j = 0; j < numVertice(); j++) {
                matrizP[i][j] = 999;
            }
        }
        for (int i = 0; i < numVertice(); i++) {

            ListaConPI<Adyacente> x = adyacenteDe(i);
            for (x.inicio(); !x.esFin(); x.siguiente()) {
                matrizP[i][x.recuperar().destino] = x.recuperar().peso;

            }
        }
        return matrizP;
    }

    public boolean esSumidero(int vertice) {

        if (!ElArray[vertice].esVacia()) {
            return false;
        }
        for (int i = 0; i < ElArray.length; i++) {
            if (i == vertice) {
                continue;
            }
            boolean sinks = false;
            for (ElArray[i].inicio(); !ElArray[i].esFin(); ElArray[i].esFin()) {
                if (ElArray[i].recuperar().destino == vertice) {
                    sinks = true;
                    break;
                }
            }
            if (!sinks) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String Caminos(int SALIDA, int DESTINO)  {
        int Nodo, cantidadVecinos;
        Pila Vecinos = new Pila();
        Pila Paquete = new Pila();
        Pila STACK = new Pila();
        Pila AUXPaquete;
        Pila AUXVecinos;
        System.out.println("Se apila en STACK " + SALIDA);
        STACK.apilar(SALIDA);
        while (!STACK.esVacia()) {
            System.out.println("--------STACK no está vacío, tiene en su cima: " + STACK.cima());
            Integer paquete = STACK.desapilar();
            char[] nums = paquete.toString().toCharArray();
            for (char c : nums) {
                Paquete.apilar(Character.getNumericValue(c));
            }
            AUXPaquete = Paquete;
            Nodo = AUXPaquete.desapilar();
            System.out.println("Se crea la pila Paquete con " + paquete + " y el Nodo con: " + Nodo);
            ListaConPI<Adyacente> l = ElArray[Nodo];
            for (l.inicio(); !l.esFin(); l.siguiente()) {
                if (l.recuperar().destino >= 0) {
                    Vecinos.apilar(l.recuperar().destino);
                }
            }
            AUXVecinos = Vecinos;
            String vecinos = "";
            while (!Vecinos.esVacia()) {
                vecinos = vecinos + Vecinos.desapilar();
            }
            System.out.println("Los vecinos de " + Nodo + " son: " + vecinos);
            char[] vec = vecinos.toCharArray();
            for (char c : vec) {
                Vecinos.apilar(Character.getNumericValue(c));
            }
            //Vecinos = AUXVecinos;
            cantidadVecinos = Vecinos.getTamanio();
            for (int i = 0; i < cantidadVecinos; i++) {
                if (Nodo == Vecinos.cima()) {
                    Vecinos.desapilar();
                } else {
                    AUXVecinos.apilar(Vecinos.desapilar());
                }
            }
            Vecinos = AUXVecinos;
            cantidadVecinos = Vecinos.getTamanio();
            System.out.println("La cantidad de vecinos para " + Nodo + " es: " + cantidadVecinos);
            for (int i = 0; i < cantidadVecinos; i++) {
                System.out.println("La cima de AUXVecinos es " + AUXVecinos.cima());
                if (DESTINO != AUXVecinos.cima()) {
                    int cimavecinos = AUXVecinos.desapilar();
                    System.out.println(cimavecinos + " no es lo que se buscaba, por eso pasamos al STACK el " + ((paquete * 10) + cimavecinos));
                    System.out.println("Se despila de vecinos..." + cimavecinos);
                    STACK.apilar((paquete * 10) + cimavecinos);
                    Integer auxstack = STACK.cima();
                    char[] auxs = auxstack.toString().toCharArray();
                    int compare = auxs[auxs.length - 1];
                    for (int k = 0; k < auxs.length - 1; k++) {
                        System.out.println("Comparando " + auxs[k] + " con " + compare);
                        if (auxs[k] == compare) {
                            System.out.println("Se ha comprobado que no se puede retorceder en los caminos por eso se desapila " + (paquete * 10) + cimavecinos);
                            STACK.desapilar();
                        }
                    }
                } else {
                    System.out.println("Se despila de vecinos..." + AUXVecinos.cima());
                    AUXVecinos.desapilar();
                    camino = camino + "    " + paquete + DESTINO;
                    System.out.println("++Nuevo camino: " + camino);
                }
            }
        }
        System.out.println("STACK pasó a estar vació, retornamos que");
        return camino;
    }
}
