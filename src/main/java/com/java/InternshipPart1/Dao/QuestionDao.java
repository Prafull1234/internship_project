package com.java.InternshipPart1.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.InternshipPart1.Model.Question;

@Repository
public class QuestionDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void saveQuestion(Question q) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(q);
	}

	@Transactional
	public List<Question> getQuestions() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Question> q = session.createQuery("from Question", Question.class);
		List<Question> questions = q.list();
		
			
		return questions;
	}

	@Transactional
	public List<Question> getTestQuestions() {
		
		Session session = sessionFactory.getCurrentSession();
		NativeQuery<Question> query = session.createNativeQuery("select * from question order by random() limit 10",Question.class);
		List<Question> questions = query.list();
		return questions;
		
		
	}

}
