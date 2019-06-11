let fName;
let sName;
let gType;
let clasName;

const setFirstName = (nameText) => {fName=nameText.value;};
const setSurname = (sNameText) => {sName=sNameText.value};
const setgameType = (gameText) => {gType=gameText.value};
const setClassName = (classText) => {clasName=classText.value};




function addCharacter() {
    let newCharacter = JSON.stringify(new Profile(fName, sName, gType, clasName));
    fetchData(newCharacter,"POST", "/characters");
}

