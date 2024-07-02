package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tmp.Account;

public class AuthenticationDAO implements Dao {
	@Override
	public List<Object> searchAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean search(Object object) {
		// TODO 自動生成されたメソッド・スタブ
		Account account;
		boolean result = false;
		if ( object instanceof Account) {
			account = (Account) object;
		} else {
			System.err.println("渡された引数が不正のため認証できませんでした");
			return false;
		}
//		JDBCドライバを読み込む
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
//		データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			SELECT文を実行する
			String sql = 
					"SELECT COUNT(*) FROM ACCOUNT WHERE NAME = ? AND PASSWORD = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, account.getName());
			pStmt.setString(2, account.getPassword());
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				int count = rs.getInt(1);
				result = count == 1;
			}
			} catch (SQLException e) {
				e.printStackTrace();
				result = false;
			}
		return result;
		}

	@Override
	public boolean create(Object object) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean remove(Object object) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
