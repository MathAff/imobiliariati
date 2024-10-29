<?php
namespace imobiliariati\php\utils;

require_once '../../autoload.php';

use PDO;
use PDOException;
use imobiliariati\utils\ConnectionCredencials;

class ConnectionDB {

    public static $conn = null;    

    public static function connect () {
        new ConnectionCredencials();

        try {
            $connCredentials = new ConnectionCredencials();
            $db = $connCredentials->getDb();
            $server = $connCredentials->getServer();
            $user = $connCredentials->getUser();
            $psw = $connCredentials->getPsw();

            self::$conn = new PDO ('mysql:host='.$server.';dbname='.$db, $user, $psw);
            self::$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return self::$conn;

        } catch (PDOException $e) {

            echo "Erro ao conectar-se no banco de dados: ".$e;
            return null;

        }
    }

    public static function disconnect () {
        try {
            self::$conn->conn = null;
        } catch (PDOException $e) {
            echo ('não foi possível desconectar: '.$e->getMessage());
        }
    }
}
?>