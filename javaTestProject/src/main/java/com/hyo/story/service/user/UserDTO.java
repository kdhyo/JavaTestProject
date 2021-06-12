package com.hyo.story.service.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString
public class UserDTO {
	protected String userId;
	protected String userName;
	protected String address;
}