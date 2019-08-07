package Nodo;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Lab
 */
public class listadobleenlazada<E> {

    private Nodo<E> cabeza, ultimo;
    private int tamaño;

    public listadobleenlazada() {
        this.cabeza = null;
        this.tamaño = 0;
        this.ultimo = null;
    }

    public Nodo<E> añadir(E dato) {

        Nodo<E> nodo = new Nodo<E>(dato);

        if (tamaño == 0) {
            cabeza = nodo;
        } else {
            ultimo.setSig(nodo);
            nodo.setAnt(ultimo);
        }
        ultimo = nodo;
        tamaño++;
        return nodo;
    }

    public Nodo<E> añadirPrimero(E dato) {
        Nodo<E> nodo = new Nodo<>(dato);

        if (tamaño > 0) {
            cabeza.setAnt(nodo);
        }
        nodo.setSig(cabeza);
        cabeza = nodo;
        tamaño++;
        return nodo;
    }

    public void borrar(Nodo<E> nodo) {
        if (cabeza == nodo) {
            if (tamaño == 1) {
                cabeza = ultimo = null;
            } else {
                nodo.getSig().setAnt(null);
                cabeza = nodo.getSig();
            }

        } else if (ultimo == nodo) {
            nodo.getAnt().setSig(null);
            ultimo = nodo.getAnt();
        } else {
            nodo.getAnt().setSig(nodo.getSig());
            nodo.getSig().setAnt(nodo.getAnt());
        }
        nodo.Destructor();
        tamaño--;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Nodo<E> getCabeza() {
        return cabeza;
    }

    public Nodo<E> getUltimo() {
        return ultimo;
    }

    @Override
    public String toString() {
        String salida = "[ ";
        Nodo<E> tmp = cabeza;
        while (tmp != null) {
            salida += tmp.toString();
            if (tmp.getSig() != null) {
                salida = ", ";
            }
            tmp = tmp.getSig();
        }
        salida += " ]";
        return salida;
    }
}
