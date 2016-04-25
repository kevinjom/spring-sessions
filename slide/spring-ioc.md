title: Spring IoC Containe
theme: jdan/cleaver-retro
controls: false
style: style.css

--

# Spring IoC Container

--

### What is IoC

--

### Why is it

--

### How (in Spring)

![how](container.jpg)

--

### IoC Containers
#### A colleciton of dependencies
- register dependencies
- dependency injection
- get dependencies

Spring provides

- BeanFactory
- ApplicationContext

--

### Congiuration metadata
#### configuration metadata represents how you as an application developer tell the Spring container to instantiate, configure, and assemble the objects in your application

Spring supports 

- xml
- java configuration

--

###  Instantiating a container

(demo code)

--

### Use beans

(demo code)

--

### BeanFactory or ApplicationContext
#### ApplicationContext *please* 
**ApplicationContext** can do all the things **BeanFactory** does, and also:

- Automatic BeanPostProcessor registration
- Automatic BeanFactoryPostProcessor registration
- Convenient MessageSource access (for i18n)
- ApplicationEvent publication

--


### DefaultListableBeanFactory
Currently,all the internal **ApplicationContext** use **DefaultListableBeanFactory** to as the bean container

--

###  Instantiating a bean
- constructor
- static fm
- instance fm
- FactoryBean

--

### Constructor Injection vs Setter Inection
#### follow Mr Jay, Constructor Injection *please*

(demo code)

--

### Bean Scope
- singleton(default)
- prototype
- request
- session
- global-session

--

### Bean Scope
> You cannot dependency-inject a prototype-scoped bean into your singleton bean, because that injection occurs only once

#### method injection?

--

### Autowire
>The Spring container can autowire relationships between collaborating beans

#### Autowiring modes
- no 
- byType
- byName
- constructor

--

@Autowired

- autowiring by type
- indicate this dependent bean is required
- BeanFactory supports? maybe *NOT*


@Resource - by name

--

### Lifecycle

![lc](lc.jpg)

--

### Lifecycle

- Bean lifecycle callbacks
- Aware interfaces
- Container extension points

--

### Bean lifecycle callbacks
- Init callbacks
- Desctruction callbacks

--

### Init callbacks
- PostConstruct 
- InitializingBean
- custom init method

--

### Desctruction callbacks
- PreDestory 
- DisposableBean
- custom destroy method

--

### Aware interfaces
- ApplicationContextAware
- ServletContextAware

--

### Container extension points
- BeanPostProcessor
- BeanFactoryPostProcessor

--

### BeanPostProcessor
```java
public interface BeanPostProcessor {
Object postProcessBeforeInitialization(Object bean, 
		String beanName);

Object postProcessAfterInitialization(Object bean, 
		String beanName) 
}
```

--

### ApplicationContextAwareProcessor

```java
class ApplicationContextAwareProcessor 
  implements BeanPostProcessor {
public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
		AccessControlContext acc = null;
      //...
			invokeAwareInterfaces(bean);
		//...
	}
	
		private void invokeAwareInterfaces(Object bean) {
		if (bean instanceof Aware) {
			//...
			if (bean instanceof ApplicationContextAware) {
				((ApplicationContextAware) bean)
				.setApplicationContext(this.applicationContext);
			}
		}
	}
```

--

### BeanFactoryPostProcessor
```
public interface BeanFactoryPostProcessor {
void postProcessBeanFactory(ConfigurableListableBeanFactory 
		beanFactory);
}
```


