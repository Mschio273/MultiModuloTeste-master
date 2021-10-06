package br.com.estudos.multimodulo.controller;

import br.com.estudos.multimodulo.Mapper;
import br.com.estudos.multimodulo.dto.ControllerRequestDTO;
import br.com.estudos.multimodulo.dto.ControllerResponseDTO;
import br.com.estudos.multimodulo.exception.StandardError;
import br.com.estudos.multimodulo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "API REST de cadastro de usuário")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    //TODO chamar facade
    //TODO busca por nome e por cpf
    private final UserService userService;

    @GetMapping
    @ResponseStatus(OK)
    @ApiOperation(value = "Retorna uma lista de usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Busca realizada com sucesso", response = ControllerResponseDTO[].class),
            @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
            @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class)
    })

    public List<ControllerResponseDTO> findAll() {
        return userService.findAll().stream()
                .map(Mapper.toControllerResponseUserDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Retorna um usuário")
    public List<ControllerResponseDTO> findById(@PathVariable Long id) {
        return userService.findById(id).stream()
                .map(Mapper.toControllerResponseUserDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation(value = "Salva um usuário")
    public ControllerResponseDTO save(@Valid @RequestBody ControllerRequestDTO requestUserDTO) {
        return Mapper.toControllerResponseUserDTO.apply(
                userService.save(Mapper.toServiceRequestDTO.apply(requestUserDTO)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Atualiza um usuário")
    public ControllerResponseDTO update(@PathVariable Long id,@Valid @RequestBody ControllerRequestDTO requestUserDTO) {
        return Mapper.toControllerResponseUserDTO.apply(userService
                .update(id, Mapper.toServiceRequestDTO.apply(requestUserDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Deleta um usuário")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    //TODO @pacth
    //TODO delete deletando lista de user
}