package br.com.viavarejo.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModelProperty;

public abstract class BaseResponseDto implements Serializable {
    private static final long serialVersionUID = -8741680162528544075L;

    @ApiModelProperty(notes = "Identifica se o response é valido ou inválido: TRUE|FALSE", required = true)
    private Boolean valido = true;

    @ApiModelProperty(notes = "Coleção de mensagens")
    private List<MensagemResponseDto> mensagens = new ArrayList<>();

    @ApiModelProperty(notes = "Protocolo da acão")
    private String protocolo;

    public BaseResponseDto() {
        super();
    }

    public Boolean isValido() {
        return this.valido;
    }

    public void setValido(final Boolean valido) {
        this.valido = valido;
    }

    public List<MensagemResponseDto> getMensagens() {
        return this.mensagens;
    }

    public void setMensagens(final List<MensagemResponseDto> mensagens) {
        this.mensagens = mensagens;
    }

    public void add(final MensagemResponseDto mensagem) {
        this.mensagens.add(mensagem);
    }

    public String getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(final String protocolo) {
        this.protocolo = protocolo;
    }

    @Override
    public String toString() {
        String jsonString = "";
        try {
            jsonString = new ObjectMapper().writeValueAsString(this);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
