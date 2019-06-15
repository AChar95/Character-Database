let fName = "";
let sName = "";
let id = 0;
let userId = JSON.parse(sessionStorage.getItem("Data"))

document.getElementById("warningId").innerHTML = "";
document.getElementById("warningName").innerHTML = "";
const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setId = (number) => { id = number.value };

function searchDatabaseById() {

    if (id === 0) {
        document.getElementById("warningId").innerHTML = "You have not inserted an id number";
    }
    fetchData("null", "GET", "/user/char/" + userId["number"]).then((value) => {
        let charList = JSON.parse(value);
        let char = charList.filter(function (charList) {
            return charList.id == id;
        })
        if (char.length === 0) {
            document.getElementById("warningId").innerHTML = "You have not inserted a correct id";
        } else {
            sessionStorage.setItem("userdata", JSON.stringify(char));
            window.location.assign("update.html");
        }
    }).catch((error) => console.log(error));
};

function searchDatabaseByName() {
    if (fName === "") {
        document.getElementById("warningName").innerHTML = "You have not inserted a name";
        alert("")
    }
    console.log(userId["number"]);
    fetchData("null", "GET", "/user/char/" + userId["number"]).then((value) => {
        let charList = JSON.parse(value);
        let char = charList.filter(function (charList) {
            return charList.firstName == fName;
        })
        if (char.length === 0) {
            document.getElementById("warningId").innerHTML = "You have not inserted a correct name";
        } else {
            sessionStorage.setItem("userData", JSON.stringify(char));
            sessionStorage.setItem("userRoute", "list")
            if (char.length > 1) {
                window.location.assign("update_list.html");
            } else {
                window.location.assign("update.html");
            }
        }

    });
};
function showAllUserChar() {
    fetchData("null", "GET", "/user/char/" + userId).then((value) => {
        sessionStorage.setItem("userData", value);
        sessionStorage.setItem("Route")
        window.location.assign("update_list.html");
    });
};
