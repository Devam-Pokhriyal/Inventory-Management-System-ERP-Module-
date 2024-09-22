document.addEventListener('DOMContentLoaded', function () {
    const signupForm = document.querySelector('#registerForm');
    signupForm.style.opacity = 0;
  
    setTimeout(() => {
      signupForm.style.transition = 'opacity 1s ease-in-out';
      signupForm.style.opacity = 1;
    }, 500);
  
    const signupButton = document.querySelector('button');
    signupButton.addEventListener('click', function (e) {
      e.preventDefault(); // prevent form submission
  
      const userIdInput = document.querySelector('input[name="userId"]');
      const nameInput = document.querySelector('input[name="name"]');
      const typeInput = document.querySelector('select[name="type"]');
      const usernameInput = document.querySelector('input[name="username"]');
      const passwordInput = document.querySelector('input[name="password"]');
      const userStatusInput = document.querySelector('input[name="userStatus"]');
      const emailInput = document.querySelector('input[name="email"]');
      const teamIdInput = document.querySelector('input[name="teamId"]');
      const managerIdInput = document.querySelector('input[name="managerId"]');
  
      // Check for a valid input (you can add your validation logic here)
      const isValid = userIdInput.checkValidity() && nameInput.checkValidity() && typeInput.checkValidity() && usernameInput.checkValidity() && passwordInput.checkValidity() && userStatusInput.checkValidity() && emailInput.checkValidity() && teamIdInput.checkValidity() && managerIdInput.checkValidity();
  
      if (!isValid) {
        signupForm.classList.add('shake');
  
        setTimeout(() => {
          signupForm.classList.remove('shake');
        }, 1000);
      } else {
        // Form is valid, you can submit it or perform any other action
        console.log('Form is valid');
      }
    });
  });
  