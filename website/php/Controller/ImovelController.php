<?php
namespace Controller;
use Model\Imovel;

class ImovelController {
    public static function consultarImoveisEImagem ($endereco) {
        $imovel = new Imovel();
        $imovel->setEndereco($endereco);
        return $imovel->consultarImoveis($imovel);
    }

    public static function consultarTodasImagens ($id) {
        $imovel = new Imovel();
        $imovel->setId($id);
        return $imovel->consultarTodasImagens($imovel);
    }
}
?>