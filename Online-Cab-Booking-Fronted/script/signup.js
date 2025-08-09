// let S_btn=document.getElementById("name");
// let username=document.getElementById("phone");
// let Email=document.getElementById("email");
// let pass1=document.getElementById("password");
// let form =document.querySelector("form");


// let baseURL = `http://localhost:8080`;
// let User_Data=JSON.parse(localStorage.getItem("login"))||[];
// // let login_alert=document.getElementById("Login_password_alert")


//  form.addEventListener("sumbit",(e)=>{ 
//   e.preventDefault();
  
  
    
//   //console.log(g_value);
//   if(Email.value!="" && pass1.value!=""){
//          console.log("hii");
//               fetch(`${baseURL}/customers`,{
//                   method:'POST',
//                   headers: {
//                       'Content-Type': 'application/json'
                      
//                     },
//                     body: JSON.stringify({
//                         "email":Email.value,
//                         "password":pass1.value,
//                         "name":Name.value,
//                         "contact":phone.value
                        
//                       })
//               }) .then((response) => response.json())
//               .then((data) => {
//                 console.log('Success:', data);
//                // getData();
//                 // document.getElementById("success").style.display="block";
//               })
//               .catch((error) => {
//                 console.log('Error:', error);
//               });

                  
//       }
//     }
//     )



let form = document.getElementById("registerFormElem");

let baseURL = `http://localhost:8080`;

form.addEventListener("submit", (e) => {
  e.preventDefault();

  let name = document.getElementById("name").value.trim();
  let phone = document.getElementById("phone").value.trim();
  let email = document.getElementById("email").value.trim();
  let password = document.getElementById("password").value.trim();

  if (name && phone && email && password) {
    let payload = {
      name: name,
      contact: phone,
      email: email,
      password: password
    };

    fetch(`${baseURL}/customers`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(payload)
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Something went wrong");
        }
        return response.json();
      })
      .then((data) => {
        alert("Registration successful");
        console.log("Registered:", data);
        // Optionally redirect
        // window.location.href = "login.html";
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("Registration failed. Please try again.");
      });
  } else {
    alert("All fields are required!");
  }
});
