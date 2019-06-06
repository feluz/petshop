package com.petshop.joao.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.petshop.joao.domain.Agendamento;
import com.petshop.joao.domain.dto.AgendamentoDTO;
import com.petshop.joao.domain.services.exceptions.DataIntegrityException;
import com.petshop.joao.domain.services.exceptions.ObjectNotFoundException;
import com.petshop.joao.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repo;
	
	@Autowired
	private ServicoService servicoService;

	public Agendamento find(Integer id) {
		Optional<Agendamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Agendamento.class.getName()));
	}
	
	public Agendamento insert(Agendamento obj) {
		obj.setId(null);
		obj.setServico(servicoService.find(obj.getServico().getId()));
		return repo.save(obj);
	}
	
	public Agendamento update(Agendamento obj) {
		Agendamento newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir esse Agendamento");
		}
	}
	
	public List<Agendamento> findAll() {
		return repo.findAll();
	}
	
	public Page<Agendamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	public Agendamento fromDTO(AgendamentoDTO objDto) {
		return new Agendamento(objDto.getId(), objDto.getNome(), null, null, null, null, null);
	}
	
	
	private void updateData(Agendamento newObj, Agendamento obj) {
		newObj.setNomedodono(obj.getNomedodono());
		newObj.setTelefone(obj.getTelefone());
		newObj.setEmail(obj.getEmail());
		newObj.setData(obj.getData());
		newObj.setHora(obj.getHora());
		newObj.setServico(servicoService.find(obj.getServico().getId()));
	}
}
