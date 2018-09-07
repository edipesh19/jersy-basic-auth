# jersy-basic-auth

# Environment Setup
1. Install maven
2. Download Mysql or install MySql. I am testing this with an standalone mysql. I am running this as user root and password is empty as below.
    mysqld.exe --console --standalone
    mysql -uroot

3. Create a database called test
4. Create a table named user with the following schema.

---------------------------------------------------------------------------------
Field -------- Type -------- Null -------- Key -------- Default -------- Extra         
---------------------------------------------------------------------------------
id -------- int(11) -------- NO -------- PRI -------- NULL -------- auto_increment  
name -------- varchar(100) -------- NO                                     
salary -------- mediumtext -------- NO                                     
---------------------------------------------------------------------------------

Clone the repository or download the zip using git clone https://github.com/edipesh19/jersy-basic-auth.git command

# Import to ecplise
File -> Import -> Under Maven choose "Existing maven projects" -> Click browse and locate the path where the repository is cloned -> Click Finish
Right click on project -> Maven -> Update Project -> Select simple-resrapi -> click OK
Download tomcat 9 and add that server to ecplise. Follow the link for details
https://www.youtube.com/watch?v=PH-bK3g2YmU


Right click on project select Run As -> Run on Server -> Select Tomcat 9 -> click Next -> If the app is not added add that using Add button -> Click Finish
# Run the app
Go to the root path "simple-restapi" where pom file is present.
run te following command which will create a war file inside target folder.
mvm package
deply the war file in a container like tomcat I have tested this app with tomcat 9.

#Test using postman
Run postman import the collection "Basic_Auth.postman_collection.json" present in the project root folder and Run the APIs
Otherwise follow the manual steps as below
Do a get call with with http://localhost:8080/simple-restapi/restapi/myresource url no need of Authorization header because it is not secured.
Do a get call to http://localhost:8080/simple-restapi/restapi/secured/user with Authorization header as Basic Auth and user name is admin password is password

#Test using Curl
Below is not secured hence no need to pass any header
curl -X GET -i http://localhost:8080/simple-restapi/restapi/myresource		
You will get the response as "Got it!"

Below resource is secured with Basic Authentication hence you have to pass the Authorization header as shown below.
curl -X GET -i http://localhost:8080/simple-restapi/restapi/secured/user
curl -X GET -H 'Authorization: Basic YWRtaW46cGFzc3dvcmQ=' -i http://localhost:8080/simple-restapi/restapi/secured/user
