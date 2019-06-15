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
    };
    let newCharacter = JSON.stringify(profile);

    let userId = JSON.parse(sessionStorage.getItem("Data"));
    fetchData(newCharacter, "PUT", "/usersChar/" + userId["number"]).then(() => {
        document.getElementById("outcome").innerHTML = "You have successfully created your character";
        document.getElementById("outcome").style.color="green";
        setTimeout(function () { document.getElementById("outcome").innerHTML = " "; }, 4000);
    }).catch((error) => console.log(error));
};

