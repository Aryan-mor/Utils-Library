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

# Example
چند نمونه از فانکشن های این کتاب خانه

Intent functions
--------
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
