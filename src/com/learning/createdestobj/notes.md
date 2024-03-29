###Creating and Destroying Objects -

***

####Item 1 - Create static factory method instead of constructors.
   * it can be provided in addition to or instead of providing public constructors.
   * one advantage of SFM is they have name unlike constructors to better describe type of object being returned.
   * second advantage of SFM is they are not required to create a new object each time they are invoked.
   (allows immutable classes to use pre-constructed object, cache instances as they are created , also a performance improvement
   if objects are costly to create)
     * this second adv also allows us to control what instance of a class exists at any point of time(instance-controlled classes)
       * instance-controlled classes allows to guarantee it is singleton or noninstantiable.
       * it allows an immutable value class, to guarantee that no 2 instances equal instance of a class exists i.e.
       if a.equals(b) if and only if a == b.
   * third adv is unlike constructors they can return object of any subtype of their return type.
     * this can help in making compact API where implementation classes are not public and hidden and their object is returned 
     as a part of SFM where return type is a parent type(mostly interface)'
     * this technique lends itself to interface-based frameworks, where interface
     provides a natural return type for SFM.
   * fourth adv is different object can be returned based on input. e.g. EnumSet internally uses RegularEnumSet of JumboEnumSet based on size and it does not effect user if a impl is removed or added to this in future.
   * fifth adv is the class of the returned type(impl) need not exist when the class containing 
   the method is created. (such flexible SFM forms the basis of service provider framework like JDBC API)
     * service interface - which represents an impl - Connection class
     * registration api - which providers use to register impl - DriverManager.registerDriver
     * service access api - which allows clients to specify criteria to choose impl. - DriverManager.getConnection
     * service provider interface(optional) - provides factory object that provides instances of service interfaces. - Driver class
     * bridge pattern and dependency injection pattern framework can be viewed as powerful service providers.
     * since Java6 it includes a general purpose service provider framework "*java.util.ServiceLoader*"
     
   * the main limitation of SFM is classes without public or protected method constructor cannot be 
   subclassed. e.g. subclassing Collection framework convenience classes.
     * it can be considered as an advtg since it encourages composition over inheritence.
     * is required for immutable types.

   * ***Summary - static factories are preferable most of the times now, so avoid reflex to provide public constructors
    without considering static factories first***
    
    
***

####Item 2 - Consider builder when faced with many constructor params.

  * static factory and constructors share a limitation that they do not scale well to large number of optional params.
  * the telescoping constructor pattern works in this case but it is 
  hard to write client code when there are too many params and even harder to read it.
  * second option in case when faced with too many params is Java Beans pattern. in which first a no arg
  constructor is called and then setter is called for required field or optional params of interest.
    * this pattern has a disadvantage though, since the construction is split over multiple calls
    of setter methods , a JavaBean might be in inconsistent state partway through its construction.
    * this pattern precludes the possibility of making a class immutable , hence programmer has
    to take extra care to ensure thread safety in code.
  * in builder all fields of built class are final to make class immutable.
  also the setter methods of Builder return builder to allow chaining in invokation for fluent API.
  (***this makes client code easy to read and write , it also simulates named Optional params like found
  in Python and Scala***)
  * Builder pattern is well suited to class hierarchy i.e. abstract classes have 
  abstract builders , concrete class have concrete builders.
  * Builder have a slight advantage over constructor that it can have multiple var args since each var arg is 
  related to its own method. also the same builder can be used to create multiple objects and the builder can
  be tweaked before calling build method.
  * DisAdv of builder is inorder to create object you must first create its builder (which can be sometimes costly as well
  and impact performance.)
  * ***Summary - better to use Builder pattern when class constructor or static factories has more than handful of 
  of params, specially many optional or identical params. Client code is easy to read and write then Telescoping or JavaBeans***



***

####Item 3 - Enforce Singleton property with private constructor or an Enum type.

  * Singleton is a simple class that can be instantiated only once.
  * Singletons typically represent a stateless object (such as func or system component which is unique intrinsically ).
  * they can be created 3 ways and each requires a private constructor and a static field to store the instance.
  * using public static field, using static factory method, using single field Enum(most preferred approach)
  * with the first 2 approach a privileged client can invoke private constructor reflectively ( **with the help of 
  AccessibleObject.setAccessible** ) , a exception can also be thrown if asked against second construction.
  * the Enum approach is best as it provides the serialization machinery for free (while the other 2 approaches need
  to make this sure by making all fields transient and implementing readResolve method to return the only valid instance.)
  * Enum approach cannot be used if singleton must extend a superclass other than Enum though it can be used if Enum has to 
  implement an interface.
 
 

***

####Item 4 - Enforce Noninstantiability with a private constructor (static utility class) 

  * for classes that contains group of static fields and static methods as in java.util.Collections (now since Java8 these
  can also be put in interface.)
  * this Noninstantiability can be achieved by making constructors private.

  

***
 
####Item 5 - Prefer dependency injection to hardwiring resources.

  * many classes depends on underlying resources and though people sometimes put those dependencies to a static utility
  class or Singleton but these are not appropriate use of those classes.
  * these approaches are not worth using because they assume there is only one impl of that type. (like dictionary but that is not 
  the case for e.g. there can be different dictionary for different languages. ) 
  * even testing these approaches which a special kind of impl(special dictionary ) would not be possible.
  * ***Static utility classes and singletons are inappropriate for classes whose behaviour is parameterized/(gets effected by 
  underlying resources) on an underlying resource***.
  * DI can be achieved by passing the resources to the constructor while creating new instance.(hence multiple instances
  of class is supported based on whichever instance is passed to the constructor)
  * another variation is to pass a resource factory to a constructor , static factory or a builder. Supplier<T> is 
  perfect for representing factories. 
  * DI greatly improves flexibility and testability, it can clutter up large project with 1000's of dependency
  but in those case dependency frameworks like spring, dagger or juice can be used.
  * ***Summary -  do not use a singleton or static utility class to implement a class that depends on one or more underlying
   resources whose behavior affects that of the class, and do not have the class create these resources directly 
   (Instead, pass the resources, or factories to create them, into the constructor (or static factory or builder))***
   

***

####Item 6 - Avoid creating unnecessary objects.

  * it is often appropriate to reuse object rather than creating new one which is functionally equivalent(always reuse is faster).
  but can be reused only if it is not immutable.
  * unnecessary object creation can be avoided using static factory method over constructor on immutable classes.
  * some object creation is much more expensive than others (so advisable to cache those). e.g. string.matches creates
  Pattern object each time and after completion that object is ready for GC and creation of Pattern is expensive as it needs
  to compile the regex (hence not recommended for repeated use in performance-critical situations).
  ***to improve performance Pattern could be explicitly compiled as a immutable static field, and then used later*** 
  * Another way to create unnecessary objects is autoboxing. though primitives and their boxed types have subtle symentic difference
  but it is not so subtle performance difference.
  * prefer Primitives to boxed Primitives and watch out for unintentional boxing.
  * ***Summary - don't create a new object when you should reuse a existing one, later Ite, 50 gives a counterpoint to this
  on defensive copying.***



***


#### Item 7 - Eliminate obsolete object references.

* 


***


#### Item 8 - Avoid finalizers and cleaners.

* 


***


#### Item 9 - Prefer try-with-resources over try-finally.

* 