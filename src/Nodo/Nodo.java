package Nodo;

public class Nodo<E> {

    protected Nodo<E> sig, ant;
    private E dato;

    public Nodo(E dato, Nodo<E> sig, Nodo<E> ant) {
        this.sig = sig;
        this.ant = ant;
        this.dato = dato;
    }

    public Nodo(E dato) {
        this(dato, null, null);
    }

    public boolean existeSig() {
        return sig != null;
    }

    public boolean existeAnt() {
        return ant != null;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public E getDato() {
        return dato;
    }

    public void setAnt(Nodo<E> ant) {
        this.ant = ant;
    }

    public void setSig(Nodo<E> sig) {
        this.sig = sig;
    }

    public Nodo<E> getAnt() {
        return ant;
    }

    public Nodo<E> getSig() {
        return sig;
    }

    protected void Destructor() {
        dato = null;
        sig = null;
        ant = null;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}
