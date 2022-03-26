package com.verification.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseErrorDTO {

	private String code;

	private String message;

}
