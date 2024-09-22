document.addEventListener("DOMContentLoaded", function() {
    document.getElementById('loginIcon').addEventListener('click', function() {
        window.location.href = "/login";
    });

    document.getElementById('registerIcon').addEventListener('click', function() {
        window.location.href = "/req/signup";
    });
});
