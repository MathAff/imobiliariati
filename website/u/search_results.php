<?php
require_once 'autoload.php';

use PDOException;
use imobiliariati\utils\ConnectionDB;
use imobiliariati\utils\ConnectionFTP;

if (!isset($_GET['search'])) {
    header('Location: index.html');
}

$conn = ConnectionDB::connect();
$ftp = ConnectionFTP::connect();

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
                    <input id='filter' class='input-search' type="text" value=<?php echo "'$search'" ?> placeholder="Pesquisar Imóveis" name="search" autofocus>
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
            $remoteDir = "/imagens-imoveis";
            $localDir = "assets/images/";

            $files = ftp_nlist($ftp, $remoteDir);

            if ($files === false) {
                die ("<div class='error'>Não foi possível listar os arquivos</div>");
            }

            foreach ($files as $file) {
                $fileName = basename($file);
                $localPath = $localDir . $fileName;

                if (!ftp_get($ftp, $localPath, $file, FTP_BINARY)){
                    echo "Falha ao baixar o arquivo $fileName";
                }
            }

            ConnectionFTP::disconnect();

            $rs = null;

            try {
                $stmt = $conn->prepare("SELECT * FROM imoveis im LEFT JOIN imagens img ON im.id = img.id_imovel WHERE im.enderco LIKE %?%");
                $stmt->bindParam(1, $search);
                $rs = $stmt->fetchAll();
            } catch (PDOException $e) {
                echo "Erro ao procurar imoveis: $e";
            }

            if ($rs != null) {
                foreach ($rs as $row) {
                    $imagePath = $localDir . $row["nome_arquivo"];

                    if (file_exists($imagePath)) {
                        echo "<div class='card'>
                                <img src='$imamgePath' alt='Imagem do Imovel' class='card-img'>
                                    <div class='card-content'>
                                        <h3>". $rs['Endereco']."</h3>
                                        <p>". $rs['descricao']."</p>
                                        <a href='#' class='button'>Mais</a>
                                    </div>
                                </div>";
                    }
                }
            }
        ?>
        <div class='card'>
            <img src='../assets/images/no-image.png' alt='Imagem do Imovel' class='card-img'>
            <div class='card-content'>
                <h3>Card 1</h3>
                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magni, deserunt accusamus. Vel nihil expedita atque eius alias dolor, facilis officia adipisci, aliquid commodi culpa odio? Ad saepe earum fuga velit?</p>
                <a href='#' class='button'>Mais</a>
            </div>
        </div>
        <div class="card">
            <img src="../assets/images/no-image.png" alt="Imagem do Imovel" class="card-img">
            <div class="card-content">
                <h3>Card 2</h3>
                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magni, deserunt accusamus. Vel nihil expedita atque eius alias dolor, facilis officia adipisci, aliquid commodi culpa odio? Ad saepe earum fuga velit?</p>
                <a href="#" class="button">Mais</a>
            </div>
        </div>
        <div class="card">
            <img src="../assets/images/no-image.png" alt="Imagem do Imovel" class="card-img">
            <div class="card-content">
                <h3>Card 3</h3>
                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magni, deserunt accusamus. Vel nihil expedita atque eius alias dolor, facilis officia adipisci, aliquid commodi culpa odio? Ad saepe earum fuga velit?</p>
                <a href="#" class="button">Mais</a>
            </div>
        </div>

        <?php
        
        ?>
    </div>
    
</body>
</html>