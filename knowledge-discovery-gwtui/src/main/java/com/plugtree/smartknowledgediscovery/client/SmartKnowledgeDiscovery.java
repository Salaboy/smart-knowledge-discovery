package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartKnowledgeDiscovery implements EntryPoint {

	private Button addButton = new Button("Add");
	private VerticalPanel panel = new VerticalPanel();
	
	@Override
    public void onModuleLoad() {

		QuestionDataSource dataSource = QuestionDataSource.getInstance();

		QuestionTable questionTable = new QuestionTable(dataSource);

		panel.add(questionTable);
		panel.add(addButton);

		RootLayoutPanel.get().add(panel);

		addStyle();
	}

	private void addStyle() {
	    addButton.addStyleName("button");
	}
}