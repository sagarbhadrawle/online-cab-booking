document.addEventListener("DOMContentLoaded", () => {
  const loginData = JSON.parse(localStorage.getItem("login"));
  if (!loginData || !loginData.customerId) {
    alert("Please log in to view bookings.");
    return;
  }

  const userId = loginData.customerId;
  const email = loginData.email;
  const password = loginData.password;


  const credentials = btoa(`${email}:${password}`);

  const booking = JSON.parse(localStorage.getItem("booking"));

  
  const bookingid = booking.id;

  fetch(`http://localhost:8080/viewBooking/${bookingid}`, {
    method: "GET",
    // headers: {
    //   Authorization: `Basic ${credentials}`,
    // },
  })
    .then((res) => {
      if (!res.ok) throw new Error("Failed to fetch bookings.");
      return res.json();
    })
    .then((data) => {
      const tbody = document.querySelector("#bookingTable tbody");
      console.log(data)
      tbody.innerHTML = "";

      if (data.length === 0) {
        tbody.innerHTML = `<tr><td colspan="7">No bookings found.</td></tr>`;
        return;
      }

        const booking = data;
        const row = document.createElement("tr");
        row.innerHTML = `
          <td>${booking.id}</td>
          <td>${booking.source}</td>
          <td>${booking.destination}</td>
          <td>${booking.distance}</td>
          <td>₹${booking.totalAmount}</td>
          <td>${booking.status}</td>
          <td>${booking.cabId}</td>
        `;
        tbody.appendChild(row);
     
    })
    .catch((err) => {
      console.error(err);
      alert("Unable to load bookings.");
    });
});
