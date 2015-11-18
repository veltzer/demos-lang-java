package jsf.examples.src.com.arcmind.jsfquickstart;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CD implements Serializable {
	private String title;
	private String artist;
	private float price;

	public CD() {
	}

	public CD(String ititle, String iartist, float iprice) {
		title = ititle;
		artist = iartist;
		price = iprice;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String iartist) {
		artist = iartist;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float iprice) {
		price = iprice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String ititle) {
		title = ititle;
	}
}
