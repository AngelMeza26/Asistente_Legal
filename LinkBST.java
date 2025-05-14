// * Interfaz genérica para un Árbol de Búsqueda Binaria (BST).
public interface LinkBST<E extends Comparable<E>> {
    // * Inserta un elemento x en el BST.
    void insert(E x) throws ItemDuplicated;

    // * Elimina un elemento x del BST.
    void remove(E x) throws ItemNotFound;

    // * Busca un elemento x en el BST.
    E search(E x) throws ItemNotFound;

    // * Verifica si el BST está vacío.
    boolean isEmpty();
}

