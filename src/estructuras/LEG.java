
package estructuras;

public class LEG<E> {

    class NodoLEG<E> {

        E dato;
        NodoLEG<E> siguiente;

        public NodoLEG(E dato) {
            this(dato, null);
        }

        public NodoLEG(E dato, NodoLEG<E> siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }
    protected NodoLEG<E> primero;
    protected int talla;

    public LEG() {
        primero = null;
        talla = 0;
    }

    public int indiceDe(E x) {
        int i = 0;
        if (primero == null) {
            i = -1;
        } else {
            NodoLEG<E> aux = primero;
            while (aux != null) {
                if (aux.dato == x) {
                    break;
                }
                aux = aux.siguiente;
                i++;
            }
        }
        return i;
    }

    public E recuperar(int i) {
        E retorna = null;
        int index = 0;
        NodoLEG<E> aux = primero;
        if (aux != null) {
            while (aux != null) {
                if (index == i) {
                    retorna = aux.dato;
                    break;
                }
                index++;
                aux = aux.siguiente;
            }
        }
        return retorna;

    }

    public void insertar(E x) {
        NodoLEG<E> nuevo = new NodoLEG<E>(x);

        if (primero != null) {
            nuevo.siguiente = primero;
        }
        primero = nuevo;
        talla++;

    }

    public void insertarFin(E x) {
        NodoLEG<E> nuevo = new NodoLEG<E>(x);
        NodoLEG<E> aux = primero;
        if (aux == null) {
            primero = nuevo;
        } else {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        talla++;
    }

    public void insertar(E x, int i) {

        E valor = recuperar(i);
        NodoLEG<E> nuevo = new NodoLEG<E>(x);
        if (valor != null) {

            NodoLEG<E> aux = primero;

            while (aux != null) {
                if (aux.dato == x) {
                    if (aux.siguiente != null) {
                        nuevo.siguiente = aux.siguiente;
                    }
                    aux.siguiente = nuevo;

                }
                aux = aux.siguiente;
            }
            talla++;
        }
    }

    public void eliminar(E x) {
        int i = indiceDe(x);

        if (i != -1) {
            NodoLEG<E> aux = primero;
            NodoLEG<E> atras = null;
            while (aux != null) {
                if (aux.dato == x) {
                    atras.siguiente = aux.siguiente;
                    talla--;
                }
                atras = aux;
                aux = aux.siguiente;
            }
        }
    }

    public E[] toArray(E[] a) {
        NodoLEG<E> aux;
        int i;
        for (aux = primero, i = 0; aux != null; aux = aux.siguiente, i++) {
            a[i] = aux.dato;
        }
        return a;
    }

}
