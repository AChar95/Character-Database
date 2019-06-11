let fName;
let sName;
let id;
let profiles

const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setId = (number) => { id = number.value };

function searchDatabase() {
    if (id > 0) {
        let userRequest = JSON.stringify(new foundId(id));
        fetchData(userRequest, "GET", "/character/" + id);
    } else {
        if (fName != "") {
            let userRequest = JSON.stringify(new foundName(fName));
            console.log(fName);
            fetchData(userRequest, "GET", "/character/" + fName);
        }
    }
}
function updateCharacter() {
    if (id > 0) {
        let userRequest = JSON.stringify(new foundId(id));
        // userRequest = fetchData(userRequest, "GET", "/character/" + id);
        console.log("updating num")
        sessionStorage.setItem("userdata", userRequest);
        sessionStorage.setItem("userRoute", "Single");
        window.location.assign("update.html");
    } else {
        if (fName != "") {
            let userRequest = JSON.stringify(new foundName(fName));
            userRequest = fetchData(userRequest, "GET", "/character/" + fName);
             if (userRequest.length() > 1) {
             sessionStorage.setItem("userdata", userRequest);
             console.log("list");
             window.location.assign("update_list.html");
            } else { 
            console.log("updating name");
            sessionStorage.setItem("userdata", userRequest);
            sessionStorage.setItem("userRoute", "Single")
            window.location.assign("update.html");
            }
        }
    }
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
                    alert("The character profile could not be found, please check the id value or spelling of the name");
                    reject("Could not connect properly");
                }
            }
        }
        req.open(type, "http://localhost:8080/Character-Database-version-1.0/api" + endpoint);
        req.send(sendbody);
    })
};