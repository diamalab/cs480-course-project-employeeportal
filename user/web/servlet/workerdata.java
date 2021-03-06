package user.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.client;
import user.domain.worker;

/**
 * Servlet implementation class workerdata
 */

public class workerdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public workerdata() {
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
		// TODO Auto-generated method stub
		
		
		UserDao user = new UserDao();
		Map<String,String[]> paramMap = request.getParameterMap();//(return the object of map)
		worker form = new worker();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) { //keyset contains the keys of specified map here paramMap (which is taking input from
			//our createclientaccount so its column name is our key and value will paramMap.keyset)
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		form.setName(info.get(1));
		form.setAge(Integer.parseInt(info.get(2)));
		form.setEmail(info.get(3));
		form.setWorkerType(info.get(4));
		form.setSkill(info.get(5));
		form.setSalaryRange(info.get(6));
		form.setReviews(Integer.parseInt(info.get(7)));
		
		try {
			user.add_worker_details(form);
			request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
