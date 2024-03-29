-- 코드를 입력하세요
SELECT PR.PRODUCT_CODE, SUM(PR.PRICE * OFL.SALES_AMOUNT) AS SALES
FROM PRODUCT PR INNER JOIN OFFLINE_SALE OFL ON PR.PRODUCT_ID = OFL.PRODUCT_ID
GROUP BY PR.PRODUCT_CODE
ORDER BY SALES DESC, PR.PRODUCT_CODE