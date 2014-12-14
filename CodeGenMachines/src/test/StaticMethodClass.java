package test;

public class StaticMethodClass {
	private static int int1;

	public StaticMethodClass(int i) {
		this.int1 = i;
		System.out.println("constructor");
	}

	public static int getInt() {
		System.out.print(int1);
		return int1;
	}

}
