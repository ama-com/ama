package model;

import dao.AuthenticationDAO;
import tmp.Account;

public class Authentication {
	public boolean login(Account account) {
		AuthenticationDAO authentication = new AuthenticationDAO();
		return authentication.search(account);
	}
	
	public boolean logout(Account account) {
		
		return false;
	}
}
