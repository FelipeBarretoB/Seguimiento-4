package model;

public class Type<T > implements Comparable<T > {
	private T dato;
	private Type<T> next;
	

	public Type(T d) {
		this.dato = d;
		next=null;
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
	
	
	
	public void setDato(T dato) {
		this.dato = dato;
	}
	public void setNext(Type<T> next) {
		this.next = next;
	}
	public void addNext(Type<T> next2){
		if(next!=null) {
			
			next.addNext(next2);
		}else {
			next=next2;
		}
	}
	
	public  int compareTo(Type<T> type) {
		
		return this.getDato().toString().compareTo(type.getDato().toString());
	}
	@Override
	public  int compareTo(T o) {
		// TODO Auto-generated method stub
		return this.compareTo(o);
	}
	
	public String toString() {
		String all = dato.toString();
		if(this.getNext()!=null) {
			all+=this.getNext();
		}
		return all;
	}
	
	/*public String soloString() {
		return dato.toString();
	}*/
}
