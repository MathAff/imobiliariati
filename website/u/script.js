const filter = document.getElementById('filter');
const form = document.querySelector('form');

form.addEventListener('submit', (e) => {
    const existingError = document.querySelector('.msg-error');
    if (existingError) {
        existingError.remove();
    }
    if (filter.value === '') {
        let errMsg = document.createElement('div');
        errMsg.className = 'msg-error';
        errMsg.textContent = 'Preencha o campo';
        form.appendChild(errMsg);
        e.preventDefault();
    }

    if (filter.value.length > 10) {
        let errMsg = document.createElement('div');
        errMsg.className = 'msg-error';
        errMsg.textContent = 'Tente algo menor';
        form.appendChild(errMsg);
        e.preventDefault();
    }
})