package listadoblecircular;

public class Main {

    public static void main(String[] args) {
        
        Lista lista = new Lista();
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.insertar(0, 0);
        lista.mostrar();
    }
    
}
