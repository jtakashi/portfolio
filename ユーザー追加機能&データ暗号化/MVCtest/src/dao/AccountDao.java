package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDao {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sukKIRIShop2";
	private final String DB_USER = "root"; //TODO 実行環境ではそれに対応したuser_idとパスワード
	private final String DB_PASS = "1234"; // id testuser pass Test1234@

	public Account findByLogin(Login login, boolean decrypt) {
		Account account = null;

		//データベースへ接続
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql ="";
			if (decrypt == true) {
				sql = "select user_id, convert(AES_DECRYPT(UNHEX(pass), 'PWD')USING utf8), mail, name, age "
						+ "from account where user_id = ? and convert(AES_DECRYPT(UNHEX(pass), 'PWD')USING utf8)=?;";
			}else {
				sql = "select user_id, pass, mail, name, age from account where user_id = ? "
						+ "and convert(AES_DECRYPT(UNHEX(pass), 'PWD')USING utf8)=?;";
			}
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserID());
			pStmt.setString(2, login.getPass());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得。
				String userId = rs.getString("USER_ID");
				String pass;
				if (decrypt == true) {
					pass = rs.getString("convert(AES_DECRYPT(UNHEX(pass), 'PWD')USING utf8)");
				}else {
					pass =rs.getString("pass");
				}
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				account = new Account(userId, pass, mail, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return account;
	}

}
//TODO LogUtil.println(this.getClass().getSimpleName() + "#update"); この機能入れたい！