package servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DbAdapter;
import entities.User;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServlet")
public class UserReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private User user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectInputStream in = new ObjectInputStream(request.getInputStream());
		try {
			user = (User) in.readObject();
			User userInfo = DbAdapter.readUser(user);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			out.writeObject(userInfo);
			out.flush();
			out.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User getUser() {
		return this.user;
	}
}
