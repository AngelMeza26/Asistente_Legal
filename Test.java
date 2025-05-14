public class Test {
    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();

        // Inserción de elementos Nodo
        System.out.println("Insertando elementos en el BST...");
        bst.insert(10);
        bst.insert(30);
        bst.insert(20);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(37);
        bst.insert(12);
        bst.insert(18);
        bst.insert(29);
        // Recorrido in-order
        System.out.print("Recorrido In-Order: ");
        bst.inOrden();
        bst.insert(26);
        // Recorrido in-order
        System.out.print("Recorrido In-Order: ");
        bst.inOrden();
        bst.insert(2);
        // Recorrido in-order
        System.out.print("Recorrido In-Order: ");
        bst.inOrden();
        
        // Búsqueda de un elemento existente
        System.out.println("Buscando el elementos");
        System.out.println("18? " + bst.search(18));
        System.out.print("In-Order tras eliminar hoja: ");
        bst.inOrden();
        
        System.out.println("12? " + bst.search(12));
        System.out.print("In-Order tras eliminar nodo con un hijo: ");
        bst.inOrden();
        
        System.out.println("2? " + bst.search(2));
        System.out.print("In-Order tras eliminar hoja: ");
        bst.inOrden();
        
        System.out.println("30? " + bst.search(30));
        System.out.print("In-Order tras eliminar hoja: ");
        bst.inOrden();
    }
}
