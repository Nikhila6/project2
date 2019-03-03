package bean;

<<<<<<< HEAD
import javax.persistence.*;

=======
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * This class represents the Question table
 *  
 * @author jinalpatel
 * @since 02/16/2019
 * @version 1.0.0
 *
 */
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
@Entity
@Table(name = "Question")
public class Question {
	@Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Question_id")
    private int questionId;

	@ManyToOne(cascade = {CascadeType.ALL})
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Question_id")
    private int questionId;

	@ManyToOne(cascade = {CascadeType.REFRESH})
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
	@JoinColumn(name = "Quiz_Id")
	private Quiz quiz;

    @Column(name = "Question")
    private String question;

    @Column(name = "Is_Multiple")
    private boolean isMultiple;
    
    @Column(name = "Points")
    private int points;

<<<<<<< HEAD
=======
    
    //For the answer side
    @OneToMany(mappedBy = "question",orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Answer> answerList = new ArrayList<Answer>();
    
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba

	public Question(Quiz quiz, String question, boolean isMultiple, int points) {
		super();
		this.quiz = quiz;
		this.question = question;
		this.isMultiple = isMultiple;
		this.points = points;
	}
	
	public Question(Quiz quiz,int questionId, String question, boolean isMultiple, int points) {
		super();
		this.quiz = quiz;
		this.question = question;
		this.isMultiple = isMultiple;
		this.points = points;
		this.questionId = questionId;
	}

	public Question() {
	}

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Question{" +
				"questionId=" + questionId +
				", quiz=" + quiz +
				", question='" + question + '\'' +
				", isMultiple=" + isMultiple +
				", points=" + points +
				'}';
	}
}
