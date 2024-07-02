package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Authentication;
import tmp.Account;

@WebServlet("/Authentication")

public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Httpsession session = 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		リクエストを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
//		データをアカウントに格納
		Account account = new Account(name,password);
//		ログイン処理
		Authentication loginlogic = new Authentication();
		boolean isLogin = loginlogic.login(account);
		
//		ログイン成功時の処理
		if (isLogin) {
//			アカウントをセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", account);
			
//			ユーザー画面にリダイレクト
			response.sendRedirect("General");
		}
	}

}
