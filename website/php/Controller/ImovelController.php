<?php
namespace imobiliariati\Controller;
use imobiliariati\Model\Imovel;

class ImovelController {
    public static function consultarImoveisEImagens ($endereco) {
        $imovel = new Imovel();
        $imovel->setEndereco($endereco);
        
        return $imovel->consultarImoveis($imovel);
    }
}
?>