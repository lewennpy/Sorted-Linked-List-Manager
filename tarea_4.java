import java.util.Scanner;

class Nodo {
    int info;
    Nodo sig;
    Nodo ant;

    public Nodo(int dato) {
        info = dato;
        sig = null;
        ant = null;
    }
}

class Lista {
    Nodo raiz;

    public Lista() {
        raiz = null;
    }

    // Método para insertar en la lista ordenada
    public void insertar(int x) {
        Nodo temp = new Nodo(x);
        if (raiz == null || raiz.info > x) {
            temp.sig = raiz;
            if (raiz != null) {
                raiz.ant = temp;
            }
            raiz = temp;
        } else {
            Nodo aux = raiz;
            while (aux.sig != null && aux.sig.info < x) {
                aux = aux.sig;
            }
            temp.sig = aux.sig;
            if (aux.sig != null) {
                aux.sig.ant = temp;
            }
            aux.sig = temp;
            temp.ant = aux;
        }
    }

    // Método para eliminar un valor dado
    public void eliminar(int x) {
        Nodo aux = raiz;
        while (aux != null) {
            if (aux.info == x) {
                if (aux.ant != null) {
                    aux.ant.sig = aux.sig;
                } else {
                    raiz = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig.ant = aux.ant;
                }
                System.out.println("Elemento " + x + " eliminado.");
                return;
            }
            aux = aux.sig;
        }
        System.out.println("Elemento " + x + " no encontrado.");
    }

    // Método para disminuir el valor de un elemento en la lista
    public void disminuir(int x) {
        Nodo aux = raiz;
        while (aux != null) {
            if (aux.info == x) {
                aux.info--; // Disminuye el valor
                System.out.println("Valor de " + x + " disminuido a " + aux.info);
                return;
            }
            aux = aux.sig;
        }
        System.out.println("Elemento " + x + " no encontrado.");
    }

    // Método para recorrer la lista y mostrarla
    public void recorrer() {
        Nodo aux = raiz;
        while (aux != null) {
            System.out.print(aux.info + " ");
            aux = aux.sig;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar en lista ordenada");
            System.out.println("2. Eliminar de la lista");
            System.out.println("3. Ver lista ordenada");
            System.out.println("4. Disminuir un valor en la lista");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número a insertar: ");
                    int numeroInsertar = scanner.nextInt();
                    lista.insertar(numeroInsertar);
                    break;
                case 2:
                    System.out.print("Ingrese el número a eliminar: ");
                    int numeroEliminar = scanner.nextInt();
                    lista.eliminar(numeroEliminar);
                    break;
                case 3:
                    System.out.println("Lista ordenada:");
                    lista.recorrer();
                    break;
                case 4:
                    System.out.print("Ingrese el valor a disminuir: ");
                    int numeroDisminuir = scanner.nextInt();
                    lista.disminuir(numeroDisminuir);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
