**Creating and Destroying Objects -**

***

***Item 1 - Create static factory method instead of constructors.***
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
   * 