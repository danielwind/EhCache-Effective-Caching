####EhCache Effective Caching: How-To
##Recipe 1 (Configuration Patterns)

In this recipe you will be shown how to configure EhCache within your application. Commonly there are two ways of proceeding with the actual configuration:

- Programmatically (Custom Class)
- Declaratively (XML)

Our simple java application will load the typical declarative configuration through ehcache.xml (resources folder). Our custom cache class, named CacheDelegate, also shows how to configure the application and EhCache in a programatically way. See [CacheDelegate#programmaticConfiguration](https://github.com/danielwind/EhCache-Effective-Caching/tree/master/Recipe%201/src/main/java/net/danielwind/effcaching/recipe1/cache/CacheDelegate/#L9)

#####Errata: [http://www.danielwind.net](http://www.danielwind.net/effcaching/errata)



