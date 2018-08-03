package br.com.viavarejo.infrastructure.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// @Value("${project.version}")
    private String versao;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                        .apis(RequestHandlerSelectors.basePackage("br.com.viavarejo.web"))
                        .build()
                        .apiInfo(this.apiInfo())
                        .tags(new Tag("Empresa Endpoint", "Possuí operações pertinentes às Empresas"), this.tags())
                        .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API Portal do Transportador")
                        .description("Documentação da API REST para o projeto - Portal do Transportador")
                        .version(this.versao)
                        .build();
    }

    private Tag[] tags() {
        final List<Tag> lista = new ArrayList<>();

        lista.add(new Tag("Filial Endpoint", "Possuí operações pertinentes às Filiais"));
		lista.add(new Tag("Pedido Endpoint", "Possuí operações pertinentes aos Pedidos"));
        lista.add(new Tag("Ocorrencia Pedido Endpoint", "Possuí operações pertinentes às Ocorrências do Pedido de Entrega"));
        lista.add(new Tag("Sincronizacao Endpoint", "Possuí operações pertinentes às Sincronizações do Processo"));
        lista.add(new Tag("Transportador Endpoint", "Possuí operações pertinentes às Transportadoras"));
        lista.add(new Tag("KitColeta Endpoint", "Possuí operações pertinentes aos Pedidos de Reversa"));
        lista.add(new Tag("Lote Cobranca Integracao Intelipost Endpoint", "Possuí operações pertinentes ao Lote de cobrança"));
        lista.add(new Tag("Log Aplicacao Endpoint", "Possuí operações pertinentes ao Log Aplicacao do MongoDB"));

        return lista.toArray(new Tag[lista.size()]);
    }
}