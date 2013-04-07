####EhCache Effective Caching: How-To
##Recipe 2 (Listening Events & Exceptions)

In this recipe you are shown how to react to EhCache Events and how to catch generated exceptions. EhCache Event Model is strictly defined and very extensible allowing us to customize and react accordingly. This task is crucial in production environments.

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
2. Create run configuration [Run -> Run Configurations… -> Maven Build -> New]
3. Name the configuration "Recipe 2"
4. Base directory [Browse Workspace… -> Recipe2] ${workspace_loc:/recipe2}
5. Goals: exec:java
6. Click on "Run" 
```

Example
-------
![image](https://raw.github.com/danielwind/resources/master/images/recipe2_eclipse.png)    