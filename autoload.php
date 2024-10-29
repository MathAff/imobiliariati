<?php
spl_autoload_register(
    function (string $className){
        $pathComplete = str_replace("imobiliariati\\", "website" . DIRECTORY_SEPARATOR."php".DIRECTORY_SEPARATOR, $className);
        $path = str_replace('\\', DIRECTORY_SEPARATOR,  $pathComplete) . ".php";
        if (file_exists($path)) {
            require_once $path;
        } else {
            echo "Arquivo não existe";
        }
    });
?>