-- 코드를 입력하세요
SELECT PR.MEMBER_NAME, RE.REVIEW_TEXT, DATE_FORMAT(RE.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM (SELECT MEMBER_ID, REVIEW_TEXT, REVIEW_DATE
FROM REST_REVIEW
WHERE MEMBER_ID IN (SELECT MEMBER_ID
FROM REST_REVIEW 
GROUP BY MEMBER_ID 
HAVING COUNT(*) = (SELECT MAX(CNT) 
                    FROM(SELECT COUNT(*) AS CNT
                            FROM REST_REVIEW 
                        GROUP BY MEMBER_ID) C))) RE
JOIN MEMBER_PROFILE PR 
ON PR.MEMBER_ID = RE.MEMBER_ID
ORDER BY RE.REVIEW_DATE, RE.REVIEW_TEXT;

# SELECT MEMBER_ID, REVIEW_TEXT, REVIEW_DATE
# FROM REST_REVIEW 
# GROUP BY MEMBER_ID 
# HAVING COUNT(*) = (SELECT MAX(CNT) 
#                    FROM(SELECT COUNT(*) AS CNT
#                       FROM REST_REVIEW 
#                       GROUP BY MEMBER_ID) C);

# SELECT COUNT(*), MEMBER_ID
# FROM REST_REVIEW 
# GROUP BY MEMBER_ID
# ORDER BY COUNT(*) DESC;

# SELECT MAX(MEMBER_NAME) FROM MEMBER_PROFILE;
