package cn.hbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;

import cn.hbc.entity.PageBean;
import cn.hbc.entity.Student;
import cn.hbc.service.StudentService;
import cn.hbc.service.StudentServiceImpl;

public class StudentServlet extends HttpServlet {

	StudentService service = new StudentServiceImpl();
	public StudentServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PageBean pageBean = new PageBean();
		pageBean.setTotalCount(service.getCount());
		String curPage = request.getParameter("curPage");
		//System.out.println("curPage1 --> " + curPage);
		if(StringUtils.isNullOrEmpty(curPage) || Integer.parseInt(curPage) <= 0){
			curPage = "1";
		}else if(Integer.parseInt(curPage) > pageBean.getTotalPage()){
			curPage = "" + pageBean.getTotalPage();
		}
		//System.out.println("curPage2 --> " + curPage);
		int l = (Integer.parseInt(curPage) - 1) * pageBean.getPageCount();
		int r = pageBean.getPageCount();
		
		List<Student> list = service.query(l, r);
		pageBean.setList(list);
		pageBean.setCurPage(Integer.parseInt(curPage));
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
