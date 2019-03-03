package controller;

import java.io.IOException;
<<<<<<< HEAD
import java.sql.Time;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
=======
import java.util.List;
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD

import bean.Answer;
import bean.Question;
import bean.Quiz;
import dao.ProfessorDAO;
import dao.QuestionDAO;
=======
import bean.Question;
import bean.Quiz;
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
import services.ProfessorServices;

/**
 * This is the controller for managing professor side of the quiz.
 *
 * @version 1.0
 * @since 02-16-2019
<<<<<<< HEAD
 * @authors Aneesh, Gangadhar, Janice, Jinal, Viraj
 */
public class ProfessorServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The professor services. */
	private ProfessorServices professorServices = new ProfessorServices();

=======
 * @authors  Gangadhar, Janice, Jinal
 */
@SuppressWarnings("serial")
public class ProfessorServlet extends HttpServlet {

	ProfessorServices professorServices = new ProfessorServices();
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
	/**
	 * This method will handle the get requests. Each request will have a flag that
	 * determines the service
	 * 
	 * @param request  request object from the jsp page
	 * @param response response to be sent to the jsp page
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
<<<<<<< HEAD
		if ("fetchQuizList".equalsIgnoreCase(flag)) {
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);
		} else if ("publishQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizID = Integer.parseInt(id);
			professorServices.publishQuiz(quizID);
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);
		} else if ("viewQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizId = Integer.parseInt(id);
			String quizName = request.getParameter("quizName");
			List<Question> questions = professorServices.getAllQuestionFromQuizID(quizId);
			List queAnsData = professorServices.getAllAnswersFromQueList(questions);
			request.setAttribute("quizName", quizName);
			request.setAttribute("queAnsData", queAnsData);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuestionstoProfessor.jsp");
			rd.forward(request, response);	
		
		}else if("addQueInQuiz".equalsIgnoreCase(flag)) {
			
			String quizID = request.getParameter("id");
			int quizId = Integer.parseInt(quizID);
			
			ProfessorDAO professorDAO = new ProfessorDAO();
			Quiz quiz = professorDAO.getQuizFromID(quizId);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("quiz", quiz);
			
			response.sendRedirect(request.getContextPath()+"/views/addQuestions.jsp");

=======
		
		if ("fetchQuizList".equalsIgnoreCase(flag)) {
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp").forward(request, response);
		} 
		else if ("publishQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizID = Integer.parseInt(id);
			professorServices.publishQuiz(quizID);
			request.setAttribute("quizList", professorServices.getAllQuizzes());
			getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp").forward(request, response);
		} 
		else if ("viewQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			String quizName = request.getParameter("quizName");
			int quizId = Integer.parseInt(id);
			List<Quiz> quizList = professorServices.getAllQuizzes();
			List<Question> questions = professorServices.getAllQuestionFromQuizID(quizId);
			List queAnsData = professorServices.getAllAnswersFromQuestionList(questions);
			request.setAttribute("quizList", quizList);
			request.setAttribute("quizName", quizName);
			request.setAttribute("queAnsData", queAnsData);
			getServletContext().getRequestDispatcher("/views/displayQuestionstoProfessor.jsp").forward(request, response);	
		}
		else if("addQuestionInQuiz".equalsIgnoreCase(flag)) {
			String quizID = request.getParameter("id");
			int quizId = Integer.parseInt(quizID);
			Quiz quiz = professorServices.getQuizFromID(quizId);
			HttpSession session = request.getSession(true);
			session.setAttribute("quiz", quiz);
			session.setAttribute("quiz", quiz);
			response.sendRedirect(request.getContextPath()+"/views/addQuestions.jsp");
		}
		else if ("professorLanding".equalsIgnoreCase(flag)) {
			getServletContext().getRequestDispatcher("/views/professorLanding.jsp").forward(request, response);
		}
		else if ("logout".equalsIgnoreCase(flag)) {
			request.getSession().invalidate();
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
		}
	}

	/**
	 * This method will handle the post requests. Each request will have a flag that
	 * determines the service
	 * 
	 * @param request  request object from the jsp page
	 * @param response response to be sent to the jsp page
	 */
<<<<<<< HEAD
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if ("InsertProfDetails".equals(flag)) {
			ProfessorServices professorServices = new ProfessorServices();
			professorServices.insertProfDetails(request);
			response.sendRedirect("views/professorLanding.jsp");
		}
		else if("DeleteQuestion".equals(flag)){
	        String quesId = request.getParameter("box1");
			QuestionDAO questionDAO = new QuestionDAO();
			questionDAO.deleteQuestionByQuestionId(quesId);
            response.sendRedirect("views/removeQuestionPage.jsp");
            
        }else if("Add Next Question".equals(flag) || "Save and Exit".equals(flag)) {
			

        	String question = request.getParameter("question").trim();
        	String questionOption1 = request.getParameter("option1").trim();
        	String questionOption2 = request.getParameter("option2").trim();
        	String questionOption3 = request.getParameter("option3").trim();
        	String questionOption4 = request.getParameter("option4").trim();
        	String points = request.getParameter("points");
        	String[] correctanswers = (String[]) request.getParameterValues("options");
     
        	
			HttpSession session = request.getSession(true);
			
    
			professorServices = new ProfessorServices();
			professorServices.storeQuestion((Quiz)session.getAttribute("quiz"), question, questionOption1,
					questionOption2, questionOption3, questionOption4, correctanswers, points);
			
        	String addQuestionPageURL = request.getContextPath() + "/ProfessorController";
        	request.setAttribute("profnavigate", addQuestionPageURL); 
        	if("Add Next Question".equals(flag)) {
        		response.sendRedirect("views/addQuestions.jsp");
        		return;
        	}else if("Save and Exit".equals(flag)) {
        		response.sendRedirect("views/professorLanding.jsp");
            	return;
        	}
        
        	
		}else if("Verify Questions".equals(flag)) {
        	response.sendRedirect("views/displayQuestionAnswer.jsp");
        	return;
        }
    }


		
=======
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if ("insertQuizDetails".equals(flag)) {		
			HttpSession sess = request.getSession(true);
			String quizName = request.getParameter("name");
	        String quizInstructions = request.getParameter("instructions");
	        String quizType = request.getParameter("quiz_type");
	        String isTimeLimitSet = request.getParameter("time_limit");
	        String shuffle = request.getParameter("shuffle");
	        String hours = request.getParameter("hours");
        	String minutes = request.getParameter("minutes");
			Quiz quiz = professorServices.insertQuizDetails(quizName,quizInstructions,quizType,
					isTimeLimitSet,hours,minutes, shuffle);
			sess.setAttribute("quizType", quizType);
			sess.setAttribute("quiz", quiz);
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp").forward(request, response);
		} 
		else if ("deleteQuestion".equals(flag)) {
			String quesID = request.getParameter("quesId");
			String flag1 = request.getParameter("flagOld");
			String id = request.getParameter("quizId");
			String quizName = request.getParameter("quizName");
			professorServices.deleteQuestionByQuestionId(quesID);
			response.sendRedirect("ProfessorController?" + "flag="+ flag1 + 
					"&id="+id + "&quizName=" + quizName);
		}  
		else if ("editQuestion".equals(flag)) {
			String quesId = request.getParameter("quesId");
			String quizId = request.getParameter("quizId");
			int quizid = Integer.parseInt(quizId);
			List<Question> questions = professorServices.getAllQuestionFromQuizID(quizid);
			List queAnsData = professorServices.getAllAnswersFromQuestionList(questions);
			request.setAttribute("quesId", quesId);
			request.setAttribute("queAnsData", queAnsData);
			request.getRequestDispatcher("views/canEditQuestion.jsp").forward(request, response);
		}
		else if ("addNextQuestion".equals(flag) || "saveAndExit".equals(flag)) {
			
			String question = request.getParameter("question");
			String questionOptions1 = request.getParameter("questionOptions1");
			String questionOptions2 = request.getParameter("questionOptions2");
			String questionOptions3 = request.getParameter("questionOptions3");
			String questionOptions4 = request.getParameter("questionOptions4");
			
			String[] optionArray = {questionOptions1, questionOptions2, questionOptions3,questionOptions4};
			String points;
			if(request.getParameter("points") == null) 
				points = "0";
			else
				points = request.getParameter("points");
			
			String[] correctanswers = request.getParameterValues("options");
			HttpSession session = request.getSession(true);
			Quiz quiz = (Quiz)session.getAttribute("quiz");
			request.setAttribute("id", quiz.getQuizId());
			request.setAttribute("quizName", quiz.getQuizName());
			
			professorServices.storeQuestion(question, optionArray,points, correctanswers, quiz);
        	String addQuestionPageURL = request.getContextPath() + "/ProfessorController";
        	request.setAttribute("profnavigate", addQuestionPageURL); 
        	if("addNextQuestion".equals(flag)) {
        		response.sendRedirect("views/addQuestions.jsp");
        	}else if("saveAndExit".equals(flag)) {
        		List<Quiz> quizList = professorServices.getAllQuizzes();
    			request.setAttribute("quizList", quizList);
    			getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp").forward(request, response);
        	}
		}
		else if("saveEdited".equals(flag))
		{
			professorServices.saveEdited(request);
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp").forward(request, response);
		}
    }
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
}