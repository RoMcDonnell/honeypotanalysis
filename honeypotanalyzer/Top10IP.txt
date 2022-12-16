#!/bin/bash

echo "The top ten IP addresses which attacked the HoneyPot are listed below"
echo ""
grep "login attempt" ~ruby/hpot/kipp* | awk '{print $6}' | awk -F ',' '{print $3}' | sed 's/]//g' | sort | uniq -c | sort -n | tail -10 | awk '{print $2}'
