#Chapter 3
##EhCache Spring Integration

author: <daniel.wind.m@gmail.com>

EhCache-Effective-Caching Book Source Code

In this chapter we will cover the following topics:

* Including EhCache in a Spring-based Project
* Declarative Configuration through XML
* Programmatic Configuration through CacheConfiguration Class

We will examine how to configure EhCache in a simple Spring-Based project. Our aim with example is to prevent database hits if they already exist.

---
If you do not want to use Maven (or your project simply does not require it), EhCache library can be obtained directly from their official website http://ehcache.org/downloads/catalog, in which you will want to download ehcache-2.6.0-distribution.tar.gz (current version as of this writing). You can also see the additional modules section which we will be visiting frequently as you progress in this book. 