<?php
require_once '../../autoload.php';

use Controller\ImovelController;
use utils\Functions;

if (!isset($_GET['search'])) {
    header('Location: index.html');
}

$search = $_GET['search'];

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
    <header>
        <div clas="header-div-logo">
            <img class="header-logo" src="../assets/images/logo.png" alt="Logo da Imobiliaria TI">
        </div>
        <div class="search-bar">
            <form action="search_results.php" method="GET">
                <div id="search-form" class="div-search">
                    <input id='filter' class='input-search' type="text" value=<?php echo "'$search'" ?> placeholder="Pesquisar Imóveis" name="search">
                    <button type="submit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                        </svg>
                    </button>
                </div>
            </form>
        </div>
    </header>
    <div class="search-container">
        <?php
            //creating an Array with the results from the database
            $rs = ImovelController::consultarImoveisEImagens($search);
            //loading the screen with the search results
            Functions::loadSearch($rs, $search);
        ?>
    </div>
    
</body>
</html>