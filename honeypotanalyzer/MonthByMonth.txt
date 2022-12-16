#!/bin/bash

echo "This generates a breakdown of the attacks by month and by sccess/fail"
echo ""
echo "**************** November Attack Summary ****************"
echo -n "Number of successful attacks: "
grep "login attempt" ~ruby/hpot/kipp* | grep "2014-11" | grep succeed | wc -l
echo -n "Number of failed attacks: "
grep "login attempt" ~ruby/hpot/kipp* | grep "2014-11" | grep failed | wc -l
echo ""
echo "**************** December Attack Summary ****************"
echo -n "Number of successful attacks: "
grep "login attempt" ~ruby/hpot/kipp* | grep "2014-12" | grep succeed | wc -l
echo -n "Number of failed attacks: "
grep "login attempt" ~ruby/hpot/kipp* | grep "2014-12" | grep failed | wc -l
echo ""
echo "**************** January Attack Summary ****************"
echo -n "Number of successful attacks: "
grep "login attempt" ~ruby/hpot/kipp* | grep "2015-01" | grep succeed | wc -l
echo -n "Number of failed attacks: "
grep "login attempt" ~ruby/hpot/kipp* | grep "2015-01" | grep failed | wc -l
echo ""
echo ""
