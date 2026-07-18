const contactBtn = document.querySelector('.hero button');
const contactSection = document.querySelector('#contact');
contactBtn.addEventListener('click', function (e) {
    e.preventDefault();
    contactSection.scrollIntoView({
        behavior: 'smooth'
    });
});

/* ============================
   DARK / LIGHT MODE TOGGLE
   ============================ */
(function () {
    const themeToggle = document.getElementById('theme-toggle');
    const root = document.body;
    const storageKey = 'momin-portfolio-theme';

    const savedTheme = localStorage.getItem(storageKey);
    const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;

    if (savedTheme === 'dark' || (!savedTheme && prefersDark)) {
        root.classList.add('dark-mode');
    }

    function setTheme(isDark) {
        root.classList.toggle('dark-mode', isDark);
        localStorage.setItem(storageKey, isDark ? 'dark' : 'light');
    }

    themeToggle.addEventListener('click', function () {
        const isDark = !root.classList.contains('dark-mode');
        setTheme(isDark);
    });
})();

/* ============================
   TYPING ANIMATION (hero role text)
   ============================ */
(function () {
    const typedEl = document.getElementById('typed-text');
    if (!typedEl) return;

    const phrases = [
        'Full Stack Web Developer',
        'Java & JavaFX Developer',
        'PHP Web Developer',
        'C++ / OpenGL Enthusiast'
    ];
    const prefersReducedMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches;

    if (prefersReducedMotion) {
        typedEl.textContent = phrases[0];
        return;
    }

    let phraseIndex = 0;
    let charIndex = 0;
    let isDeleting = false;

    function tick() {
        const currentPhrase = phrases[phraseIndex];

        if (!isDeleting) {
            charIndex++;
            typedEl.textContent = currentPhrase.substring(0, charIndex);
            if (charIndex === currentPhrase.length) {
                isDeleting = true;
                setTimeout(tick, 1600);
                return;
            }
        } else {
            charIndex--;
            typedEl.textContent = currentPhrase.substring(0, charIndex);
            if (charIndex === 0) {
                isDeleting = false;
                phraseIndex = (phraseIndex + 1) % phrases.length;
            }
        }

        setTimeout(tick, isDeleting ? 40 : 80);
    }

    tick();
})();

/* ============================
   HERO ENTRANCE STAGGER (data-delay -> CSS var)
   ============================ */
(function () {
    document.querySelectorAll('.anim-pop').forEach(function (el) {
        const delay = el.getAttribute('data-delay');
        if (delay) {
            el.style.setProperty('--pop-delay', (delay / 1000) + 's');
        }
    });
})();

/* ============================
   SCROLL-REVEAL ANIMATIONS
   ============================ */
(function () {
    const revealEls = document.querySelectorAll('.reveal');
    const prefersReducedMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches;

    revealEls.forEach(function (el) {
        const delay = el.getAttribute('data-delay');
        if (delay) {
            el.style.setProperty('--reveal-delay', (delay / 1000) + 's');
        }
    });

    if (prefersReducedMotion || !('IntersectionObserver' in window)) {
        revealEls.forEach(function (el) {
            el.classList.add('is-visible');
        });
        return;
    }

    const observer = new IntersectionObserver(function (entries) {
        entries.forEach(function (entry) {
            if (entry.isIntersecting) {
                entry.target.classList.add('is-visible');
                observer.unobserve(entry.target);
            }
        });
    }, {
        threshold: 0.15,
        rootMargin: '0px 0px -60px 0px'
    });

    revealEls.forEach(function (el) {
        observer.observe(el);
    });
})();

/* ============================
   SCROLL PROGRESS BAR + NAV SHRINK + BACK TO TOP
   ============================ */
(function () {
    const progressBar = document.getElementById('scroll-progress-bar');
    const nav = document.getElementById('mainNav');
    const backToTop = document.getElementById('back-to-top');

    function onScroll() {
        const scrollTop = window.scrollY;
        const docHeight = document.documentElement.scrollHeight - window.innerHeight;
        const progress = docHeight > 0 ? (scrollTop / docHeight) * 100 : 0;

        if (progressBar) progressBar.style.width = progress + '%';
        if (nav) nav.classList.toggle('scrolled', scrollTop > 40);
        if (backToTop) backToTop.classList.toggle('visible', scrollTop > 400);
    }

    window.addEventListener('scroll', onScroll, { passive: true });
    onScroll();

    if (backToTop) {
        backToTop.addEventListener('click', function () {
            window.scrollTo({ top: 0, behavior: 'smooth' });
        });
    }
})();

/* ============================
   TILT EFFECT ON PROJECT CARDS
   ============================ */
(function () {
    const prefersReducedMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches;
    if (prefersReducedMotion) return;

    const cards = document.querySelectorAll('.tilt-card');

    cards.forEach(function (card) {
        card.addEventListener('mousemove', function (e) {
            const rect = card.getBoundingClientRect();
            const x = e.clientX - rect.left;
            const y = e.clientY - rect.top;
            const centerX = rect.width / 2;
            const centerY = rect.height / 2;
            const rotateX = ((y - centerY) / centerY) * -6;
            const rotateY = ((x - centerX) / centerX) * 6;

            card.style.transform = 'perspective(800px) rotateX(' + rotateX + 'deg) rotateY(' + rotateY + 'deg) translateY(-6px)';
        });

        card.addEventListener('mouseleave', function () {
            card.style.transform = 'perspective(800px) rotateX(0) rotateY(0) translateY(0)';
        });
    });
})();