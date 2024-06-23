package com.example.GryPlanszowe.service;


import com.example.GryPlanszowe.model.Game;
import com.example.GryPlanszowe.model.GameCreateRequest;
import com.example.GryPlanszowe.model.GameResponse;
import com.example.GryPlanszowe.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameResponse> getAllGames() {
        return gameRepository.findAll().stream()
                .map(game -> new GameResponse(game.getId(), game.getTitle(), game.getDescription()))
                .collect(Collectors.toList());
    }

    public GameResponse getGameById(Long id) {
        return gameRepository.findById(id)
                .map(game -> new GameResponse(game.getId(), game.getTitle(), game.getDescription()))
                .orElse(null);
    }

    public GameResponse createGame(GameCreateRequest request) {
        Game game = new Game(request.getTitle(), request.getDescription());
        Game savedGame = gameRepository.save(game);
        return new GameResponse(savedGame.getId(), savedGame.getTitle(), savedGame.getDescription());
    }

    public GameResponse updateGame(Long id, GameCreateRequest request) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setTitle(request.getTitle());
                    game.setDescription(request.getDescription());
                    Game updatedGame = gameRepository.save(game);
                    return new GameResponse(updatedGame.getId(), updatedGame.getTitle(), updatedGame.getDescription());
                }).orElse(null);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
