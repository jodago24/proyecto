document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const firstName = document.getElementById('registerFirstName').value;
    const lastName = document.getElementById('registerLastName').value;
    const email = document.getElementById('registerEmail').value;
    const password = document.getElementById('registerPassword').value;
    console.log(`Registrado: ${firstName} ${lastName}, ${email}`);
    // Aquí agregar lógica de registro
});

document.getElementById('goToLogin').addEventListener('click', function() {
    window.location.href = 'login&register.html'; // Cambia 'login.html' por la ruta real de tu página de inicio de sesión
});
