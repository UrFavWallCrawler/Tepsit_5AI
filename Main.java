import java.util.Scanner;
/*Fare un programma che chiede all’utente due valori T ed N,
 *dove T indica quanti Thread creare ed ogni Thread conta i valori 
 *(SENZA STAMPARE) da 0 fino ad X dove X è un numero compreso tra 0 e N.
 *
 *Ogni Thread dopo che ha stampato un valore aspetta 120ms
 *
 *Il Thread principale stampa periodicamente (al massimo una volta al secondo) 
 *lo stato dei Thread e per i Thread attivi stampa il valore a cui è arrivato a contare, 
 *mentre per quelli terminati stampa “COMPLETATO”, 
 *quando tutti i Thread hanno raggiunto il loro valore X il programma 
 *deve stampare “TUTTI I THREAD COMPLETATI” e terminare*/

public class Main {

	public static void main(String[] args) {
		
		int Thread_N, N_Max,list_true=0;
		boolean check=false;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Quanti Threads vuoi creare?");
		Thread_N = scanner.nextInt();
		System.out.println("Qual'è il numero massimo fino a cui  vuoi contare?");
		N_Max = scanner.nextInt();
		
		counter[] count = new counter[Thread_N];
		Thread[] threads = new Thread[Thread_N];

		
		for (int i = 0; i< threads.length; i++){
			count[i] = new counter();
			count[i].Random_Limit(N_Max);
			threads[i] = new Thread(count[i]);	
		}
		
		for (int i = 0; i< threads.length; i++) {
			threads[i].start();
		}
		
		while(!check) {
			check = true;
			for ( int i = 0; i < threads.length; i++ ) {
				
					if (threads[i].isAlive()) {
						
						System.out.println(count[i].GetX());
						check = false;
						System.out.println("Stato Thread= " + threads[i].getState());
						
					}else {
						
						System.out.println("completat");
						
					}
				}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println("Tutti ithread compelatiti");
		scanner.close();
		
	}

}
