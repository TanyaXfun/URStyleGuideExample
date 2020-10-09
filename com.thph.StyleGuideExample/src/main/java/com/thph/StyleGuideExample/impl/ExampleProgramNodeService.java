package com.thph.StyleGuideExample.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.data.DataModel;


public class ExampleProgramNodeService implements SwingProgramNodeService<ExampleProgramNodeContribution, ExampleProgramNodeView> {

	@Override
	public String getId() {

		return "examplenode";
	}

	@Override
	public void configureContribution(ContributionConfiguration configuration) {

		configuration.setChildrenAllowed(false);
	
	}

	@Override
	public String getTitle(Locale locale) {
	
		return "Example ProgramNode";
	}

	@Override
	public ExampleProgramNodeView createView(ViewAPIProvider apiProvider) {
		return new ExampleProgramNodeView();

	}

	@Override
	public ExampleProgramNodeContribution createNode(ProgramAPIProvider apiProvider, ExampleProgramNodeView view,
			DataModel model, CreationContext context) {

		return new ExampleProgramNodeContribution(apiProvider, view, model, context);
	}

}