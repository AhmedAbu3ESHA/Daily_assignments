#!/bin/bash

export ANT_HOME=/u01/app/oracle/fmw_dev/12.1.3.0/oracle_common/modules/org.apache.ant_1.9.2
export PATH=$ANT_HOME/bin:$PATH

export SOA_BIN=/u01/app/oracle/fmw_dev/12.1.3.0/soa/bin

SAR_FILE=$1
CONFIG_PLAN=$2
PARTITION=$3

if [ ! -z "$CONFIG_PLAN" ]; then
  CONFIG_PLAN="-Dconfigplan=$CONFIG_PLAN"
fi

if [ -z "$PARTITION" ]; then
  PARTITION=default
fi

ant -f $SOA_BIN/ant-sca-deploy.xml -DserverURL=http://localhost:7101 -DsarLocation=$SAR_FILE -Doverwrite=true -Duser=weblogic -Dpassword=welcome1 -DforceDefault=true $CONFIG_PLAN -Dpartition=$PARTITION


# To deploy a composite application use the following syntax:
#
#   Usage: deploy[.sh] sar-file-name [config-plan] [partition]
#
#   Revision is derived from the SAR file name. The sar-file-name must be provided.
#   The config-plan is the XML file name for the configuration plan (if any).
#   The partition is set to 'default' unless specified as the third parameter.
