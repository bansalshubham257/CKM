set projectLocation=C:\Users\shubham.bansal\eclipse-workspace\CKM\seleniumFramework-master_GitHub
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java -cp %projectLocation%\bin;%projectLocation%\lib\* org.testng.TestNG Test.xml
pause