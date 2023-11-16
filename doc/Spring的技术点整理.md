## Spring的BeanUtils.copyProperties()
1. 不声明属性的get、set方法，属性将copy失败
2. copy为浅拷贝（拷贝对象的引用）
3. Spring不同版本对属性泛型处理方式不同
4. Spring5.3之后，匹配源对象和目标对象中的属性时遵循泛型类型信息，意思是copy属性时，会判断属性的泛型是否一致，如不一致，直接忽略属性的拷贝。
5. TargetBean拷贝的成员属性实际类型可能跟声明不一致
   
### BeanUtils.copyProperties()更适合简单Bean之间拷贝，如果Bean属性复杂，很容易因为浅拷贝导致一系列的问题。而且copyProperties方法实现过程并不简单，相对于直接用get和set方法赋值，其性能开销更大。
