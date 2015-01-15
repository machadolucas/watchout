<h1>Watch out!</h1>
<p>This project aims to develop risks awareness through a turn based game</p>
<p>This software is under Apache 2.0 License. For more details, refer to the `LICENSE` file.</p>

<hr/>

<h2>How to run and develop using Vagrant</h2>
<p>The software is prepared to run with Vagrant, so everything is easier. You need to install <a href="http://git-scm.com/downloads">Git</a>, <a href="https://www.vagrantup.com/downloads.html">Vagrant</a>, <a href="https://www.virtualbox.org/wiki/Downloads"> and Virtual Box</a>. You can also use other Git software if you prefer, such as <a href="http://www.sourcetreeapp.com/">Atlassian SourceTree</a>.</p>
<p>You can then follow instructions in <a href="https://www.youtube.com/watch?v=DZte2FwOypg">this video</a> about how to set the environment. In summary you just need to install the tools, `git clone` this repository, `cd` into its folder, and run the `vagrant up` command.</p>

<h3>Other important information:</h3>
<ul>
    <li>Remember to adjust the db connection settings in the file `src/main/webapp/WEB-INF/applicationContext.xml`</li>
    <li>For CSS changes, you need Ruby and Compass installed. See more instructions [here](http://compass-style.org/install/). Then you can edit the `*.scss` files.</li>
    <li>Import this project in your Eclipse IDE. It has an automatic builder for compiling SASS files using Compass.</li>
    <li>The vagrant virtual machine will use Java 8, Tomcat 7 and MySql 5.5. It uses the `install.sh` script to set the environment</li>
    <li>If you make changes to the project and want to update it in the vagrant environment, use `vagrant ssh` and run the `build.sh` file. It will compile, test and deploy your changes with a restart of Tomcat server.</li>
</ul>


<h2>How to run and develop locally</h2>
<p>If you don't want to run the project in a virtual machine and want to run it locally, you can try to modify the `install.sh` script to your needs, or you can run all of the steps manually:</p>

<ul>
	<li>Install Java (7 or later), Git, Tomcat7, Maven, and MySql or other relational database compatible with JDBC (If you want to other db than MySql, remember to include the driver dependency in `pom.xml`).</li>
	<li>Clone this repository.</li>
	<li>Apply the `CreateDb.sql` file in the database. Optionally apply the `PreConfiguredData.sql` (Sample data).</li>
	<li>Remember to adjust the db connection settings in the file `src/main/webapp/WEB-INF/applicationContext.xml`</li>
	<li>Use `mvn package` to generate a WAR file in the project root, then deploy it to the Tomcat server.</li>
	<li>Start the server.</li>
</ul>

<hr/>

<h2>More information</h2>

<p>You can find information about managing data of the game in <a href="https://www.youtube.com/watch?v=oNyqmua8SKY">this video</a></p>

<p>You can find the database model in the MySqlWorkbench file `databaseModel.mwb`</p>

<p>You can (probably) find a running demo of this game <a href="http://test-machadolucas.rhcloud.com/">here</a></p>

<hr/>

<h2>About this project</h2>

<p>This project was born as a <a href="http://tampere.demola.net/projects/watch-out-dangerous">Demola project</a>. It received contribution from the following people:</p>
<ul>
	<li><a href="http://machadolucas.me">Lucas Machado</a> - Software Developer</li>
	<li>Niko Vornanen - Insurance Specialist</li>
	<li>Lê Phú - Graphic Designer</li>
	<li>Yahya Arganka - UI/UX Designer</li>
	<li>Jere Wessman - Demola Facilitator</li>
	<li>Olli-Pekka Ruuskanen - University of Tampere Professor</li>
</ul>