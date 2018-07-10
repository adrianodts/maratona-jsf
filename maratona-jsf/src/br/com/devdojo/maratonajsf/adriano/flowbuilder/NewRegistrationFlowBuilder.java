package br.com.devdojo.maratonajsf.adriano.flowbuilder;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class NewRegistrationFlowBuilder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Produces
	@FlowDefinition
	public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder ) {
		String flowId = "newregistration";
		flowBuilder.id("", flowId);
		flowBuilder.viewNode(flowId, "/newregistration/newregistration.xhtml").markAsStartNode();
		flowBuilder.viewNode(flowId, "/newregistration/newregistration2.xhtml");
		flowBuilder.viewNode(flowId, "/newregistration/newregistration3.xhtml");
		flowBuilder.switchNode("newRegistrationPage2")
			.defaultOutcome(flowId)
			.switchCase()
			.condition("#{not empty testeFlowBuilderBean.nome and not empty testeFlowBuilderBean.sobreNome}")
			.fromOutcome("newregistration2");
		flowBuilder.flowCallNode("callNewPendencie")
			.flowReference("", "newpendencie")
			.outboundParameter("userName", "#{testeFlowBuilderBean.nome}")
			.outboundParameter("userSurname", "#{testeFlowBuilderBean.sobreNome}");
		flowBuilder.returnNode("exitToInicio").fromOutcome("inicioFlow.xhtml");
		flowBuilder.returnNode("exitToIndex").fromOutcome("index.xhtml");
		flowBuilder.finalizer("#{testeFlowBuilderBean.salvar}");
		return flowBuilder.getFlow();
	}
}
