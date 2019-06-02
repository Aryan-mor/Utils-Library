# Utils-Library

Android amazing helper fucntion library<br>
`Only work on kotlin`

Setup
--------
 Use Gradle:

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

Example
--------
Intent functions:
```intent
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        
        intentTo(AnotherActivity::class)
        //Or
        var intent = makeIntent(AnotherActivity::class)
        
        
        //You can send any params to another activity
        intentTo(AnotherActivity::class,"myParamKey",AnyObject)
        
        
        
        //On another activity you can recive object like this
        //if your paramter not int, float,
        
    }

}
```
