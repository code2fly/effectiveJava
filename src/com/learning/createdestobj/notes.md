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
  abstract builders , concrete class have concrete builders .