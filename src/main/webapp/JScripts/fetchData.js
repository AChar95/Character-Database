function fetchData(sendbody, typeRequest, endpoint) {
    const mainPath =window.location.host
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
        req.open(typeRequest, "http://localhost:8080/Character-Database-1.0/api" + endpoint);
        req.setRequestHeader("content-type", "application/json");
        req.send(sendbody);
    })
};