let email = document.getElementById("email");
let password = document.getElementById("password");
let form = document.querySelector("form");

let baseURL = `http://localhost:8080`;

form.addEventListener("submit", (e) => {
    e.preventDefault();

    if (email.value !== "" && password.value !== "") {
        const credentials = btoa(`${email.value}:${password.value}`); // base64 encode

        fetch(`${baseURL}/auth/login`, {
            method: 'GET',
            headers: {
                'Authorization': `Basic ${credentials}`
            }
        })
        .then(response => {
            if (!response.ok) throw new Error("Login failed");
            return response.json();
        })
        .then(data => {
            console.log("Login successful:", data);
            localStorage.setItem("login", JSON.stringify(data));
            alert("Login successful!");
            window.location.href = "bookRide.html";
        })
        .catch(error => {
            console.error("Error:", error);
            alert("Invalid credentials.");
        });
    } else {
        alert("Email and password cannot be empty.");
    }
});
