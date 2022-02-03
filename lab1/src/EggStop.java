public class EggStop {
	static void m1()
	{
		System.out.println("  ______  ");
		System.out.println(" /      \\ ");
		System.out.println("/        \\");
	}
	static void m2() {
		System.out.println("\\        / ");
		System.out.println(" \\______/ ");
	}
	static void m3() {
		System.out.println("|  STOP  |");
	}
	static void m4() {
		System.out.println(" +-------+");
	}
	public static void main(String[] args) {
		EggStop.m1();
		EggStop.m2();
		EggStop.m1();
		EggStop.m2();
		EggStop.m4();
		EggStop.m1();
		EggStop.m3();
		EggStop.m2();
		EggStop.m4();
		System.out.println();
	}
}
