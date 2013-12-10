CWAC AndDown: Markdown. Android. Perfect Together.
==================================================

**Work on this project has been suspended, partly because sundown is fading away, and partly because
[Bypass](https://github.com/Uncodin/bypass/blob/master/platform/android/README.md)
is probably a superior solution at the present time.**

Markdown is a popular markup language for wikitext and the like.
While there are Java-based Markdown processors available, these are
likely to be slow on Android, where they run at all.

This project offers an Android-compliant wrapper around [sundown](https://github.com/tanoku/sundown),
a C-based Markdown parser and HTML generator. By using the NDK with this
C library, parsing speeds are nice and fast -- 5K of input can be
converted into HTML in about 1 millisecond. Also, sundown is a fairly
popular Markdown processor and is the brains behind GitHub-flavored Markdown.

Installation
------------
Option #1: Clone the repository and add it as an Android library project to your
application. You will also need to install the NDK and run `ndk-build`
from the project root directory, in order to build the `.so` file.

Option #2: UnZIP [the ZIP file](https://github.com/commonsguy/downloads) into
the `libs/` directory of your project. This only works for ARM and x86 targets, and
this has been *very* lightly tested.

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

Also, while sundown is very fast, using the resulting HTML will inevitably
be slower. The same 5K sample file that sundown processes in about 1
millisecond takes a few hundred milliseconds to convert into a `SpannedString`
via `Html.fromHtml()`.

The author of this project is a complete klutz when it comes to C/JNI/NDK
development. You have been warned.

Dependencies
------------
This project has no dependencies. This repository includes a copy of the
relevant files from the sundown project.

This project should work on API Level 7 and higher &mdash; please report
bugs if you find otherwise.

Version
-------
This is version v0.1 of this module, which means it is really new. Moreover,
it is the first CWAC project incorporating the NDK, so there may be new
and exiciting issues as a result.

Demo
----
In the `demo/` sub-project you will find
a sample activity that demonstrates the use of `AndDown`, loading the
sundown README out of a raw resource and displaying it in a `TextView`
wrapped in a `ScrollView`.

Future
------
Future editions of this project will add things like:

 - a custom sundown renderer that generates a `SpannedString` directly, bypassing HTML
 - code to convert a `SpannedString` back into Markdown source

License
-------
The code in this project is licensed under the Apache
Software License 2.0, per the terms of the included LICENSE
file.

The sundown source code is available under [its own license](https://github.com/tanoku/sundown),
which appears to be a modified BSD license.

Questions
---------
If you have questions regarding the use of this code, please post a question
on [StackOverflow](http://stackoverflow.com/questions/ask) tagged with `commonsware` and `android`. Be sure to indicate
what CWAC module you are having issues with, and be sure to include source code 
and stack traces if you are encountering crashes.

If you have encountered what is clearly a bug, please post an [issue](https://github.com/commonsguy/cwac-anddown/issues). Be certain to include complete steps
for reproducing the issue.

Do not ask for help via Twitter.

Release Notes
-------------
v0.1.1: added `Application.mk` to support both x86 and ARM
v0.1.0: initial release

Who Made This?
--------------
<a href="http://commonsware.com">![CommonsWare](http://commonsware.com/images/logo.png)</a>

