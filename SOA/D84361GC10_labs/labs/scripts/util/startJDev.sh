# startJDev.sh
# ron pinkerton
# version 0.2 2014.07.25

export JAVA_HOME=/usr/bin
export MW_HOME=/u01/app/fmw12c
export ORACLE_HOME=$MW_HOME/Oracle_Home
export JDEV_USER_DIR=$MW_HOME/domains
export WLS_REDIRECT_LOG=$JDEV_USER_DIR/jdevserver.log
$ORACLE_HOME/jdeveloper/jdev/bin/jdev -clean
