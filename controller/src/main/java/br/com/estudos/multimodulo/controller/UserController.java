package br.com.estudos.multimodulo.controller;

import br.com.estudos.multimodulo.dto.UserDto;
import br.com.estudos.multimodulo.exception.StandardError;
import br.com.estudos.multimodulo.model.User;
import br.com.estudos.multimodulo.service.UserFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    private final UserFacade userFacade;

    @ApiOperation(value = "Retorna uma lista de usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Busca realizada com sucesso", response = UserDto[].class),
            @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
            @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class)
    })

    @GetMapping
    @ResponseStatus(OK)
    public List<UserDto> findAll() {
        return userFacade.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Retorna um usuário")
    public UserDto findById(@PathVariable Long id) {
        return userFacade.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation(value = "Salva um usuário")
    public UserDto save(@Valid @RequestBody User user) {
        return userFacade.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Atualiza um usuário")
    public UserDto update(@PathVariable Long id,@Valid @RequestBody User user) {
        return userFacade.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Deleta um usuário")
    public void delete(@PathVariable Long id) {
        userFacade.deleteById(id);
    }

    //TODO @pacth
    //TODO delete deletando lista de user(delete all users, delete user by attribute[name, cpf, email])
}