## @validated和@valid 比较
| 区别      | @valid | @validated |
| ----------- | ----------- | ----------- |
| 提供者      | spring-boot-starter-web 里面，springboot 项目自带 |spring-boot-starter-web 里面，springboot 项目自带 |
| 是否支持分组	   | 不支持	        | 支持，参数校验时，根据不同的分组采取不同的校验 |
| 使用位置	| 构造函数、方法、方法参数、成员属性 | 类、方法、方法参数，不能用于成员属性 |
| 嵌套校验 | 支持，因为可以在成员属性上使用 | 不支持 |

## 集合参数校验
### 方式一 
1. 类上添加@Validated
2. 在请求对象前面添加注解@valid

### 方式二
1. 在请求对象前面添加注解@Validated
2. @valid在成员属性上集合上

## 分组校验
1. 请求对象上使用@Validated({指定group.class})
2. 需要校验的对象属性上指定group.class
