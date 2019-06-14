let fName;
let sName;
let gType;
let clasName;

const setFirstName = (nameText) => { fName = nameText.value; };
const setSurname = (sNameText) => { sName = sNameText.value };
const setgameType = (gameText) => { gType = gameText.value };
const setClassName = (classText) => { clasName = classText.value };




function addCharacter() {
    let profile = {
        firstName: fName,
        surname: sName,
        gameType: gType,
        className: clasName
    }
    let newCharacter = JSON.stringify(profile);
    fetchData(newCharacter, "POST", "/characters");
    let userId = sessionStorage.getItem("User");
    let pin = userId.id;
    fetchData(newCharacter, "PUT", "/usersChar/" + pin).catch((error) => console.log(error));
}

