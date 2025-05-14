public class BSTree<E extends Comparable<E>> implements LinkBST<E> {
    private NodeBST<E> root;

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E x) throws ItemDuplicated {
        root = insertRec(root, x);
    }
    private NodeBST<E> insertRec(NodeBST<E> node, E x) throws ItemDuplicated {
        if (node == null) {
            return new NodeBST<>(x);
        }
        int cmp = x.compareTo(node.getData());
        if (cmp < 0) {
            node.setLeft(insertRec(node.getLeft(), x));
        } else if (cmp > 0) {
            node.setRight(insertRec(node.getRight(), x));
        } else {
            throw new ItemDuplicated("El elemento " + x + " ya existe en el BST.");
        }
        return node;
    }

    public E search(E x) throws ItemNotFound {
        return searchRec(root, x);
    }
    private E searchRec(NodeBST<E> node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Elemento " + x + " no encontrado.");
        }
        int cmp = x.compareTo(node.getData());
        if (cmp < 0) {
            return searchRec(node.getLeft(), x);
        } else if (cmp > 0) {
            return searchRec(node.getRight(), x);
        } else {
            return node.getData();
        }
    }

    // * Recorrido in-order
    public void inOrden() {
        if (isEmpty()) {
            System.out.println("BST vacío...");
        } else {
            inOrdenRec(root);
            System.out.println();
        }
    }
    private void inOrdenRec(NodeBST<E> node) {
        if (node != null) {
            inOrdenRec(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrdenRec(node.getRight());
        }
    }
    
    public void searchFamily(E x) throws ItemNotFound {
        NodeBST<E> nodo = findNode(root, x);
        // Mostrar el nodo
        System.out.println("Nodo: " + nodo.getData());
        // Mostrar hijo izquierdo
        if (nodo.getLeft() != null) {
            System.out.println("Hijo izquierdo: " + nodo.getLeft().getData());
        } else {
            System.out.println("Hijo izquierdo: null");
        }
        // Mostrar hijo derecho
        if (nodo.getRight() != null) {
            System.out.println("Hijo derecho: " + nodo.getRight().getData());
        } else {
            System.out.println("Hijo derecho: null");
        }
    }

}
