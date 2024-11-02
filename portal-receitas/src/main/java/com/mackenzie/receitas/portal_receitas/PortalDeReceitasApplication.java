package com.mackenzie.receitas.portal_receitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Delícias do Dia", version = "1", description = "API desenvolvida para o projeto de Programação de Sistemas II"))
public class PortalDeReceitasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalDeReceitasApplication.class, args);
    }

}
