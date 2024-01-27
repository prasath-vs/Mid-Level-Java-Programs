import java.util.Random; 
class SimpleTryCatch {
	public static void main(String a[]) 
	{ 
		int a1=0, b=0, c=0;
		Random r = new Random(); 
		for(int i=0; i<10; i++)
		{
			try {
				b = r.nextInt();
				c = r.nextInt();
				a1 = 12345 / (b/c);
				}
			catch (ArithmeticException e)
			{
				System.out.println("Division by zero.");
				a1 = 0; // set a to zero and continue
			}
			System.out.println("a: " + a1);
		}
	}
}

