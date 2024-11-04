// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Delícias do Dia",
        version = "1",
        description = "API de receitas onde os usuários logados podem adicionar, editar e excluir receitas, e os visitantes podem visualizar e buscar receitas de acordo com categorias ou ingredientes.<br>"
                    + "Desenvolvida para o projeto de Programação de Sistemas II.<br><br>"
                    + "Principais links:<br>"
                    + "- <a href='https://github.com/DeliciasDoDia' target='_blank'>GitHub</a>: Visualização de código Front-End e Back-End.<br>"
                    + "- <a href='https://www.figma.com/proto/kngo5D1QpJNEtPctR28pSc/Delicias-do-Dia?node-id=1-2&t=m5r17AVlPIJzUEmS-1' target='_blank'>Figma</a>: Visualização do protótipo do Figma."
    )
)
public class PortalDeReceitasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalDeReceitasApplication.class, args);
    }

}
