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

	public void sort() {
		T temp = null;
		int count=counter(this,0);
		for(int c=0; c<count; c++) {
			if(this.getNext()!= null) {
				if (this.getDato().toString().compareTo(this.getNext().getDato().toString()) <0) {
					temp = this.getDato();
					this.setDato(this.getNext().getDato());
					this.getNext().setDato(temp);
					sort(this.getNext());
				}else {
					this.getNext().sort();
				}
			}
		}
	}

	private int counter(Type<T> counter, int count) {
		if(counter!=null) {
			count++;
			counter=counter.getNext();
			return counter( counter,  count);
		}
		return count;
	}

	private void sort(Type<T> toOrder) {
		if(toOrder!=null && toOrder.getNext()!=null) {
			T temp = null;
			if (toOrder.getDato().toString().compareTo(toOrder.getNext().getDato().toString()) <0) {
				temp = toOrder.getDato();
				toOrder.setDato(toOrder.getNext().getDato());
				toOrder.getNext().setDato(temp);
				sort(toOrder.getNext());
			}
		}
	}
}
