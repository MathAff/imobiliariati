<?php
namespace imobiliariati\utils;

use PDO;
use PDOException;

class ConnectionDB {
    public $conn = null;
    
    public static function connect () {
        $db = "imobiliariati";
        $user = "imobiliariati";
        $psw = "1f7.2;C1Kj7;";
        $server = "db4free.net";

        try {

            self::$conn = new PDO ('mysql:host='.$server.';dbname='.$db, $user, $psw);
            self::$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return self::$conn;

        } catch (PDOException $e) {

            echo "Erro ao conectar-se no banco de dados: ".$e;
            return null;

        }
    }

    public function disconnect () {
        try {
            $this->conn->close();
            $this->conn = null;
        } catch (PDOException $e) {
            echo ('não foi possível desconectar: '.$e);
        }
    }
}
?>