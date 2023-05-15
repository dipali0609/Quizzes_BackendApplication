package com.quiz.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Quiz {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Question is mandatory")
	    private String question;

	    
	    @ElementCollection
	    private List<String> options;

	    @NotNull(message = "Right answer index is mandatory")
	    private Integer rightAnswer;

	    @NotNull(message = "Start date is mandatory")
	    private LocalDateTime startDate;

	    @NotNull(message = "End date is mandatory")
	    private LocalDateTime endDate;

	    @Enumerated(EnumType.STRING)
	    private QuizStatus status;

	 // constructors, getters, setters, and other methods
		public Quiz() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Quiz(Long id, @NotBlank(message = "Question is mandatory") String question, List<String> options,
				@NotNull(message = "Right answer index is mandatory") Integer rightAnswer,
				@NotNull(message = "Start date is mandatory") LocalDateTime startDate,
				@NotNull(message = "End date is mandatory") LocalDateTime endDate, QuizStatus status) {
			super();
			this.id = id;
			this.question = question;
			this.options = options;
			this.rightAnswer = rightAnswer;
			this.startDate = startDate;
			this.endDate = endDate;
			this.status = status;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public List<String> getOptions() {
			return options;
		}

		public void setOptions(List<String> options) {
			this.options = options;
		}

		public Integer getRightAnswer() {
			return rightAnswer;
		}

		public void setRightAnswer(Integer rightAnswer) {
			this.rightAnswer = rightAnswer;
		}

		public LocalDateTime getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDateTime startDate) {
			this.startDate = startDate;
		}

		public LocalDateTime getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDateTime endDate) {
			this.endDate = endDate;
		}

		public QuizStatus getStatus() {
			return status;
		}

		public void setStatus(QuizStatus status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Quiz [id=" + id + ", question=" + question + ", options=" + options + ", rightAnswer=" + rightAnswer
					+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
		}
	}

//PostMan InputBody
//"question":"What Is Variable?",
//"options":["a,b,c,d"],
//"rightAnswer":1,
//"startDate":"2023-05-15T00:02:00.012438300",
//"endDate":"2023-05-15T00:05:00.012438300"
