package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[] args) {
		testExecute1();
	}

	public static void testExecute1() {
		Login login = new Login("minato","1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(result) {
			System.out.println("testE1:成功！");
		}else {
			System.out.println("tesE1:失敗。。。");
		}
	}
}
