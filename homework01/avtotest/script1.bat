# if you dont have generated file Vagrant 
# remove # on the next line
# git clone https://github.com/Varying-Vagrant-Vagrants/VVV.git
# will start process of copying

#rename database that u want to import to init.sql
copy /y "init.sql" "%vagrant-local%\database\"

cd vagrant-local
vagrant up
# will start process of instaling that take some time

cd..
cd src
cd test
cd java
cd mozila

mvn test

vagrant halt


