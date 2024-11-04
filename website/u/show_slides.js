const radio1 = document.getElementById("radio1");
const selected = document.querySelectorAll('[id^="radio"]:checked');
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

function loadNextImage () {
    count++;
    
    if (count > qntBtns) {
        count = 1;
    }
    loadImage(count);
    let radio = document.getElementById("radio"+count);
    radio.checked = true;
}

function loadPreviousImage () {
    count--;
    if (count < 1) {
        count = qntBtns;
    }
    document.getElementById('radio'+count).checked = true;
    loadImage(count);
}

function loadImage(count) {
    let percentage = btnDividedBy100 * count * -1;
    alert (percentage);

    if (selected) {
        image.style.marginLeft = percentage.toString() + "%";
    }
}