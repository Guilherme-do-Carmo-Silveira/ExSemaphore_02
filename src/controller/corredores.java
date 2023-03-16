package controller;

import java.util.concurrent.Semaphore;

public class corredores extends Thread {
	
	private int pessoa;
	private Semaphore farol;

	public corredores(int pessoa, Semaphore farol) {
		this.pessoa = pessoa;
		this.farol = farol;
	}
	
	public void run() {
		caminhada();
		try {
			farol.acquire();
			AbrirPorta();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			farol.release();		
		}
		
	}


	private void caminhada() {
		 int distancia = 200;
		 int distanciatotal = 0;
		 int passo;
		 
		 while(distanciatotal < distancia) {
			 passo = (int) (Math.random() * 2) + 4; 
			 distanciatotal += passo;
			 System.out.println("A pessoa " + pessoa + " Caminhou " + distanciatotal + " .m");
			 try {
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 System.out.println("A pessoa " + pessoa + " chegou na porta");
	}
	
	private void AbrirPorta() {
		int tempo = (int) (Math.random() * 1001) + 1000;
		System.out.println("A pessoa " + pessoa + " Abriu a porta");
		try {
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
