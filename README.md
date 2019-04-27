Santoryu
=======

Features
--------

- Animated screen saver image views ( Released :heavy_check_mark: :rocket: )
- News feed stories image views  ( Baking :cookie:  :hourglass: )
- Creating custom GIF with set of images ( Baking :cookie:  :hourglass: )
- **Based on Android Scaling Animation and Animation Drawables**


Uses
----
- Home page banners
- Login screen animated backgrounds
- News feed or stories view


How to use
----------

- First add this line to your app gradle file

```groovy
implementation 'com.github.Ahmednagyyy:Santoryu:1.0.0'
```
- Don't forget to add this in your root build.gradle at the end of repositories:

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
---

Implementation
----
```xml
    <com.extremesolution.santoryu.ScreenSaver
            android:id="@+id/screen_saver"
            android:layout_height="<HEIGHT>"
            android:layout_width="<WIDTH>"
    />
```
For single image screen saver
=
```kotlin
     // Setting the screen saver with bitmap
     screen_saver.setSingleImage(bitmap)

     // Setting the screen saver with drawable
     screen_saver.setSingleImage(R.drawable.image)
	 
```

For multiple images screen saver
----
```kotlin
	// Setting the screen saver images
        val arrayImage = ArrayList<Int>() //or <Bitmap>
        arrayImage.add(R.drawable.image1)
        arrayImage.add(R.drawable.image2)
        arrayImage.add(R.drawable.image3)
		
	// Use default duration between images transition
        screen_saver.setMultiDrawables(arrayImage)
	// Use custom duration ( in seconds ) between images transition
        screen_saver.setMultiDrawables(arrayImage, 10)
```

For Animation config
----
```kotlin
	 // Use animation resource ( scaling animation )
	 screen_saver.startScreenSaver(R.anim.animation)
	 
	 // Use library default animation
	 screen_saver.startScreenSaver()
	 
	 // To control the animation programaticlly
	 // PARAM:  seconds "Duration", fromX, fromY, toX, toY, pivotX, pivotY, repeat, and reversed
     	 screen_saver.startScreenSaver(16, 1.0F, 1.0F, 1.5F, 1.5F, 0.5F, 0.5F, 10, true)
	 
	 // Use same method without repeat param for INFINITE count
	 screen_saver.startScreenSaver(10, 1.0F, 1.0F, 1.5F, 1.5F, 0.5F, 0.5F, true)
	 
	 // Use same method with default duration
	 screen_saver.startScreenSaver(1.0F, 1.0F, 1.5F, 1.5F, 0.5F, 0.5F, true)
```

---
** Still had alot of work to do with Santoryu**

> "You need to accept the fact that you're not the best and have all the will to strive to be better than anyone you face."

> ~ Zoro Senpai ~

![](https://imgix.ranker.com/user_node_img/50081/1001615815/original/even-one-step-back-photo-u2?w=250&q=50&fm=pjpg&fit=crop&crop=faces)

