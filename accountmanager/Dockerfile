FROM java:8-jre
ADD ./target/accountmanager-1.0.jar accountmanager/src/accountmanager-1.0.jar
WORKDIR accountmanager/src
ENTRYPOINT ["java", "-jar", "accountmanager-1.0.jar"]