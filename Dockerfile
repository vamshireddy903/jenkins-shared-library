FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY Manin.java .

RUN javac Manin.java

EXPOSE 8081

CMD ["java", "Manin"]
