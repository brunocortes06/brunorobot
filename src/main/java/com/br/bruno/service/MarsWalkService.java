package com.br.bruno.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.bruno.util.Position;

public class MarsWalkService extends Position {

	private String orientation = "north";
	private boolean erro = false;

	public String getdDirections(String params) throws Exception {
		x = 0;
		y = 0;
		orientation = "N";
		erro = false;

		int j = 0;
		for(int i=1; i <= params.length() ; i++) {
			String command = params.substring(j, i);

			switch (command) {
			case "R":
				right();
				break;
			case "L":
				left();
				break;
			case "M":
				forward();
				break;
			default: erro = true;
			break;
			}
			if(erro) {
				throw new IllegalArgumentException("Parâmetros inválidos");
			}
			j++;
		}

		return x+","+y+","+orientation;

	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

	public void left() {
		switch (orientation) {
		case "N": orientation = "W"; break;
		case "W": orientation = "S"; break;
		case "S": orientation = "E"; break;
		}
	}

	public void right() {
		switch (orientation) {
		case "N": orientation = "E"; break;
		case "E": orientation = "S"; break;
		case "S": orientation = "W"; break;
		}
	}

	public void forward() throws Exception {
		switch (orientation) {
		case "N":
			if (isValidPostinion(0 , 1)) {
				y += 1;
			} else {
				erro = true;
			}
			break;
		case "S":
			if (isValidPostinion(0 , -1)) {
				y-=1;
			} else {
				erro = true;
			}
			break;
		case "E":
			if (isValidPostinion(1 , 0)) {
				x+=1;
			} else {
				erro = true;
			}
			break;
		case "W":
			if (isValidPostinion(-1 , 0)) {
				x-=1;
			} else {
				erro = true;
			}
			break;
		}

	}

	public boolean isValidPostinion(int linha, int coluna) {
		if(x + linha < 5){
			if(y + coluna < 5) {
				return true;
			}
		}
		return false;
	}
}
