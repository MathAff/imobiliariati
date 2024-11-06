# Introduction
This is a project from my IT course where me and other colleges challenged ourselves to implement some features arround the Java, PHP, JavaScript, HTML and CSS technologies. Overall, this is an application and website for a fictional Real State Agency. 
We were told to make a Java app that allows the user to insert a property into a database.
For the Website, the user could only see all properties uploaded. In other words, the Java application uploads registers in the database and files in the FTP server, meanwhile the web application only read those informations.

# Technologies used: 
This project uses:
- MySql Databases
- FileZilla FTP server
- Java with Ant
- Jackson API (to read JSON files)
- ViaCEP API (to track adress info. by Zip Code)
- HTML
- CSS
- Javascript
- PHP

# Instructions for testing it yourself:
Before running any file, remember to use a Local Web Server with Apache, MySQL and FileZilla. Without that you can't run this app. Understand that this was a test project, so we couldn't use any server for our own. 
This problem gets us in the other topic, which is: you need to create a file yourself. If you take a look into ```.gitgnore``` file, you can see that there are the ```/website/php/utils/ConnectionCredencials.php```, which is the file where we stored our Database Credentials for connecting, and the ```/website/imagens-imoveis/``` where all the media uploaded by the FTP are alocated. 
In other words you need to create your own file inside ```/website/php/utils``` with the credencials for your database. After that, you need to setup your FTP server for storing inside the directory ```imobiliariati/website/imagens-imoveis```. 
Another way to do that is just changing the information inside the code, so instead of creating a whole file with the credentials, just put them in the ```ConnectionDB.php```. Or access your FTP from another server, using other credentials.
I guess this is all you need to run and enjoy our final product.

# Java Application
As it was said earlier, the Java app can upload properties of some Real State Agency to a database. Once uploaded, the user could register an image in your computer to a FTP Server. Initially we were triygn to use a free online FTP Server, but we were getting trouble making uploads there, so finally, we just let this job for XAMPP. For this reason, if you try to run this app on your own, you can only test it if you're using some kind of Local Web Server with Apache, MySQL and FileZilla. Finally, here are some screenshots of the app:
## Overview:
![image](https://github.com/user-attachments/assets/3953bfd2-bf43-46a0-854e-73d3dd59b153)


![image](https://github.com/user-attachments/assets/ac3f8814-7755-4b01-969c-a68865c07614)


![image](https://github.com/user-attachments/assets/1fe49b87-5e7c-4684-afe9-5b96cf9d6141)



# PHP Application
As we were learning Hypertext Processor (PHP) language, the homework was to make an Web app that could show the results of any search for an address to the database, and displaying the images uploaded in the FTP Server, so the user didn't need to login for any reason, the same way a site for a Real State Agency works. Anyways, here it goes some screeshots to the website:

![image](https://github.com/user-attachments/assets/34e036dd-79b2-41ad-97a4-633bc409c764)

![image](https://github.com/user-attachments/assets/40991f78-3eac-4bfc-98e6-867860c3fa4c)

![image](https://github.com/user-attachments/assets/cce8849d-9d0e-4d37-8f33-4a85447901ee)
