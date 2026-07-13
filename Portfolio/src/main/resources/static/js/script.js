const contactBtn = document.querySelector('.hero button');
const contactSection = document.querySelector('#contact');

contactBtn.addEventListener('click', function (e) {
    e.preventDefault();
    contactSection.scrollIntoView({
        behavior: 'smooth'
    });
});