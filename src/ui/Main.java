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


	public <T> String addNext(Type<T> start) throws IOException {
		String line="";
		bw.write("Que le quiere añadir a la lista, use enter para parar");
		bw.newLine();
		bw.flush();
		line=br.readLine();
		if(line.equals("")) {
			return "";
		}else {
			T data= (T) line;
			Type<T> next= new Type<T>(data);
			start.addNext(next);
		}
		return "a";
		
	}
	
	public <T> Type<T> addFirst() throws IOException {
		
		bw.write("Que le quiere añadir a la lista");
		bw.newLine();
		bw.flush();
		T data= (T) br.readLine();
		Type<T> next= new Type<T>(data);
		return next;
	}

	public Main() {
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
	}

	public Type<Integer> getTestInt(){
		return testInt;
	}
	public Type<String> getTestString(){
		return testString;
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
			boolean finish = false;
			int size = 1;
			Type<Object> first= ui.<Object>addFirst();
			
			while(!finish) {
				System.out.println("Tamaño de la lista enlazada: "+size);
				if(ui.<Object>addNext(first).equals("")) {
					finish=true;
					
				}else {
					size++;
				}
			}
			first.sort();
			System.out.println(first.toString());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
