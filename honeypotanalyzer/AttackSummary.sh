#!/bin/bash

echo "This generates a breakdown of the attacks by month and by sccess/fail"
echo ""
echo -n "Number of successful attacks: "
grep "login attempt" ~ruby/hpot/kipp* | grep succeed | wc -l
echo -n "Number of failed attacks: "
grep "login attempt" ~ruby/hpot/kipp* | grep failed | wc -l
