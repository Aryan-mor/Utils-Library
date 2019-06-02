# Utils-Library

Android amazing helper fucntion library<br>
`Only work on kotlin`

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
      implementation 'com.github.Aryan-mor:Utils-Library:1.3.7'
}
```

### Index
* [Intent](#intentfunctions)
* [Log](#logfunctions)

# Example
چند نمونه از فانکشن های این کتاب خانه

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

## LogFunctions
**AnyWhere can use log funtion :relaxed:**
```basicLog
class AnyClass{

    fun a(){
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
    
    }

}
```

**You can use 6 type log type :metal:**
```logType
class AnyClass{

    fun a(){
       logD("Log Type Debug")
       logE("Log Type Error")
       logI("Log Type Info")
       logV("Log Type Verbose")
       logW("Log Type Warn")
       logWTF("Log Type WTF")
    }

}
```

You can log ArrayList or Map item
```logType
class AnyClass{

    fun a(){
        val map = hashMapOf<String,Any>()
        map["aa"] = "safa"
        map.logThis()
        //or
        map.logThisE()
        //or ....
        
        
        //The array is the same
    }

}
```
