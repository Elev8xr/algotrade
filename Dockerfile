FROM ubuntu:18.04

RUN apt update
RUN apt install -y openjdk-8-jdk curl 
ENV PATH=/usr/lib/jvm/java-1.8.0-openjdk-amd64/bin:$PATH
WORKDIR /home
RUN curl -o apache-maven-3.8.1-bin.tar.gz https://downloads.apache.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz
RUN tar xzvf apache-maven-3.8.1-bin.tar.gz
ENV PATH=/home/apache-maven-3.8.1/bin:$PATH

ADD ./ /home/Crawler
WORKDIR /home/Crawler

RUN mvn clean package
RUN useradd myuser
USER myuser

# CMD java -jar target/rest-service-0.0.1-SNAPSHOT.jar
