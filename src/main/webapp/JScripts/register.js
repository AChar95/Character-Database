let username = sessionStorage.getItem("tempName");
let usersName;
document.getElementById("username").value = sessionStorage.getItem("tempName");

const setName = (enteredName) => usersName = enteredName.value;

function checkUser() {
    let userProfile = {
        username: username,
        name: usersName
    }

    fetchData(JSON.stringify(userProfile), "POST", "/users").then((value) => {
        fetchData("", "GET", "/users").then((value) => {
            let user = JSON.parse(value);
            let pinUse = user.filter(function (user) {
                return user.username === username;
            });
            let userData = pinUse[0];
            let data = { number: userData["id"] };
            sessionStorage.setItem("Data", JSON.stringify(data));
            sessionStorage.removeItem("tempName");
            window.location.assign("Home.html");
        }).catch((error) => console.log("You have encountered the following error " + error));
    }).catch((error) => console.log("the following error occured" + error))
};
