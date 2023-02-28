## Docs

```shell
# run
./gradlew bootRun
```

```shell
# build and run
./gradlew build
java -jar build/libs/genesis-0.0.1-SNAPSHOT.jar
```



## Request Params

```java
// Var in URL path
// e.g. /user/123

@RequestMapping("/user/{id}")
public String getUser(@PathVariable String id)
```

```java
// GET, POST or PUT

public String getParam(@RequestParam Map<String, String> map) {}

public String getParam(@RequestParam String name, int age) {}

public String getParam(
        @RequestParam String name,
        int age,
        @RequestParam(name = "email", required = false, defaultValue = "") String email,
        String address
) {}
```

```java
// RAW Request Body
// Request header type
// Content-Type: application/json

public String getParam(@RequestBody UserEntity obj){}

public String getParam(@RequestBody Map<String, String> map){}
```


## Resource
https://www.concretepage.com/spring-boot  
https://start.aliyun.com  
https://start.spring.io  
https://start.springboot.io  


## Demo Project
https://github.com/macrozheng/mall-learning  
https://github.com/macrozheng/mall-tiny  
https://github.com/macrozheng/mall  
https://github.com/lenve/vhr  
https://github.com/halo-dev/halo  
https://github.com/codecentric/spring-boot-admin  
https://gitee.com/52itstyle/spring-boot-seckill  
https://gitee.com/52itstyle/spring-boot-pay  
https://gitee.com/52itstyle/SPTools  
https://gitee.com/JeeHuangBingGui/jeeSpringCloud  
https://gitee.com/xiandafu/springboot-plus  
https://gitee.com/geek_qi/cloud-platform  
https://gitee.com/lab1024/smart-admin  
https://gitee.com/linlinjava/litemall  
https://gitee.com/gz-yami/mall4j  
https://gitee.com/aun/Timo  
https://gitee.com/enilu/web-flash  
https://gitee.com/mumu-osc/NiceFish  
https://gitee.com/jishenghua/JSH_ERP  
https://gitee.com/catshen/zscat_sw  
