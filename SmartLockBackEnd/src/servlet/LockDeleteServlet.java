package servlet;

import java.io.IOException;
import java.io.ObjectInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Lock;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServlet")
public class LockDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int lockId;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LockDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectInputStream in = new ObjectInputStream(request.getInputStream());
		try {
			this.lockId= (Integer) in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public int getLockId() {
		return this.lockId;
	}
}
