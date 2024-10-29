<?php
namespace imobiliariati\utils;

require_once 'autoload.php';

use PDO;
use PDOException;
use imobiliariati\utils\ConnectionCredencials;

class ConnectionDB {
    private $db = "imobiliariati";
    private $user = "imobiliariati";
    private $psw = "1f7.2;C1Kj7;";
    private $server = "db4free.net";

    public static $conn = null;
    
    public static function connect () {
        self::$db = ConnectionCredencials::getDb();
        self::$user = ConnectionCredencials::getUser();
        self::$psw = ConnectionCredencials::getPsw();
        self::$server = ConnectionCredencials::getServer();

        try {

            self::$conn = new PDO ('mysql:host='.self::$server.';dbname='.self::$db, self::$user, self::$psw);
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