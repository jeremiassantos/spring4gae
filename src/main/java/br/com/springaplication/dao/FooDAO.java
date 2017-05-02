package br.com.springaplication.dao;

import br.com.springaplication.entity.Foo;
import org.springframework.stereotype.Component;

@Component
public class FooDAO extends GenericDAO<Foo, Long> {

	public FooDAO() {
		super(Foo.class);
	}
}
