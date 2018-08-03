package br.com.viavarejo.domain.model.mongodb.cobranca;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class PedidoVendaInforRessarcimento implements DomainObject<PedidoVendaInforRessarcimento> {

	private static final long serialVersionUID = 2144586912691308760L;

	@ApiModelProperty(notes = "Pedido venda", required = false)
	private String pedidoVenda;

	@ApiModelProperty(notes = "Pedido venda desmembramento", required = false)
	private String pedidoVendaDesmembramento;

	@ApiModelProperty(notes = "Pedido venda desmembramento", required = false)
	private BigDecimal valorDesconto;

    public PedidoVendaInforRessarcimento() {
        super();
    }


	public String getPedidoVenda() {
		return this.pedidoVenda;
	}

	public void setPedidoVenda(final String pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public String getPedidoVendaDesmembramento() {
		return this.pedidoVendaDesmembramento;
	}

	public void setPedidoVendaDesmembramento(final String pedidoVendaDesmembramento) {
		this.pedidoVendaDesmembramento = pedidoVendaDesmembramento;
	}

	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(final BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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
