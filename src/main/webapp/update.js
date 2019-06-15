let fName = "";
let sName = "";
let gType = "";
let clasName = "";
let id;
let userData;
let updatedCharacter
let userId = sessionStorage.getItem("Data");
let buttonClick = document.getElementById("idDelete");
let userEntry = JSON.parse(sessionStorage.getItem("userData"));
let route = sessionStorage.getItem("userRoute");

if (route === "id") {
    userData = userEntry
} else if (route === "list") {
    userData = userEntry[0];
}

id = userData["id"];
document.getElementById("firstname").value = userData["firstName"];
document.getElementById("surname").value = userData["surname"];
document.getElementById("class").value = userData["className"];
document.getElementById("gametype").value = userData["gameType"];

const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setgameType = (gameText) => { gType = gameText.value };
const setClassName = (classText) => { clasName = classText.value };

buttonClick.onclick = function deleteProfile() {
    let userId = sessionStorage.getItem("Data");
    fetchData("", "DELETE", "/characters/" + id).then(() => {
        fetchData(JSON.stringify(userEntry), "PUT", "/usersDeleteChar/" + userId["number"]).then(() => {
            sessionStorage.removeItem("userData");
            sessionStorage.removeItem("userRoute");
            window.location.assign("index.html");
        }).catch((error) => {
            errorZone.innerHTML = "You received the following error:" + error
        });
    }).catch((error) => {
        errorZone.innerHTML = "You received the following error:" + error
    });


}


function updateCharacter() {
    if (fName !== "" && fName !== undefined) {
        userData["firstName"] = fName;
    }
    if (sName !== "" && sName !== undefined) {
        userData["surname"] = sName;
    }
    if (gType !== "" && gType !== undefined) {
        userData["gameType"] = gType;
    }
    if (clasName !== "" && clasName !== undefined) {
        userData["className"] = clasName;
    }
    updatedCharacter = JSON.stringify(userData);
    fetchData(updatedCharacter, "PUT", "/characters/" + id).then(() => {
        fetchData(updatedCharacter, "PUT", "/usersChar/" + userId["number"]).then(() => {
            sessionStorage.removeItem("userData")
            window.location.assign("index.html");
        });
    }).catch((error) => { errorZone.innerHTML = "You received the following error:" + error });
}
function showCharacter() {
    window.location.assign("Show.html");
}

function deleteProfile() {

    fetchData("", "DELETE", "/characters/" + id).then(() => {
        fetchData("", "PUT", "/usersDeleteChar/" + userId["number"]).then(() => {
            sessionStorage.removeItem
            window.location.assign("index.html");
        }).catch((error) => {
            errorZone.innerHTML = "You received the following error:" + error
        });
    }).catch((error) => { errorZone.innerHTML = "You received the following error:" + error });
}