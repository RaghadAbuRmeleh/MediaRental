    package application;

public class Album extends Media {
	
	private String artist;
	private String song;

	public Album() {
		super();
	}


	public Album(String code,String title, int numOfCopies,String artist, String song) {
		super(code,title, numOfCopies);
		this.artist=artist;
		this.song=song;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return "Album [ "+ super.toString() + "Artist = " + artist  + "Songs = " + song + "].\n";
	}
	

}

    
