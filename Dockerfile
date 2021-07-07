FROM payara/micro
COPY ./target/electivo2.war $DEPLOY_DIR
