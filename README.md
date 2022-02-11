# homeownersQA

Outline - Prepare a homeowner database to store a persons first, last names along with how many properties they own and their networth. The user should then be able to create new entries, update existing entries . This is to practice some of the material we have learned. I have also included custom exceptions and a custom query also.

**Tools Used **
Database - Persistent MySQL, Temporary for Testing H2
Database tool to check - MySQL workbench
Language - Java version 17
Framework - Spring Boot
HTTP Connectio Protocol - Rest
Build Tool - Maven
Testing Suite - Mockito using Unit and Integration
Source Control Method  - Git Hub storing in Github Repo. Feature branches for each of the features. 
Jira Board - https://catalyse.atlassian.net/jira/software/projects/HOME/boards/6
Annotation Dependencies - Lombok
API Dcumentation - Swagger


**How Do I expect the challenge to go**
I expect it will be tricky pulling together the various part s f the course and I understand the importance of reaching out early to get answers to sticking point.s 

**What went well**
The domain and controller classes were relatively easy 

**What didn't go well**
the rest of the classes took a lot of messing around with the get right. The testing was quite tricky and also the source control management system is very fiddly and long winded.

**Improvments for future projects**
Ensure that I go over the material and study optionals and generics better. I could also learn how to do dto so I can have mutiple tables. I could also aim for even higher test coverage.

**Screenshots of Database**
Included in project document folder

**Failures Encountered**

1. Issues with imports not pulling in correctly
2. Usses when redoing classes and not following through where those changes impacted other classes
3. Issues with annotations not being picked up often fixed by a restart of the IDE
4. Lots of testing issues, particularly with the controller integration. Dealing with null pointer using optionals and getting syntax right fixed this. 

**Testing Analysis**
Unit Tests were created Create, Delete, GetOne, GetAll, and Update Methods and they all passed
The domain, service and user repo classes all passed with 100% coverage on both the methods and the classes
The exceptions class had 100% coverage of the method but not the class itself
The rest controller had 100% class coverage and 62% of methods

A controller Integration Test was created for Get All, GetByOne, GetByFirstName and the Delete service which all also passed.

In total, 80% of the classes and 90% of the lines had coverage
