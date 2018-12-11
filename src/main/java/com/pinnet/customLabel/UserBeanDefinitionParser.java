package com.pinnet.customLabel;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");
        BeanDefinitionRegistry registry = parserContext.getRegistry();
        BeanDefinition beanDefinition = null;
        try {
            beanDefinition = new RootBeanDefinition(User.class);
            beanDefinition.getPropertyValues().add("id", id);
            beanDefinition.getPropertyValues().add("name", name);
            beanDefinition.getPropertyValues().add("age", age);
            registry.registerBeanDefinition(id, beanDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beanDefinition;
    }
}
