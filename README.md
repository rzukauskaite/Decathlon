# Decathlon
Example of using: Spring, JSF 2

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Instructions how to enable this sample
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

~~~~~~~~~~~
 1. Tools 
~~~~~~~~~~~

1.1. Building project: download maven and place under 'C:\' directory, i.e.: apache-maven-3.0.4;

1.2. Starting application: download tomcat and place under 'C:\' directory, i.e.: apache-tomcat-7.0.72;

1.3. Coding: download java and eclipse, i.e.: jdk1.7, Mars.2;


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. Prepare sample application 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Run following maven commands (from sample directory) to prepare sample application:

2.1. mvn clean install;

2.2. mvn package;


~~~~~~~~~~~~~~~~~~~~
3. Run application 
~~~~~~~~~~~~~~~~~~~~

3.1. click on startup.bat under tomcat directory;

3.2. when tomcat is starting, user will be asked to enter full path to the file, you would like to read (that file should contains all information about contestants);

3.3. when file is read and tomcat is up, enter http://localhost:8080/decathlon-app/default.xhtml to your browser;


~~~~~~
Note 
~~~~~~

1. Services functionality covered by unit tests;

2. ITest for Bean class provided;

