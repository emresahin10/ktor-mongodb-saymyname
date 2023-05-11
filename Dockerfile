FROM openjdk:11
EXPOSE 1010:1010
RUN mkdir /app
COPY build/libs/*.jar /app/saymyname.jar
ENTRYPOINT ["java","-jar","/app/saymyname.jar"]
ENV MONGO_DB_NAME=$MONGO_DB_NAME
ENV MONGO_USER=$MONGO_USER
ENV MONGO_PW=$MONGO_PW
ENV MONGO_DB_URI=$MONGO_DB_URI