// Toggle Nav

const nav = document.querySelector('nav');
const navToggle = document.querySelector('.nav-toggle');

if(navToggle){
    navToggle.addEventListener('click', () => {
        nav.classList.toggle('nav-open');
    });
}
