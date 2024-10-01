import java.util.Random;

public class counter implements Runnable {
	public int N = Integer.MAX_VALUE;
	public int X = 0;
	
	public void Random_Limit(int N) {
		
		Random rand = new Random();
		N = rand.nextInt((N - 1) + 1) + 1;
		
	}
	
	public void run() {
		for (int i = 0; i < X; i++) {
			X++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public int GetX() {
		return X;
	}
	
	
	

}
