package model;

import dao.AccountDao;

public class LoginLogic {
	public boolean execute(Login login, boolean decrypt) {
		AccountDao dao = new AccountDao();
		Account account = dao.findByLogin(login, decrypt);
		return account != null;
	}
}
