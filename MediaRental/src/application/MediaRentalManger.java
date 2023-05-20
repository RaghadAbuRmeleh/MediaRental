    package application;

import java.util.ArrayList;
import java.util.Collections;


public class MediaRentalManger implements MediaRentalInt {

	ArrayList <Media> mediaList = new ArrayList <>();
	ArrayList <Customer> customerList = new ArrayList <>();

	@Override
	public void addCustomer(String id, String name, String address, String mobile, String plan) {

		if (plan.equalsIgnoreCase("Limited")) 
			customerList.add(new Customer(id,name, address, mobile,plan));

		else if (plan.equalsIgnoreCase("Unlimited"))
			customerList.add(new Customer(id,name, address, mobile,plan));

		else
			throw new IllegalArgumentException("Your plan must be either Limited or Unlimited");
	}

	//@Override
	public void removeCustomer (String id, String name, String address, String mobile, String plan) {
		for (Customer c : customerList) {
			if (c.getId().equalsIgnoreCase(id) && c.getName().equalsIgnoreCase(name) && c.getAddress().equalsIgnoreCase(address) && c.getMobile().equalsIgnoreCase(mobile) && c.getPlan().equalsIgnoreCase(plan))
				customerList.remove(c);
		}
	}

	@Override
	public void updateCustomer(String id,String name, String address, String mobile, String plan, String newName, String newAddress, String newMobile, String newPlan) {
		for (Customer c : customerList) {
			if (c.getId().equalsIgnoreCase(id) && c.getName().equalsIgnoreCase(name) && c.getAddress().equalsIgnoreCase(address) && c.getMobile().equalsIgnoreCase(mobile) && c.getPlan().equalsIgnoreCase(plan)) {
				c.setId(id);
				c.setName(newName);
				c.setAddress(newAddress);
				c.setMobile(newMobile);
				c.setPlan(newPlan);
			}
		}
	}

	@Override
	public void addMovie(String code, String title, int copiesAvailable, String rating) {
		mediaList.add(new Movie(code,title, copiesAvailable, rating));
	}
	@Override
	public void removeMovie(String code, String title, int copiesAvailable, String rating) {
		for (Media m : mediaList) {
			if (m.getCode().equalsIgnoreCase(code) && m.getTitle().equalsIgnoreCase(title) && m.getNumOfCopies() == (copiesAvailable) && ((Movie)m).getRating().equalsIgnoreCase(rating))
				mediaList.remove(m);
		}
	}

	@Override
	public void updateMovie(String code, String title, int copiesAvailable, String rating, String newCode,
			String newTitle, int newCopies, String newRating) {
		for (Media m : mediaList) {
			if (m.getCode().equalsIgnoreCase(code) && m.getTitle().equalsIgnoreCase(title) && m.getNumOfCopies() == (copiesAvailable) && ((Movie)m).getRating().equalsIgnoreCase(rating)) {
				m.setCode(newCode);
				m.setTitle(newTitle);
				m.setNumOfCopies(newCopies);
				((Movie)m).setRating(newRating);
			}

		}		
	}

	@Override
	public void addGame(String code,String title, int copiesAvailable, double weight) {
		mediaList.add(new Game(code,title, copiesAvailable, weight));
	}

	@Override
	public void removeGame(String code, String title, int copiesAvailable, double weight) {
		for (Media m : mediaList) {
			if (m.getCode().equalsIgnoreCase(code) && m.getTitle().equalsIgnoreCase(title) && m.getNumOfCopies() == (copiesAvailable) && ((Game)m).getWeigth() == weight )
				mediaList.remove(m);
		}

	}

	@Override
	public void updateGame(String code, String title, int copiesAvailable, double weight, String newCode,
			String newTitle, int newCopies, double newWeight) {
		for (Media m : mediaList) {
			if (m.getCode().equalsIgnoreCase(code) && m.getTitle().equalsIgnoreCase(title) && m.getNumOfCopies() == (copiesAvailable) && ((Game)m).getWeigth() == weight ) {
				m.setCode(newCode);
				m.setTitle(newTitle);
				m.setNumOfCopies(newCopies);
				((Game)m).setWeigth(newWeight);
			}
		}


	}

	@Override
	public void addAlbum(String code,String title, int copiesAvailable, String artist, String songs) {
		mediaList.add(new Album(code,title, copiesAvailable, artist, songs));
	}

	@Override
	public void removeAlbum(String code, String title, int copiesAvailable, String artist, String songs) {
		for (Media m : mediaList) {
			if (m.getCode().equalsIgnoreCase(code) && m.getTitle().equalsIgnoreCase(title) && m.getNumOfCopies() == (copiesAvailable) && ((Album)m).getArtist().equalsIgnoreCase(artist) && ((Album)m).getSong().equalsIgnoreCase(songs) )
				mediaList.remove(m);
		}

	}
	@Override
	public void updateAlbum(String code, String title, int copiesAvailable, String artist, String songs, String newCode,
			String newTitle, int newCopies, String newArtist, String newSongs) {
		for (Media m : mediaList) {
			if((m.getCode().equalsIgnoreCase(code) && m.getTitle().equalsIgnoreCase(title) && m.getNumOfCopies() == (copiesAvailable) && ((Album)m).getArtist().equalsIgnoreCase(artist) && ((Album)m).getSong().equalsIgnoreCase(songs))){
				m.setCode(newCode);
				m.setTitle(newTitle);
				m.setNumOfCopies(newCopies);
				((Album)m).setArtist(newArtist);
				((Album)m).setSong(newSongs);
			}
		}

	}
	@Override
	public void setLimitedPlanLimit(int value) {
		if (value > 0)
			for (int i = 0; i < customerList.size(); i++) {
				if (customerList.get(i).getPlan().equalsIgnoreCase("Limited"))
					customerList.get(i).setLimited(value);
			}
	}

	@Override
	public String getAllCustomersInfo() {
		Collections.sort(customerList);
		return "The customers information: " + customerList;
	}

	@Override
	public String getAllMediaInfo() {
		Collections.sort(mediaList);
		return "The media information:\n " + mediaList;
	}

	@Override
	public boolean addToCart(String id, String code) {
		//for (Media m : mediaList) {
		for (Customer c : customerList) {

			if (c.getId().equalsIgnoreCase(id))
				if (c.getInterested().contains(code))
					return false;
				else {
					c.getInterested().add(code);
				}
			return true;
		}

		return false;
	}

	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) {
		for (Customer c : customerList) {
			for (Media m : mediaList) {
				if (c.getName().equalsIgnoreCase(customerName) && m.getTitle().equalsIgnoreCase(mediaTitle))
					c.getRented().remove(mediaTitle);
				m.setNumOfCopies(m.getNumOfCopies() +1);
			}
		}
		return false;
	}

	@Override
	public String processRequests() {
		Collections.sort(customerList);
		ArrayList <String> rentedCart= new ArrayList<>();
		String forReturn = "Sending";

		for (int i = 0; i < customerList.size() ; i++) {
				if (customerList.get(i).getPlan().equalsIgnoreCase("Limited") && customerList.get(i).getRented().size() <= customerList.get(i).getLimited()) {
					for (int j = 0; j < customerList.get(i).getInterested().size() ; j++) {
						rentedCart = customerList.get(i).getRented();
						if ((customerList.get(i).getRented().contains(customerList.get(i).getInterested().get(j)))){
							System.out.println(" This media is already reserved to this customer.");
						}
						else  {
							rentedCart.add(customerList.get(i).getInterested().get(j));
							customerList.get(i).setRented(rentedCart);
							customerList.get(i).getInterested().remove(j);
							customerList.get(i).setLimited(customerList.get(i).getLimited()-1);
							mediaList.get(j).setNumOfCopies(mediaList.get(j).getNumOfCopies()-1);
							forReturn += " [ " + customerList.get(i).getInterested().get(j) + "]";
						}
					}	
				}
			if (customerList.get(i).getPlan().equalsIgnoreCase("Unlimited") ) {	
				for (int j = 0; j < customerList.get(i).getInterested().size() ; j++) {
					rentedCart = customerList.get(i).getRented();
					if ((customerList.get(i).getRented().contains(customerList.get(i).getInterested().get(j)))){
						System.out.println(" This media id already reserved to this customer.");
					}
					else  {
						rentedCart.add(customerList.get(i).getInterested().get(j));
						customerList.get(i).setRented(rentedCart);
						customerList.get(i).getInterested().remove(j);
						customerList.get(i).setLimited(customerList.get(i).getLimited()-1);
						mediaList.get(j).setNumOfCopies(mediaList.get(j).getNumOfCopies()-1);
						forReturn += " [ " + customerList.get(i).getInterested().get(j) + "]";
					}
				}
			}
			
		}	
		return forReturn; 

	}

	@Override
	public boolean returnMedia(String customerID, String mediaCode) {
		for (Media m : mediaList) {
			if (m.getCode().equalsIgnoreCase(mediaCode)) {
				m.setNumOfCopies(m.getNumOfCopies() +1);
				return true;
			}

			for (int i = 0; i < customerList.size(); i++) {
				if (customerList.get(i).getId().equalsIgnoreCase(customerID)) {
					if (customerList.get(i).getRented().contains(mediaCode)) 
						customerList.get(i).getRented().remove(mediaCode);

					if(customerList.get(i).getPlan().equalsIgnoreCase("Limited"))
						customerList.get(i).setLimited(customerList.get(i).getLimited()+1);;
				}
			}

		}
		return false;
	}

	/*@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		Collections.sort(mediaList);
		ArrayList <String> forReturn = new ArrayList <>();

		for (Media m : mediaList) {

			if (title != null && rating == null && artist==null && songs == null ) {
				if (title == m.getTitle()) {
					forReturn.add(m.getTitle());

				}
			}
			if (title != null && rating != null ) {
				if ( m  instanceof Movie) {
					if (((Movie) m ).getRating().equalsIgnoreCase(rating))
						forReturn.add(m.getTitle());

				}
			}

			if ((title != null && songs != null) || (title != null && artist != null) ) {
				if ( m  instanceof Album) {
					if (((Album) m ).getArtist().equalsIgnoreCase(artist))
						forReturn.add(m.getTitle());
					if (((Album) m ).getSong().equalsIgnoreCase(artist))
						forReturn.add(m.getTitle());
				}
			}

			if (title == null && rating == null && artist == null && songs == null) {
				forReturn.add(m.getTitle());
				return forReturn;
			}

			if ((rating != null && songs != null ) || (rating != null && artist != null ))
				forReturn=null;
		}

		return forReturn;
	}*/

	@Override
	public String printIntersted(String id) {
		// TODO Auto-generated method stub
		ArrayList <String> s =  new ArrayList<String > ();
		String str="";

		for (int i = 0; i < customerList.size() ; i++) {
			if (customerList.get(i).getId().equalsIgnoreCase(id)) {
				s.addAll(customerList.get(i).getInterested());
				str = s.toString();	
			}
		}
		return str; 

	}

	@Override
	public String printRented(String id) {
		ArrayList <String> s2 =  new ArrayList<String > ();
		String str2="";

		for (int i = 0; i < customerList.size() ; i++) {

			if (customerList.get(i).getId().equalsIgnoreCase(id)) {
				String s = customerList.get(i).getRented().toString();
				s2.add(s);
				str2 = s2.toString();	
			}
		}
		return str2; 
	}

}	

    
