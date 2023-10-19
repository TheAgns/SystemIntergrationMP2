package org.camunda.bpm.getstarted.loanapproval.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;


@Named('helloworld')
public class HelloWorldDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution){
        System.out.println("Hello world");
    }
}
