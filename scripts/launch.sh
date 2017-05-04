#!/bin/bash

# Launch ArcticActivity
adb shell 'am start -a android.intent.action.VIEW -d geo:87,65'

# Launch CountCharacterActivity
adb shell 'am start -a android.intent.action.SEND \
  -e android.intent.extra.TEXT "Greetings from ADB" \
  -t "text/plain"'

# Launch CelsiusToFahrenheitActivity
adb shell 'am start -a com.sqisland.intent.incoming.CELSIUS_TO_FAHRENHEIT \
  --ef Celsius 30'