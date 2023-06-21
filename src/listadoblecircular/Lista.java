package listadoblecircular;

public class Lista {
    
    private Nodo raiz;
    private int contador;
    
    public Lista(){
        raiz = null;
        contador = 0;
    }
    
    public void insertar(int dato){
        if(raiz != null){
            Nodo aux = new Nodo(dato,raiz,raiz.izquierda);
            raiz.izquierda = aux;
            aux.izquierda.derecha = aux;
            contador++;
        }else{
            raiz = new Nodo(dato);
            raiz.derecha = raiz;
            raiz.izquierda = raiz;
            contador++;
        }
    }
    
    public void insertar(int dato, int posicion){
        if(raiz != null){
            if(posicion < contador){
                if(posicion == 0){
                    Nodo aux = new Nodo(dato, raiz, raiz.izquierda);
                    raiz.izquierda = aux;
                    aux.izquierda.derecha = aux;
                    contador++;
                    raiz = aux;
                }else{
                    int cont = 0;
                    Nodo aux = raiz;
                    while(cont < posicion){
                        aux = aux.derecha;
                        cont++;
                    }
                    Nodo nuevo = new Nodo(dato, aux, aux.izquierda);
                    aux.izquierda = nuevo;
                    nuevo.izquierda.derecha = nuevo;
                    contador++;
                }
            }else{
                insertar(dato);
            }
        }else{
            insertar(dato);
        }
    }
    
    public void remover(int dato){
        if(raiz != null){
            if(raiz.dato == dato){
                raiz.izquierda.derecha = raiz.derecha;
                raiz.derecha.izquierda = raiz.izquierda;
                Nodo aux = raiz;
                raiz = raiz.derecha;
                aux = null;
                contador--;
            }else{
                Nodo aux = raiz;
                boolean encontrado = false;
                while(aux.derecha != raiz && !encontrado){
                    if(aux.dato == dato){
                        encontrado = true;
                    }else{
                        aux = aux.derecha;
                    }
                }
                if(encontrado){
                    aux.derecha.izquierda = aux.izquierda;
                    aux.izquierda.derecha = aux.derecha;
                    aux = null;
                    contador--;
                }else{
                    System.out.println("NO EXISTE EL DATO: " + dato);
                }
            }
        }else{
            System.out.println("NO HAY DATOS");
        }
    }
    
    public int obtener(){
        int dato = -1;
        if(raiz != null){
            if(contador > 1){
                Nodo aux = raiz.izquierda;
                dato = aux.dato;
                raiz.izquierda = aux.izquierda;
                aux.izquierda.derecha = raiz;
                aux = null;
                contador--;
                return dato;
            }else{
                dato = raiz.dato;
                vaciar();
                return dato;
            }
        }
        return dato;
    }
    
    public int obtener(int posicion){
        int dato = -1;
        if(raiz != null){
            if(contador > posicion){
                if(posicion == 0){
                    raiz.izquierda.derecha = raiz.derecha;
                    raiz.derecha.izquierda = raiz.izquierda;
                    Nodo aux = raiz;
                    raiz = raiz.derecha;
                    dato = aux.dato;
                    aux = null;
                    contador--;
                    return dato;
                }else{
                    Nodo aux = raiz;
                    int cont = 0;
                    while(cont != posicion){
                        aux = aux.derecha;
                        cont++;
                    }
                    aux.izquierda.derecha = aux.derecha;
                    aux.derecha.izquierda = aux.izquierda;
                    dato = aux.dato;
                    aux = null;
                    contador--;
                    return dato;
                }
            }else{
                System.out.println("NO EXISTE LA POSICION: " + posicion);
                return dato;
            }
        }
        return dato;
    }
    
    public void vaciar(){
        contador = 0;
        raiz = null;
    }
    
    public void mostrar(){
        if(raiz != null){
            Nodo aux = raiz;
            while(aux.derecha != raiz){
                System.out.print("[" + aux.dato + "]->");
                aux = aux.derecha;
            }
            System.out.println("[" + aux.dato + "]");
        }else{
            System.out.println("NO HAY DATOS");
        }
    }
    
    public int posicion(int dato){
        if(raiz != null){
            int cont = 0;
            Nodo aux = raiz;
            boolean encontrado = false;
            if(aux.dato == dato){
                return cont;
            }else{
                aux = aux.derecha;
                cont++;
            }
            while(aux != raiz && !encontrado){
                if(aux.dato == dato){
                    encontrado = true;
                }else{
                    aux = aux.derecha;
                    cont++;
                }
            }
            if(encontrado){
                return cont;
            }else{
                System.out.println("NO EXISTE EL DATO: " + dato);
                return -1;
            }
        }
        System.out.println("NO HAY DATOS");
        return -1;
    }
    
    public int contador(){
        return contador;
    }
    
    public void voltear(){
        if(raiz != null){
            if(contador > 1){
                Nodo aux = raiz;
                Nodo aux2 = raiz.derecha;
                while(aux2 != raiz){
                    aux.derecha = aux.izquierda;
                    aux.izquierda = aux2;
                    aux = aux.izquierda;
                    aux2 = aux2.derecha;
                }
                aux.derecha = aux.izquierda;
                aux.izquierda = aux2;
                raiz = aux;
            }
        }
    }
    
    public void extender(Lista lista){
        while(lista.contador() != 0){
            insertar(lista.obtener(0));
        }
    }
    
}
