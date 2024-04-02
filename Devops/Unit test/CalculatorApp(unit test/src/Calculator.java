
public class Calculator {

	public int add(int i, int j) {
		return i+j;
		
	}

	public int Subtract(int i, int j) {
		return i-j;
	}

	public int divide(int i, int j) {
		if (j==0) {
			throw new IllegalArgumentException("division by zero is illegal");
			
		}
		
		return i/j;
	}
	
	public void doWork() {
		for(int i=0;i<100000;i++) {
			System.out.println(i);
		}
	}

}
