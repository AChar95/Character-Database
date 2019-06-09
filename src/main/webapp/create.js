let fName;
let sName;
let gType;
let clasName

const setFirstName = (nameText) => {fName=nameText.value};
const setSurname = (sNameText) => {sName=sNameText.value};
const setgameType = (gameText) => {gType=gameText.value};
const setClassName = (classText) => {clasName=classText.value};


class Profile {
    constructor(firstName, surname, gameType, className) {
        this.firstName = firstName;
        this.surname = surname;
        this.gameType = gameType;
        this.className = className;
    }
}
function clearTextboxes(){
    console.log("clearing");
    document.getElementById("firstname").value="";
    document.getElementById("surname").value="";
    document.getElementById("class").value="";
    document.getElementById("gametype").value="";
    console.log("cleared");
}
function addCharacter() {
    let newCharacter = JSON.stringify(new Profile(fName, sName, gType, clasName));
    fetchData(newCharacter,"POST", "/characters");
}
function fetchData(sendbody, type, endpoint) {
    this.sendbody = sendbody;
    this.type = type;
    this.endpoint = endpoint;
    return new Promise((resolve, reject) => {
        const req = new XMLHttpRequest();
        req.onreadystatechange = function () {
            if (req.readyState === 4) {
                if (req.status >= 200 && req.status < 300) {
                    resolve(req.responseText);
                } else {
                    reject("Could not connect properly");
                }
            }
        }
        req.open(type, "http://localhost:8080/Character-Database-version-1.0/api" + endpoint);
        req.send(sendbody);
    })
};
