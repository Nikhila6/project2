package edu.asu.ser516.quiz.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asu.ser516.quiz.dao.impl.QuizDetailsDao;
import edu.asu.ser516.quiz.model.QuizModel;

@SuppressWarnings("serial")
public class QuizDetailsController extends HttpServlet {
	
    private static QuizDetailsDao quizDetailsDao = null;

    public void init(ServletConfig config) throws ServletException {
	// if you forget this your getServletContext() will get a NPE! 
	super.init(config);
	
		quizDetailsDao = new QuizDetailsDao();
    }

    
    @SuppressWarnings("static-access")
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException	{
    	
    	//set Content-Type and other response headers
    	res.setHeader("Cache-Control", "no-cache") ;
        res.setContentType("text/html");
        
    	//process request headers
    	
    	//process request parameters
        String action = req.getParameter("Action");
    	String title = req.getParameter("title");
    	String instructions = req.getParameter("instructions");
    	String assignmentGroup = req.getParameter("assignmentGroup");
    	String shuffled = req.getParameter("shuffled");
    	String graded = req.getParameter("graded");
    	String time = req.getParameter("timeLimit");
    	String multipleAttempt = req.getParameter("multipleAttempt");
    	
    	Boolean isShuffled = false;
    	Boolean isGraded = false;
    	Integer timeLimit = 0;
    	Boolean isMultipleAttempt = false;
    	
    	//perform processing and aggregate response payload
    	try {
    		if(action.equals("Submit")) {
    			if(Pattern.matches("[a-zA-Z0-9][a-zA-Z0-9]*", title) && Pattern.matches("[0-9][0-9]*", time)) {
    				
    				if(shuffled != null && shuffled.equals("true"))
    					isShuffled = true;
    				if(graded != null && graded.equals("true"))
    					isGraded = true;
    				if(time != null)
    					timeLimit = Integer.valueOf(time);
    				if(multipleAttempt != null && multipleAttempt.equals("true"))
    					isMultipleAttempt = true;
    				
    				QuizModel quizModel = quizDetailsDao.findByPrimaryKey(title);
    				
    				if(quizModel != null)
    					res.sendError(HttpServletResponse.SC_BAD_REQUEST,"This Quiz already Exists!");
    				else {
    					quizModel = new QuizModel(title, instructions,assignmentGroup, isShuffled, isGraded, timeLimit, isMultipleAttempt);
    					quizDetailsDao.insert(quizModel);
    					req.getRequestDispatcher("Success.html").forward(req, res);
    				}
    		
    			}
    			else {
    				res.sendError(HttpServletResponse.SC_BAD_REQUEST,"Wrong Parameters Sent!");
    			}
    		}
    		else {
    			req.getRequestDispatcher("index.html").forward(req, res);
    		}
    	}
    	catch (Exception exc) {
    		res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
    		exc.printStackTrace();
	    }
    	
    }
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException	{
    	res.setHeader("Cache-Control", "no-cache") ;
        res.setContentType("text/html");
	res.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "GET not supported by this servlet");
    }
}