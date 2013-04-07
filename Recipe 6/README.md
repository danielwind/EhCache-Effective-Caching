####EhCache Effective Caching: How-To
##Recipe 6 (Cache Search API)

In this recipe you will be shown how the Cache Search API works through a simple cache search query implementation. EhCache search API allows us to query and search for elements being cached. We start by issuing simple queries and then increase complexity by relaxing query criteria conditions.

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
3. Name the configuration "Recipe 6"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe6}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe6_eclipse.png) 