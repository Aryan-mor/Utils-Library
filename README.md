# Utils-Library

Android amazing helper function library<br>
`Works better on kotlin`

Usage
--------
Include the library in your build.gradle

```gradle
//Project
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}

//Module:App
dependencies {
      implementation 'com.github.Aryan-mor:Utils-Library:1.3.9'
}
```

### Index
* [UtilsFucntion](#utilsfunctions)
* [Intent](#intentfunctions)
* [Log](#logfunctions)
* [SharedPreferences](#sharedpreferencesfunctions)
* [Toast](#toastfunctions)
* [SnackBar](#snackbarfunctions)
* [CheckUtils](#checkutilsfunctions)
* [Convertor](#convertorfunctions)
* [DateUtils](#datefunctions)
* [VoiceRecorder](#voicerecorder)
* [DirUtils](#dirfunctions)
* [FileUtils](#filefunctions)
* [Encryption](#encryptionfunctions)
* [Hash](#hashfunctions)

# Example
Some examples of library functions


## UtilsFunctions

You can convert all classes to json like this and hydrate
```ConvetToJson

    val json = Any().toJson()
    //json type is String

    val myObject = json.hydrate(Any::class.java)
    //myObject type is Any

```

Another functions
```AnotherFunction

    //You can close application like this
    activity.closeApp()
    
    //You can restart application like this
    activity.restartApp()
    
    //you can delay application like this 
    actvity.delayOnUiThread(200) // 200 is duration milisecound
    //or run funtion by delay like this
    actvity.delayOnUiThread(200){
        //your code
    }
    
    ***************************************
    
    //Hidden keyboard
    actvity.showSoftKeyboard()
    //or
    actvity.showSoftKeyboard(EditText)
    
    //Show keyboard
    actvity.showSoftKeyboard()
    //or
    actvity.showSoftKeyboard(AnyView)
    
    ***************************************
    
    //You can understand user device size | fucntions return Boolean
    context.isTablet()
    context.isLargeScreen()
    context.isNormalScreen()
    context.isSmallScreen()
    
    ***************************************
    
    //You can understand device is portrait or landscape | fucntions return Boolean
    context.isPortrait()
    context.isLandscape()
    
    ***************************************
    
    //You can vibrate phone if use vibrate permision on your manifest | fucntions return Vibrator?
    activity.vibrate(VibrationEffect)
    //Or 
    activity.vibrate(milliseconds: Long, amplitude: Int)
    
```

## IntentFunctions
```intent

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //Basic usage
        intentTo(AnotherActivity::class)
        //Or
        var intent = makeIntent(AnotherActivity::class)
        
        
        //You can send any params to another activity
        intentTo(AnotherActivity::class,"myParamKey", anyObject)
        
        
        
        //On another activity you can recive object like this
        val myParam = getExtra("myParamKey",AnyObject::class.java)
        
    }

}

```

You can intent to your app package setting like this
```intentToPackageSetting

    context.intentToPackageSetting()
    
```


You can open link like this
```intentToPackageSetting

    context.openLink("http://...")
    
```

## LogFunctions
AnyWhere can use log funtion :relaxed:
```basicLog

    //Basic usage
    log(Any) // log any object
    //or
    Any().logThis()
    //or
    log("log this message")

    //AdvanceTools
    log(Any(),"MyLogFlag",LOG_ERROR_MODE)
    //or
    log(logMessage = Any(),logFlag = "MyLogFlag",logType = LOG_ERROR_MODE)

    //LogType ->
    //LOG_DEBUG_MODE
    //LOG_ERROR_MODE
    //LOG_INFO_MODE
    //LOG_VERBOSE_MODE
    //LOG_WARN_MODE
    //LOG_WTF_MODE

```

You can use 6 type log type :metal:
```logType

   logD("Log Type Debug")
   logE("Log Type Error")
   logI("Log Type Info")
   logV("Log Type Verbose")
   logW("Log Type Warn")
   logWTF("Log Type WTF")

```

You can log ArrayList or Map item
```logMapAndArray

    val map = hashMapOf<String,Any>()
    map["aa"] = "safa"
    map.logThis()
    //or
    map.logThisE()
    //or ....

    //The array is the same

```

## SharedPreferencesFunctions
Source code for Shared Preferences
All items will be first encrypted and then saved into shared preferences,
items will be decrypted upon retrieving
```Pref
    
    context.addPref("key", any)
    
    context.getPref("key", Any:class.java)
    //Or
    getPrefBoolean("key", defultValue)
    getPrefString("key", defultValue)
    getPrefInt("key", defultValue)
    getPrefFloat("key", defultValue)
    getPrefLong("key", defultValue)

```

## ToastFunctions
Toast fuction by context
```toast

    //ToastFucntion | return Toast
    context.toast("myToastMessage").show()
    
    context.toast(R.string.myString).show()
    
    context.longToast("myToastMessage").show()
    
    context.longToast(R.string.myString).show()

```

## HashFunctions
You can make hash of your string using 6 algoritm
```hash

    val s = "MyString"
    logI("toMD5 -> " + s.toMd5())
    logI("toSHA-1 -> " + s.toSHA_1())
    logI("toSHA-224 -> " + s.toSHA_224())
    logI("toSHA-256 -> " + s.toSHA_256())
    logI("toSHA-384 -> " + s.toSHA_384())
    logI("toSHA-512 -> " + s.toSHA_512())
        
```

