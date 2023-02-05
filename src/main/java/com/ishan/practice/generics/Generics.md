The term generics means parameterized types. Parameterized types are important
because they enable you to create classes, interfaces, and methods in which the type of data
upon which they operate is specified as a parameter

It is important to understand that Java has always given you the ability to create
generalized classes, interfaces, and methods by operating through references of type
Object. Because Object is the superclass of all other classes, an Object reference can refer
to any type object. Thus, in pre-generics code, generalized classes, interfaces, and methods
used Object references to operate

**Type argument cannot be of primitive type**

The generics syntax shown in the preceding examples can be generalized. Here is the
syntax for declaring a generic class:
class class-name<type-param-list > { // …
Here is the full syntax for declaring a reference to a generic class and instance creation:
class-name<type-arg-list > var-name =
new class-name<type-arg-list >(cons-arg-list);

When specifying a type parameter,
you can create an upper bound that declares the superclass from which all type arguments
must be derived. This is accomplished through the use of an extends clause when specifying
the type parameter, as shown here:
<T extends superclass>

In addition to using a class type as a bound, you can also use an interface type. In fact,
you can specify multiple interfaces as bounds. Furthermore, a bound can include both a
class type and one or more interfaces.

class Gen<T extends MyClass & MyInterface> { // ...
Here, T is bounded by a class called MyClass and an interface called MyInterface. Thus,
any type argument passed to T must be a subclass of MyClass and implement MyInterface.

static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {