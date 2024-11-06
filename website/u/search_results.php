<?php
require_once '../../autoload.php';

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
    <title>Resulatdos</title>
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
        <div class="search-container">
            <?php
                //loading the screen with the search results
                Functions::loadSearch($search);
            ?>
            <!--<div class='card'>
                <img src='../assets/images/no-image.png' alt='Imagem do Imovel' class='card-img'>
                <div class='card-content'>
                    <h3>Cidade - Bairro - 00</h3>
                    <h4>Casa Condomínio</h4>
                    <h4>Venda: R$001,00</h4>
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Sapiente, reiciendis quas. Cumque, architecto repellendus? Nisi exercitationem sed, cumque, quas similique quisquam quo aliquam libero, laudantium quae eaque accusamus ad quia?</p>
                    <div class='table'>
                        <div class='table-icon'>
                            <svg class='icon icon-ruler' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><g fill='none' stroke='currentColor' stroke-width='1.5'><path d='M4.045 18.508C2.682 17.145 2 16.463 2 15.616c0-.848.682-1.53 2.045-2.893l8.678-8.678C14.087 2.682 14.768 2 15.616 2s1.529.682 2.892 2.045l1.447 1.447C21.318 6.855 22 7.537 22 8.384s-.682 1.53-2.045 2.893l-8.678 8.678C9.913 21.318 9.23 22 8.384 22s-1.529-.682-2.892-2.045z'/><path stroke-linecap='round' d='M8.464 8.464L9.88 9.88m2.827-5.658l1.414 1.414m-9.899 7.071l1.414 1.414m.707-3.535l2.122 2.121m2.121-6.364l2.121 2.121'/></g></svg>
                            <label for='icon-ruler'>00</label>
                        </div>

                        <div class='table-icon'>
                            <svg class='icon icon-bed' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><path fill='currentColor' d='M7 14c1.66 0 3-1.34 3-3S8.66 8 7 8s-3 1.34-3 3s1.34 3 3 3m0-4c.55 0 1 .45 1 1s-.45 1-1 1s-1-.45-1-1s.45-1 1-1m12-3h-8v8H3V5H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4m2 8h-8V9h6c1.1 0 2 .9 2 2Z'/></svg>
                            <label for='icon-bed'>00</label>
                        </div>
                        <div class='table-icon'>
                            <svg class='icon icon-garage' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 512 512'><path fill='currentColor' d='M448 255.454h-.511L407.067 164.5A48.04 48.04 0 0 0 363.2 136H148.8a48.04 48.04 0 0 0-43.863 28.5l-40.426 90.954H64a32.036 32.036 0 0 0-32 32v112a32.036 32.036 0 0 0 32 32V472a24.03 24.03 0 0 0 24 24h56a24.03 24.03 0 0 0 24-24v-40.546h176V472a24.03 24.03 0 0 0 24 24h56a24.03 24.03 0 0 0 24-24v-40.546a32.036 32.036 0 0 0 32-32v-112a32.036 32.036 0 0 0-32-32M134.175 177.5A16.01 16.01 0 0 1 148.8 168h214.4a16.01 16.01 0 0 1 14.621 9.5l34.646 77.953H99.529ZM136 464H96v-32.546h40Zm280 0h-40v-32.546h40Zm32-64.546H64v-112h384Z'/><path fill='currentColor' d='M96 328h80v32H96zm240 0h80v32h-80zM256 14.758L16 111.121v34.483l240-96.362l240 96.362v-34.483z'/></svg>
                            <label for='icon-garage'>00</label>
                        </div>

                        <div class='table-icon'>
                            <svg class='icon icon-toilet' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><path fill='currentColor' d='M9 22h8v-2.5c2.41-1.63 4-4.38 4-7.5V4a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v8H3c0 3.09 2 6 6 7.5zm-3.71-8h13.42A7.02 7.02 0 0 1 15 18.33V20h-4v-1.67C9 18 5.86 15.91 5.29 14M15 4h4v8h-4zm1 1v3h2V5z'/></svg>
                            <label for='icon-toilet'>00</label>
                        </div>

                        <div class='table-icon'>
                            <svg class='icon icon-bathtub' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><g fill='none' stroke='currentColor' stroke-linecap='round' stroke-linejoin='round' stroke-width='1.5'><path d='M21 13v3a4 4 0 0 1-4 4H7a4 4 0 0 1-4-4v-2.4a.6.6 0 0 1 .6-.6zm-5 7l1 2m-9-2l-1 2m14-9V7a4 4 0 0 0-4-4h-5'/><path d='M15.4 8H8.6c-.331 0-.596-.268-.56-.598C8.186 6.075 8.863 3 12 3s3.814 3.075 3.96 4.402c.036.33-.229.598-.56.598'/></g></svg>
                            <label for='icon-bathtub'>00</label>
                        </div>
                    </div>
                    <h4>Imobiliaria teste</h4>
                    <form action='show_imovel.php' method='GET'>
                        <input class='button' type='submit' value='Ler mais'>
                        <input type='hidden' name='idImovel' value='1'>
                    </form>
                </div>
            </div>-->
        </div>
    </main>
</body>
</html>