### Methods common to all Objects - 

***

#### Item 10 - Obey the general contract when overriding EQUALS - 
  * there is no need to override equals method if one of the below conditions is true -
    * each instance of class is inherently unique. e.g. Thread object that represent active entities rather 
    than values(it would be hard to compare Thread objects hence the default impl is good enough)
    * there is no need for the class to provide "logical equality" test.
    * a superclass already has overridden equals and the superclass behavior is appropriate for this class.
    e.g  Set impl inherit equals behavior from AbstractSet, List from AbstractList etc..
    * a class is private or package-private and we are certain that the equals method will not be invoked.
    in such case something like an AssertionError can be added inside the method, just in case it is invoked using
    reflection.
    
  * equals method are generally overridden in value classes. (a class that represents a value such as integer or String),
  basically this helps us find ***logical equivalency*** of two references pointing to two objects.
  * overriding equals method enables us to use those elements as Map's keys or elements of Set with predictable and 
  desirable behaviour.
  * For instance controlled class (defined in Item 1) it is not required to override equals method, as they ensure
  at most one object exists for a given value. e.g. Enum types fall into this category.
  * Equals method implements equivalence relation i.e. reflexive, symmetric, transitive, consistent and for
  any non-null x , x.equals(null) should be false.
  * To understand Symmetric equivalence check CaseInsensitive class equals method.
  * 