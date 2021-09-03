package model;

public class Type<T> {
	T dato;
	Type<T> next;
	

	public Type(T d) {
		this.dato = d;
	}
	public Type(T d, Type<T> n) {
		this.dato = d;
		this.next = n;
	}
	
	public Type<T> getNext() {
		return next;
	}
	
	public T getDato() {
		return dato;
	}
	
	public void addNext(Type<T> newNext){
		if(next!=null) {
			next.getNext().addNext(newNext);
		}else {
			next=newNext;
		}
	}
	
	
}
