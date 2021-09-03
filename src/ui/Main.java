package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.Type;

public class Main {
	private Type<Integer> testInt;
	private Type<String> testString;

	private BufferedReader br;
	private BufferedWriter bw;


	public <T> void addNext(Type<T> start) throws IOException {
		bw.write("Que le quiere añadir a la lista");
		bw.newLine();
		bw.flush();
		T data= (T) br.readLine();
		Type<T> next= new Type<T>(data);
		start.addNext(next);
	}

	public Main() {
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
		testInt = new Type<Integer>(123);
		testString = new Type<String>("baba boy");
	}

	public Type<Integer> getTestInt(){
		return testInt;
	}
	public Type<String> getTestString(){
		return testString;
	}
	public <T> void order(Type<T> toOrder) {

		Type<T> countElements= toOrder;
		int counter=0;
		while(countElements.getNext()!=null) {
			counter++;
			countElements=countElements.getNext();
		}

		Type<T> temp = null;
		for (int i = 0; i < counter; i++) {
			System.out.println("primer loop");
			for (int j = 1; j < (counter - i); j++) {
				System.out.println("segundo loop");
				System.out.println(toOrder.compareTo(toOrder.getNext()));
				if (toOrder.compareTo(toOrder.getNext()) >0) {
					
					temp = toOrder;
					if(toOrder.getNext().getNext()!=null) {
						temp.setNext(toOrder.getNext().getNext());
					}
					toOrder = toOrder.getNext();
					toOrder.setNext(temp);
				}
			}
		}
	}
	
	public <T> String print(Type<T> toPrint) {
		String print="";
		while(toPrint!=null) {
			print+=toPrint.getDato().toString();
			toPrint=toPrint.getNext();
		}
		return print;
	}

	public static void main(String[] args ) {
		Main ui= new Main();
		try {
			ui.<Integer>addNext(ui.getTestInt());
			ui.<Integer>addNext(ui.getTestInt());
			ui.<String>addNext(ui.getTestString());
			ui.order(ui.getTestInt());
			System.out.println(ui.print(ui.getTestInt()));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
