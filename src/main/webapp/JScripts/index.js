let username;
const setUserName = (name) => { username = name.value };


function submit() {
    fetchData("", "GET", "/username/" + username).then((value) => {
        let user = JSON.parse(value);
        let userData = user[0];
        let data = { number: userData["id"] };
        sessionStorage.setItem("Data", JSON.stringify(data));
        window.location.assign("Home.html");
    }).catch(() => {
        sessionStorage.setItem("tempName", username);
        window.location.assign("register.html")
    });
};