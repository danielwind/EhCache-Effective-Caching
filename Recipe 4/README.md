####EhCache Effective Caching: How-To
##Recipe 4 (Web Fragment Caching)

In this recipe you will be shown how web fragment caching works and how EhCache make this task very simple to implement in your own Java web project. EhCache web component provides built-in helpers that can be reused in any typical web application. 

In our case, we will create our own custom filters based on the EhCache built-in caching filters with extended criteria. The purpose of these filters is to show how customizable fragment caching is. This filter will then be integrated in Struts 2 framework application.    

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
3. Name the configuration "Recipe 4"
4. Base directory [Browse Workspace… -> Recipe1] ${workspace_loc:/recipe4}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe4_eclipse.png) 