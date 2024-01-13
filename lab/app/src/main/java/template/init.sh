#!/usr/bin/env sh
# To be runed from 'app/src/main/java' directory.

if [ $# -ne 2 ]
then
    echo "Usage: init.sh [lab_no] [tasks_no]"
    exit
fi

lab=$1
tasks=$2

if [ ! -d $lab ]
then
    echo "Cannot find lab folder"
    exit
fi

if [ $tasks -lt 0 ]
then
    echo "Illegal number of tasks"
    exit
fi

for i in $(seq 1 $tasks)
do
    mkdir $lab/task$i
    cp template/Main.java $lab/task$i
    sed -i -e "s/package template;/package $lab.task$i;/g" $lab/task$i/Main.java
    sed -i -e "s/return 0;/return $i;/g" $lab/task$i/Main.java
done
