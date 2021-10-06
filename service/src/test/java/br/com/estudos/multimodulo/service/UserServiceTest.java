//package br.com.estudos.multimodulo.service;
//
//import br.com.estudos.multimodulo.model.User;
//import br.com.estudos.multimodulo.service.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Collections;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes = {UserRepository.class, UserFacadeImpl.class})
//@Sql(value = "/banco.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@TestPropertySource("classpath:application-test.properties")
//@ExtendWith(MockitoExtension.class)
////@ContextConfiguration(classes = {UserFacadeImpl.class, UserRepository.class})
//class UserServiceTest {
//
//    private ServiceRequestDTO requestDTO;
//    private User user;
//
//    UserRepository userRepository;
//
//    @InjectMocks
//    UserFacadeImpl userService;
//
//    @BeforeEach
//    void setUp() {
//        this.user = br.com.estudos.multimodulo.model.User.builder()
//                .id(1L)
//                .name("Matheus")
//                .cpf("029.550.330-06")
//                .email("matheus")
//                .password("123")
//                .build();
//
//        this.requestDTO = ServiceRequestDTO.builder()
//                .name(this.user.getName())
//                .cpf(this.user.getCpf())
//                .email(this.user.getEmail())
//                .password(this.user.getPassword())
//                .build();
//    }
//
//    @Test
//    void givenValidScenario_whenFindAllIsCalled_thenShouldReturnGamesList() {
//
//         when(userRepository.findAll()).thenReturn(Collections.singletonList(this.user));
//
//        var userAtual = userService.findAll();
//
//        var userEsperado = Stream.of(this.user)
//                .map(dto -> ServiceResponseDTO.builder()
//                        .id(dto.getId())
//                        .name(dto.getName())
//                        .cpf(dto.getCpf())
//                        .build())
//                .collect(Collectors.toList());
//
//        assertEquals(userEsperado, userAtual);
//
//    }
//
//    @Test
//    public void givenAValidIdAndExistentId_whenFindByIdIsCalled_thenShouldReturnAGame() {
//        when(userRepository.findById(this.user.getId())).thenReturn(Optional.of(this.user));
//
//        var userAtual = userService.findById(user.getId());
//
//        var userEsperado = Stream.of(this.user)
//                .map(dto -> ServiceResponseDTO.builder()
//                        .id(dto.getId())
//                        .name(dto.getName())
//                        .cpf(dto.getCpf())
//                        .build())
//                .collect(Collectors.toList());
//
//        assertEquals(userEsperado, userAtual);
//    }
//
//    @Test
//    public void givenAInvalidId_whenFindByIdIsCalled_thenShouldThrowException() {
//
//        Exception exception = assertThrows(ResponseStatusException.class, () -> {
//            userService.findById(1L);
//        });
//    }
//
//    @Test
//    public void givenAInvalidScenario_whenFindAllIsCalled_thenShouldThrowException() {
//
//        Exception exception = assertThrows(ResponseStatusException.class, () -> {
//            userService.findAll();
//        });
//    }
//
//    @Test
//    public void givenAInvalidId_whenDeleteIsCalled_thenShouldThrowException() {
//
//        Exception exception = assertThrows(ResponseStatusException.class, () -> {
//            userService.deleteById(1L);
//        });
//    }
//
//    @Test
//    public void givenAInvalidScenario_whenSaveIsCalled_thenShouldThrowException() {
//
//        Exception exception = assertThrows(ResponseStatusException.class, () -> {
//            userService.save(requestDTO);
//        });
//    }
//    @Test
//    public void givenAInvalidScenario_whenUpdateIsCalled_thenShouldThrowException() {
//
//        Exception exception = assertThrows(ResponseStatusException.class, () -> {
//            userService.update(1L, requestDTO);
//        });
//    }
//}
//
//
