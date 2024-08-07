package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductData;
import model.TopModel;

@WebServlet("/Top")
/**
 * Servlet implementation class TopServlet
 */
public class TopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public TopServlet() {
        // コンストラクタ
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TopModel topModel = new TopModel(); // データを取得するためのモデルを生成
        List<ProductData> productList = topModel.execute(); // DAOからデータを取得

        request.setAttribute("productList", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // POSTメソッドの処理（今回はコメントアウト）
    }

}
