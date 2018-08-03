package br.com.viavarejo.domain.model.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.viavarejo.domain.DomainObject;

@Document(collection = "log_aplicacao")
public class LogAplicacao implements DomainObject<LogAplicacao> {
    private static final long serialVersionUID = -2861678742279759967L;

    @Id
    private ObjectId id;

    private String dataHora;

    private String nivel;

    private String processo;

    private String linha;

    private String logMessage;


    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public String getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(final String dataHora) {
        this.dataHora = dataHora;
    }

    public String getNivel() {
        return this.nivel;
    }

    public void setNivel(final String nivel) {
        this.nivel = nivel;
    }

    public String getProcesso() {
        return this.processo;
    }

    public void setProcesso(final String processo) {
        this.processo = processo;
    }

    public String getLinha() {
        return this.linha;
    }

    public void setLinha(final String linha) {
        this.linha = linha;
    }

    public String getLogMessage() {
        return this.logMessage;
    }

    public void setLogMessage(final String logMessage) {
        this.logMessage = logMessage;
    }

}
