<?php
namespace Model;
use DAO\ImovelDAO;

require_once "../../autoload.php";

class Imovel {
    private $id;
    private $endereco;

    public function getId () {
        return $this->id;
    }

    public function setId ($id) {
        $this->id = $id;
    }

    public function getEndereco () {
        return $this->endereco;
    }

    public function setEndereco ($endereco) {
        $this->endereco = $endereco;
    }

    public function consultarImoveis ($imovel) {
        $imDAO = new ImovelDAO();
        return $imDAO->selectImoveis($imovel);
    }

    public function consultarTodasImagens ($imovel) {
        $imDAO = new ImovelDAO();
        return $imDAO->selectAllImagens($imovel);
    }
}
?>