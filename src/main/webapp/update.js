let fName = "";
let sName = "";
let gType = "";
let clasName = "";
let id;
let userData;
let errorZone = document.getElementById("error");

userData = sessionStorage.getItem("userdata");
userData = JSON.parse(userData);
id = userData["id"];
document.getElementById("firstname").value = userData["firstName"];
document.getElementById("surname").value = userData["surname"];
document.getElementById("class").value = userData["className"];
document.getElementById("gametype").value = userData["gameType"];

const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setgameType = (gameText) => { gType = gameText.value };
const setClassName = (classText) => { clasName = classText.value };

function updateCharacter() {

    errorZone.innerHTML = "";
    let profile = {
        firstName: fName,
        surname: sName,
        className: clasName,
        gameType: gType
    }
    let updatedCharacter = JSON.stringify(profile);
    fetchData(updatedCharacter, "PUT", "/characters/" + id).then(() => { window.location.assign("index.html"); }).catch((error) => { errorZone.innerHTML = "You received the following error:" + error });

    function showCharacter() {
        window.location.assign("index.html");
    }

    function deleteProfile() {
        errorZone.innerHTML = "";
        fetchData("", "DELETE", "/characters/" + id).then(() => { window.location.assign("index.html"); }).catch((error) => { errorZone.innerHTML = "You received the following error:" + error }