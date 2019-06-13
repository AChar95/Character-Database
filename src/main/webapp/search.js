let fName = "";
let sName = "";
let id = 0;
document.getElementById("warningId").innerHTML = "";
document.getElementById("warningName").innerHTML = "";
const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setId = (number) => { id = number.value };

function searchDatabaseById() {
    if (id === 0) {
        document.getElementById("warningId").innerHTML = "You have not inserted an id number";
    }
    fetchData("null", "GET", "/characters/" + id).then((value) => {
        sessionStorage.setItem("userdata", value);
        sessionStorage.setItem("userRoute", "id")
        window.location.assign("update.html");
    }).catch((error) => { document.getElementById("warningId").innerHTML = "You have not inserted a correct id" });
}
function searchDatabaseByName() {
    if (fName === "") {
        document.getElementById("warningName").innerHTML = "You have not inserted a name";
        alert("")
    }
    fetchData("null", "GET", "/charactersName/" + fName).then((value) => {
        sessionStorage.setItem("userdata", value);
        let userDataText = JSON.parse(value);
        if (userDataText.length > 1) {
            sessionStorage.setItem("userRoute", "list")
            window.location.assign("update_list.html");
        } else {
            sessionStorage.setItem("userRoute", "list")
            window.location.assign("update.html");
        }

    })
}
