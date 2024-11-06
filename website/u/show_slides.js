const radio1 = document.getElementById("radio1");
const selected = document.querySelectorAll('[id^="radio"]:checked');
const radios = document.querySelectorAll('[id^="radio"]');
const carouselImages = document.querySelectorAll('.slide');
const image = document.querySelector('.first');
const nextImage = document.getElementById("next-image");
const previousImage = document.getElementById("previous-image");
const qntBtns = document.getElementsByClassName('manual-btn').length;
const btnDividedBy100 = parseInt(100 / qntBtns);

let count = 1;

radio1.checked = true;

nextImage.addEventListener ('click', () => {
    loadNextImage();
});

previousImage.addEventListener("click", () => {
    loadPreviousImage();
});

radios.forEach((element) => {
    element.addEventListener('click', (event) => {
        let radioId = parseInt(event.target.id.match(/\d+/)[0]);
        count = radioId;
        loadImagePosition(count);
    })
});

function loadNextImage () {
    count++;
    
    if (count > qntBtns) {
        count = 1;
    }
    loadImagePosition(count);
    document.getElementById("radio"+count).checked = true;
}

function loadPreviousImage () {
    count--;
    if (count < 1) {
        count = qntBtns;
    }
    loadImagePosition(count);
    document.getElementById('radio'+count).checked = true;
}

function loadImagePosition(count) {
    /*
    let currentImage = carouselImages[count-1];
    
    let imageWidth = currentImage.clientWidth;
    */
    let offset = (count - 1) * -800;
    
    image.style.marginLeft = offset+"px";
    
    console.log("o count é: "+count);
    console.log(carouselImages[count-1]);
    //console.log(imageWidth);
    console.log(`Deslocamento calculado: ${offset}px`);
}