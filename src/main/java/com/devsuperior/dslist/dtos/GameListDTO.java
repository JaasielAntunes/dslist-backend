package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.GameList;
import lombok.Data;

@Data
public class GameListDTO {

	private Long id;
	private String name;
	
	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}
}
