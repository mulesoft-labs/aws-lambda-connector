#!/bin/sh -x
ARTIFACT_ID=aws-lambda-connector
VERSION=1.0.0

LOGO_PATH=$(ls icons/theme.light/*-large.png)
ARTIFACT_JAR=$(ls target/mule-module-*.jar)
# Solutions Consulting Internal Exchange
ORG_ID=e6c8356b-f191-46fe-8991-2ee0b1096472
# Solutions Consulting Exchange Group ID
GROUP_ID=f724cd54-2a9f-4c26-a198-82dc24f57c7c.solutions-consulting
MVN_REPO_URL=https://maven.anypoint.mulesoft.com/api/v1/organizations/$ORG_ID/maven
UPDATE_SITE=target/UpdateSite.zip

# Connector Update Site Upload (for Studio)
mvn deploy:deploy-file -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dversion=$VERSION -Dpackaging=zip -Dfile=$UPDATE_SITE -Dclassifier=studio-plugin -DpomFile=pom.xml -DrepositoryId=$ORG_ID -Durl=$MVN_REPO_URL

# Connector JAR upload 
mvn deploy:deploy-file -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dversion=$VERSION -Dpackaging=jar -Dfile=$ARTIFACT_JAR -DgeneratePom=false -DrepositoryId=$ORG_ID -Durl=$MVN_REPO_URL

# Icon upload (The one you see on Exchange)
mvn deploy:deploy-file -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dversion=$VERSION -Dclassifier=icon -Dfile=$LOGO_PATH -DgeneratePom=false -DrepositoryId=$ORG_ID -Durl=$MVN_REPO_URL
