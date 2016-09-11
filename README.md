# SETUP
```
# psql -Upostgres
postgres=# create user bigbears;
postgres=# create database shop;
```

# INITIAL DB
```
#!/bin/bash
if [[ ! -n $REIMPORTDB_PATH  ]]; then
export REIMPORTDB_PATH=/usr/local/bin/
fi
${REIMPORTDB_PATH}dropdb --if-exists shop
${REIMPORTDB_PATH}createdb shop
${REIMPORTDB_PATH}psql shop < schema.sql
```

# RUN
```
kill -9 $(cat bearshop/release/RUNNING_PID)
rm -rf bearshop/release
unzip bearshop/release.zip -d bearshop
bearshop/release/bin/bearshop -Dconfig.file=/home/ubuntu/bearshop/application.conf \
    -Dlogger.file=/home/ubuntu/bearshop/production.xml \
    -Djava.net.preferIPv4Stack=true \
    & disown
```

© 2016 BigBears Co., Ltd.
