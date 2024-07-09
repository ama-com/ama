package model;

import dao.AccountDAO;

public class LoginLogic {
  public boolean execute(LoginData login) {
    AccountDAO dao = new AccountDAO();
    boolean result = dao.login(login);
    if (result) {
    	return true; 
    }
    return false;
  }
}