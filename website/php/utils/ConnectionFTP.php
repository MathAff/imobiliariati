<?php
namespace imobiliariati\utils;

class ConnectionFTP {
    private $conn = null;

    public static function connect () {
        $ftpHost = "localhost";
        $ftpUser = "usuario";
        $ftpPsw = "123";
        self::$conn = ftp_connect($ftpHost) or die ("Nao foi possivevl conectar ao FTP");

        if (ftp_login(self::$conn, $ftpUser, $ftpPsw)) {
            return self::$conn;
        } else {
            die("Falha ao autenticar no servidor FTP");
            return false;
        }
    }

    public static function disconnect () {
        if (self::$conn != null) {
            ftp_close(self::$conn);
            self::$conn = null;
            return true;
        } else {
            return false;
        }
    }
}
?>