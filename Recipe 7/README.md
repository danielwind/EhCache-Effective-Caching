####EhCache Effective Caching: How-To
##Recipe 7 (Custom Eviction Algorithm)

In this recipe you will be shown how to create and implement an EhCache custom eviction algorithm. Eviction algorithms are used to determine when to evict (or simply "eject") an element from the Cache Layer. There are built-in algorithms already in EhCache that you can certainly reuse, namely:

- LRU (Least Recently Used, this is the default)
- LFU (Least Frequently Used)
- FIFO (First In First Out)

However, you can create your custom eviction policy by inheriting simple EhCache Abstraction classes. In our case, we will be creating our own policy for evicting elements.

######Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)


Build Dependencies
-------

| Requirement      |  Version   |
|------------------|:----------:|
|  Apache Maven    |    3.x     |
|  Java JDK        |    >= 6    |
|  Eclipse         | >= Helios  |


Building The Recipe
-------
```
1. Import the project [File -> Import -> Maven -> Existing Maven Projects]
2. Create a run configuration [Run -> Run Configurations… -> Maven Build -> New]
3. Name the configuration "Recipe 7"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe7}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe7_eclipse.png) 