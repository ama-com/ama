package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.FileUploader;
import model.Product;
import model.ProductData;

@WebServlet("/ProductCreate")
@MultipartConfig
public class ProductCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view = "WEB-INF/jsp/ProductForm.jsp";
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
		
		Part filePart = request.getPart("image");
		String applicationPath = request.getServletContext().getRealPath("");
		System.out.println(applicationPath);

		FileUploader uploader = new FileUploader(filePart, applicationPath);
		String filePath = uploader.fileUploader();
		
		ProductData productData = new ProductData();
		
		productData.setName(name);
		productData.setExplanation(explanation);		
		productData.setPrice(price);
		productData.setStock(stock);
		productData.setImagePass(filePath);
		
		Product product = new Product(productData);
		product.createProduct();
		
		request.setAttribute("Product", product);
		
		String view = "WEB-INF/jsp/ProductResult.jsp";
		RequestDispatcher dispatcer = request.getRequestDispatcher(view);
		dispatcer.forward(request, response);
	}

}
