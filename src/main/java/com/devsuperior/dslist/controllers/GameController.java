package com.devsuperior.dslist.controllers;

import java.util.List;

import com.devsuperior.dslist.entities.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.dtos.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
@RequiredArgsConstructor
public class GameController {

	@Autowired
	final GameService gameService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> saveGame(@RequestBody GameDTO gameDTO) {
		var game = new Game();
		BeanUtils.copyProperties(gameDTO, game);
		gameService.save(game);
		return ResponseEntity.status(HttpStatus.CREATED).body("Jogo cadastrado com sucesso!");
	}

	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}

	@GetMapping(value = "/listar-tudo")
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
