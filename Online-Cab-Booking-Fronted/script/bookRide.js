let form = document.getElementById("registerFormElem");




const distanceInput = document.getElementById("distance");
const cabIdSelect = document.getElementById("cabId");
const payInput = document.getElementById("pay");

// Dynamically update amount when cab or distance changes
function updateAmount() {
    const distance = parseFloat(distanceInput.value.trim());
    const cabId = parseInt(cabIdSelect.value);

    if (!isNaN(distance) && cabId) {
        let rate = 0;
        if (cabId === 1) rate = 10;
        else if (cabId === 2) rate = 15;
        else if (cabId === 3) rate = 8;

        const total = rate * distance;
        payInput.value = total.toFixed(2); // show with 2 decimal places
    } else {
        payInput.value = "";
    }
}

// Event listeners to auto-calculate price
cabIdSelect.addEventListener("change", updateAmount);
distanceInput.addEventListener("input", updateAmount);




form.addEventListener("submit", (e) => {
    e.preventDefault();
console.log(localStorage.getItem("login"));


    let source = document.getElementById("Source").value.trim();
    let destination = document.getElementById("Destination").value.trim();
    let cabId = document.getElementById("cabId").value;
    let distance = document.getElementById("distance").value.trim();
    let totalAmount = document.getElementById("pay").value.trim();


    let loginData = JSON.parse(localStorage.getItem("login"));
    let userId = loginData.customerId;

    
    let email = loginData.email;  // or whatever your key is
    let password = loginData.password; // only if you stored password (not recommended!)
    console.log(email)
    console.log(password)
    const credentials = btoa(`${email}:${password}`);

    if (!userId) {
        alert("User not logged in.");
        return;
    }

    if (!source || !destination || !cabId || !distance || !totalAmount) {
        alert("All fields are required.");
        return;
    }
    let rate =0;
    if(cabId==1)
    {   rate=10;

    }
    else if(cabId==2 )
    {
        rate = 15;
    }
    else{
        rate =8;
    }

    let total = rate*distance
    
    
    let booking = {
        source: source,
        destination: destination,
        distance: parseFloat(distance),
        totalAmount: total,
        status: "CONFIRMED"

    };

    fetch(`http://localhost:8080/booking/${userId}/${cabId}`, {
        method: "POST",
        headers: {
            // 'Authorization': `Basic ${credentials}`,
            "Content-Type": "application/json"
        },
        body: JSON.stringify(booking)
    })
        .then((res) => {
            if (!res.ok) {
                throw new Error("Booking failed.");
            }
            return res.json();
        })
        .then((data) => {
            alert("Booking successful!");
            console.log("Booking details:", data);
            form.reset();
        })
        .catch((err) => {
            console.error(err);
            alert("Failed to book. Please try again.");
        });
});
