package br.com.estudos.multimodulo;

//TODO .

import br.com.estudos.multimodulo.dto.ServiceRequestDTO;
import br.com.estudos.multimodulo.dto.ServiceResponseDTO;
import br.com.estudos.multimodulo.service.UserFacadeImpl;
import br.com.estudos.multimodulo.service.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerTest2 {

    private ServiceResponseDTO responseDTO;
    private ServiceRequestDTO requestDTO;
    private br.com.estudos.multimodulo.model.User user;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    //TODO retirar o service
    @MockBean
    UserFacadeImpl userService;

    @BeforeEach
    void setUp() {
        this.user = br.com.estudos.multimodulo.model.User.builder()
                .id(1L)
                .name("Matheus")
                .cpf("029.550.330-06")
                .login("matheus")
                .password("123")
                .build();

        this.responseDTO = ServiceResponseDTO.builder()
                .id(this.user.getId())
                .name(this.user.getName())
                .cpf(this.user.getCpf())
                .build();

        this.requestDTO = ServiceRequestDTO.builder()
                .name(this.user.getName())
                .cpf(this.user.getCpf())
                .login(this.user.getLogin())
                .password(this.user.getPassword())
                .build();
    }

    @Test
    void givenValidScenario_whenFindAllIsCalled_thenShouldExpectStatusOk() throws Exception {

        Mockito.when(this.userService.findAll()).thenReturn(Collections.singletonList(this.responseDTO));
        mockMvc.perform(get("/api/v1/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenValidId_whenFindByIdIsCalled_thenShouldExpectStatusOk() throws Exception {

        Mockito.when(this.userService.findById(this.user.getId())).thenReturn(Collections.singletonList(this.responseDTO));

        mockMvc.perform(get("/api/v1/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenValidScenario_whenSaveIsCalled_thenShouldExpectStatusCreated() throws Exception {

        var json = new ObjectMapper().writeValueAsString(this.requestDTO);

        Mockito.when(userService.save(this.requestDTO)).thenReturn(this.responseDTO);

        mockMvc.perform(post("/api/v1/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void givenValidScenario_whenDeleteIsCalled_thenShouldExpectStatusOk() throws Exception {

        mockMvc.perform(delete("/api/v1/user/1"))
                .andExpect(status().isOk());
    }

    @Test
    void givenValidScenario_whenUpdateIsCalled_thenShouldExpectStatusOk() throws Exception {

        var json = new ObjectMapper().writeValueAsString(this.requestDTO);

        Mockito.when(userService.update(1L, this.requestDTO)).thenReturn(this.responseDTO);

        mockMvc.perform(put("/api/v1/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}