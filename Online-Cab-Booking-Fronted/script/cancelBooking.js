let cancelForm = document.getElementById("cancelFormElem");

cancelForm.addEventListener("submit", function (e) {
  e.preventDefault();

  let bookingId = document.getElementById("bookingId").value.trim();

  if (!bookingId) {
    alert("Please enter Booking ID.");
    return;
  }

  let loginData = JSON.parse(localStorage.getItem("login"));
  if (!loginData || !loginData.email || !loginData.password) {
    alert("User not logged in.");
    return;
  }

  let email = loginData.email;
  let password = loginData.password;
  const credentials = btoa(`${email}:${password}`);

  fetch(`http://localhost:8080/booking/${bookingId}`, {
    method: "DELETE",
    headers: {
      "Authorization": `Basic ${credentials}`
    }
  })
    .then((res) => {
      if (!res.ok) {
        throw new Error("Booking not found or unauthorized.");
      }
      return res.text(); // Since your controller returns a string message
    })
    .then((message) => {
      alert(message); // "Booking deleted successfully"
      cancelForm.reset();
    })
    .catch((err) => {
      console.error(err);
      alert("Failed to cancel booking. Please check the booking ID or try again later.");
    });
});
