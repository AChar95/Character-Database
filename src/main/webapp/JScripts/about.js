let id = JSON.parse(sessionStorage.getItem("Data"));

fetchData("null", "GET", "/users/" + id["number"]).then((value) => {
    let user = JSON.parse(value);
    document.getElementById("user").innerHTML= user["username"];
}).catch(() => {
    document.getElementById("welcome").innerHTML = "Welcome dark lord of all"
});