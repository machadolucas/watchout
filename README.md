<h1>Watch out!</h1>
<p>This project aims to develop risks awareness through a turn based game</p>

<hr/>

<h2>Requirements to run</h2>
<p>You need at least JDK7, Eclipse IDE with Maven installed for dependency management, and a relational database server (such as MySql) running.</p>
<ul>
    <li>Run the SQL file present in this project root folder in your database server</li>
    <li>Adjust the connection settings in the file `/src/main/webapp/WEB-INF/applicationContext.xml`</li>
    <li>Import this project in your Eclipse IDE</li>
    <li>For CSS changes, you need Ruby and Compass installed. See more instructions [here](http://compass-style.org/install/). Then you can edit the `*.scss` files.</li>
    <li>Import this project in your Eclipse IDE. It has an automatic builder for compiling SASS files.</li>
    <li>Create a new Tomcat server in Eclipse (or other server such as jboss) and add the project to it.</li>
    <li>After starting the server, go to the address `/admin` and try to login. Your try will be recorded as the first username and password. If you forget this information, you have to drop your database and create it again.</li>
    <li>Follow the instructions in the administrative interface to add data to the application</li>
</ul>
