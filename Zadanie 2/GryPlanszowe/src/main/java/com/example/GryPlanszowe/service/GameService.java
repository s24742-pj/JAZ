package com.example.GryPlanszowe.service;


import com.example.GryPlanszowe.mapper.GameMapper;
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

    @Autowired
    private GameMapper gameMapper;

    public List<GameResponse> getAllGames() {
        return gameRepository.findAll().stream()
                .map(gameMapper::toGameResponse)
                .collect(Collectors.toList());
    }

    public GameResponse getGameById(Long id) {
        return gameRepository.findById(id)
                .map(gameMapper::toGameResponse)
                .orElse(null);
    }

    public GameResponse createGame(GameCreateRequest request) {
        Game game = gameMapper.toGame(request);
        Game savedGame = gameRepository.save(game);
        return gameMapper.toGameResponse(savedGame);
    }

    public GameResponse updateGame(Long id, GameCreateRequest request) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setTitle(request.getTitle());
                    game.setDescription(request.getDescription());
                    Game updatedGame = gameRepository.save(game);
                    return gameMapper.toGameResponse(updatedGame);
                }).orElse(null);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
