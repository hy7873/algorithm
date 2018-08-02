call mvn clean:clean
call mvn -Dmaven.test.skip=true package -Plocal
@pause

rem master