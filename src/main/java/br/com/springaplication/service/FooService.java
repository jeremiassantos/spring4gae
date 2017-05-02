package br.com.springaplication.service;

import br.com.springaplication.dao.FooDAO;
import br.com.springaplication.dto.FooDTO;
import br.com.springaplication.entity.Foo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FooService {

	@Autowired
	private FooDAO fooDAO;

	@Autowired
	private ModelMapper modelMapper;

	public FooDTO save (FooDTO fooDTO) {
		Foo foo = modelMapper.map(fooDTO, Foo.class);
		foo = this.fooDAO.save(foo);
		return modelMapper.map(foo, FooDTO.class);
	}

	public FooDTO findById(Long id) {
		return modelMapper.map(this.fooDAO.findById(id), FooDTO.class);
	}

	public void deleteById(Long id) {
		this.fooDAO.delete(id);
	}

	public List<FooDTO> findAll() {
		List<FooDTO> fooList = new ArrayList<>();

		for(Foo foo : this.fooDAO.findAll()) {
			fooList.add(modelMapper.map(foo, FooDTO.class));
		}

		return fooList;
	}
}
