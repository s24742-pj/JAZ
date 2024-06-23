package com.example.GryPlanszowe.mapper;

import com.example.GryPlanszowe.model.Game;
import com.example.GryPlanszowe.model.GameCreateRequest;
import com.example.GryPlanszowe.model.GameResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);
    Game toGame (GameCreateRequest gameCreateRequest);

    GameResponse toGameResponse(Game game);
}
