package com.verification.dto.user;

import com.verification.annotation.Phone;
import com.verification.dto.item.ItemDTO;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

	@NotNull
	private Long id;

	@NotEmpty(groups = CreateUser.class)
	private String name;

	@Phone(groups = CreateUser.class)
	private String phone;

	@Valid
	@NotNull
	private ItemDTO itemDTO;

	@Override
	public String toString() {
		return "UserDTO{" +
			"id=" + id +
			", name='" + name + '\'' +
			", phone='" + phone + '\'' +
			", itemDTO=" + itemDTO +
			'}';
	}

}
