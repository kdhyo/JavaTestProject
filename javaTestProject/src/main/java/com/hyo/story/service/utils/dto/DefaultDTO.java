package com.hyo.story.service.utils.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter @Setter @SuperBuilder
@NoArgsConstructor @AllArgsConstructor
public abstract class DefaultDTO implements Persistable<String> {

	@Column(updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime createdDateTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime updatedDateTime;

	@Transient
	protected boolean isCreatedMode;

	@Override
	public boolean isNew() {
		return isCreatedMode;
	}

	@PrePersist
	private void prePersist() {
		createdDateTime = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate() {
		updatedDateTime = LocalDateTime.now();
	}

}
