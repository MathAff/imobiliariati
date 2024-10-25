<?php
namespace imobiliariati\DAO;

use imobiliariati\utils\ConnectionDB;
use PDOException;

class ImovelDAO {
    public function selectImoveis ($endereco) {
        $conn = ConnectionDB::connect();
        try {
            $sql = "SELECT * FROM imoveis im LEFT JOIN imagens img ON im.id = img.id_imovel WHERE im.id = ?";
            $stmt = $conn->prepare($sql);
            $stmt->bindParam(1, $endereco);
            return $stmt->execute();
        } catch (PDOException $e) {
            echo "Erro ao selecionar imoveis: $e";
        }
    }
}
?>