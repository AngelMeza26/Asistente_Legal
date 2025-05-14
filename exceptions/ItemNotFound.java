// * Excepción lanzada cuando un elemento buscado no se encuentra en el BST.
public class ItemNotFound extends Exception {
    public ItemNotFound(String message) {
        super(message);
    }
}