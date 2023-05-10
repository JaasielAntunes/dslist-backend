package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Table(name = "tb_belonging")
@Data
@EqualsAndHashCode
public class Belonging {

	@EmbeddedId
	private BelongingPK id = new BelongingPK();

	private Integer position;
}
