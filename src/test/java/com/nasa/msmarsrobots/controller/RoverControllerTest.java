package com.nasa.msmarsrobots.controller;

import com.nasa.msmarsrobots.model.domain.ECardinalPointDirection;
import com.nasa.msmarsrobots.model.domain.EValidation;
import com.nasa.msmarsrobots.model.dto.OutputDTO;
import com.nasa.msmarsrobots.model.exception.InvalidPositionException;
import com.nasa.msmarsrobots.model.exception.handler.ValidatorContractHandler;
import com.nasa.msmarsrobots.model.service.RoverService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.core.MediaType;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class RoverControllerTest {

    private MockMvc mockMvc;

    @Mock private RoverService service;

    @InjectMocks private RoverController controller;

    @BeforeEach
    private void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(ValidatorContractHandler.class)
                .build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Should move the rover to the position MML.")
    public void shouldMoveRoverToPositionMML() throws Exception {
        String movement = "MML";
        OutputDTO response = OutputDTO.builder()
                .x(0)
                .y(2)
                .orientation(ECardinalPointDirection.WEST.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position MMRMMRMM.")
    public void shouldMoveRoverToPositionMMRMMRMM() throws Exception {
        String movement = "MMRMMRMM";
        OutputDTO response = OutputDTO.builder()
                .x(2)
                .y(0)
                .orientation(ECardinalPointDirection.SOUTH.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position MMRL.")
    public void shouldMoveRoverToPositionMMRL() throws Exception {
        String movement = "MMRL";
        OutputDTO response = OutputDTO.builder()
                .x(0)
                .y(2)
                .orientation(ECardinalPointDirection.NORTH.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, N)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position MLRR.")
    public void shouldMoveRoverToPositionMLRR() throws Exception {
        String movement = "MLRR";
        OutputDTO response = OutputDTO.builder()
                .x(0)
                .y(1)
                .orientation(ECardinalPointDirection.EAST.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 1, E)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position MLMLML.")
    public void shouldMoveRoverToPositionMLMLML() throws Exception {
        String movement = "MLMLML";
        OutputDTO response = OutputDTO.builder()
                .x(-1)
                .y(0)
                .orientation(ECardinalPointDirection.EAST.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(-1, 0, E)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position MLMLMR.")
    public void shouldMoveRoverToPositionMLMLMR() throws Exception {
        String movement = "MLMLMR";
        OutputDTO response = OutputDTO.builder()
                .x(-1)
                .y(0)
                .orientation(ECardinalPointDirection.WEST.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(-1, 0, W)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position MLMLMRR.")
    public void shouldMoveRoverToPositionMLMLMRR() throws Exception {
        String movement = "MLMLMRR";
        OutputDTO response = OutputDTO.builder()
                .x(-1)
                .y(0)
                .orientation(ECardinalPointDirection.NORTH.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(-1, 0, N)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position MLMLMRRRR.")
    public void shouldMoveRoverToPositionMLMLMRRRR() throws Exception {
        String movement = "MLMLMRRRR";
        OutputDTO response = OutputDTO.builder()
                .x(-1)
                .y(0)
                .orientation(ECardinalPointDirection.SOUTH.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(-1, 0, S)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position RMRM.")
    public void shouldMoveRoverToPositionRMRM() throws Exception {
        String movement = "RMRM";
        OutputDTO response = OutputDTO.builder()
                .x(1)
                .y(-1)
                .orientation(ECardinalPointDirection.SOUTH.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(1, -1, S)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position RMRMR.")
    public void shouldMoveRoverToPositionRMRMR() throws Exception {
        String movement = "RMRMR";
        OutputDTO response = OutputDTO.builder()
                .x(1)
                .y(-1)
                .orientation(ECardinalPointDirection.WEST.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(1, -1, W)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position RMRMRR.")
    public void shouldMoveRoverToPositionRMRMRR() throws Exception {
        String movement = "RMRMRR";
        OutputDTO response = OutputDTO.builder()
                .x(1)
                .y(-1)
                .orientation(ECardinalPointDirection.NORTH.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(1, -1, N)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("Should move the rover to the position RMRMRRR.")
    public void shouldMoveRoverToPositionRMRMRRR() throws Exception {
        String movement = "RMRMRRR";
        OutputDTO response = OutputDTO.builder()
                .x(1)
                .y(-1)
                .orientation(ECardinalPointDirection.EAST.getPosition())
                .build();

        doReturn(response).when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("(1, -1, E)"));

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("An exception should occur when passing position not found.")
    public void AnExceptionShouldOccurWhenPassingPositionNotFound() throws Exception {
        String movement = "*";

        doThrow(new InvalidPositionException(EValidation.POSITION_NOT_FOUND))
                .when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].code", is(1)))
                .andExpect(jsonPath("$.errors[0].message", is("Movement position not found.")))
                .andDo(print());

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("An exception should occur when passing command invalid AAA.")
    public void AnExceptionShouldOccurWhenPassingCommandInvalidAAA() throws Exception {
        String movement = "AAA";

        doThrow(new InvalidPositionException(EValidation.COMMAND_INVALID))
                .when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].code", is(2)))
                .andExpect(jsonPath("$.errors[0].message", is("Invalid movement command.")))
                .andDo(print());

        verify(service, times(1)).movementRover(movement);
    }

    @Test
    @DisplayName("An exception should occur when passing invalid position MMMMMMMMMMMMMMMMMMMMMMMM.")
    public void AnExceptionShouldOccurWhenPassingInvalidPositionMMMMMMMMMMMMMMMMMMMMMMMM() throws Exception {
        String movement = "MMMMMMMMMMMMMMMMMMMMMMMM";

        doThrow(new InvalidPositionException(EValidation.OUTSIDE_AREA))
                .when(service).movementRover(movement);

        mockMvc.perform(post("/mars/" + movement).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].code", is(3)))
                .andExpect(jsonPath("$.errors[0].message"
                        , is("The rover has exceeded the bounded movement perimeter.")))
                .andDo(print());

        verify(service, times(1)).movementRover(movement);
    }
}
