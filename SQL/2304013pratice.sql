--1.請查詢“C001”課程及格的學生，按分數降序排列的同學學號
--來源TABLE =  SC
--顯示欄位 [SNO] [CNO] [SCORE]

select * 
	from SC 
	where CNO='C001' and SCORE>=60 
	order by SCORE DESC

--2.查詢男生、女生人數
--來源TABLE =  STUDENT
--顯示欄位 [SEX] [CNT]

select SSEX as SEX,count(*) as CNT 
	from STUDENT 
	group by SSEX;


--3.查詢不同課程成績相同的學生的學號、課程號、學生成績
--來源TABLE =  SC
--顯示欄位 [SNO] [CNO] [SCORE]

select * from SC where SNO in(select SNO 
	from SC 
	group by SCORE,SNO 
	having count(SCORE)>1);

	
--4.查詢選修課程有不及格的同學的學號及平均成績(四捨五入至整數)
--來源TABLE =  STUDENT
--顯示欄位 [sno] [avg]

select sno,round(AVG(score)) as avg from sc 
    -> where  sno in(
    -> select sno 
    -> from sc where score<60)
    -> group by sno;





--5.請查詢選修三門課程以上的學生學號
--來源TABLE =  SC
--顯示欄位 [NO] [CNT]

select sno as no,count(cno) as cnt from sc 
    -> group by sno
    -> having count(cno)>=3;



--6.請先計算學生年齡並依照各年齡統計學生數量(注：Student.SBDAY的類型是DATE)
--來源TABLE =  STUDENT
--顯示欄位 [AGE] [CNT]


SELECT TIMESTAMPDIFF(YEAR, SBDAY, CURDATE()) AS AGE, COUNT(*) AS CNT
    -> FROM STUDENT
    -> GROUP BY AGE;


--7.查詢沒學過“ORACLE”的同學的學號、姓名；
--來源TABLE =  STUDENT, TEACHER, COURSE, SC
--顯示欄位 [NO] [NAME]
SELECT sno, sname
FROM STUDENT as s
WHERE s.SNO NOT IN (
  SELECT sc.SNO
  	FROM SC as sc
  	JOIN COURSE as c ON sc.CNO = c.CNO
  	JOIN TEACHER as t ON c.TNO = t.TNO
  	WHERE c.CNAME = 'ORACLE'
);
	
--8.查詢所有課程成績在60分以下的學生姓名、課程名稱和分數；
--來源TABLE =  STUDENT, SC, COURSE
--顯示欄位 [SNAME] [CNAME] [SCORE]
select st.sname,c.cname,s.score
	from STUDENT as st,COURSE as c ,SC as s
	where s.SNO = st.SNO
	and s.CNO = c.CNO
	and s.SCORE < 60;

--9.查詢所有學生的選課數並使用選課數排序(由大至小)；
--來源TABLE =  STUDENT, SC
--顯示欄位 [NO] [NAME] [CNT]
select st.SNO as NO ,st.SNAME as NAME,COUNT(SC.CNO) as CNT
	from  STUDENT as st
	left join SC on st.SNO = SC.SNO
	group by st.SNO,st.SNAME
	order by CNT DESC


--10.查詢選修“陳菁菁”老師所授課程的學生中，各科成績最高的課程名稱，學生姓名及其成績
--來源TABLE =  STUDENT, TEACHER, COURSE, SC
--顯示欄位 [CNAME] [SNAME] [SCORE]
select c.CNAME as CNAME ,s.SNAME as SNAME ,MAX(SC.SCORE) as SCORE
	from STUDENT as s
	inner join SC on s.SNO = sc.SNO
	inner join COURSE as c on  SC.CNO = c.CNO
	inner join TEACHER as t on  c.TNO = t.TNO
	where t.TNAME = '陳菁菁'
	group by c.CNAME,s.SNAME


	
--11.查詢各科成績最高和最低的分：以如下形式顯示：課程中文名稱，最高分，最低分
--來源TABLE =  COURSE，SC
--顯示欄位 [NAME] [MAX_SCORE] [MIN_SCORE]
select c.CNAME as NAME,MAX(SC.SCORE) as MAX_SCORE,MIN(SC.SCORE)as MIN_SCORE
	from SC
	inner join COURSE as c on SC.CNO =c.CNO
	group by c.CNAME

--12.查詢學過C001(JAVA WEB)並且學過C004(JAVA SCRIPT)課程的同學學號、姓名；
--來源TABLE =  STUDENT，SC
--顯示欄位 [NO] [NAME]
select s.SNO as NO,s.SNAME as NAME
	from STUDENT as s
	inner join SC as SC1 on s.SNO = SC1.SNO AND SC1.CNO ='C001'
	inner join SC as SC2 on s.SNO = SC2.SNO AND SC2.CNO ='C004'


--13.統計各科成績,各分數段人數:課程ID,課程名稱,[100-85],[85-70],[70-60],[ <60]
--來源TABLE =  SC, COURSE
--顯示欄位 [CNO] [CNAME] [100-85] [85-70] [70-60] [<60]
SELECT
	SC.CNO as CNO,
	c.CNAME as CNAME,
	COUNT(CASE WHEN SC.SCORE>=85 AND SC.SCORE<=100 THEN 1 END) as '100-85',
	COUNT(CASE WHEN SC.SCORE>=70 AND SC.SCORE<85 THEN 1 END) as '85-70',
	COUNT(CASE WHEN SC.SCORE>=60 AND SC.SCORE<70 THEN 1 END) as '70-60',
	COUNT(CASE WHEN SC.SCORE<60 THEN 1 END) as '60'
	from SC
	join COURSE as c  on SC.CNO  = c.CNO
	group by SC.CNO,c.CNAME

--14.請查詢所有老師所教課程的平均分(請四捨五入至整數)，並排序從高到低顯示
--來源TABLE =  TEACHER, COURSE, SC
--顯示欄位 [CNAME] [TNAME] [AVG]
SELECT c.CNAME as CNAME ,t.TNAME as TNAME ,round(AVG(SC.SCORE)) as AVG
	from COURSE as c 
	join SC on c.CNO = SC.CNO
	join TEACHER as t on c.TNO = t.TNO
	GROUP BY t.TNAME, c.CNAME
	order by AVG DESC

--15.請查詢平均成績大於70分的同學姓名和平均成績
--來源TABLE =  STUDENT，SC
--顯示欄位 [NAME] [SCORE]

SELECT s.SNAME as Name ,Round(AVG(SC.SCORE)) as SCORE
	From STUDENT as s 
	left join SC on s.SNO = SC.SNO
	group by s.SNAME 
	having (AVG(SC.SCORE))>70

