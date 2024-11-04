<?php
namespace DAO;

use utils\ConnectionDB;
use PDOException;
use PDOStatement;

class ImovelDAO {
    public function selectImoveis ($imovel) {
        $conn = ConnectionDB::connect();
        try {
            $sql = "SELECT im.*, MIN(img.nome_arquivo) AS imagem, st.nome FROM imoveis im LEFT JOIN imagens img  ON im.id_imovel = img.id_imovel LEFT JOIN subtipos st ON im.id_subtipo = st.id_subtipo WHERE im.endereco LIKE ? GROUP BY im.id_imovel";
            $stmt = $conn->prepare($sql);
            $stmt->bindValue(1, '%'. $imovel->getEndereco().'%');
            $stmt->execute();
            return $stmt->fetchAll();
        } catch (PDOException $e) {
            echo "Erro ao selecionar imoveis: ".$e->getMessage();
        }
    }

    public function selectAllImagens ($imovel) {
        $conn = ConnectionDB::connect();
        try {
            $sql = "SELECT * FROM imoveis im INNER JOIN imagens img ON im.id_imovel = img.id_imovel WHERE im.id_imovel = ?";
            $stmt = $conn->prepare($sql);
            
            $stmt->bindValue (1, $imovel->getId());
            $stmt->execute();

            return $stmt->fetchAll();
        } catch (PDOException $e) {
            echo $e->getMessage();
        }
    }
}
?>