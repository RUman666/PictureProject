
public class test {
	public static void main(String[] args) {
		int test = 100;
		int def = 15;
		test = (int)(test *(1.0 - (double)(def * 2.0 / 100.0)));
		
		System.out.println(test);
	}
}
