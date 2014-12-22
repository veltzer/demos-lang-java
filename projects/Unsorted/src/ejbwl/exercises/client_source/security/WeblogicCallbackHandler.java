package ejbwl.exercises.client_source.security;

//import javax.security.auth.callback.*;
//import weblogic.security.auth.callback.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

class WeblogicCallbackHandler implements CallbackHandler {

	private String username = null;
	private String password = null;
	private String url = null;

	public WeblogicCallbackHandler() {
	}

	public WeblogicCallbackHandler(String pUsername, String pPassword, String pUrl) {
		username = pUsername;
		password = pPassword;
		url = pUrl;
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		System.out.println("Please login to WebLogic.");

		for (int i = 0; i < callbacks.length; i++) {
			boolean found = false;
			if (callbacks[i] instanceof TextOutputCallback) {
				// Display the message according to the specified type
				TextOutputCallback toc = (TextOutputCallback) callbacks[i];
				switch (toc.getMessageType()) {
					case TextOutputCallback.INFORMATION :
						System.out.println(toc.getMessage());
						break;
					case TextOutputCallback.ERROR :
						System.out.println("ERROR: " + toc.getMessage());
						break;
					case TextOutputCallback.WARNING :
						System.out.println("WARNING: " + toc.getMessage());
						break;
					default :
						throw new IOException("Unsupported message type: " + toc.getMessageType());
				}
				found = true;
			}
			if (callbacks[i] instanceof NameCallback) {
				// If username not supplied on cmd line, prompt the user for the username.
				NameCallback nc = (NameCallback) callbacks[i];
				if (username == null || username.equals("")) {
					System.err.print(nc.getPrompt());
					System.err.flush();
					nc.setName((new BufferedReader(new InputStreamReader(System.in))).readLine());
				} else {
					System.out.println("username: " + username);
					nc.setName(username);
				}
				found = true;
			}
			/*
			if (callbacks[i] instanceof URLCallback) {
				// If url not supplied on cmd line, prompt the user for the url.
				// This example requires the url.
				URLCallback uc = (URLCallback) callbacks[i];
				if (url == null || url.equals("")) {
					System.err.print(uc.getPrompt());
					System.err.flush();
					uc.setURL((new BufferedReader(new InputStreamReader(System.in))).readLine());
				} else {
					System.out.println("URL: " + url);
					uc.setURL(url);
				}
				found = true;
			}
			*/
			if (callbacks[i] instanceof PasswordCallback) {
				PasswordCallback pc = (PasswordCallback) callbacks[i];

				// If password not supplied on cmd line, prompt the user for the password.
				if (password == null || password.equals("")) {
					System.err.print(pc.getPrompt());
					System.err.flush();

					// Note: JAAS specifies that the password is a char[] rather than a String
					String tmpPassword = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					int passLen = tmpPassword.length();
					char[] passwordArray = new char[passLen];
					for (int passIdx = 0; passIdx < passLen; passIdx++) {
						passwordArray[passIdx] = tmpPassword.charAt(passIdx);
					}
					pc.setPassword(passwordArray);
				} else {
					String tPass = new String();
					for (int p = 0; p < password.length(); p++) {
						tPass += "*";
					}
					System.out.println("password: " + tPass);
					pc.setPassword(password.toCharArray());
				}
				found = true;
			}
			if (callbacks[i] instanceof TextInputCallback) {
				// Prompt the user for the username
				TextInputCallback callback = (TextInputCallback) callbacks[i];
				System.err.print(callback.getPrompt());
				System.err.flush();
				callback.setText((new BufferedReader(new InputStreamReader(System.in))).readLine());
				found = true;
			}
			if (!found) {
				throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
			}
		}
	}
}
