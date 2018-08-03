package br.com.viavarejo.domain.model.mongodb.cobranca;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class NotaFiscalRessarcimento implements DomainObject<NotaFiscalRessarcimento> {

	private static final long serialVersionUID = 2144586912691308760L;

	@ApiModelProperty(notes = "Nota fiscal pedido venda", required = false)
	private String notaFiscalVenda;

	@ApiModelProperty(notes = "Nota fiscal pedido venda serie", required = false)
	private String notaFiscalVendaSerie;

    public NotaFiscalRessarcimento() {
        super();
	}

	public String getNotaFiscalVenda() {
		return this.notaFiscalVenda;
	}

	public void setNotaFiscalVenda(final String notaFiscalVenda) {
		this.notaFiscalVenda = notaFiscalVenda;
	}

	public String getNotaFiscalVendaSerie() {
		return this.notaFiscalVendaSerie;
	}



	public void setNotaFiscalVendaSerie(final String notaFiscalVendaSerie) {
		this.notaFiscalVendaSerie = notaFiscalVendaSerie;
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
