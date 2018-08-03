package br.com.viavarejo.infrastructure.error;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

	private final HttpStatus status;
	private final List<String> errors;

	public ApiError(final HttpStatus status, final List<String> errors) {
		super();
		this.status = status;
		this.errors = errors;
	}

	public ApiError(final HttpStatus status, final String error) {
		super();
		this.status = status;
		this.errors = Arrays.asList(error);
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public List<String> getErrors() {
		return this.errors;
	}

}