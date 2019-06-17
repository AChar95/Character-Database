# Character-Database
A front, back and api for hosting a character databse

## 1. Operating the site
Initially the user will be prompted to create a user name this is entirely up to the user and can be any combination of characters and letters, the only constraint is that the username must be unique, currently there is no password in place this will be a future sprint, and due to nature of testing the overall functionality, this feature was restricted to a later build as it would restrict fast access to core functionality of the page. Navigate to the **Create Character** page using the navbar at the top of the page, here you can create your character. Clicking on the **Find Character** link at the top will allow you to search for **your own** characters (characters made by other users will not be visible to you). after searching for your desired character you will then be taken to an update page where you can see the character details and you can update them as you wish. if you have more than one character with the same first name you will then be taken to a page which will display a list of characters that you have access to with that name, and you will be asked the id of the character you wish to alter, submit this and you will be taken to the normal update page.
Other areas: the **About** page, explains a bit more about the project and credits the artists for their images, the **New** page discribes the new functions added to the site with each update.

Future plans:
Include password for users, include a repository to show how many characters users have stored, a method to add campaigns which will link to the characters, therefore allowing you to see other characters in a campaign that you are part of. 

## 2.Deploying the site
Requirements:
 1. Wildfly
 2. H2 version 1.4.197 (later version restrict creation of a table)
 3. Maven
 4. Java JDK and JRE 8
 
 Ensure that the standalone.xml file that was included as part of Wildfly(in standalone/configuration) is edited to allow for a persistant database:
 < datasource jta="true" jndi-name="java:jboss/datasources/MyApplicationDS" pool-name="MyApplicationDS" enabled="true" use-ccm="true"> 
    < connection-url>jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</ connection-url> 
    < driver-class>org.h2.Driver</ driver-class>
    < driver>h2</ driver>
    < security> 
        < user-name>sa</ user-name> 
        < password>sa</ password> 
    </ security> 
    < validation> 
          < background-validation>false</ background-validation> 
    </ validation> 
    </ datasource>
    
The above portion of code must be placed following the section containing the local in-memory database, easiest method to find this would be to search for datasources in the file.
Within the project navigate to the Character-Database\src\main\webapp\JScripts folder and alter the fetchData.js, you will see the following file:

function fetchData(sendbody, typeRequest, endpoint) {
    const mainPath =window.location.host
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
        req.open(typeRequest, "http://35.246.82.192:8080/Character-Database-1.0/api" + endpoint);
        req.setRequestHeader("content-type", "application/json");
        req.send(sendbody);
    })
};

please alter the http address to the following: 

**http://localhost:8080/Character-Database-1.0/api**

this will allow for access website's various functionality locally

Please note that to see your saved data, on a browser of your choice, enter into the navigation bar "localhost:8082" this should redirect you to the h2 database landing, select the server database from the dropdown menu, and ensure that the following address is in the box labeled JDBC url: jdbc:h2:tcp://localhost/~/test 
Logging in will allow you to see your data after you've created it, and you will be able to see the one-to-many relationship between Users and Characters at work.

After completing this the website can then be safely deployed by placing the .war file, that can be created by running the mvn install command in the project's main landing (using console commands), the .war file can then be found in the target folder, copy this file then paste inside the following directory within Wildfly Wildfly##/standalone/deployment, where the Wildfly## represents your Wildfly root folder. Once the war file is inside return to the root folder and then go to the bin folder and run the standalone.bat file (for windows) or standalone.sh (for linux). Once the wildfly has deployed the site, it may be accessed on the port 8080, the url with be as follows localhost:8080/Character-Database-1.0, this will take you to the login page where you can create your own user.
Please note that this software comes as is, 
