<?php
spl_autoload_register(
    function (string $className){
        $pathComplete = str_replace("imobiliariati\\Controller;", "website", $className);
        $path = str_replace('\\', DIRECTORY_SEPARATOR, $pathComplete);
        $path .= '.php';
        if (file_exists($path)) {
            require_once $path;
        }
    });
?>