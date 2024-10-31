<?php
require_once '../../autoload.php';

use utils\ConnectionDB;
use utils\ConnectionFTP;

if (!isset($_GET['idImovel'])) {
    header('Location: index.html');
}

//$conn = ConnectionDB::connect();
//$ftp = ConnectionFTP::connect();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Imobiliaria TI</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <link rel="shortcut icon" href="../assets/images/favicon.png" type="image/x-icon">
    <script src="script.js" defer></script>
</head>
<body>
    <?php
    include_once 'head.php';
    ?>
    <main>
        <div class="content">
            <div class="previous-image" id='previous-image'>
                <img src="../assets/images/previous-image.png" alt="Icone de uma seta para esquerda">
            </div>
            <div class="slider">
                <div class="slides">
                    <input type="radio" name="radio-btn" id="radio1">
                    <input type="radio" name="radio-btn" id="radio2">
                    <input type="radio" name="radio-btn" id="radio3">
                    <input type="radio" name="radio-btn" id="radio4">
                    
                    <div class="slide first">
                        <img src="../imagens-imoveis/1/1_sc8967.png" alt="Imagem do Imovel">
                    </div>
                    <div class="slide">
                        <img src="../imagens-imoveis/1/1_sc88i0.jpg" alt="Imagem do Imovel">
                    </div>
                    <div class="slide">
                        <img src="../imagens-imoveis/1/1_sc8967.png" alt="Imagem do Imovel">
                    </div>
                    <div class="slide">
                        <img src="../imagens-imoveis/1/1_sc8967.png" alt="Imagem do Imovel">
                    </div>
                    <div class="nav-auto">
                        <div class="auto-btn1"></div>
                        <div class="auto-btn2"></div>
                        <div class="auto-btn3"></div>
                        <div class="auto-btn4"></div>
                    </div>
                </div>
                
                <div class="manual-nav">
                    <label for="radio1" class="manual-btn"></label>
                    <label for="radio2" class="manual-btn"></label>
                    <label for="radio3" class="manual-btn"></label>
                    <label for="radio4" class="manual-btn"></label>
                </div>
            </div>
            <div class="next-image" id='next-image'>
                <img src="../assets/images/next-image.png" alt="Icone de uma seta para direita">
            </div>
        </div>
    </main>
    <script src="show_slides.js"></script>
</body>
</html>