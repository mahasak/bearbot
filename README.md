# SETUP
```
# psql -Upostgres
postgres=# create user bigbears;
postgres=# alter role bigbears set password='bigbears';
postgres=# create database gst;
```

# INITIAL DB
```
#!/bin/bash
if [[ ! -n $REIMPORTDB_PATH  ]]; then
export REIMPORTDB_PATH=/usr/local/bin/
fi
${REIMPORTDB_PATH}dropdb --if-exists gst
${REIMPORTDB_PATH}createdb gst
${REIMPORTDB_PATH}psql shop < schema.sql
```

# RUN
```
kill -9 $(cat bearbot/release/RUNNING_PID)
rm -rf bearbot/release
unzip bearshop/release.zip -d bearshop
bearbot/release/bin/bearbot -Dconfig.file=/home/ubuntu/bearbot/application.conf \
    -Dlogger.file=/home/ubuntu/bearbot/production.xml \
    -Djava.net.preferIPv4Stack=true \
    & disown
```

© 2016 BigBears Co., Ltd.
