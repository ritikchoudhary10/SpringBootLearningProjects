package com.ritik.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "IPLPlayer_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class IPLPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO ,generator = "IPL_Player_ID")
	private Integer pId;
	@NonNull
	private String pName;
	@NonNull
	private Integer pAge;
	@NonNull
	private String pRole;
	
	@NonNull
	@ManyToOne(cascade = CascadeType.MERGE ,fetch = FetchType.EAGER ,targetEntity = IPLTeam.class)
	@JoinColumn(name = "team_Id" ,referencedColumnName = "teamId")
	private IPLTeam team;
	
}
