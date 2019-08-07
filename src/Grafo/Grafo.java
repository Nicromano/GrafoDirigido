package Grafo;

public abstract class Grafo {

    private int numVertice;
    private int numArista;

    public Grafo() {
    }

    public class Adyacente {

        int destino;
        double peso;

        Adyacente(int i, double j) {
            destino = i;
            peso = j;
        }

        @Override
        public String toString() {
            return destino + "(" + peso + ")";
        }
    }

    public abstract int numVertice();

    public abstract int numArista();

    public abstract boolean existeArista(int i, int j);

    public abstract double pesoArista(int i, int j);

    public abstract void insertarArista(int i, int j);

    public abstract void insertarArista(int i, int j, double p);

    public abstract String Caminos(int SALIDA, int DESTINO);

    public abstract ListaConPI<Adyacente> adyacenteDe(int i);

    public abstract int[][] matrizAdyacencia();

    public abstract double[][] matrizPesoAdyacencia();

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < numVertice(); i++) {
            res += "Vertice: " + i;
            ListaConPI<Adyacente> l = adyacenteDe(i);
            if (l.esVacia()) {
                res += " sin Adyacentes ";
            } else {
                res += " con Adyacentes ";
            }
            for (l.inicio(); !l.esFin(); l.siguiente()) {
                res += l.recuperar() + " ";
            }
            res += "\n";
        }
        return res;

    }

}
