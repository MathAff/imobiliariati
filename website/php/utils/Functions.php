<?php
namespace utils;

use Controller\ImovelController;
use utils\ConnectionDB;
use utils\ConnectionFTP;

class Functions {
    public static function loadSearch ($search) {
        $rs = ImovelController::consultarImoveisEImagem($search);

        if (!empty($rs)) {
            $ftp = ConnectionFTP::connect();
            ftp_pasv($ftp, true);

            foreach ($rs as $row) {
                $imagePath = '../assets/images/no-image.png';

                if ($row['imagem'] != null) {
                    $imagePath = "../imagens-imoveis/".$row['id_imovel']."/".$row['imagem'];
                }

                $subtipo = $row['nome'];
                $subtipoReplaced = str_replace("_", " ", $subtipo);

                $number = preg_split('/[-_]/', $row['endereco'])[3] ?? 'N/A';
                echo "<div class='card'>
                <img src='".$imagePath."' alt='Imagem do Imovel' class='card-img'>
                <div class='card-content'>
                    <h3>". $row['cidade']." - ".$row['bairro'] . " - " . $number ."</h3>
                    <h4>".$subtipoReplaced."</h4>
                    <h4>". $row['tipo_negocio'].": R$".$row['valor']."</h4>
                    <p>".$row['descricao']."</p>
                    <div class='table'>
                        <div class='table-icon'>
                            <svg class='icon icon-ruler' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><g fill='none' stroke='currentColor' stroke-width='1.5'><path d='M4.045 18.508C2.682 17.145 2 16.463 2 15.616c0-.848.682-1.53 2.045-2.893l8.678-8.678C14.087 2.682 14.768 2 15.616 2s1.529.682 2.892 2.045l1.447 1.447C21.318 6.855 22 7.537 22 8.384s-.682 1.53-2.045 2.893l-8.678 8.678C9.913 21.318 9.23 22 8.384 22s-1.529-.682-2.892-2.045z'/><path stroke-linecap='round' d='M8.464 8.464L9.88 9.88m2.827-5.658l1.414 1.414m-9.899 7.071l1.414 1.414m.707-3.535l2.122 2.121m2.121-6.364l2.121 2.121'/></g></svg>
                            <label for='icon-ruler'>".$row['tamanho']."m²"."</label>
                        </div>

                        <div class='table-icon'>
                            <svg class='icon icon-bed' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><path fill='currentColor' d='M7 14c1.66 0 3-1.34 3-3S8.66 8 7 8s-3 1.34-3 3s1.34 3 3 3m0-4c.55 0 1 .45 1 1s-.45 1-1 1s-1-.45-1-1s.45-1 1-1m12-3h-8v8H3V5H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4m2 8h-8V9h6c1.1 0 2 .9 2 2Z'/></svg>
                            <label for='icon-bed'>".$row['quartos']."</label>
                        </div>
                        <div class='table-icon'>
                            <svg class='icon icon-garage' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 512 512'><path fill='currentColor' d='M448 255.454h-.511L407.067 164.5A48.04 48.04 0 0 0 363.2 136H148.8a48.04 48.04 0 0 0-43.863 28.5l-40.426 90.954H64a32.036 32.036 0 0 0-32 32v112a32.036 32.036 0 0 0 32 32V472a24.03 24.03 0 0 0 24 24h56a24.03 24.03 0 0 0 24-24v-40.546h176V472a24.03 24.03 0 0 0 24 24h56a24.03 24.03 0 0 0 24-24v-40.546a32.036 32.036 0 0 0 32-32v-112a32.036 32.036 0 0 0-32-32M134.175 177.5A16.01 16.01 0 0 1 148.8 168h214.4a16.01 16.01 0 0 1 14.621 9.5l34.646 77.953H99.529ZM136 464H96v-32.546h40Zm280 0h-40v-32.546h40Zm32-64.546H64v-112h384Z'/><path fill='currentColor' d='M96 328h80v32H96zm240 0h80v32h-80zM256 14.758L16 111.121v34.483l240-96.362l240 96.362v-34.483z'/></svg>
                            <label for='icon-garage'>".$row['vagas']."</label>
                        </div>

                        <div class='table-icon'>
                            <svg class='icon icon-toilet' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><path fill='currentColor' d='M9 22h8v-2.5c2.41-1.63 4-4.38 4-7.5V4a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v8H3c0 3.09 2 6 6 7.5zm-3.71-8h13.42A7.02 7.02 0 0 1 15 18.33V20h-4v-1.67C9 18 5.86 15.91 5.29 14M15 4h4v8h-4zm1 1v3h2V5z'/></svg>
                            <label for='icon-toilet'>".$row['suites']."</label>
                        </div>

                        <div class='table-icon'>
                            <svg class='icon icon-bathtub' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><g fill='none' stroke='currentColor' stroke-linecap='round' stroke-linejoin='round' stroke-width='1.5'><path d='M21 13v3a4 4 0 0 1-4 4H7a4 4 0 0 1-4-4v-2.4a.6.6 0 0 1 .6-.6zm-5 7l1 2m-9-2l-1 2m14-9V7a4 4 0 0 0-4-4h-5'/><path d='M15.4 8H8.6c-.331 0-.596-.268-.56-.598C8.186 6.075 8.863 3 12 3s3.814 3.075 3.96 4.402c.036.33-.229.598-.56.598'/></g></svg>
                            <label for='icon-bathtub'>".$row['banheiros']."</label>
                        </div>
                    </div>
                    <form action='show_imovel.php' method='GET'>
                        <input class='button' type='submit' value='Ler mais'>
                        <input type='hidden' name='idImovel' value='".$row['id_imovel']."'>
                    </form>
                </div>
            </div>";
            }
            ConnectionFTP::disconnect();
            ConnectionDB::disconnect();
        } else {
            echo "<div class='warning'>Não foi possível encontrar nenhum resultado para: <p class='search-warning'>$search.</p> Pesquise novamente.</div>";
        }
    }

    public static function loadImovelDescription ($idImovel) {
        $rs = ImovelController::consultarTodasImagens($idImovel);

        if ($rs != null) {
            echo "<div class='container' id='container-show'>
                <button class='nav-slider' id='previous-image'>
                    <svg class='nav-slider-icon' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 16 16'><path fill='currentColor' d='M10.843 13.069L6.232 8.384a.546.546 0 0 1 0-.768l4.61-4.685a.55.55 0 0 0 0-.771a.53.53 0 0 0-.759 0l-4.61 4.684a1.65 1.65 0 0 0 0 2.312l4.61 4.684a.53.53 0 0 0 .76 0a.55.55 0 0 0 0-.771'/></svg>
                </button>
                <div class='slider'>
                    <div class='slides'>";
            for ($i=0; $i < count($rs); $i++) {
                $x = $i+1;
                echo "<input type='radio' name='radio-btn' id='radio".$x."'></input>";
            }

            $firstImage = '../assets/images/no-image.png';
            if ($rs[0]['nome_arquivo'] != null) {
                $firstImage = '../imagens-imoveis/'.$rs[0]["id_imovel"]."/".$rs[0]['nome_arquivo'];
            }

            echo "<div class='slide first'>
                    <img src='".$firstImage."' alt='Imagem do Imovel'>
                </div>";

            foreach (array_slice($rs, 1) as $row) {
                $imagePath = '../assets/images/no-image.png';

                if ($row['nome_arquivo'] != null) {
                    $imagePath = "../imagens-imoveis/".$row['id_imovel']."/".$row['nome_arquivo'];
                }

                echo "<div class='slide'>
                        <img src='".$imagePath."' alt='Imagem do Imovel'>
                    </div>";
            }
            
            echo "<div class='nav-auto'>";
            for ($i=0; $i < count($rs); $i++) {
                $x = $i+1;
                echo "<div class='auto-btn".$x."'></div>";
            }
            //closing the nav-auto div
            echo "</div>";

            //closing the slides div opened previously
            echo "</div>";

            echo "<div class='manual-nav'>";

            for ($i=0; $i < count($rs); $i++) {
                $x = $i+1;
                echo "<label for='radio".$x."' class='manual-btn'></label>";
            }
            echo '</div>'; //closing the manual-nav div
            echo "</div>"; //closing the slider div opened previously
            
            $number = preg_split('/[-_]/', $rs[0]['endereco'])[3] ?? 'N/A';
            echo "<button class='nav-slider' id='next-image'>
                        <svg class='nav-slider-icon'xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 16 16'><path fill='currentColor' d='m5.157 13.069l4.611-4.685a.546.546 0 0 0 0-.768L5.158 2.93a.55.55 0 0 1 0-.771a.53.53 0 0 1 .759 0l4.61 4.684a1.65 1.65 0 0 1 0 2.312l-4.61 4.684a.53.53 0 0 1-.76 0a.55.55 0 0 1 0-.771'/></svg>
                    </button>
                </div>
            <div class='desc-container'>
                <div class='description'>
                    <h1>". $rs[0]['cidade']." - ".$rs[0]['bairro'] . " - " . $number ."</h1>
                    <h3>".$rs[0]['tipo_negocio'].": R$".$rs[0]['valor']."</h3>";
                if ($rs[0]['taxa_condominio'] != null) {
                    echo "<h4>Condomínio: R$".$rs[0]['taxa_condominio']."</h4>";
                }
                if ($rs[0]['iptu'] != null) {
                    echo "<h4>Iptu: R$".$rs[0]['iptu']."</h4>";
                }
                echo"<p style='margin: 30px 0; max-width: 700px;'>".$rs[0]['descricao']."</p>
                </div>
                <div class='table' id='table-show'>
                    <div class='table-icon'>
                        <label for='icon-ruler'>Área</label>
                        <svg class='icon-ruler' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><g fill='none' stroke='currentColor' stroke-width='1.5'><path d='M4.045 18.508C2.682 17.145 2 16.463 2 15.616c0-.848.682-1.53 2.045-2.893l8.678-8.678C14.087 2.682 14.768 2 15.616 2s1.529.682 2.892 2.045l1.447 1.447C21.318 6.855 22 7.537 22 8.384s-.682 1.53-2.045 2.893l-8.678 8.678C9.913 21.318 9.23 22 8.384 22s-1.529-.682-2.892-2.045z'/><path stroke-linecap='round' d='M8.464 8.464L9.88 9.88m2.827-5.658l1.414 1.414m-9.899 7.071l1.414 1.414m.707-3.535l2.122 2.121m2.121-6.364l2.121 2.121'/></g></svg>
                        <label for='icon-ruler'>".$rs[0]['tamanho']."m²</label>
                    </div>
                    <div class='table-icon'>
                        <label for='icon-bed'>Quartos</label>
                        <svg class='icon-bed' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><path fill='currentColor' d='M7 14c1.66 0 3-1.34 3-3S8.66 8 7 8s-3 1.34-3 3s1.34 3 3 3m0-4c.55 0 1 .45 1 1s-.45 1-1 1s-1-.45-1-1s.45-1 1-1m12-3h-8v8H3V5H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4m2 8h-8V9h6c1.1 0 2 .9 2 2Z'/></svg>
                        <label for='icon-bed'>".$rs[0]['quartos']."</label>
                    </div>
                    <div class='table-icon'>
                        <label for='icon-garage'>Vagas</label>
                        <svg class='icon-garage' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 512 512'><path fill='currentColor' d='M448 255.454h-.511L407.067 164.5A48.04 48.04 0 0 0 363.2 136H148.8a48.04 48.04 0 0 0-43.863 28.5l-40.426 90.954H64a32.036 32.036 0 0 0-32 32v112a32.036 32.036 0 0 0 32 32V472a24.03 24.03 0 0 0 24 24h56a24.03 24.03 0 0 0 24-24v-40.546h176V472a24.03 24.03 0 0 0 24 24h56a24.03 24.03 0 0 0 24-24v-40.546a32.036 32.036 0 0 0 32-32v-112a32.036 32.036 0 0 0-32-32M134.175 177.5A16.01 16.01 0 0 1 148.8 168h214.4a16.01 16.01 0 0 1 14.621 9.5l34.646 77.953H99.529ZM136 464H96v-32.546h40Zm280 0h-40v-32.546h40Zm32-64.546H64v-112h384Z'/><path fill='currentColor' d='M96 328h80v32H96zm240 0h80v32h-80zM256 14.758L16 111.121v34.483l240-96.362l240 96.362v-34.483z'/></svg>
                        <label for='icon-garage'>".$rs[0]['vagas']."</label>
                    </div>
                    <div class='table-icon'>
                        <label for='icon-toilet'>Suítes</label>
                        <svg class='icon-toilet' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><path fill='currentColor' d='M9 22h8v-2.5c2.41-1.63 4-4.38 4-7.5V4a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v8H3c0 3.09 2 6 6 7.5zm-3.71-8h13.42A7.02 7.02 0 0 1 15 18.33V20h-4v-1.67C9 18 5.86 15.91 5.29 14M15 4h4v8h-4zm1 1v3h2V5z'/></svg>
                        <label for='icon-toilet'>".$rs[0]['suites']."</label>
                    </div>
                    <div class='table-icon'>
                        <label for='icon-bathtub'>Banehiros</label>
                        <svg class='icon-bathtub' xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'><g fill='none' stroke='currentColor' stroke-linecap='round' stroke-linejoin='round' stroke-width='1.5'><path d='M21 13v3a4 4 0 0 1-4 4H7a4 4 0 0 1-4-4v-2.4a.6.6 0 0 1 .6-.6zm-5 7l1 2m-9-2l-1 2m14-9V7a4 4 0 0 0-4-4h-5'/><path d='M15.4 8H8.6c-.331 0-.596-.268-.56-.598C8.186 6.075 8.863 3 12 3s3.814 3.075 3.96 4.402c.036.33-.229.598-.56.598'/></g></svg>
                        <label for='icon-bathtub'>".$rs[0]['banheiros']."</label>
                    </div>
                </div>
            </div>";

        }
    }
}
?>