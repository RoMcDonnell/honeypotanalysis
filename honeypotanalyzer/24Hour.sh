#!/bin/bash

echo "Preparing to analyse the data. The number of attacks"
echo "that took place over the 24 hours is listed below......"
echo ""
for (( i=0; i<24; i++ ))
do
        if [ $i -lt 10 ]
        then
                echo -n "0$i:00 Number of Attacks: "
                grep "login attempt" ~ruby/hpot/kipp* | grep succeeded | grep " 0$i:" | wc -l

        fi
        if [ $i -gt 9 ]
        then
                echo -n "$i:00 Number of Attacks: "
                grep "login attempt" ~ruby/hpot/kipp* | grep succeeded | grep " $i:" | wc -l
	fi
done

