--JDBupdate_waitingorders.sql
--rp 2014.02.11

UPDATE BCA_ORDERS SET STATUS = 'approved' 
WHERE STATUS = 'waiting'
AND ORD_ID < (SELECT MAX(ORD_ID) FROM BCA_ORDERS WHERE STATUS ='waiting');

COMMIT;
EXIT