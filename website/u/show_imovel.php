<?php
require_once '../../autoload.php';

use utils\Functions;

if (!isset($_GET['idImovel'])) {
    header('Location: index.html');
}

$idImovel = $_GET['idImovel'];

$rs = Functions::getResultSetImovel($idImovel);
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $rs[0]['endereco']; ?></title>
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
        <?php
        Functions::loadImovelDescription($rs);
        ?>
    </main>
    <script src="show_slides.js"></script>
</body>
</html>