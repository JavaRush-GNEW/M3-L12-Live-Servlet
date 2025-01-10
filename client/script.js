window.addEventListener("load", fetchUsers);

// console.log("Fetch users func triggered")

function fetchUsers(){

    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch("http://localhost:8080/user", requestOptions)
        .then((response) => response.json())
        .then((result) => {

            let tableBody = document.getElementById("userTableBody");
            tableBody.innerHTML = "";

            result.forEach( (user) => {
                let row = document.createElement("tr");

                let idCell = document.createElement("td");
                let nameCell = document.createElement("td");
                let emailCell = document.createElement("td");

                idCell.textContent = user.id;
                nameCell.textContent = user.name;
                emailCell.textContent = user.email;


                row.appendChild(idCell);
                row.appendChild(nameCell);
                row.appendChild(emailCell);

                tableBody.appendChild(row)
            })


        })
        .catch((error) => console.error(error));
}