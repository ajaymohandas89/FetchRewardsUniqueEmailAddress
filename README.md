# FetchRewardsUniqueEmailAddress

# FetchRewards
## Problem Statement
Accept a list of email addresses and return an integer indicating the number of unique email addresses.

### Expectation
Examples
test.email@gmail.com, test.email+spam@gmail.com and testemail@gmail.com will all go to the same address, and thus the result should be 1.
test.email@gmail.com and test.email@fetchrewards.com are two different email addresses, and thus the result should be 2.

### Assumptions
1) Email address is validated as per regex pattern such as "^[A-Za-z0-9+_.-]+@[a-z]+\\.[a-z]{2,3}$"

### Approach
1) Created a Spring Boot MVC arhcitecture using Java as my technology language
2) Validation of input parameter is writter in a separate class under validator package
3) Service handles EmailService giving us the result
4) Splitting the input with @ and will consider first part of split part
5) Then ignore rest of string is "+" is found and replace any dot(.) with nothing
6) This username is added with @and domain name to add in HashSet which would always contain unique set and return the size of set

#### Time complexity and Space complexity
The time complexity of the code on a avergae case runs till maximum size of email list

#### Steps to run to on IDE
1) Insall IDE (preferrably [Eclipse](https://www.eclipse.org/downloads/packages/release/helios/sr1/eclipse-ide-java-developers))
2) Clone the repository using [http](https://github.com/ajaymohandas89/FetchRewardsUniqueEmailAddress.git) or [ssh](git@github.com:ajaymohandas89/FetchRewardsUniqueEmailAddress.git)
3) Open the spring project in the IDE
5) Run project as "Spring Boot App"

#### Steps to run to on command line
1) Install maven ```https://maven.apache.org/download.cgi```
2) Open command line in windows or terminal on Ubuntu mvn clean install
3) Find .jar file on the target folder created after building the project in FetchRewards_Backend_SWE\target
4) Execute ```java -jar UniqueEmailAddress-0.0.1-SNAPSHOT.jar```

#### To test the api service locally use any API testing tool (Example: Postman) or hit url http://localhost:8081/cmpVersion (since port mentioned on application properties is 8081)
``` bash
curl --location --request POST 'http://localhost:8081/uniqueEmailList' \
--header 'Content-Type: application/json' \
--data-raw '{
    "emailList":["test.email+spam@gmail.com","testemail@gmail.com","test.email@gmail.com"]
}'
```

#### Steps to run unit test cases
1) Run the project as JUnit test cases by right click and run as "JUnit test cases"
2) By command line use  ```mvn test```
