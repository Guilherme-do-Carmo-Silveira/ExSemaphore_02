package view;

import java.util.concurrent.Semaphore;

import controller.corredores;

public class principal {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore farol = new Semaphore(permissao);
		
		for(int pessoa = 1; pessoa < 5; pessoa++) {
			Thread corredores = new corredores(pessoa, farol);
			corredores.start();
		}
		
	}

}
