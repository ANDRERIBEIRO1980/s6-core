package br.com.viavarejo.domain.model.mongodb.transportador;

import static br.com.viavarejo.util.PortalTransportadorUtils.valoresConcatenados;
import static br.com.viavarejo.util.Utils.isNotNull;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.domain.model.enumerator.TipoAcaoRegistroEnum;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "transportador")
public class Transportador implements DomainObject<Transportador> {

    private static final long serialVersionUID = -1806236791502648035L;

    @Id
    @ApiModelProperty(notes = "ID da transportadora gerada pelo Banco", allowEmptyValue = true)
    private ObjectId id;

    @Indexed
    @ApiModelProperty(notes = "Chave composta da transportadora no DB2", required = true)
    @Valid
    private TransportadorPK pk;

    @ApiModelProperty(notes = "CNPJ da Transportadora", allowEmptyValue = true)
    @NotBlank
    private String cnpj;

    @ApiModelProperty(notes = "Razão Social", allowEmptyValue = true)
    private String razaoSocial;

    @ApiModelProperty(notes = "Código do funcionário Casas Bahia", allowEmptyValue = true)
    private Integer codigoFuncionarioCasasBahia;

    @ApiModelProperty(notes = "Contato comercial da Transportadora", required = true)
    @Valid
    private ContatoTransportador contatoComercial;

    @ApiModelProperty(notes = "Contato do responsável pela Transportadora", required = true)
    @Valid
    private ContatoTransportador contatoResponsavel;

    @ApiModelProperty(notes = "Nome do arquivo original. Ex: arquivo_21-78.csv", allowEmptyValue = true)
    private String nomeArquivoOriginal;

    @ApiModelProperty(notes = "Nome do arquivo zipado. Ex: arquivo_21-78.zip", allowEmptyValue = true)
    private String nomeArquivoGeradoZip;

    @ApiModelProperty(notes = "Arquivo contendo informações adicionais com extensão .zip no formato String base64", allowEmptyValue = true)
    private String file1ZipBase64; // ok FIXME removido do equals hashcode

    @Indexed
    @ApiModelProperty(notes = "Flag para tornar a entidade visível à integração", hidden = true)
    private Boolean integracaoIntelipost;

    @ApiModelProperty(notes = "Representa se a ação será de criação ou atualização de transportador: (1) Nova ou (2) Atualização",
                    allowEmptyValue = true)
    private Integer tipoAcao;

    @ApiModelProperty(
                    notes = "Código gerado a partir das PKs composta da transportadora. Ex: codigoEmpresa = 21, codigo = 5000 -> codigoIntegrado = 215000",
                    allowEmptyValue = true)
    private String codigoIntegrado;

    @ApiModelProperty(notes = "Comentários do Transportador", allowEmptyValue = true)
    private String comentarios;

    public Transportador() {}

    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public TransportadorPK getPk() {
        return this.pk;
    }

    public void setPk(final TransportadorPK pk) {
        this.pk = pk;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Integer getCodigoFuncionarioCasasBahia() {
        return this.codigoFuncionarioCasasBahia;
    }

    public void setCodigoFuncionarioCasasBahia(final Integer codigoFuncionarioCasasBahia) {
        this.codigoFuncionarioCasasBahia = codigoFuncionarioCasasBahia;
    }

    public ContatoTransportador getContatoComercial() {
        return this.contatoComercial;
    }

    public void setContatoComercial(final ContatoTransportador contatoComercial) {
        this.contatoComercial = contatoComercial;
    }

    public ContatoTransportador getContatoResponsavel() {
        return this.contatoResponsavel;
    }

    public void setContatoResponsavel(final ContatoTransportador contatoResponsavel) {
        this.contatoResponsavel = contatoResponsavel;
    }

    public String getNomeArquivoOriginal() {
        return this.nomeArquivoOriginal;
    }

    public void setNomeArquivoOriginal(final String nomeArquivoOriginal) {
        this.nomeArquivoOriginal = nomeArquivoOriginal;
    }

    public String getNomeArquivoGeradoZip() {
        return this.nomeArquivoGeradoZip;
    }

    public void setNomeArquivoGeradoZip(final String nomeArquivoGeradoZip) {
        this.nomeArquivoGeradoZip = nomeArquivoGeradoZip;
    }

    public String getFile1ZipBase64() {
        return this.file1ZipBase64;
    }

    public void setFile1ZipBase64(final String file1ZipBase64) {
        this.file1ZipBase64 = file1ZipBase64;
    }

    public Integer getTipoAcao() {
        return this.tipoAcao;
    }

    public TipoAcaoRegistroEnum getTipoAcaoEnum() {
        return TipoAcaoRegistroEnum.getInstance(this.tipoAcao);
    }

    public void setTipoAcao(final TipoAcaoRegistroEnum tipoAcao) {
        this.tipoAcao = isNotNull(tipoAcao) ? tipoAcao.getCodigo() : null;
    }

    public String getCodigoIntegrado() {
        return this.codigoIntegrado;
    }

    public void setCodigoIntegrado(final String codigoIntegrado) {
        this.codigoIntegrado = codigoIntegrado;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(final String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Prepara a entidade antes de submeta-la ao banco:<br>
     * - Torna visivel para a integracao com a Intelipost<br>
     * - Torna visivel o tipo de operacao que sera realizada - novo ou atualizacao<br>
     * - Gera um id unico com base na pk da entidade<br>
     *
     */
    public void prepararEntidade(final TipoAcaoRegistroEnum tipoAcao) {
        this.visivelIntelipost();
        this.setTipoAcao(tipoAcao);
        this.codigoIntegrado = valoresConcatenados(this.pk.getCodigoEmpresa(), this.pk.getCodigo());
    }

    public void visivelIntelipost() {
        this.integracaoIntelipost = true;
    }

    public void naoVisivelIntelipost() {
        this.integracaoIntelipost = null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.cnpj == null) ? 0 : this.cnpj.hashCode());
        result = (prime * result) + ((this.codigoFuncionarioCasasBahia == null) ? 0 : this.codigoFuncionarioCasasBahia.hashCode());
        result = (prime * result) + ((this.comentarios == null) ? 0 : this.comentarios.hashCode());
        result = (prime * result) + ((this.contatoComercial == null) ? 0 : this.contatoComercial.hashCode());
        result = (prime * result) + ((this.contatoResponsavel == null) ? 0 : this.contatoResponsavel.hashCode());
        result = (prime * result) + ((this.pk == null) ? 0 : this.pk.hashCode());
        result = (prime * result) + ((this.razaoSocial == null) ? 0 : this.razaoSocial.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Transportador other = (Transportador) obj;
        if (this.cnpj == null) {
            if (other.cnpj != null) {
                return false;
            }
        } else if (!this.cnpj.equals(other.cnpj)) {
            return false;
        }
        if (this.codigoFuncionarioCasasBahia == null) {
            if (other.codigoFuncionarioCasasBahia != null) {
                return false;
            }
        } else if (!this.codigoFuncionarioCasasBahia.equals(other.codigoFuncionarioCasasBahia)) {
            return false;
        }
        if (this.comentarios == null) {
            if (other.comentarios != null) {
                return false;
            }
        } else if (!this.comentarios.equals(other.comentarios)) {
            return false;
        }
        if (this.contatoComercial == null) {
            if (other.contatoComercial != null) {
                return false;
            }
        } else if (!this.contatoComercial.equals(other.contatoComercial)) {
            return false;
        }
        if (this.contatoResponsavel == null) {
            if (other.contatoResponsavel != null) {
                return false;
            }
        } else if (!this.contatoResponsavel.equals(other.contatoResponsavel)) {
            return false;
        }
        if (this.pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!this.pk.equals(other.pk)) {
            return false;
        }
        if (this.razaoSocial == null) {
            if (other.razaoSocial != null) {
                return false;
            }
        } else if (!this.razaoSocial.equals(other.razaoSocial)) {
            return false;
        }
        return true;
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
