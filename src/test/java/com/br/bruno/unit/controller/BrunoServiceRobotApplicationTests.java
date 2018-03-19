package com.br.bruno.unit.controller;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.bruno.service.MarsWalkService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BrunoServiceRobotApplicationTests {

	private static final String MML_REQ = "MML";
	private static final String MML_RESP = "0,2,w";
	private static final String MMMS_REQ = "MMMMMMMMMMMMMMM";

	@Mock
	private MarsWalkService marsWalkService;

	@Test
	public void simpleRequest() throws Exception{
		when(marsWalkService.getdDirections(MML_REQ)).thenReturn(MML_RESP);
		
		try {
			 marsWalkService.getdDirections(MMMS_REQ);
	        } catch (Exception e) {
	            throw e;
	        }
	}
	
	@Test
	public void errorRequest() throws Exception{
		when(marsWalkService.getdDirections(MMMS_REQ)).thenThrow(new IllegalArgumentException("Parâmetros inválidos"));
		when(marsWalkService.isValidPostinion(0,1)).thenThrow(new IllegalArgumentException("Parâmetros inválidos"));
		
		 try {
			 marsWalkService.getdDirections(MMMS_REQ);
	        } catch (Exception e) {
	            throw e;
	        }
	}

}
