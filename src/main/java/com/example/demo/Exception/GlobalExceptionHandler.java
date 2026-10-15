package com.example.demo.Exception;

import java.net.Authenticator.RequestorType;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ExceptionResponseDto;
import com.example.demo.dto.ValidationExceptionResponsedto;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	//DuplicateResourceException
	//Runtime Exception
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ExceptionResponseDto> handleDuplicateResourceException(DuplicateResourceException ex, HttpServletRequest request)
	{
		
		ExceptionResponseDto Responsedto = new ExceptionResponseDto(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.getReasonPhrase(),
				"validation failed",
				request.getRequestURI()
				);
		
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(Responsedto);
				
	}
	//RespurceNotFoundException
	//Runtime Exception
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request)
		{
			ExceptionResponseDto ResponseDto = new ExceptionResponseDto(
					LocalDateTime.now(),
					HttpStatus.NOT_FOUND.value(),
					HttpStatus.NOT_FOUND.getReasonPhrase(),
					"validation failed",
					request.getRequestURI()
					
					);
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(ResponseDto);
			
		}
		
	//MethodArgumentNotValidException is a Spring Boot exception that 
	//occurs when validation fails for a request body annotated with @Valid.
	//Runtime Exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationExceptionResponsedto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request)
	{
		Map<String, String> fieldErrors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors()
					.forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));
		
		ValidationExceptionResponsedto ResponseDto = new ValidationExceptionResponsedto(
		LocalDateTime.now(),
		HttpStatus.BAD_REQUEST.value(),
		HttpStatus.BAD_REQUEST.getReasonPhrase(),
		"validation failed",
		request.getRequestURI(),
		fieldErrors 
		);
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(ResponseDto);
				
		}
			
	//Runtime Exception
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex,HttpServletRequest request)
	{
		ExceptionResponseDto Responsedto =  new ExceptionResponseDto(
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				"validation failed",
				request.getRequestURI()
				);
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Responsedto);
		
	}
	//compile time 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponseDto> handleGenericException(Exception ex,HttpServletRequest request)
	{
		ExceptionResponseDto Responsedto = new ExceptionResponseDto(
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				"validation failed",
				request.getRequestURI()
				);
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Responsedto);
				
	}
}
