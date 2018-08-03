package br.com.viavarejo.domain.model.mongodb.ocorrencia;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class EventoPedido implements DomainObject<EventoPedido> {
    private static final long serialVersionUID = 4755311692891684119L;

    @ApiModelProperty(notes = "Data e hora que o evento aconteceu.", required = true)
    @NotNull
    private Date data;

    @ApiModelProperty(notes = "Código do evento da transportadora.", required = true)
    @NotNull
    private Integer codigo;

    @ApiModelProperty(notes = "Sigla do evento da transportadora.", required = true)
    @NotBlank
    private String sigla;

    @ApiModelProperty(notes = "Mensagem original da transportadora.", allowEmptyValue = true)
    private String mensagem;

    @ApiModelProperty(notes = "Sistema que originou o evento", allowEmptyValue = true)
    private String sistemaOrigem;

	@ApiModelProperty(notes = "De-Para código remetente", allowEmptyValue = true)
	private String statusRemetenteDePara;

    @ApiModelProperty(notes = "Localização do endereço", allowEmptyValue = true)
    private Localizacao localizacao;

    @ApiModelProperty(notes = "Flag para tornar a entidade visível à integração", hidden = true)
    @Indexed
    private Boolean integracaoIntelipost = false;

    @ApiModelProperty(notes = "Flag para tornar a entidade visível à Sislogica", hidden = true)
    @Indexed
    private final Boolean integracaoSislogica = false;

    public EventoPedido() {
        super();
    }

    public EventoPedido(final Date data, final Integer codigo, final String sigla, final String mensagem, final String sistemaOrigem) {
        super();
        this.data = data;
        this.codigo = codigo;
        this.sigla = sigla;
        this.mensagem = mensagem;
        this.sistemaOrigem = sistemaOrigem;
    }

    public EventoPedido(final Date data, final Integer codigo, final String sigla, final String mensagem, final String sistemaOrigem,
                    final Localizacao localizacao) {
        this(data, codigo, sigla, mensagem, sistemaOrigem);
        this.localizacao = localizacao;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(final Date data) {
        this.data = data;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(final String sigla) {
        this.sigla = sigla;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }

    public String getSistemaOrigem() {
        return this.sistemaOrigem;
    }

    public void setSistemaOrigem(final String sistemaOrigem) {
        this.sistemaOrigem = sistemaOrigem;
    }

    public Localizacao getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(final Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public void visivelIntelipost() {
        this.integracaoIntelipost = true;
    }

    public void naoVisivelIntelipost() {
        this.integracaoIntelipost = null;
    }

    public void visivelSislogica() {
        this.integracaoIntelipost = true;
    }

    public void naoVisivelSislogica() {
        this.integracaoIntelipost = null;
    }

	public String getStatusRemetenteDePara() {
		return this.statusRemetenteDePara;
	}

	public void setStatusRemetenteDePara(final String statusRemetenteDePara) {
		this.statusRemetenteDePara = statusRemetenteDePara;
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
