package com.virtualpairprogrammers;

import org.junit.Before;
import org.junit.Test;


import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RepaymentAmountTest {

    // Spy: it will actually create an instance of our new LoanApplication, but it will also allow us to override some of its methods
    // When we do mock we have to pass the class type, but for spy we will have to pass the instantiated object
    @Spy
    LoanApplication loanApplication;

    @Before
    public void setup(){

    }

    @Test
    public void test1YearLoanWholePounds() {

        loanApplication = Mockito.spy(new LoanApplication());
        loanApplication.setPrincipal(1200);
        loanApplication.setTermInMonths(12);
        //TODO: set the interest rate to 10%
        //doReturn(return_value).when(spy_object).method_call(params);
        //isThrownBy(() -> doReturn(10).when(loanApplication).getRepayment());
        doReturn(new BigDecimal(10)).when(loanApplication).getInterestRate();

        LoanRepository repository = mock(LoanRepository.class);
        RestTemplate restTemplate = mock(RestTemplate.class);
        JavaMailSender data = mock(JavaMailSender.class);

        LoanCalculatorController controller =  new LoanCalculatorController();

        controller.setData(repository);
        controller.setRestTemplate(restTemplate);
        controller.setMailSender(data);

        controller.processNewLoanApplication(loanApplication);

        assertEquals(new BigDecimal(110), loanApplication.getRepayment());
    }

    @Test
    public void test2YearLoanWholePounds() {
        loanApplication = spy(new LoanApplication());
        loanApplication.setPrincipal(1200);
        loanApplication.setTermInMonths(24);
        //TODO: set the interest rate to 10%
        //doReturn(return_value).when(spy_object).method_call(params);
        doReturn(new BigDecimal(10)).when(loanApplication).getRepayment();

        LoanRepository repository = mock(LoanRepository.class);
        RestTemplate restTemplate = mock(RestTemplate.class);
        JavaMailSender data = mock(JavaMailSender.class);

        LoanCalculatorController controller =  new LoanCalculatorController();

        controller.setData(repository);
        controller.setRestTemplate(restTemplate);
        controller.setMailSender(data);

        controller.processNewLoanApplication(loanApplication);

        assertEquals(new BigDecimal(110), loanApplication.getRepayment());

    }

    @Test
    public void test3YearLoanWholePounds() {

        loanApplication = spy(new LoanApplication());
        loanApplication.setPrincipal(1200);
        loanApplication.setTermInMonths(24);
        //TODO: set the interest rate to 10%
        //doReturn(return_value).when(spy_object).method_call(params);
        doReturn(new BigDecimal(10)).when(loanApplication).getRepayment();

        LoanRepository repository = mock(LoanRepository.class);
        RestTemplate restTemplate = mock(RestTemplate.class);
        JavaMailSender data = mock(JavaMailSender.class);

        LoanCalculatorController controller =  new LoanCalculatorController();

        controller.setData(repository);
        controller.setRestTemplate(restTemplate);
        controller.setMailSender(data);

        controller.processNewLoanApplication(loanApplication);

        assertEquals(new BigDecimal(110), loanApplication.getRepayment());
    }
}