package com.verification.dto.item;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDTO {

	@NotNull
	private Long id;

	@NotBlank
	private String itemName;

	@NotNull
	@Min(1)
	@Max(100)
	private Integer quantity;

	@Override
	public String toString() {
		return "ItemDTO{" +
			"id=" + id +
			", itemName='" + itemName + '\'' +
			", quantity=" + quantity +
			'}';
	}

}
