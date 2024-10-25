<?php
namespace imobiliariati\Model;
class Imagem {
    private $id;
    private $idImovel;
    private $nomeArquivo;

    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getIdImovel() {
        return $this->idImovel;
    }

    public function setIdImovel($idImovel) {
        $this->idImovel = $idImovel;
    }

    public function getNomeArquivo () {
        return $this->nomeArquivo;
    }

    public function setNomeArquivo($nomeArquivo) {
        $this->nomeArquivo = $nomeArquivo;
    }
}
?>