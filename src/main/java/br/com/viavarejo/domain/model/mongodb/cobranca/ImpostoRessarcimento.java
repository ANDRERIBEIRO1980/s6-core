package br.com.viavarejo.domain.model.mongodb.cobranca;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class ImpostoRessarcimento implements DomainObject<ImpostoRessarcimento> {
    private static final long serialVersionUID = 2144586912691308760L;

	@ApiModelProperty(notes = "Valor PIS", required = false)
	private BigDecimal pis;

	@ApiModelProperty(notes = "Valor COFINS", required = false)
	private BigDecimal cofins;

	@ApiModelProperty(notes = "Valor ICMS", required = false)
	private BigDecimal icms;

	@ApiModelProperty(notes = "Valor origem ICMS ", required = false)
	private BigDecimal origemIcms;

	@ApiModelProperty(notes = "Valor destino ICMS ", required = false)
	private BigDecimal destinoIcms;

    public ImpostoRessarcimento() {
        super();
    }

	public BigDecimal getPis() {
		return this.pis;
	}

	public void setPis(final BigDecimal pis) {
		this.pis = pis;
	}

	public BigDecimal getCofins() {
		return this.cofins;
	}

	public void setCofins(final BigDecimal cofins) {
		this.cofins = cofins;
	}

	public BigDecimal getIcms() {
		return this.icms;
	}

	public void setIcms(final BigDecimal icms) {
		this.icms = icms;
	}

	public BigDecimal getOrigemIcms() {
		return this.origemIcms;
	}

	public void setOrigemIcms(final BigDecimal origemIcms) {
		this.origemIcms = origemIcms;
	}

	public BigDecimal getDestinoIcms() {
		return this.destinoIcms;
	}

	public void setDestinoIcms(final BigDecimal destinoIcms) {
		this.destinoIcms = destinoIcms;
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
