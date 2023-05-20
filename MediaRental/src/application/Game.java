    package application;
public class Game extends Media {
	
	private double weigth;

	public Game() {
		super();
	}

	public Game(String code ,String title, int numOfCopies, double weigth) {
		super(code,title, numOfCopies);
		this.weigth=weigth;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	@Override
	public String toString() {
		return "Game [ " +  super.toString()  +"Weigth = " + weigth + "].\n";
	}
	

}

    
