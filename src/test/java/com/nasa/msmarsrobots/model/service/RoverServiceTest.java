package com.nasa.msmarsrobots.model.service;

import com.nasa.msmarsrobots.model.domain.ECardinalPointDirection;
import com.nasa.msmarsrobots.model.dto.OutputDTO;
import com.nasa.msmarsrobots.model.entity.Position;
import com.nasa.msmarsrobots.model.exception.InvalidPositionException;
import com.nasa.msmarsrobots.model.exception.ResourceNotFoundException;
import com.nasa.msmarsrobots.model.exception.handler.ValidatorContractHandler;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class RoverServiceTest {

    private MockMvc mockMvc;

    @SpyBean private RoverService service;

    @BeforeEach
    private void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(service).build();
    }

    @Test
    @DisplayName("Should move the rover to the position MML.")
    public void shouldMoveRoverToPositionMML() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(0)
                .y(2)
                .orientation(ECardinalPointDirection.WEST.getPosition())
                .build();

        OutputDTO response = service.movementRover("MML");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position MMRMMRMM.")
    public void shouldMoveRoverToPositionMMRMMRMM() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(2)
                .y(0)
                .orientation(ECardinalPointDirection.SOUTH.getPosition())
                .build();

        OutputDTO response = service.movementRover("MMRMMRMM");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position MLRR.")
    public void shouldMoveRoverToPositionMLRR() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(0)
                .y(1)
                .orientation(ECardinalPointDirection.EAST.getPosition())
                .build();

        OutputDTO response = service.movementRover("MLRR");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position MMRL.")
    public void shouldMoveRoverToPositionMMRL() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(0)
                .y(2)
                .orientation(ECardinalPointDirection.NORTH.getPosition())
                .build();

        OutputDTO response = service.movementRover("MMRL");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position MLMLML.")
    public void shouldMoveRoverToPositionMLMLML() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(-1)
                .y(0)
                .orientation(ECardinalPointDirection.EAST.getPosition())
                .build();

        OutputDTO response = service.movementRover("MLMLML");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position MLMLMR.")
    public void shouldMoveRoverToPositionMLMLMR() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(-1)
                .y(0)
                .orientation(ECardinalPointDirection.WEST.getPosition())
                .build();

        OutputDTO response = service.movementRover("MLMLMR");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position MLMLMRR.")
    public void shouldMoveRoverToPositionMLMLMRR() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(-1)
                .y(0)
                .orientation(ECardinalPointDirection.NORTH.getPosition())
                .build();

        OutputDTO response = service.movementRover("MLMLMRR");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position MLMLMRRRR.")
    public void shouldMoveRoverToPositionMLMLMRRRR() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(-1)
                .y(0)
                .orientation(ECardinalPointDirection.SOUTH.getPosition())
                .build();

        OutputDTO response = service.movementRover("MLMLMRRRR");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position RMRM.")
    public void shouldMoveRoverToPositionRMRM() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(1)
                .y(-1)
                .orientation(ECardinalPointDirection.SOUTH.getPosition())
                .build();

        OutputDTO response = service.movementRover("RMRM");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position RMRMR.")
    public void shouldMoveRoverToPositionRMRMR() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(1)
                .y(-1)
                .orientation(ECardinalPointDirection.WEST.getPosition())
                .build();

        OutputDTO response = service.movementRover("RMRMR");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position RMRMRR.")
    public void shouldMoveRoverToPositionRMRMRR() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(1)
                .y(-1)
                .orientation(ECardinalPointDirection.NORTH.getPosition())
                .build();

        OutputDTO response = service.movementRover("RMRMRR");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("Should move the rover to the position RMRMRRR.")
    public void shouldMoveRoverToPositionRMRMRRR() {
        OutputDTO outputDTO = OutputDTO.builder()
                .x(1)
                .y(-1)
                .orientation(ECardinalPointDirection.EAST.getPosition())
                .build();

        OutputDTO response = service.movementRover("RMRMRRR");

        assertEquals(response.getX(), outputDTO.getX());
        assertEquals(response.getY(), outputDTO.getY());
        assertEquals(response.getOrientation(), outputDTO.getOrientation());
    }

    @Test
    @DisplayName("An exception should occur when passing position not found.")
    public void AnExceptionShouldOccurWhenPassingPositionNotFound() {
        InvalidPositionException thrown =
                assertThrows(InvalidPositionException.class,
                        () -> service.movementRover(null));

        assertEquals(thrown.getClass(), InvalidPositionException.class);
        assertEquals(thrown.getCode(), 1);
        assertEquals(thrown.getMessage(), "Movement position not found.");
    }

    @Test
    @DisplayName("An exception should occur when passing command invalid AAA.")
    public void AnExceptionShouldOccurWhenPassingCommandInvalidAAA() {
        InvalidPositionException thrown =
                assertThrows(InvalidPositionException.class,
                        () -> service.movementRover("AAA"));

        assertEquals(thrown.getClass(), InvalidPositionException.class);
        assertEquals(thrown.getCode(), 2);
        assertEquals(thrown.getMessage(), "Invalid movement command.");
    }

    @Test
    @DisplayName("An exception should occur when passing invalid position MMMMMMMMMMMMMMMMMMMMMMMM.")
    public void AnExceptionShouldOccurWhenPassingInvalidPositionMMMMMMMMMMMMMMMMMMMMMMMM() {
        InvalidPositionException thrown =
                assertThrows(InvalidPositionException.class,
                        () -> service.movementRover("MMMMMMMMMMMMMMMMMMMMMMMM"));

        assertEquals(thrown.getClass(), InvalidPositionException.class);
        assertEquals(thrown.getCode(), 3);
        assertEquals(thrown.getMessage(), "The rover has exceeded the bounded movement perimeter.");
    }
}
