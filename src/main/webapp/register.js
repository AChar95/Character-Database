let username = sessionStorage.getItem("tempName");
let userName;
document.getElementById("username").value = sessionStorage.getItem("tempName");

const setName = (enteredName) => userName = enteredName.value;

function checkUser() {
    let userProfile = {
        username: userName,
        name: userName
    }

    fetchData(userProfile, "POST", "/users").then((value) => {
        sessionStorage.setItem("User", JSON.stringify(userProfile));
    }).catch((error) => console.log("the following error occured" + error));
    fetchData("", "GET", "/users").then((value) => {
        let user = JSON.parse(value);
        let pinUse = user.filter(function (user) {
            return user.username === userName;
        });
        sessionStorage.setItem("User", JSON.stringify(pinUse));
    }).catch((error) => console.log("You have encountered the following error " + error));
}