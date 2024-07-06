package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.FileUpload;
import model.Product;

@WebServlet("/Product")
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view = "WEB-INF/jsp/ProductCreate.jsp";
		RequestDispatcher dispatcer = request.getRequestDispatcher(view);
		dispatcer.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String explanation = request.getParameter("explanation");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		List<String> fileNames = new ArrayList();
		
		String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
		
		Collection<Part> parts = request.getParts();
		
		FileUpload fileupload = new FileUpload();
		for (Part part : parts) {
			String fileName = fileupload.uploadFile(part, uploadPath);
			fileNames.add(fileName);
			if (fileName != null) {
				System.out.println("ファイルアップロード完了");
			}
		}
		
		Product product = new Product();
		product.setName(name);
		product.setExplanation(explanation);
		product.setPrice(price);
		product.setStock(stock);
		product.setImagePass(fileNames.get(0));
		
		fileNames.remove(0);
		
	}

}
