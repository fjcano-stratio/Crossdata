#!/bin/bash

# CROSSDATA_CONF is global enviroment variable
# JAVA_OPTS
# JSVCCMD
# JAVA_HOME
if [ -z $CROSSDATA_SHELL_HOME ];then
	CROSSDATA_SHELL_HOME="$(cd "`dirname "$0"`"/..; pwd)"
fi 
if [ -z $CROSSDATA_SHELL_LOGS ];then
	CROSSDATA_SHELL_LOGS=$(pwd)
fi 
# CROSSDATA_LIB
CROSSDATA_SHELL_LIB="${CROSSDATA_SHELL_HOME}/lib"

# CROSSDATA_BIN
CROSSDATA_SHELL_BIN="${CROSSDATA_SHELL_HOME}/bin"

# CROSSDATA_LOG_OUT
CROSSDATA_SHELL_LOG_OUT="${CROSSDATA_SHELL_LOGS}/crossdata-shell.out"

# CROSSDATA_LOG_ERROR
CROSSDATA_SHELL_LOG_ERR="${CROSSDATA_SHELL_LOGS}/crossdata-shell.err"

# CROSSDATA_SERVER_USER
CROSSDATA_SHELL_USER=$USER

# CROSSDATA_SERVER_PID
CROSSDATA_SHELL_PID="${CROSSDATA_HOME}/crossdata-shell.pid"

CROSSDATA_CONF="/etc/sds/crossdata-shell"

echo "CROSSDATA_SHELL_HOME = $CROSSDATA_SHELL_HOME"
echo "CROSSDATA_SHELL_CONF = $CROSSDATA_SHELL_CONF"
echo "CROSSDATA_SHELL_LIB  = $CROSSDATA_SHELL_LIB"
echo "CROSSDATA_SHELL_BIN  = $CROSSDATA_SHELL_BIN"
echo "CROSSDATA_SHELL_LOG_OUT  = $CROSSDATA_SHELL_LOG_OUT"
echo "CROSSDATA_SHELL_LOG_ERR  = $CROSSDATA_SHELL_LOG_ERR"
echo "CROSSDATA_SHEL_PID  = $CROSSDATA_SHELL_PID"

export CROSSDATA_SHELL_LOGS
export CROSSDATA_SHELL_HOME
export CROSSDATA_SHELL_LIB
export CROSSDATA_SHELL_BIN
export CROSSDATA_SHELL_LOG_OUT
export CROSSDATA_SHELL_LOG_ERR
export CROSSDATA_SERVER_PID

