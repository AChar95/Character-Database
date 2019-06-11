let fName = "";
let sName = "";
let gType = "";
let clasName = "";
let id;
let userData;

const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setgameType = (gameText) => { gType = gameText.value };
const setClassName = (classText) => { clasName = classText.value };

let userRoute = sessionStorage.getItem("userRoute");
if (userRoute == "list") {
    userData = sessionStorage.getItem("user_list");
} else {
    userData = sessionStorage.getItem("userdata");
}

userData = JSON.parse(userData);
id = userData["id"];
document.getElementById("firstname").value = userData["firstName"];
document.getElementById("surname").value = userData["surname"];
document.getElementById("class").value = userData["className"];
document.getElementById("gameType").value = userData["gameType"];

function updateCharacter() {
    let updatedCharacter = JSON.stringify(new Profile(fName, sName, gType, clasName));
    fetchData(updatedCharacter, "PUT", "/characters" + id);
}