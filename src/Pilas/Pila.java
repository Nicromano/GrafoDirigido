/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilas;

/**
 *
 * @author nicromano
 */
public class Pila {

    private Nodo cima;
    private int tam;

    public Pila() {

        cima = null;
        tam = 0;
    }

    public void apilar(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (!esVacia()) {
            nuevo.setSig(cima);
        }
        cima = nuevo;
        tam++;
    }

    public int desapilar() {

        int devolver = -1;
        if (!esVacia()) {
            devolver = cima.getDato();

            tam--;
            cima = cima.getSig();
            return devolver;
        }
        return devolver;

    }

    public int cima() {
        return cima.getDato();

    }

    public boolean esVacia() {
        return cima == null;
    }

    public int getTamanio() {
        return tam;
    }

}
