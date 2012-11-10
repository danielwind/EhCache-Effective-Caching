#Chapter 4
##Fragment Caching (Servlet Filter) 

author: <daniel.wind.m@gmail.com>

In this recipe we cover the following topics:

* What Fragment Caching is and its benefits for web projects.
* How to integrate Fragment Caching using EhCache and Servlet API. 

We will examine how to implement fragment caching by integrating EhCache and the Servlet API. We will cache the header of a web page in order to demonstrate how caching can be achieved for sections of a web page or a full web page if needed.

--
If you do not want to use Maven (or your project simply does not require it), EhCache library can be obtained directly from their official website http://ehcache.org/downloads/catalog, in which you will want to download ehcache-2.6.0-distribution.tar.gz (current version as of this writing). You can also see the additional modules section which we will be visiting frequently as you progress in this book.