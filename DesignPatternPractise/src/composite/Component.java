package composite;

public interface Component {
	default String getName() {
		throw new UnsupportedOperationException();
	}
	default void add(Component c) {
		throw new UnsupportedOperationException();
	}
	default void remove(Component c) {
		throw new UnsupportedOperationException();
	}
	default void print() {
		throw new UnsupportedOperationException();
	}
}	
