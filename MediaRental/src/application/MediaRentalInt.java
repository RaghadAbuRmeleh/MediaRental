    package application;
import java.util.ArrayList;

public interface MediaRentalInt {


	void addCustomer(String id, String name,String address,String mobile,String plan) ;
	
	void removeCustomer(String id, String name,String address,String mobile,String plan) ;

	void updateCustomer (String id,String name, String address, String mobile, String plan, String newName, String newAddress, String newMobile, String newPlan);
	
	void addMovie(String code,String title, int copiesAvailable,String rating) ;

	void addGame(String code,String title, int copiesAvailable,double weight) ;

	void addAlbum(String code,String title,int copiesAvailable,String artist,String songs) ;

	void removeMovie(String code,String title, int copiesAvailable,String rating) ;

	void removeGame(String code,String title, int copiesAvailable,double weight) ;

	void removeAlbum(String code,String title,int copiesAvailable,String artist,String songs) ;
	
	void updateMovie (String code, String title, int copiesAvailable, String rating, String newCode, String newTitle, int newCopies, String newRating);
	
	void updateGame (String code, String title, int copiesAvailable, double weight, String newCode, String newTitle, int newCopies, double newWeight);
	
	void updateAlbum (String code, String title, int copiesAvailable, String artist, String songs, String newCode, String newTitle, int newCopies, String newArtist, String newSongs);
	
	void setLimitedPlanLimit(int value) ;

	String getAllCustomersInfo() ;

	String getAllMediaInfo() ;

	boolean addToCart(String customerName,String mediaTitle) ;

	boolean removeFromCart(String customerName, String mediaTitle) ;
	
	String printIntersted (String id);
	
	String printRented (String id);

	String processRequests(); 

	boolean returnMedia(String customerName,String mediaTitle) ;

	//ArrayList<String> searchMedia(String title,String rating, String artist,String songs);

}

    
