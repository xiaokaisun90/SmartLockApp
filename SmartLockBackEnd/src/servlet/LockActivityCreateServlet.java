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
import entities.*;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/LockActivityCreate")
public class LockActivityCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LockActivity lockActivity;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LockActivityCreateServlet() {
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
		ObjectInputStream in = new ObjectInputStream(request.getInputStream());
		try {
			this.lockActivity= (LockActivity) in.readObject();
			String info = DbAdapter.createLockActivity(lockActivity);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			out.writeObject(info);
			out.flush();
			out.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public LockActivity getLockActivity() {
		return this.lockActivity;
	}

}
