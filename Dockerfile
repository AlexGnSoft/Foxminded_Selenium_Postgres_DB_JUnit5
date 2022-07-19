FROM maven:4.0.0-openjdk:11-jre-slim

COPY src /Users/aleksandrgnuskin/Documents/QA_Automation/AutomationFoxminded/src
COPY pom.xml /Users/aleksandrgnuskin/Documents/QA_Automation/AutomationFoxminded
RUN mvn -f /Users/aleksandrgnuskin/Documents/QA_Automation/AutomationFoxminded/pom.xml