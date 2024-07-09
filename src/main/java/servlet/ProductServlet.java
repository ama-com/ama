package servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Product")
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view = "WEB-INF/jsp/ProductForm.jsp";
		RequestDispatcher dispatcer = request.getRequestDispatcher(view);
		dispatcer.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		create Upload file
		String uploadPath = getServletContext().getRealPath("/") + File.separator + "uploads";

        String fname = request.getParameter("path");
        String dir = getServletContext().getRealPath("/");
        BufferedImage im = null;
        
        // イメージの読み込み
        File f = new File(dir + fname);
        if (f.exists()) {
            try {
                im = ImageIO.read(f);
            } catch (IOException e) {
                System.out.println("can't read from file.");
                im = new BufferedImage(300,200,
                        BufferedImage.TYPE_INT_RGB); // 仮のイメージ
            }
        } else {
            im = new BufferedImage(300,200,
                    BufferedImage.TYPE_INT_RGB); // 仮のイメージ
        }

        // イメージの書き出し
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(dir + "new_saved.png");
            ImageIO.write(im,"png",out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                out.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
        // リダイレクト
        getServletContext().getRequestDispatcher("/test.jsp")
                .forward(request, response);
    }

}
