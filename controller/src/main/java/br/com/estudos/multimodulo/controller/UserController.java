package br.com.estudos.multimodulo.controller;

import br.com.estudos.multimodulo.exception.StandardError;
import br.com.estudos.multimodulo.model.UserControllerRequest;
import br.com.estudos.multimodulo.model.UserControllerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "API REST de cadastro de usuário")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private final UserControllerFacade controllerFacade;

    @GetMapping
    @ResponseStatus(OK)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Busca realizada com sucesso", response = UserControllerResponse[].class),
            @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
            @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class)
    })
    public List<UserControllerResponse> findAll() {
        return controllerFacade.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Retorna um usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Busca realizada com sucesso", response = UserControllerResponse[].class),
            @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
            @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class),
            @ApiResponse(code = 404, message = "Recurso não encontrado", response = StandardError.class)
    })
    public UserControllerResponse findById(@PathVariable Long id) {
        return controllerFacade.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation(value = "Salva um usuário")
    @ApiResponses({
            @ApiResponse(code = 201, message = "User cadastrado com sucesso", response = UserControllerResponse[].class),
            @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
            @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class),
            @ApiResponse(code = 404, message = "Recurso não encontrado", response = StandardError.class)
    })
    public UserControllerResponse save(/*@Valid*/ @RequestBody UserControllerRequest user) {
        return controllerFacade.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Atualiza um usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Update realizado com sucesso", response = UserControllerResponse[].class),
            @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
            @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class),
            @ApiResponse(code = 404, message = "Recurso não encontrado", response = StandardError.class)
    })
    public UserControllerResponse update(@PathVariable Long id, /*@Valid*/ @RequestBody UserControllerRequest user) {
        return controllerFacade.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Deleta um usuário")
    @ApiResponses({
            @ApiResponse(code = 204, message = "O recurso não existe", response = UserControllerResponse[].class),
            @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
            @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class),
            @ApiResponse(code = 404, message = "Recurso não encontrado", response = StandardError.class)
    })
    public void delete(@PathVariable Long id) {
        controllerFacade.delete(id);
    }

}