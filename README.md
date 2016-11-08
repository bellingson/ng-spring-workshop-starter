# Angular 2 with Spring MVC - Workshop Starter
angular 2 with spring mvc starter app

1) Install Recent Node - v6.5.0 or Higher

    OS X: https://nodejs.org/dist/v6.5.0/node-v6.5.0.pkg
    Windows: https://nodejs.org/dist/v6.5.0/win-x64/node.exe
    Linux: https://nodejs.org/dist/v6.5.0/node-v6.5.0-linux-x64.tar.xz
    Other: https://nodejs.org/en/

2) Install Angular CLI, Gulp, and TypeScript

    npm install -g angular-cli gulp typescript
    
3) Install Java 8

http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

4) Clone Workshop Repo

    git clone https://github.com/bellingson/ng-workshop-starter.git

5) Install npm dependencies

    cd ng-workshop-starter/product-mgr
    npm install

    cd ng-workshop-starter/stuffmart
    npm install


6) Test Angular CLI Installation

    ng -v
    
    should print angular-cli: 1.0.0-beta.19-3 (or higher)
    
    cd ng-workshop-starter/product-mgr
    ng serve

    got to http://localhost:4200/ in browser
    should say "app works!"

7) Test Spring MVC App

    on mac and linux:
    cd ng-workshop-starter/stuffmart
    ./gradlew appRun

    on windows:
    cd ng-workshop-starter/stuffmart
    ./gradlew.bat appRun
    
    go to http://localhost:8080/ in browser
    should load "Stuff Mart" website
    
    

## Browser

Chrome Browser is prefered  
    
## IDE Recommendations 

IntelliJ Ultimate and Visual Studio Code seem to have the best Angular 2 support at this time.  Both offer code completion and automatic imports.  The workshop instructor will use IntelliJ Ultimate, but you are free to use another IDE that you are comfortable with.

- IntelliJ Ultimate Edition (not free)

    https://www.jetbrains.com/idea/#chooseYourEdition
    
    Also install Angular JS plugin
    https://plugins.jetbrains.com/plugin/6971?pr=phpStorm
    
- IntelliJ Community Edition (free) is good too, but lacks JavaScript code completion   
    
- Visual Studio Code

    https://code.visualstudio.com/

Also recommend installing an Emmet plugin for any IDE you use.

    http://emmet.io/



