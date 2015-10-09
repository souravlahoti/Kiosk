# Kiosk

Android app that can be used on kiosk desk to take name, email address and feedback from the attendees of an event to keep them updated for future events.

Uses Sqlite to store data of the attendees.

## Access sqlite database from non rooted android device

Goto Terminal and type the following command

`adb shell` <br>
`run-as packagename`<br>
`chmod 666 databases\databasename`<br>
`exit`<br>
`cp \data\data\packagename\databases\databasename \sdcard\`<br>
`run-as packagename`<br>
`chmod 600 databases\databasename`<br>
`exit`<br>
`exit`<br>
`adb pull sdcard\databasename`<br>


Use sqlitebrowser to open the database.sqlite file



