package br.com.viavarejo.domain.model.builder.eventoretornointelipost;

import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.Invoice;

public class InvoiceBuilder {

	private String serieNotaFiscal;
	private String numeroNotaFiscal;
	private String chaveNotaFiscal;

    private InvoiceBuilder() {}

    public static InvoiceBuilder init() {
        return new InvoiceBuilder();
    }

	public InvoiceBuilder serieNotaFiscal(final String serieNotaFiscal) {
		this.serieNotaFiscal = serieNotaFiscal;
		return this;
	}

	public InvoiceBuilder numeroNotaFiscal(final String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
		return this;
	}

	public InvoiceBuilder chaveNotaFiscal(final String chaveNotaFiscal) {
		this.chaveNotaFiscal = chaveNotaFiscal;
		return this;
	}



	public Invoice build() {

		final Invoice invoice = new Invoice();
		invoice.setSerieNotaFiscal(this.serieNotaFiscal);
		invoice.setNumeroNotaFiscal(this.numeroNotaFiscal);
		invoice.setChaveNotaFiscal(this.chaveNotaFiscal);
		return invoice;
    }
}
