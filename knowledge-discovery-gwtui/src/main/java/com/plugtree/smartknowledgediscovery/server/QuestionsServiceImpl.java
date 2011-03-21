package com.plugtree.smartknowledgediscovery.server;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.QuestionsService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.services.ServiceException;
import com.plugtree.smartprocessdiscovery.services.impl.QuestionServiceImpl;

@SuppressWarnings("serial")
public class QuestionsServiceImpl extends RemoteServiceServlet implements QuestionsService {

    private LinkedList<Question> questionList = new LinkedList<Question>();
    private QuestionServiceImpl questionService;
    
  
	public QuestionsServiceImpl() throws ServiceException {
    	
    	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
    	System.out.println(applicationContext.toString());
    	System.out.println(applicationContext.containsBean("questionService"));
    	questionService = (QuestionServiceImpl) applicationContext.getBean("questionService");
     
    	System.out.println(questionService.toString());
    	    	
        Question question1 = new Question("what?");
        question1.setId(new Long(1));
        question1.setNotes("Amazing");

        Question question2 = new Question("how?");
        question2.setId(new Long(2));
        question2.setNotes("Impressive");

        //questionList.add(question1);
        //questionList.add(question2);
       
        questionService.create(question1.getText(),question1.getNotes());
        questionService.create(question2.getText(),question2.getNotes());
        
    }

	@Override
    public List<Question> fetch() {
				
	    return (List<Question>) questionService.findAll();
	}

    @Override
    public List<Question> add(Question question) {

        questionService.create(question.getText(), question.getNotes());

        return (List<Question>) questionService.findAll();
    }

    @Override
    public List<Question> remove(Long questionId) {

    	try {
			questionService.remove(questionId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return (List<Question>) questionService.findAll();
    }

    @Override
    public List<Question> update(Question question){

       try {
		questionService.update(question.getId(), question.getText(), question.getNotes());
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
       return (List<Question>) questionService.findAll();
    }
}