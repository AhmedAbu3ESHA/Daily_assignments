# deploySeedApp.sh
# used in practice 9

. /u01/app/fmw12c/Oracle_Home/wlserver/server/bin/setWLSEnv.sh
java weblogic.Deployer -username weblogic -password welcome1 -adminurl t3://localhost:7101 -deploy -source /home/oracle/labs/apps/earFiles/SOATestDemoApp.ear

# copy an icon with the URL to open the deployed app to the desktop 
cp /home/oracle/labs/scripts/util/DemoCommunitySeedServlet.desktop /home/oracle/Desktop
