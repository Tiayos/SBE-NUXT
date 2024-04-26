FROM amazoncorretto:17.0.4

WORKDIR /app

COPY ./target/ins-0.0.1-SNAPSHOT.jar .
#COPY /reports/reportFicha.jasper .
#COPY /reports/reportFicha.jrxml .

COPY ./src/main/resources/fonts/calibri.ttf /usr/share/fonts


#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target
#RUN ./mvnw dependency:go-offline
COPY ./src ./src

#RUN ./mvnw clean package -DskipTests


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ins-0.0.1-SNAPSHOT.jar"]