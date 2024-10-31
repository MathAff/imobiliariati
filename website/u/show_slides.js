const radio1 = document.getElementById("radio1");
const nextImage = document.getElementById("next-image");
const previousImage = document.getElementById("previous-image");

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
    if (count > 4) {
        count = 1;
    }
    document.getElementById("radio"+count).checked = true;
}

function loadPreviousImage () {
    count--;
    if (count < 1) {
        count = 4;
    }
    document.getElementById("radio"+count).checked = true;
}