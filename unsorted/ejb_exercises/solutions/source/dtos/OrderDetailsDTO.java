package dtos;

import java.io.Serializable;
import java.util.*;

public class OrderDetailsDTO implements Serializable {
	private String id;
	private String customerId;
	private long timestamp;
	private List bookTitles;

	public OrderDetailsDTO(String id, long timestamp, List bookTitles){
		this.id=id;
		this.timestamp=timestamp;
		this.bookTitles = bookTitles;
	}

	public OrderDetailsDTO(){
	}

	public List getBookTitles() {
		return bookTitles;
	}

	public String getId() {
		return id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setBookTitles(List list) {
		bookTitles = list;
	}

	public void setId(String string) {
		id = string;
	}

	public void setTimestamp(long l) {
		timestamp = l;
	}

	/**
	 * @return
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param string
	 */
	public void setCustomerId(String string) {
		customerId = string;
	}

}
