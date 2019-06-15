let id;
const setId = (number) => id = number.value;

function showList() {
    document.getElementById("table").innerHTML="";
    let userData = JSON.parse(sessionStorage.getItem("userData"));
    let tableOne = document.getElementById("table");
    let header = tableOne.createTHead();
    let rowOne = header.insertRow(0);
    let headNum = 0;
    for (let prop in userData[0]) {
        let cell = rowOne.insertCell(headNum);
        if (headNum === 0) {
            cell.innerHTML= "id";
        }else if (headNum === 1) {
            cell.innerHTML = "First Name";
        } else if (headNum === 2) {
            cell.innerHTML = "Surname";
        } else if (headNum === 3) {
            cell.innerHTML = "Class Name";
        } else if (headNum === 4) {
            cell.innerHTML = "Game Type";
        }
        headNum = headNum + 1;
    }
    let rowNumber = 1;
    for (let i = 0; i < userData.length; i++) {
        let rowBody = tableOne.insertRow(rowNumber);
        let elementNumber = 0;
        for (data in userData[i]) {
            let profiles = userData[i];
            let cell = rowBody.insertCell(elementNumber);
            if (elementNumber === 0) {
                cell.innerHTML = profiles["id"];
            } else if (elementNumber === 1) {
                cell.innerHTML = profiles["firstName"];
            } else if (elementNumber === 2) {
                cell.innerHTML = profiles["surname"];
            } else if (elementNumber === 3) {
                cell.innerHTML = profiles["className"];
            } else if (elementNumber === 4) {
                cell.innerHTML = profiles["gameType"];
            }
            elementNumber = elementNumber + 1;

        }
        rowNumber++;

    }

}
function findId() {
    fetchData("", "GET", "/characters/" + id).then((value) =>{
        let userId = JSON.parse(sessionStorage.getItem("User"));

        let userCharacters = JSON.parse(value);
        let userFound = userCharacters.filter(function (userCharacters) {
            return userCharacters.User_id === userId["number"];
        })
        sessionStorage.setItem("userdata", JSON.stringify(userFound));
        sessionStorage.setItem("userRoute", "id")
        window.location.assign("update.html")
    });
    ;

}
