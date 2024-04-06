package com.ritik.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Tourist {
	private Integer tId;
	@NonNull
	private String name;
	@ NonNull
	private String packageType;
	@ NonNull
	private String packageName;
	@ NonNull
	private String packageDuration;
	@ NonNull
	private LocalDate startsFrom;
	@ NonNull
	private LocalDate validTill;
	@ NonNull
	private Double budget;
}
