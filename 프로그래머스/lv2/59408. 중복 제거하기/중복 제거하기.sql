-- 코드를 입력하세요
# SELECT DISTINCT COUNT(*) FROM ANIMAL_INS WHERE NAME IS NOT NULL;
# SELECT COUNT(*) FROM ANIMAL_INS;
SELECT COUNT(DISTINCT NAME) FROM ANIMAL_INS;