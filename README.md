# README

## Object Mapper

Proof of concept to get the default objectMapper from springboot context.

Interesting if you define an ObjectMapper bean, it will be substituted by the default 
ObjectMappers out of the box from springboot.

If an ObjectMapper is defined in the spring context, then you will need to get the default 
instance byinjecting the Jackson2ObjectMapperBuilder.

```java

@Configuration
public class ObjectMapperConfig {
 
    @Autowired
    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    public ObjectMapper objectMapper() {
        return jackson2ObjectMapperBuilder.build();
    }

}
```


