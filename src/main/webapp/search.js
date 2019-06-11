let fName = "";
let sName = "";
let id = 0;
let userData;

const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setId = (number) => { id = number.value };

function searchDatabase() {
    if (id >= 1) {
        let userRequest = JSON.stringify(new foundId(id));
        fetchData(userRequest, "GET", "/characters/" + id);
    } else {
        if (fName != "") {
            let userRequest = JSON.stringify(new foundName(fName));
            console.log(fName);
            fetchData(userRequest, "GET", "/charactersName/" + fName);
        }
    }
}
function updateCharacter() {
    if (id >= 1) {
        let userRequest = JSON.stringify(new foundId(id));
        fetchData(userRequest, "GET", "/character/" + id).then((value) => { userData = JSON.parse(value) });
        console.log(userData);
        console.log("updating num")
        sessionStorage.setItem("userdata", userData);
        sessionStorage.setItem("userRoute", "Single");
        fName = "";
        id="";
        userData = "";
        window.location.assign("update.html");
        

    } else {
        if (fName != "") {
            let userRequest = JSON.stringify(new foundName(fName));
            fetchData(null, "GET", "/charactersName/" + fName).then((value) => { userData = JSON.parse(value) });
            console.log(userData);
            console.log(userData.length);
            if (userData.length > 1) {
                sessionStorage.setItem("userdata", userData);
                console.log("list");
                 //window.location.assign("update_list.html");
                // } else { 
                // console.log("updating name");
                // sessionStorage.setItem("userdata", userRequest);
                // sessionStorage.setItem("userRoute", "Single")
                // window.location.assign("update.html");
            }
        }
    }
//
