class ExcMultiCatch {
	public static void main(String args[])
	{
		try
		{
			int a = args.length; 
			System.out.println("a = " + a); 
			int b = 42 / a;
			int c[] = { 1 }; c[42] = 99;
		}
		catch(ArithmeticException e) 
		{ 
			System.out.println("Exception: "+ e);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Exception " + e);
		}
		System.out.println("After try/catch blocks.");
	} 
}
