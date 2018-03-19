package com.br.bruno.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.bruno.service.MarsWalkService;

@RestController
public class MarsWalkController {

	@PostMapping("/rest/mars/{path}")
	public String getPath(@PathVariable("path")String params, HttpServletResponse response) throws Exception {
		
		MarsWalkService service = new MarsWalkService();
		
		return service.getdDirections(params);
	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}
