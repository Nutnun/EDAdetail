const main = document.querySelector('main');

window.addEventListener('load', e => {
    var data;
    updateYWC();

    if ('serviceWorker' in navigator) {
        try {
            navigator.serviceWorker.register('serviceWorker.js');
            console.log('service Worker registered');
        } catch (error) {
            console.log('Service Worker is fail');
        }
    }
});



$(document).ready(function () {
    showNoti()
});

