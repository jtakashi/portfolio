package test;

import dao.AccountDao;
import model.Account;
import model.Login;

public class RegisterDaoTest {
	public static void main(String[] args) {
		testFindByLogic1();
//		testFindByLogic2();
	}

	public static void testFindByLogic1() {
		Login login = new Login("itou","aiue");
		AccountDao dao = new AccountDao();
		Account result = dao.findByLogin(login,false );
		if(result != null &&
				result.getUserID().equals("itou") &&
				//result.getPass().equals("aiue") &&
				result.getMail().equals("ito@example.com") &&
				result.getName().equals("伊藤　弘樹") &&
				result.getAge() == 23) {
			System.out.println("test1:成功！");
			System.out.println();
		}else {
			System.out.println("test1:失敗！");
		}
	}
}
