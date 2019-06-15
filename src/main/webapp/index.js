let username;
const setUserName = (name) => { username = name.value };


function submit() {
    fetchData("", "GET", "/users").then((value) => {
        let user = JSON.parse(value);
        let pinUse = user.filter(function (user) {
            return user.username === username;
        }) 
        if (pinUse.length == 1) {
            let userData = pinUse[0];
            let data = { number: userData["id"] };
            sessionStorage.setItem("Data", JSON.stringify(data));
            window.location.assign("Home.html");
        } else {
            sessionStorage.setItem("tempName", username);
            window.location.assign("register.html");
        }}).catch((error) => console.log(error));
};