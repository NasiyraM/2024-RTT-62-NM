document.getElementById('newsletterForm').addEventListener('submit', function(event) {
    event.preventDefault();
    validateEmail();
});

function validateEmail() {
    const emailInput = document.getElementById('newsletterEmail');
    const emailValue = emailInput.value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (emailRegex.test(emailValue)) {
        emailInput.classList.remove('is-invalid');
        emailInput.classList.add('is-valid');
        alert('Thank you for subscribing!');
    } else {
        emailInput.classList.remove('is-valid');
        emailInput.classList.add('is-invalid');
    }
}