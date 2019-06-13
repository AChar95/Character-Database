function clearTextboxes(pageId) {
    if (pageId == 1) {
        document.getElementById("firstname").value = "";
        document.getElementById("surname").value = "";
        document.getElementById("class").value = "";
        document.getElementById("gametype").value = "";
    } if (pageId === 2) {
        console.log("clearing");
        document.getElementById("firstname").value = "";
        document.getElementById("surname").value = "";
        console.log("cleared");
    } if (pageId === 3) {
        document.getElementById("table").innerHTML ="";
    }
}
