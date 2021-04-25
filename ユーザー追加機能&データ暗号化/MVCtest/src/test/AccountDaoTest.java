package test;

import dao.AccountDao;
import model.Account;
import model.Login;

public class AccountDaoTest {
	public static void main(String[] args) {
		testFindByLogic1();
//		testFindByLogic2();
	}

	public static void testFindByLogic1() {
		Login login = new Login("minato","1234");
		AccountDao dao = new AccountDao();
		Account result = dao.findByLogin(login);
		if(result != null &&
				result.getUserID().equals("") &&
				result.getPass().equals("1234") &&
				result.getMail().equals("minato@sukkiri.com") &&
				result.getName().equals("湊　雄輔") &&
				result.getAge() == 23) {
			System.out.println("test1:成功！");
			System.out.println();
		}else {
			System.out.println("test1:失敗！");
		}
	}
}
