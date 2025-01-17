package io.github.malldonado.arquiteturaspring;

import io.github.malldonado.arquiteturaspring.todos.AppProperties;
import io.github.malldonado.arquiteturaspring.todos.TodoEntity;
import io.github.malldonado.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy(false)
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope("singleton")
//@Scope("request")
//@Scope("session")
//@Scope("application")
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;

    //mais comum de ser usar
    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    //menos comum de usar essa injecao de dependencias
    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
