@echo off

cd basketballClubs
call mvnw.cmd clean verify
cd ..
cd basketballPlayers
call mvnw.cmd clean verify
cd ..
cd gateway
call mvnw.cmd clean verify
cd ..