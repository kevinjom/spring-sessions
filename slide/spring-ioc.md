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

--

### IoC Containers
#### A colleciton of beans

- BeanFactory
- ApplicationContext

--

### BeanFactory

--

### ApplicationContext

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


