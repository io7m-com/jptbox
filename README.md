jptbox
===

[![Maven Central](https://img.shields.io/maven-central/v/com.io7m.jptbox/com.io7m.jptbox.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.io7m.jptbox%22)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/com.io7m.jptbox/com.io7m.jptbox?server=https%3A%2F%2Fs01.oss.sonatype.org&style=flat-square)](https://s01.oss.sonatype.org/content/repositories/snapshots/com/io7m/jptbox/)
[![Codecov](https://img.shields.io/codecov/c/github/io7m-com/jptbox.svg?style=flat-square)](https://codecov.io/gh/io7m-com/jptbox)

![com.io7m.jptbox](./src/site/resources/jptbox.jpg?raw=true)

| JVM | Platform | Status |
|-----|----------|--------|
| OpenJDK (Temurin) Current | Linux | [![Build (OpenJDK (Temurin) Current, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/jptbox/main.linux.temurin.current.yml)](https://www.github.com/io7m-com/jptbox/actions?query=workflow%3Amain.linux.temurin.current)|
| OpenJDK (Temurin) LTS | Linux | [![Build (OpenJDK (Temurin) LTS, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/jptbox/main.linux.temurin.lts.yml)](https://www.github.com/io7m-com/jptbox/actions?query=workflow%3Amain.linux.temurin.lts)|
| OpenJDK (Temurin) Current | Windows | [![Build (OpenJDK (Temurin) Current, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/jptbox/main.windows.temurin.current.yml)](https://www.github.com/io7m-com/jptbox/actions?query=workflow%3Amain.windows.temurin.current)|
| OpenJDK (Temurin) LTS | Windows | [![Build (OpenJDK (Temurin) LTS, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/jptbox/main.windows.temurin.lts.yml)](https://www.github.com/io7m-com/jptbox/actions?query=workflow%3Amain.windows.temurin.lts)|

## jptbox

Java functions to draw Unicode boxes.

## Features

* Functions for drawing boxes.
* High coverage test suite.
* [OSGi-ready](https://www.osgi.org/)
* [JPMS-ready](https://en.wikipedia.org/wiki/Java_Platform_Module_System)
* ISC license.

## Usage

Create a text image to act as a canvas, and then draw boxes into it:

```
final JPTextImageType image =
  JPTextImage.create(80, 10);
final JPTextBoxDrawingType draw =
  JPTextBoxDrawing.get();

draw.drawBox(image, 0, 0, 30, 3);
draw.drawBox(image, 29, 0, 10, 3);
draw.drawBox(image, 38, 0, 10, 3);

draw.drawBox(image, 0, 2, 30, 3);
draw.drawBox(image, 29, 2, 10, 3);
draw.drawBox(image, 38, 2, 10, 3);

System.out.println(JPTextImages.show(image));
```

```
┌────────────────────────────┬────────┬────────┐
│                            │        │        │
├────────────────────────────┼────────┼────────┤
│                            │        │        │
└────────────────────────────┴────────┴────────┘
```

