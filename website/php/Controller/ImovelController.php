<?php
namespace Controller;
use Model\Imovel;

class ImovelController {
    public static function consultarImoveisEImagens ($endereco) {
        $imovel = new Imovel();
        $imovel->setEndereco($endereco);
        return $imovel->consultarImoveis($imovel);
    }
}
?>