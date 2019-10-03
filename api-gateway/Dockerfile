FROM hub.c.163.com/library/java:8-alpine

ADD target/*.jar application.jar

RUN echo "Asia/Shanghai" >/etc/timezone

EXPOSE 4000

ENTRYPOINT ["java", "-jar", "/application.jar"]