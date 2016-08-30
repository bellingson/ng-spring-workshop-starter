# NG with Spring MVC - Workshop Starter
angular 2 with spring mvc starter app

1) Install Latest Node - v6.5.0 Current Branch

OS X: https://nodejs.org/dist/v6.5.0/node-v6.5.0.pkg
Windows: https://nodejs.org/dist/v6.5.0/win-x64/node.exe
Linux: https://nodejs.org/dist/v6.5.0/node-v6.5.0-linux-x64.tar.xz
Other: https://nodejs.org/en/

2) Install Gulp

    npm install -g gulp

3) Install TypeScript and Typings

    npm install -g typescript typings

4) Install Angular CLI (webpack branch)

    npm install -g angular-cli@webpack
    
5) Install Java 8

http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

6) Clone Workshop Repo

    git clone https://github.com/bellingson/ng-workshop-starter.git

7) Install npm dependencies

    cd ng-workshop-starter/product-mgr
    npm install

    cd ng-workshop-starter/stuffmart
    npm install


8) Test Angular CLI Installation

    ng -v
    
    should print angular-cli: 1.0.0-beta.11-webpack.8 (or higher)
    
    cd ng-workshop-starter/product-mgr
    ng serve

    got to http://localhost:4200/ in browser
    should say "app works!"

9) Test Spring MVC App

    cd ng-workshop-starter/stuffmart
    ./gradlew appRun
    
    go to http://localhost:8080/ in browser
    should load "Stuff Mart" website
    
    



