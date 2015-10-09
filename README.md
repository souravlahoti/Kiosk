# Kiosk

Android app that can be used on kiosk desk to take name, email address and feedback from the attendees of an event to keep them updated for future events.

Uses Sqlite to store data of the attendees.

## Access sqlite database from non rooted android device

Goto Terminal and type the following command

'''
adb shell
run-as packagename
chmod 666 databases\databasename
exit
cp \data\data\packagename\databases\databasename \sdcard\
run-as packagename
chmod 600 databases\databasename
exit
exit
adb pull sdcard\databasename
'''


