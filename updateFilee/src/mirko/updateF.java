package mirko;

import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateFile
 */
@WebServlet("/updateF")
public class updateF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		 if (!isMultipartContent) {
		 return;
		 }
		 FileItemFactory ff = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(ff);
		 
		 try {
		 List < FileItem > fields = upload.parseRequest(request);
		 Iterator < FileItem > at = fields.iterator();
		 if (!at.hasNext()) {
		 return;
}
		 while (at.hasNext()) {
		 FileItem fileItem = at.next();
		 
	
		
		 if (fileItem.getSize() > 0) {
			 
		 fileItem.write(new File("E:\\server\\" + fileItem.getName()));
		 String nameOfFile=fileItem.getName();
		 
		 request.setAttribute("successful", "Successful updated file : "+nameOfFile);
		 RequestDispatcher d=request.getRequestDispatcher("updateFile.jsp");
		 d.forward(request, response);
		      }
		   
	 }
} catch (Exception e) {
		 e.printStackTrace();		
		    }
		 }
	}
