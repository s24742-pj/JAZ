package com.example.GryPlanszowe.mapper;

import com.example.GryPlanszowe.model.Game;
import com.example.GryPlanszowe.model.GameCreateRequest;
import com.example.GryPlanszowe.model.GameResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-23T22:58:14+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class GameMapperImpl implements GameMapper {

    @Override
    public Game toGame(GameCreateRequest gameCreateRequest) {
        if ( gameCreateRequest == null ) {
            return null;
        }

        Game game = new Game();

        game.setTitle( gameCreateRequest.getTitle() );
        game.setDescription( gameCreateRequest.getDescription() );

        return game;
    }

    @Override
    public GameResponse toGameResponse(Game game) {
        if ( game == null ) {
            return null;
        }

        GameResponse gameResponse = new GameResponse();

        gameResponse.setId( game.getId() );
        gameResponse.setTitle( game.getTitle() );
        gameResponse.setDescription( game.getDescription() );

        return gameResponse;
    }
}
