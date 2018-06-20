package com.java.InternshipPart1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.InternshipPart1.Dao.QuestionDao;
import com.java.InternshipPart1.Model.Question;

public class Questioncontroller {
	@Autowired
	QuestionDao qDao;
	
		@RequestMapping("saveQuestion.htm")
		public ModelAndView saveQuestion(@ModelAttribute Question q)
		{
			
			ModelAndView mv = new ModelAndView("printQuestions.jsp");
			qDao.saveQuestion(q);
			return mv;
		}

		@RequestMapping("getQuestions")
		@ResponseBody
		public List<Question> getQuestions()
		{
			List<Question> questions = qDao.getTestQuestions();
			
			//System.out.println(questions);
			
			return questions;
		}
}
