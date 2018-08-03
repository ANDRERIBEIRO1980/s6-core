package br.com.viavarejo.domain.model.mongodb.ocorrencia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class Localizacao implements DomainObject<Localizacao> {

    private static final long serialVersionUID = 1547304839764492618L;

    @ApiModelProperty(notes = "Endereço", example = "Av. Brigadeiro Faria Lima", allowEmptyValue = true, position = 1)
    private String endereco;

    @ApiModelProperty(notes = "Número do endereço", example = "1620", allowEmptyValue = true, position = 2)
    private String numero;

    @ApiModelProperty(notes = "Informações adicionais do endereço", example = "Condominio La Plaza", allowEmptyValue = true, position = 3)
    private String informacaoAdicional;

    @ApiModelProperty(notes = "Referência do endereço", example = "Mesmo prédio da Google", allowEmptyValue = true, position = 4)
    private String referencia;

    @ApiModelProperty(notes = "Cidade do endereço", example = "São Paulo", allowEmptyValue = true, position = 5)
    private String cidade;

    @ApiModelProperty(notes = "Código do estado", example = "35", allowEmptyValue = true, position = 6)
    private String codigoEstado;

    @ApiModelProperty(notes = "Bairro", example = "Jardim Paulistano", allowEmptyValue = true, position = 7)
    private String bairro;

    @ApiModelProperty(notes = "CEP do endereço", example = "01451912", allowEmptyValue = true, position = 8)
    private String cep;

    @ApiModelProperty(notes = "Descrição da localização", example = "Região nobre", allowEmptyValue = true, position = 9)
    private String descricao;

    @ApiModelProperty(notes = "Latitude", example = "-23.5720352", allowEmptyValue = true, position = 10)
    private String latitude;

    @ApiModelProperty(notes = "Longitude", example = "-46.6904198", allowEmptyValue = true, position = 11)
    private String longitude;

    public Localizacao() {
        super();
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(final String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public String getInformacaoAdicional() {
        return this.informacaoAdicional;
    }

    public void setInformacaoAdicional(final String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(final String referencia) {
        this.referencia = referencia;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }

    public String getCodigoEstado() {
        return this.codigoEstado;
    }

    public void setCodigoEstado(final String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(final String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(final String cep) {
        this.cep = cep;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        final ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            // mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
