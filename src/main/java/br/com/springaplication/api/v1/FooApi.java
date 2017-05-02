package br.com.springaplication.api.v1;

import br.com.springaplication.dto.FooDTO;
import br.com.springaplication.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.WebServiceException;
import java.util.List;

@RestController
@RequestMapping("/foo")
public class FooApi {

	@Autowired
	private FooService fooService;

	@RequestMapping(method = RequestMethod.POST)
	public FooDTO save(@RequestBody @Valid FooDTO fooDTO) {
		return this.fooService.save(fooDTO);
	}

	@RequestMapping(method = RequestMethod.GET, value = "findById")
	public FooDTO findById(@RequestParam("id") Long id) {
		return this.fooService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<FooDTO> findAll() {
		return this.fooService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "deleteById/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		this.fooService.deleteById(id);
	}
}
