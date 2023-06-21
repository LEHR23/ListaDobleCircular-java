package listadoblecircular;

public class Nodo {
    
    Nodo izquierda;
    Nodo derecha;
    int dato;
    
    public Nodo(int dat, Nodo der, Nodo izq){
        derecha = der;
        izquierda = izq;
        dato = dat;
    }
    
    public Nodo(int dat){
        dato = dat;
    }
    
}
