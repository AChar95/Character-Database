let fName = "";
let sName = "";
let id = 0;
document.getElementById("warningId").innerHTML = "";
document.getElementById("warningName").innerHTML = "";
const setFirstName = (nameText) => { fName = nameText.value };
const setSurname = (sNameText) => { sName = sNameText.value };
const setId = (number) => { id = number.value };

function searchDatabaseById() {
    if (id === 0) {
        document.getElementById("warningId").innerHTML = "You have not inserted an id number";
    }
    fetchData("null", "GET", "/characters/" + id).then((value) => {
        sessionStorage.setItem("userdata", value);
        window.location.assign("update.html");
    }).catch((error) => {document.getElementById("warningId").innerHTML = "You have not inserted a correct id"});
}
function searchDatabaseByName() {
    if (fName === "") {
        document.getElementById("warningName").innerHTML = "You have not inserted a name";
        alert("")
    }
    fetchData("null", "GET", "/charactersName/" + fName).then((value) => {
        sessionStorage.setItem("userdata", value);
        let userDataText = JSON.parse(value);
        console.log(userDataText.length);
        if (userDataText.length > 1) {
            window.location.assign("update_list.html");
        } else {
            window.location.assign("update.html");
        }

    })
}
// function searchDatabase() {
//     if (id >= 1) {
//         let userRequest = JSON.stringify(new foundId(id));
//         fetchData(userRequest, "GET", "/characters/" + id);

//     } else {
//         if (fName != "") {
//             let userRequest = JSON.stringify(new foundName(fName));
//             console.log(fName);
//             fetchData(userRequest, "GET", "/charactersName/" + fName);
//         }
//     }
//     let button = document.createElement("button");
//     button.innerHTML = "Update Character";
//     let buttonBody = document.g
// }
// function updateCharacter() {
//     console.log(fName);
//     console.log(id);
//     if (id >= 1) {
//         let userDataNum;
//         fetchData("null", "GET", "/characters/" + id).then((value) => { userDataNum = JSON.parse(value) });
//         console.log(userDataNum);
//         console.log("updating num")
//         let userData = JSON.stringify(userDataNum)
//         sessionStorage.setItem("userdata", userData);
//         sessionStorage.setItem("userRoute", "Single");
//         //window.location.assign("update.html");


//     } else {
//         if (fName != "") {
//             fetchData("null", "GET", "/charactersName/" + fName).then((value) => {userDataText=JSON.parse(value)});
//             console.log(userDataText);
//         } else {
//             alert("No details have been entered");
//         }
//     fName = "";
//     id = "";

// }
// }
