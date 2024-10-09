<?php
class Connection {
    public $conn = null;
    
    public function connect () {
        $db = "imobiliariati";
        $user = "imobiliariati";
        $psw = "1f7.2;C1Kj7;";
        $server = "db4free.net";

        try {

            $this->conn = new PDO ('mysql:host='.$server.';dbname='.$db, $user, $psw);
            return $this->conn;

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