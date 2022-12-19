for (( i=0; 1<24; 1++ ))
do
        if [ $i -lt 10 ]
        then
                echo -n "0$1:00 Number of Attacks: "
                grep "login attempt" kipp* | grep succeeded | grep " 0$i:" | wc -l

        fi
        if [ $i -lt 9 ]
        then
                echo -n "$i:00 Number of Attacks: "
                grep "login attempt" kipp* | grep succeeded | grep " $i:" | wc -l
done

