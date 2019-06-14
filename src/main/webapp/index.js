let username;
const setUserName = (name) => { username = name.value };


function submit() {
    fetchData("", "GET", "/username/" + username)
        .then((value) => {
            sessionStorage.setItem("User", value);
            window.location.assign("Home.html");
        })
        .catch((error) => {
            sessionStorage.setItem("tempName", username);
            window.location.assign("register.html")
        })
}