    package application;
public abstract class Media implements Comparable <Media>{

	protected String title;
	protected String code;
	protected int numOfCopies;
	
	public Media() {
	}
	
	public Media(String code,String title, int numOfCopies) {
		this.code=code;
		this.title = title;
		this.numOfCopies = numOfCopies;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumOfCopies() {
		return numOfCopies;
	}
	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return " Title = " + title + ", Code = " + code + ", Number Of Copies = " + numOfCopies + ", ";
	}
	@Override
	public int compareTo(Media o) {
		if (title.compareTo(o.getTitle()) > 0 )
			return 1;
		else if (title.compareTo(o.getTitle()) < 0 )
			return -1;
		else 
			return 0;
	}
	
}

    
