#Watch out!

This project aims to develop risks awareness through a turn based game.

This software is under Apache 2.0 License. For more details, refer to the `LICENSE` file.



##How to run and develop using Vagrant

The software is prepared to run with Vagrant, so everything is easier. You need to install [Git](http://git-scm.com/downloads), [Vagrant](https://www.vagrantup.com/downloads.html), and [Virtual Box](https://www.virtualbox.org/wiki/Downloads). You can also use other Git software if you prefer, such as [Atlassian SourceTree](http://www.sourcetreeapp.com/).

You can then follow instructions in [this video](https://www.youtube.com/watch?v=DZte2FwOypg) about how to set the environment. In summary you just need to install the tools, `git clone` this repository, `cd` into its folder, and run the `vagrant up` command.

####Other important information:

* Remember to adjust the db connection settings in the file `src/main/webapp/WEB-INF/applicationContext.xml`
* For CSS changes, you need Ruby and Compass installed. See more instructions [here](http://compass-style.org/install/). Then you can edit the `*.scss` files.
* Import this project in your Eclipse IDE. It has an automatic builder for compiling SASS files using Compass.
* The vagrant virtual machine will use Java 8, Tomcat 7 and MySql 5.5. It uses the `install.sh` script to set the environment
* If you make changes to the project and want to update it in the vagrant environment, use `vagrant ssh` and run the `build.sh` file. It will compile, test and deploy your changes with a restart of Tomcat server.



##How to run and develop locally

If you don't want to run the project in a virtual machine and want to run it locally, you can try to modify the `install.sh` script to your needs, or you can run all of the steps manually:

* Install Java (7 or later), Git, Tomcat7, Maven, and MySql or other relational database compatible with JDBC (If you want to other db than MySql, remember to include the driver dependency in `pom.xml`).
* Clone this repository.
* Apply the `CreateDb.sql` file in the database. Optionally apply the `PreConfiguredData.sql` (Sample data).
* Remember to adjust the db connection settings in the file `src/main/webapp/WEB-INF/applicationContext.xml`
* Use `mvn package` to generate a WAR file in the project root, then deploy it to the Tomcat server.
* Start the server.



##More information

You can find information about managing data of the game in [this video](https://www.youtube.com/watch?v=oNyqmua8SKY).

You can find the database model in the MySqlWorkbench file `databaseModel.mwb`

You can (probably) find a running demo of this game [here](http://test-machadolucas.rhcloud.com/).



##About this project

This project was born as a [Demola project](http://tampere.demola.net/projects/watch-out-dangerous). It received contribution from the following people:

* [Lucas Machado](http://machadolucas.me) - Software Developer
* Niko Vornanen - Insurance Specialist
* Lê Phú - Graphic Designer
* Yahya Arganka - UI/UX Designer
* Jere Wessman - Demola Facilitator
* Olli-Pekka Ruuskanen - University of Tampere Professor