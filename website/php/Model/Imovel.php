<?php
class Imovel {
    private $id;
    private $idImobiliaria;
    private $idSubtipo;
    private $tipo;
    private $tamanho;
    private $quartos;
    private $suites;
    private $vagas;
    private $banheiros;
    private $valor;
    private $taxaCondominio;
    private $iptu;
    private $tipoNegocio;
    private $bairro;
    private $cidade;
    private $endereco;
    private $cep;
    private $descricao;
    private $statusImovel;

    public function __construct($id, $idImobiliaria, $idSubtipo, $tipo, $tamanho, $quartos, $suites, $vagas, $banheiros, $valor, $taxaCondominio, $iptu, $tipoNegocio, $bairro, $cidade, $endereco, $cep, $descricao, $statusImovel) {
        $this->id = $id;
        $this->idImobiliaria = $idImobiliaria;
        $this->idSubtipo = $idSubtipo;
        $this->tipo = $tipo;
        $this->tamanho = $tamanho;
        $this->quartos = $quartos;
        $this->suites = $suites;
        $this->vagas = $vagas;
        $this->banheiros = $banheiros;
        $this->valor = $valor;
        $this->taxaCondominio = $taxaCondominio;
        $this->iptu = $iptu;
        $this->tipoNegocio = $tipoNegocio;
        $this->bairro = $bairro;
        $this->cidade = $cidade;
        $this->endereco = $endereco;
        $this->cep = $cep;
        $this->descricao = $descricao;
        $this->statusImovel= $statusImovel;
    }

    public function getId () {
        return $this->id;
    }

    public function setId ($id) {
        $this->id = $id;
    }

    public function getIdImobiliaria () {
        return $this->idImobiliaria;
    }

    public function setIdImobiliaria ($idImobiliaria) {
        $this->idImobiliaria = $idImobiliaria;
    }
    
    public function getIdSubtipo () {
        return $this->idSubtipo;
    }

    public function setIdSubtipo ($idSubtipo) {
        $this->idSubtipo = $idSubtipo;
    }
    
    public function getTipo () {
        return $this->tipo;
    }

    public function setTipo ($tipo) {
        $this->tipo = $tipo;
    }

    public function getTamanho () {
        return $this->tamanho;
    }

    public function setTamanho ($tamanho) {
        $this->tamanho = $tamanho;
    }
    
    public function getQuartos () {
        return $this->quartos;
    }

    public function setQuartos ($quartos) {
        $this->quartos = $quartos;
    }
    
    public function getSuites () {
        return $this->suites;
    }

    public function setSuites ($suites) {
        $this->suites = $suites;
    }
    
    public function getVagas () {
        return $this->vagas;
    }

    public function setVagas ($vagas) {
        $this->vagas = $vagas;
    }
    
    public function getBanheiros () {
        return $this->banheiros;
    }

    public function setBanheiros ($banheiros) {
        $this->banheiros = $banheiros;
    }
    
    public function getValor () {
        return $this->valor;
    }

    public function setValor ($valor) {
        $this->valor = $valor;
    }
    
    public function getTaxaCondominio ($taxaCondominio) {
        return $this->taxaCondominio;
    }

    public function setTaxaCondominio ($taxaCondominio) {
        $this->taxaCondominio = $taxaCondominio;
    }
    
    public function getIptu () {
        return $this->iptu;
    }

    public function setIptu ($iptu) {
        $this->iptu = $iptu;
    }

    public function getTipoNegocio () {
        return $this->tipoNegocio;
    }

    public function setTipoNegocio ($tipoNegocio) {
        $this->tipoNegocio = $tipoNegocio;
    }
    
    public function getBairro () {
        return $this->bairro;
    }

    public function setBairro ($bairro) {
        $this->bairro = $bairro;
    }
    
    public function getCidade () {
        return $this->cidade;
    }

    public function setCidade ($cidade) {
        $this->cidade = $cidade;
    }
    
    public function getEndereco () {
        return $this->endereco;
    }

    public function setEndereco ($endereco) {
        $this->endereco = $endereco;
    }
    
    public function getCep () {
        return $this->cep;
    }

    public function setCep ($cep) {
        $this->cep = $cep;
    }
    
    public function getDescricao () {
        return $this->descricao;
    }

    public function setDescricao ($descricao) {
        $this->descricao = $descricao;
    }
    
    public function getStatusImovel () {
        return $this->statusImovel;
    }

    public function setStatusImovel ($statusImovel) {
        $this->statusImovel = $statusImovel;
    }
}
?>