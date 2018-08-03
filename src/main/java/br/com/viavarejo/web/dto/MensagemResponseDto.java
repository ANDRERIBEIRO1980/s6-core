package br.com.viavarejo.web.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModelProperty;

@JsonRootName("mensagem")
public class MensagemResponseDto implements Serializable {
    private static final long serialVersionUID = 8046444716179937168L;

    @ApiModelProperty(notes = "Código da mensagem", required = true)
    private Integer codigo;

    @ApiModelProperty(notes = "Conteúdo da mensagem", required = true)
    private String conteudo;

    public MensagemResponseDto() {}

    public MensagemResponseDto(final Integer codigo, final String conteudo) {
        super();
        this.codigo = codigo;
        this.conteudo = conteudo;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(final String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        final ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(this);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
