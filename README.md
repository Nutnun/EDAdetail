# EDA (Emergency Disaster Alert)

## สิ่งที่จำเป็นในการ Run Project
1. Tomcat
2. Maven

# รายละเอียดฐานข้อมูล
 - Database Name : emergencyeda
 - ชุดคำสั่ง SQL อยู่ในไฟล์ชื่อ table.sql
 
# สิ่งที่ต้องทำก่อนการ deploy
หลังจากที่ clone ตัวโปรเจคลงมาแล้ว ให้เปิด bash และเข้าไปที่ directory ของโปรเจค โดยใช้คำสั่ง
```bash
cd ./src/main/resources
```

และใช้คำสั่ง
```bash
cp config.properties
```

สร้างไฟล์ชื่อ config.properties โดยกำหนด PATH ดังนี้ ..\src\main\resources
```bash
DB_IP=localhost
DB_PORT=3306
DB_NAME=emergencyeda
DB_USERNAME=
DB_PASSWORD=
```

กลับมาที่ directory ของโปรเจคโดยใช้คำสั่ง
```bash
cd ../../..
```

# Deploy ตัว Tomcat ผ่าน MVN
ทำการติดตั้ง dependency ของตัวโปรเจคโดยใช้คำสั่ง
```bash
mvn install
```

และสามารถเข้าไปแก้ไข Config ได้ ผ่านคำสั่ง
```bash
.
.
<configuration>
  <url>http://127.0.0.1:8080/manager/text</url>
  <server>TomcatServer</server>
  <path>/${project.artifactId}</path>
</configuration>
.
.
```

ไปที่ PATH คือ ${MAVEN_HOME}/conf และเปิดไฟล์ settings.xml 
และทำการเพิ่ม tag server ลงไป ด้วยคำสั่งดังนี้
```bash
 <server>
 .
 .
   <server>
      <id>TomcatServer</id>
      <username>admin</username>      \\username ที่ใช้ login tomcat
      <password>password</password>   \\password ที่ใช้ login tomcat
   </server>
</server>
```
