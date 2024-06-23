package com.example.GryPlanszowe.controller;


import com.example.GryPlanszowe.model.GameCreateRequest;
import com.example.GryPlanszowe.model.GameResponse;
import com.example.GryPlanszowe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameResponse> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public GameResponse getGameById(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @PostMapping
    public GameResponse createGame(@RequestBody GameCreateRequest request) {
        return gameService.createGame(request);
    }

    @PutMapping("/{id}")
    public GameResponse updateGame(@PathVariable Long id, @RequestBody GameCreateRequest request) {
        return gameService.updateGame(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
