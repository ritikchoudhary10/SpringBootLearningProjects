package com.ritik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "IPLTeam_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class IPLTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "Team_Id_Generator")
	private Integer teamId;
	@NonNull
	private String teamName;
	@NonNull
	private String teamCity;
	@NonNull
	private String teamState;
	
}
