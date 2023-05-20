    package application;
public class Movie extends Media {
	
	public String rating;

	public Movie() {
		super();
	}

	public Movie(String code,String title, int numOfCopies,String rating) {
		super(code,title, numOfCopies);
		this.rating=rating;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [ " +  super.toString() +"Rating = " + rating + "].\n";
	}
	


	

}

    
