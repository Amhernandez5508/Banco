package hernandez.alejandro.productosbancarios.dao;

public interface DAO<E, K> {
	void insert(E entity);
	void select();
	E selectLastRegistry();
}
