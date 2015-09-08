CWAC AndDown: Markdown. Android. Perfect Together.
==================================================

Markdown is a popular markup language for wikitext and the like.
While there are Java-based Markdown processors available, these are
likely to be slow on Android, where they run at all.

This project offers an Android-compliant wrapper around [hoedown](https://github.com/hoedown/hoedown),
a C-based Markdown parser and HTML generator. By using the NDK with this
C library, parsing speeds are nice and fast -- 5K of input can be
converted into HTML in about 1 millisecond.

If your objective is to put the results of Markdown in a `TextView`, or something
else in Android that understands `Spanned` objects, you are perhaps better served
using [Bypass](https://github.com/Uncodin/bypass/blob/master/platform/android/README.md).
That project goes straight from Markdown to a `Spanned`, bypassing HTML. However,
if you are looking to convert Markdown to HTML to display in a `WebView`, or have
other reasons to, um, bypass Bypass, then AndDown may be of use to you.

Installation
------------
Option #1: Clone the repository and add the `anddown/` subdirectory as an Android library project to your
application. You will also need to install the NDK and run `ndk-build`
from the project root directory, in order to build the `.so` file.

Option #2: Use the AAR artifact for use with Gradle. To use that, add the following
blocks to your `build.gradle` file:

```groovy
repositories {
    maven {
        url "https://s3.amazonaws.com/repo.commonsware.com"
    }
}

dependencies {
    compile 'com.commonsware.cwac:anddown:0.2.+'
}
```

Or, if you cannot use SSL, use `http://repo.commonsware.com` for the repository
URL.

The AAR artifact contains compiled binaries for ARM,
ARM-v7a, x86, x86_64, and ARM64-v8a so you do not need your own copy of the NDK, unless
you need a MIPS edition.

Usage
-----
Create an instance of `com.commonsware.cwac.anddown.AndDown`, then call
`markdownToHtml()` on it, supplying
a `String` containing your Markdown source. This method returns a `String`
containing HTML generated from that source.

And, that's pretty much it, at least at this time.

There is no statefulness in the `AndDown` object. It should be reusable
without having to create a fresh instance each time. It might even
be thread-safe, though this has not been tested.

Limitations
-----------
The Markdown spec says that Markdown converted to HTML should use
`<em>` and `<strong>` tags. On most browsers, those map to italics and
boldface, respectively. However, the `Html.fromHtml()` method in Android
that creates a `SpannedString` from HTML source flips those, so what you
might be used to seeing in boldface turns into italics and vice-versa.
This should only be an issue if you are displaing the Markdown-generated
HTML in a `TextView` &mdash; `WebView` in particular should behave more
normally.

Also, while hoedown is very fast, using the resulting HTML will inevitably
be slower. The same 5K sample file that hoedown processes in about 1
millisecond takes a 100+ milliseconds to convert into a `SpannedString`
via `Html.fromHtml()`.

The author of this project is a complete klutz when it comes to C/JNI/NDK
development. You have been warned.

Dependencies
------------
This project has no dependencies. This repository includes a copy of the
relevant files from the hoedown project.

This project should work on API Level 7 and higher &mdash; please report
bugs if you find otherwise.

Version
-------
This is version v0.2.4 of this module, which means it is...
well... it is what it is.

Demo
----
In the `demo/` sub-project you will find
a sample activity that demonstrates the use of `AndDown`, loading the
hoedown README out of a raw resource and displaying it in a `TextView`
wrapped in a `ScrollView`.

License
-------
The code in this project is licensed under the Apache
Software License 2.0, per the terms of the included LICENSE
file.

The hoedown source code is available under [its own license](https://github.com/hoedown/hoedown/blob/master/LICENSE),
which appears to be a modified BSD license.

Questions
---------
If you have questions regarding the use of this code, please post a question
on [StackOverflow](http://stackoverflow.com/questions/ask) tagged with
`commonsware-cwac` and `android` after [searching to see if there already is an answer](https://stackoverflow.com/search?q=[commonsware-cwac]+anddown). Be sure to indicate
what CWAC module you are having issues with, and be sure to include source code 
and stack traces if you are encountering crashes.

If you have encountered what is clearly a bug, please post an [issue](https://github.com/commonsguy/cwac-anddown/issues). Be certain to include complete steps
for reproducing the issue.

Do not ask for help via Twitter.

Release Notes
-------------
- v0.2.4: added 64-bit x86 and ARM support
- v0.2.3: better `Android.mk`, updated to `hoedown` 3.0.1
- v0.2.2: updated for Android Studio 1.0 and new AAR publishing system
- v0.2.1: updated Gradle, fixed manifest for merging
- v0.2.0: migrated to hoedown and Gradle
- v0.1.1: added `Application.mk` to support both x86 and ARM
- v0.1.0: initial release

Who Made This?
--------------
<a href="http://commonsware.com">![CommonsWare](http://commonsware.com/images/logo.png)</a>

