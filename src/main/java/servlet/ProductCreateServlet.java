package servlet;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.ProductData;

@WebServlet("/Product")
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads";

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
		
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
		
		File uploadDir = new File(uploadFilePath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		Part filePart = request.getPart("image");
		String fileName = filePart.getSubmittedFileName();
		String filePath = uploadFilePath + File.separator + fileName;
		filePart.write(filePath);
		
		ProductData productData = new ProductData();
		
		productData.setName(name);
		productData.setExplanation(explanation);
		productData.setPrice(price);
		productData.setStock(stock);
		productData.setImagePass(filePath);
		
		RequestDispatcher("WEB-INF/jsp/productResult.jsp");
	}

}
