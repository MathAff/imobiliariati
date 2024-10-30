<?php
namespace utils;

class ConnectionFTP {
    private static $conn = null;

    public static function connect () {
        $ftpHost = "localhost";
        $ftpUser = "usuario";
        $ftpPsw = "123";
        if (!self::$conn = ftp_connect($ftpHost)){
            echo "Erro ao conectar ao FTP";
            die();
        }

        if (ftp_login(self::$conn, $ftpUser, $ftpPsw)) {
            return self::$conn;
        } else {
            echo "Falha ao autenticar servidor FTP";
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