package br.com.estudos.multimodulo.swagger.annotations;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantsSwagger {
    public static final String GET_ALL_USERS_SUMMARY = "Retorna os usuários";
    public static final String GET_ALL_USERS_DESCRIPTION = "Retorna uma lista de usuários do banco";
}
