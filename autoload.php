<?php
spl_autoload_register(function ($className) {
    $baseDir = __DIR__ . '\\website\\php\\';
    $file = $baseDir . str_replace('\\', '/', $className) . '.php';

    if (file_exists($file)) {
        require_once $file;
    } else {
        echo "Erro: Classe não encontrada -> $file <br>";
    }
});
?>