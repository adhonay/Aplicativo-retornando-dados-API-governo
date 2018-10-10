package com.software.tp.adhonay.tp02lddm;

import java.io.Serializable;
import java.text.DecimalFormat;


public class Contrato implements Serializable {

    int uasg,  codigoContrato,numeroAvisoLicitacao,numero,numeroAditivo;
    String identificador,licitacaoAssociada,origemLicitacao,numeroProcesso, cnpj_contratada,cnpjContratada, objeto, dataAssinatura,
            fundamentoLegal,dataInicioVigencia,dataFinalVigencia,valorInicial;

    public Contrato(String identificador,String licitacaoAssociada, String origemLicitacao,String numeroProcesso,String cnpjContratada,String dataAssinatura,String fundamentoLegal,
                    String dataInicioVigencia,String dataFinalVigencia,int numeroAvisoLicitacao,int numero,int numeroAditivo, int uasg, int  codigoContrato, String objeto, String valorInicial) {

        this.identificador = identificador;
        this.licitacaoAssociada = licitacaoAssociada;
        this.origemLicitacao = origemLicitacao;
        this.numeroProcesso = numeroProcesso;
        this.cnpj_contratada = cnpjContratada;
        this.dataAssinatura = dataAssinatura;
        this.fundamentoLegal = fundamentoLegal;
        this.dataInicioVigencia = dataInicioVigencia;
        this.dataFinalVigencia = dataFinalVigencia;
        this.numeroAvisoLicitacao = numeroAvisoLicitacao;
        this.numero = numero;
        this.numeroAditivo = numeroAditivo;
        this.uasg = uasg;
        this.codigoContrato = codigoContrato;
        this.objeto = objeto;
        this.valorInicial = valorInicial;


    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getLicitacaoAssociada() {
        return licitacaoAssociada;
    }

    public void setLicitacaoAssociada(String licitacaoAssociada) {
        this.licitacaoAssociada = licitacaoAssociada;
    }

    public String getOrigemLicitacao() {
        return origemLicitacao;
    }

    public void setOrigemLicitacao(String origemLicitacao) {
        this.origemLicitacao = origemLicitacao;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getCnpjContratada() {
        return cnpjContratada;
    }

    public void setCnpjContratada(String cnpjContratada) {
        this.cnpjContratada = cnpjContratada;
    }

    public String getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(String dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public String getFundamentoLegal() {
        return fundamentoLegal;
    }

    public void setFundamentoLegal(String fundamentoLegal) {
        this.fundamentoLegal = fundamentoLegal;
    }

    public String getDataInicioVigencia() {
        return dataInicioVigencia;
    }

    public void setDataInicioVigencia(String dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
    }

    public String getDataFinalVigencia() {
        return dataFinalVigencia;
    }

    public void setDataFinalVigencia(String dataFinalVigencia) {
        this.dataFinalVigencia = dataFinalVigencia;
    }

    public int getUasg() {
        return uasg;
    }

    public void setUasg(int uasg) {
        this.uasg = uasg;
    }



    public int getNumeroAvisoLicitacao() {
        return numeroAvisoLicitacao;
    }

    public void setNumeroAvisoLicitacao(int numeroAvisoLicitacao) {
        this.numeroAvisoLicitacao = numeroAvisoLicitacao;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroAditivo() {
        return numeroAditivo;
    }

    public void setNumeroAditivo(int numeroAditivo) {
        this.numeroAditivo = numeroAditivo;
    }

    public String getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(String valorInicial) {
        this.valorInicial = valorInicial;
    }

}