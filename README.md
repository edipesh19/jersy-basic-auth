# jersy-basic-auth

# Environment Setup
1. Install maven
2. Download Mysql or install MySql. I am testing this with an standalone mysql. I am running this as user root and password is empty as below.
    mysqld.exe --console --standalone
    mysql -uroot

3. Create a database called test
4. Create a table named user with the following schema.
#-----------------------------------------------------------------
#| Field  | Type         | Null | Key | Default | Extra          |
#-----------------------------------------------------------------
#| id     | int(11)      | NO   | PRI | NULL    | auto_increment |
#| name   | varchar(100) | NO   |     |         |                |
#| salary | mediumtext   | NO   |     |         |                |
#-----------------------------------------------------------------

# Run the app
Clone the repository or download the zip
Go to the root path "simple-restapi" where pom file is present.
run te following command which will create a war file inside target folder.
mvm package
deply the war file in a container like tomcat I have tested this app with tomcat 9.
