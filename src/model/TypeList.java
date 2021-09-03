package model;

public class TypeList<T> {
	T first;
	int next;
	
	public TypeList(Type<T> f) {
		this.first = f;
		size = 1;
	}
	
	public void add(Type<T> t) {
		Type aux = first;
		for (int i = 0; i < size; i++) {
			if ( aux.getNext()== null) {
				
			}else {
				aux=aux.getNext();
			}
		}
	}
}
