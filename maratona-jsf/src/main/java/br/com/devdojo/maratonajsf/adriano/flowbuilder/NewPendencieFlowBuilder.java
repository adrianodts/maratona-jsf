package br.com.devdojo.maratonajsf.adriano.flowbuilder;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class NewPendencieFlowBuilder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Produces
	@FlowDefinition
	public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder ) {
		String flowId = "newpendencie";
		flowBuilder.id("", flowId);
		flowBuilder.viewNode(flowId, "/newpendencie/newpendencie.xhtml").markAsStartNode();
		flowBuilder.returnNode("proceedToNewRegistration3").fromOutcome("newregistration/newregistration3.xhtml");
		flowBuilder.returnNode("exitToNewRegistration").fromOutcome("newregistration/newregistration.xhtml");
		flowBuilder.inboundParameter("userName", "#{testeFlowBuilderNestedBean.userName}");
		flowBuilder.inboundParameter("userSurname", "#{testeFlowBuilderNestedBean.userSurname}");
		return flowBuilder.getFlow();
	}
}
