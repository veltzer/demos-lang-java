package swing.jbeans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BeanDemo implements Serializable {
	private String username;
	private String password;
	public void setUsername(String iusername) {
		username = iusername;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String ipassword) {
		password = ipassword;
	}
	public String getPassword() {
		return password;
	}
}
