<?php
namespace utils;

use utils\ConnectionDB;
use utils\ConnectionFTP;

class Functions {
    public static function loadSearch ($rs, $search) {
        if (!empty($rs)) {
            $ftp = ConnectionFTP::connect();
            ftp_pasv($ftp, true);

            foreach ($rs as $row) {
                $imagePath = "../assets/images/no-image.png";

                if ($row['imagem'] != null) {
                    $imagePath = "../imagens-imoveis/".$row['id_imovel']."/".$row['imagem'];
                }

                $number = preg_split('/[-_]/', $row['endereco'])[3] ?? 'N/A';
                echo "<div class='card'>
                        <img src='$imagePath' alt='Imagem do Imovel' class='card-img'>
                            <div class='card-content'>
                                <h3>". $row['cidade']." - ".$row['bairro'] . " - " . $number ."</h3>
                                <p>". $row['descricao']."</p>
                                <form action='imovel.php' method='GET'>
                                    <input class='button' type='submit' value='Ler mais'>
                                    <input type='hidden' name='idImovel' value='".$row['id_imovel']."'>
                                </form>
                            </div>
                        </div>";
            }
            ConnectionFTP::disconnect();
            ConnectionDB::disconnect();
        } else {
            echo "<div class='warning'>Não foi possível encontrar nenhum resultado para: <p class='search-warning'>$search.</p> Pesquise novamente.</div>";
        }
    }
}
?>