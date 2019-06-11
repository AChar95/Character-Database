let id;
const setId = (number) => id = number.value;

function showList() {
    let userData = JSON.parse(sessionStorage.getItem("userdata", userRequest));
    let tableOne = document.getElementById("table");
    let rowNumber = 1;
    for (let i = 0; i < userData.length(); i++) {
        let rowBody = tableOne.insertRow(rowNumber);
        for (data in userData[i]) {
            let profiles = userData[i];
            let cell = rowBody.insertCell(elementNumber)
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
            elementNumber++;

        }
        rowNumber++;

    }

}
function findId() {
    let findCharacter = fetchData("", "GET", "/character/" + id);
    sessionStorage.setItem("user_list", findCharacter);
    sessionStorage.setItem("userRoute", "list");
    window.location.assign("update.html");

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
                    alert("The character profile could not be found, please check the id value");
                    reject("Could not connect properly");
                }
            }
        }
        req.open(type, "http://localhost:8080/Character-Database-version-1.0/api" + endpoint);
        req.send(sendbody);
    })
};