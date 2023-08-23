package week3.day1;

public class Automation extends MultipleLanguage implements Language, TestTool{

	public static void main(String[] args) {
		Automation auto = new Automation();
		auto.selenium();
		auto.java();
		auto.python();
		auto.ruby();

	}

	@Override
	public void ruby() {
		System.out.println("Ruby");		
	}

	public void selenium() {
		System.out.println("Selenium");
	}

	public void java() {
		System.out.println("Java");
	}

}
