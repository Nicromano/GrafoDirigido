
package Grafo;

public interface ListaConPI<E> {

    void insertar(E x);
    void eliminar();
    void inicio();
    void fin();
    void siguiente();
    E recuperar();
    boolean esFin();
    boolean esVacia();
    
}
