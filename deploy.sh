#!/usr/bin/env bash
kill -9 $(cat bearshop/release/RUNNING_PID)
rm -rf bearshop/release
unzip bearshop/release.zip -d bearshop
nohup bearshop/release/bin/bearshop -Dconfig.file=/home/ubuntu/bearshop/application.conf \
    -Dlogger.file=/home/ubuntu/bearshop/production.xml \
    -Djava.net.preferIPv4Stack=true > foo.out 2> foo.err < /dev/null &
