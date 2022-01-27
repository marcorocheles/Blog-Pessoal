package org.generation.blog.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI springBlogOpenAPI() {
		return new OpenAPI()
				.info(new Info()
					.title("Projeto Blog Pessoal")
					.description("Projeto Blog Pessoal - Generation Brasil")
					.version("v0.0.1")
				.license(new License()
					.name ("Generation Brasil")
					.url("https://brazil.generation.org/"))
				.contact(new Contact()
					.name("Contato")
					.url("https://github.com/marcorocheles")
					.email("marcorocheles@gmail.com")))
				.externalDocs(new ExternalDocumentation()
					.description("GitHub")
					.url("https://github.com/marcorocheles/BlogPessoal"));
	}
	
	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
				
				ApiResponses apiResponses = operation.getResponses();
				
				apiResponses.addApiResponse("200", createApiResponse("Deu certoooo, sucesso!!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto excluido!!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na requisição T-T"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso não Autorizado! o.o"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto não encontrado."));
				apiResponses.addApiResponse("500", createApiResponse("Erro na aplicação :/"));
				
			}));
		};
	}
	
	private ApiResponse createApiResponse (String message) {
		
		return new ApiResponse().description(message);
		
	}
 
}
