let fName = "";
let sName = "";
let gType = "";
let clasName = "";

const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setgameType = (gameText) => { gType = gameText.value };
const setClassName = (classText) => { clasName = classText.value };

function updateCharacter() {
    let userData = sessionStorage.getItem("userdata");
    userData = JSON.parse(userData);
    document.getElementById("")
    userData.firstName.value
        console.log(userData);
}