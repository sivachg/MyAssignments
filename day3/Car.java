package week1.day3;

public class Car {
	
	public void driveCar() {
		System.out.println("Skoda");
	}
	protected void applyBrake() {
		System.out.println("Press to Stop");
	}
	public void soundHorn() {
		System.out.println("Just move away");
	}
	private void isPuncture() {
		System.out.println("Yes its punctured");
	}

	public static void main(String[] args) {
		Car roll = new Car();
		roll.driveCar();
		roll.applyBrake();
		roll.soundHorn();
		roll.isPuncture();
	}

}
