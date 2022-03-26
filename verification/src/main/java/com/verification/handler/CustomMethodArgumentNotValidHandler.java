package com.verification.handler;

import com.verification.dto.ResponseErrorDTO;
import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomMethodArgumentNotValidHandler {

	@ExceptionHandler(value = MethodArgumentNotValidException.class) // 유효성 검사 실패 시 발생하는 예외를 처리
	protected ResponseEntity<ResponseErrorDTO> handleException(MethodArgumentNotValidException e) {
		List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
		String message = getMessage(allErrors.iterator());

		ResponseErrorDTO result = ResponseErrorDTO.builder()
			.code("MethodArgumentNotValidException.class")
			.message(message)
			.build();

		return ResponseEntity.badRequest().body(result);
	}

	private String getMessage(Iterator<ObjectError> errorIterator) {
		final StringBuilder resultMessageBuilder = new StringBuilder();
		while (errorIterator.hasNext()) {
			ObjectError error = errorIterator.next();
			resultMessageBuilder
				.append("['")
				.append(((FieldError) error).getField()) // 유효성 검사가 실패한 속성
				.append("' is '")
				.append(((FieldError) error).getRejectedValue()) // 유효하지 않은 값
				.append("' :: ")
				.append(error.getDefaultMessage()) // 유효성 검사 실패 시 메시지
				.append("]");

			if (errorIterator.hasNext()) {
				resultMessageBuilder.append(", ");
			}
		}

		log.error(resultMessageBuilder.toString());
		return resultMessageBuilder.toString();
	}

}
