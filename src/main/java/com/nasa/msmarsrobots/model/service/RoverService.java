package com.nasa.msmarsrobots.model.service;

import com.nasa.msmarsrobots.model.domain.ECardinalPointDirection;
import com.nasa.msmarsrobots.model.domain.ELocomotion;
import com.nasa.msmarsrobots.model.domain.EValidation;
import com.nasa.msmarsrobots.model.dto.OutputDTO;
import com.nasa.msmarsrobots.model.entity.Position;
import com.nasa.msmarsrobots.model.exception.InvalidPositionException;
import com.nasa.msmarsrobots.model.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

import static java.lang.String.format;

@Slf4j
@Service
public class RoverService {

    Map<Character, Position> mapper = new HashMap<>();
    Map<Character, Character> mapperRight = new HashMap<>();
    Map<Character, Character> mapperLeft = new HashMap<>();

    @PostConstruct
    private void RoverService(){
        mapper.put('M', new Position(1));
        mapper.put('R', new Position(0));
        mapper.put('L', new Position(0));

        mapperRight.put('N', ECardinalPointDirection.EAST.getPosition());
        mapperRight.put('S', ECardinalPointDirection.WEST.getPosition());
        mapperRight.put('E', ECardinalPointDirection.SOUTH.getPosition());
        mapperRight.put('W', ECardinalPointDirection.NORTH.getPosition());

        mapperLeft.put('N', ECardinalPointDirection.WEST.getPosition());
        mapperLeft.put('S', ECardinalPointDirection.EAST.getPosition());
        mapperLeft.put('E', ECardinalPointDirection.NORTH.getPosition());
        mapperLeft.put('W', ECardinalPointDirection.SOUTH.getPosition());
    }

    public OutputDTO movementRover(String movement){
        try {
            if (Objects.isNull(movement))
                throw new InvalidPositionException(EValidation.POSITION_NOT_FOUND);

            return locomotionRover(movement.toUpperCase());
        } catch (InvalidPositionException e){
            throw e;
        } catch (Exception e){
            log.error("There was a generic problem when trying to move the Rover. ", e);
            throw new ResourceNotFoundException(EValidation.NOT_IDENTIFIED);
        }
    }

    private OutputDTO locomotionRover(String locomotion){
        int x = 0;
        int y = 0;
        List<Character> chars = new ArrayList<>();
        Character positionChar = ECardinalPointDirection.NORTH.getPosition();

        for (char ch : locomotion.toCharArray()) {
            chars.add(ch);
        }

        for (Character aChar : chars) {
            if (!ELocomotion.valueOfPositionBoolean(aChar))
                throw new InvalidPositionException(EValidation.COMMAND_INVALID);
        }

        for (Character aChar : chars) {
            Position position = mapper.get(aChar);

            switch (aChar) {
                case 'M':
                    x = position.getXPosition(positionChar, x);
                    y = position.getYPosition(positionChar, y);
                    break;
                case 'R':
                    positionChar = mapperRight.get(positionChar);
                    break;
                case 'L':
                    positionChar = mapperLeft.get(positionChar);
                    break;
            }
        }

        if (x > 5 || y > 5) throw new InvalidPositionException(EValidation.OUTSIDE_AREA);

        return OutputDTO.builder().x(x).y(y).orientation(positionChar).build();
    }
}
