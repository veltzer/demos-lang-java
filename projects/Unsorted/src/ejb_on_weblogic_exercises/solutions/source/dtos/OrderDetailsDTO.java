package ejb_on_weblogic_exercises.solutions.source.dtos;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OrderDetailsDTO implements Serializable {
	private String id;
	private String customerId;
	private long timestamp;
	private List<String> bookTitles;

	public OrderDetailsDTO(String iid, long itimestamp, List<String> ibookTitles) {
		id = iid;
		timestamp = itimestamp;
		bookTitles = ibookTitles;
	}

	public OrderDetailsDTO() {
	}

	public List<String> getBookTitles() {
		return bookTitles;
	}

	public String getId() {
		return id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setBookTitles(List<String> list) {
		bookTitles = list;
	}

	public void setId(String string) {
		id = string;
	}

	public void setTimestamp(long l) {
		timestamp = l;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String string) {
		customerId = string;
	}
}
