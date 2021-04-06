FROM java
COPY target/*.jar app.jar
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD /target/springboot-hibernate-starter-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8686
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]