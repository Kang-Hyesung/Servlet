/*=========================
 	    Test1.java
 ========================*/

// HttpServlet 을 상속받는 클래스로 설계 -> Servlet

package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HttpServlet 은 추상클래스이지만 추상메소드가 없다
public class Test1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	// 서블릿 컨테이너가 이 메소드들을 호출해서 사용하는데 
	// get 과 post 두 방식 중에서 get 방식이라고 하면 서블릿 컨테이너는 doGet 메소드를 호출한다.
	// post 방식이라고 지정하면 doPost 메소드를 호출한다.
	// 하지만 실제 이 방식으로 코딩을 하게 되면 개발자의 입장에서 코딩을 이중으로 해야 하는 문제가 생긴다
	// 그 때문에 사용자 정의 메소드를 만들어 어떤 방식이든 사용자 정의 메소드가 호출되도록 하면 편리하다
	
	// 우리가 보이지 않는 영역에서 클라이언트와 서버는 뭔가를 주고 받는다.
	
	// 사용자의 http 프로토콜 요청이 Get 방식일 경우 호출되는 메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}
	
	// 사용자의 http 프로토콜 요청이 Post 방식일 경우 호출되는 메소드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Get 방식이든 Post 방식이든
		// 어던 방식의 요청에도 모두 처리할 수 있는 사용자 정의 메소드
		/* 
		// 1
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<htm1>");
		pw.println("<head>");
		pw.println("<title>" + "Test1.java" + "</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div>");
		pw.println("<h1>name : " + "홍길동" + "</h1>");
		pw.println("<h1>age : " + 19 + "</h1>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</htm1>");
		
		// 서블릿 컨테이너가 메소드를 호출함
		// web.xml 통해 일함
		 */
		
		// 2
		/*		이 상태라면 나중에 변경하고 싶을 때 프로젝트를 재구성해야 한다.
		String name = "길현욱";
		int age = 21;
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		
		pw.println("<htm1>");
		pw.println("<head>");
		pw.println("<title>" + "Test1.java" + "</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div>");
		pw.println("<h1>name : " + name + "</h1>");
		pw.println("<h1>age : " + age + "</h1>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</htm1>");
		*/
		
		// 3
		
		// 이 구조는 web.xml부터 불러온 데이터를 가지고 오는 것이기 때문에
		// 배포 후라도 xml파일만 변경해주면 된다.
		
		// ServletConfig
		// 컨테이너가 서블릿을 초기화할 때
		// 서블릿 당 하나씩 ServletConfig 을 생성하게 된다.
		ServletConfig config = getServletConfig();
		
		// web.xml 에 <init-param>
		String name = config.getInitParameter("name");
		String age = config.getInitParameter("age");
		
		/*
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<htm1>");
		pw.println("<head>");
		pw.println("<title>" + "Test1.java" + "</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div>");
		pw.println("<h1>name : " + name + "</h1>");
		pw.println("<h1>age : " + age + "</h1>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</htm1>");
		*/
		
		// 4
		
		// ServletContext
		// ServletConfig 는 서블릿에 대한 환경을 설정하는 과정에서
		// 필요한 값들을 전달하는 형태로 주로 사용된다면
		// ServletContext 는 서블릿에서 사용되는 컨텍스트를
		// 구성하는 형태로 활용된다.
		ServletContext context = getServletContext();
		
		String type = context.getInitParameter("type");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<htm1>");
		pw.println("<head>");
		pw.println("<title>" + "Test1.java" + "</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div>");
		pw.println("<h1>name : " + name + "</h1>");
		pw.println("<h1>age : " + age + "</h1>");
		
		pw.println("<h1>type : " + type + "</h1>");
		
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</htm1>");
		
	}
	
}


















