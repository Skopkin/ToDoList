
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ToDoController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ToDoItem item = new ToDoItem();
	ToDoDao dao = new ToDoDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		if (request.getParameter("addItem") != null) {
			String task = request.getParameter("task");
			item.setTask(task);
			dao.saveItem(item);
			RequestDispatcher rd = request.getRequestDispatcher("ToDoAdd.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("showItem") != null) {
			List<ToDoItem> list = new ArrayList<ToDoItem>();
			list = dao.showAllTasks();
			request.setAttribute("ToDoList", list);
			RequestDispatcher rd = request.getRequestDispatcher("ToDoView.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("updateItem") != null) {
			int id = Integer.parseInt(request.getParameter("taskSelect"));
			String task = request.getParameter("uTask");
			item.setId(id);
			item.setTask(task);
			dao.updateItem(item);
			RequestDispatcher rd = request.getRequestDispatcher("ToDoAdd.jsp");
			rd.forward(request, response);
		}
		
		if (request.getParameter("deleteItem") != null) {
			int id = Integer.parseInt(request.getParameter("taskSelect"));
			dao.deleteItem(id);
			RequestDispatcher rd = request.getRequestDispatcher("ToDoAdd.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
