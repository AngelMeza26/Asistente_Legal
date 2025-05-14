// * Excepción lanzada cuando se intenta insertar un elemento duplicado en el BST.
public class ItemDuplicated extends Exception {
    public ItemDuplicated(String message) {
        super(message);
    }
}