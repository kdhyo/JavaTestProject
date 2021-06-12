package com.hyo.story.service.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

	@Test
	@DisplayName("Set을_활용한_중복찾기")
	void getDuplicateByStreamSet() {
		Set<String> duplicateSet = new HashSet<>();
		
		List<UserDTO> userList = this.generatorUserList();
		List<String> userIdList = userList.stream().map(UserDTO::getUserId).collect(Collectors.toList());
		
		for(String userId : userIdList) {
			if(userIdList.indexOf(userId) != userIdList.lastIndexOf(userId)) {
				duplicateSet.add(userId);
			}
		}
		
		System.out.println(duplicateSet);
	}
	
	@Test
	@DisplayName("for문을_한번만_돌기_List")
	void getDuplicateByOneForList() {
		List<String> duplicateList = new ArrayList<>(); // 중복된 ID List
		List<String> userIdList = new ArrayList<>(); // 유저 ID List
		
		List<UserDTO> userList = this.generatorUserList();
		
		for (UserDTO user : userList) {
			String userId = user.getUserId();
			if(userIdList.contains(userId)) {
				if(!duplicateList.contains(userId)) duplicateList.add(userId);
			} else {
				userIdList.add(userId);
			}
		}
		
		System.out.println(duplicateList);
	}
	
	@Test
	@DisplayName("for문을_한번만_돌기_Set")
	void getDuplicateByOneForSet() {
		Set<String> duplicateSet = new HashSet<>(); // 중복된 ID Set
		List<String> userIdList = new ArrayList<>(); // 유저 ID List
		
		List<UserDTO> userList = this.generatorUserList();
		
		for (UserDTO user : userList) {
			String userId = user.getUserId();
			if(userIdList.contains(userId)) {
				duplicateSet.add(userId);
			} else {
				userIdList.add(userId);
			}
		}
		
		System.out.println(duplicateSet);
	}
	
	@Test
	@DisplayName("for문을_한번만_돌기_Set_to_List")
	void getDuplicateByOneForSetToList() {
		Set<String> duplicateSet = new HashSet<>(); // 중복된 ID Set
		List<String> userIdList = new ArrayList<>(); // 유저 ID List
		
		List<UserDTO> userList = this.generatorUserList();
		
		for (UserDTO user : userList) {
			String userId = user.getUserId();
			if(userIdList.contains(userId)) {
				duplicateSet.add(userId);
			} else {
				userIdList.add(userId);
			}
		}
		
		List<String> duplicateList = new ArrayList<>(duplicateSet);
		
		System.out.println(duplicateList);
	}
	
	List<UserDTO> generatorUserList() {
		List<UserDTO> userList = new ArrayList<>();
		userList.add(UserDTO.builder().userId("aaa").userName("일").address("1").build());
		userList.add(UserDTO.builder().userId("aaa").userName("이").address("2").build());
		userList.add(UserDTO.builder().userId("bbb").userName("삼").address("3").build());
		userList.add(UserDTO.builder().userId("ccc").userName("사").address("4").build());
		userList.add(UserDTO.builder().userId("ddd").userName("오").address("5").build());
		userList.add(UserDTO.builder().userId("ccc").userName("육").address("6").build());
		userList.add(UserDTO.builder().userId("aaa").userName("칠").address("7").build());
		userList.add(UserDTO.builder().userId("bbb").userName("팔").address("8").build());
		userList.add(UserDTO.builder().userId("eee").userName("구").address("9").build());
		userList.add(UserDTO.builder().userId("bbb").userName("십").address("10").build());
		
		return userList;
	}
	
	
	

}
