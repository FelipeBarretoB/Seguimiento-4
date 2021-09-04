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
		testInt = new Type<Integer>(1);
		testString = new Type<String>("baba boy");
	}

	public Type<Integer> getTestInt(){
		return testInt;
	}
	public Type<String> getTestString(){
		return testString;
	}
	public <T> Type<T> order(Type<T> toOrder) {

		Type<T> temp = null;
		System.out.println(toOrder.compareTo(toOrder.getNext())<0);
		if (toOrder.compareTo(toOrder.getNext()) <0) {
		
			temp = toOrder;
			temp.setNext(toOrder.getNext().getNext());
			toOrder = toOrder.getNext();
			
			toOrder.setNext(temp);
			System.out.println(toOrder.getNext().getNext().getDato().toString());
			System.out.println(toOrder.getNext().getDato().toString());
			System.out.println(toOrder.getDato().toString());
			
		}
		return toOrder;
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
			System.out.println(ui.print(ui.getTestInt()));
			//ui.<Integer>addNext(ui.getTestInt());
			ui.<String>addNext(ui.getTestString());
			ui.testInt = ui.order(ui.getTestInt());
			
			System.out.println(ui.print(ui.getTestInt()));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
