package com.plugtree.smartknowledgediscovery.client.datasources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.plugtree.smartknowledgediscovery.client.services.QuestionService;
import com.plugtree.smartknowledgediscovery.client.services.QuestionServiceAsync;
import com.plugtree.smartknowledgediscovery.client.utils.Field;
import com.plugtree.smartknowledgediscovery.client.utils.KeyField;
import com.plugtree.smartknowledgediscovery.client.utils.StringValidator;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

public class QuestionnaireDataSource extends GenericDataSource<Questionnaire> {

	private QuestionServiceAsync service;
    private static QuestionnaireDataSource instance = null;	
	
    public static QuestionnaireDataSource getInstance() {
        if(instance == null) {
           instance = new QuestionnaireDataSource();
        }
        return instance;
     }
	
    
    private QuestionnaireDataSource() {

	    service = GWT.create(QuestionService.class);
		((ServiceDefTarget)service).setServiceEntryPoint(GWT.getModuleBaseURL() + "questionnaire");

		fetch();
		
		Field textField = new Field("Text", new StringValidator(true, 200));
		Field notesField = new Field("Notes", new StringValidator(true, 200));
		Field idField = new KeyField("Id");

	    addField(idField);
		addField(textField);
		addField(notesField);
	}
    
	
	@Override
	public boolean fetch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fetchWithFilter(String filter) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Questionnaire element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Questionnaire element) {
		// TODO Auto-generated method stub
		return false;
	}

}
