package com.petshop.joao.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.petshop.joao.domain.Servico;
import com.petshop.joao.domain.dto.ServicoDTO;
import com.petshop.joao.domain.services.exceptions.DataIntegrityException;
import com.petshop.joao.domain.services.exceptions.ObjectNotFoundException;
import com.petshop.joao.repositories.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
	}
	
	public Servico insert(Servico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Servico update(Servico obj) {
		Servico newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma serviço que possui agendamentos.");
		}
	}
	
	public List<Servico> findAll() {
		return repo.findAll();
	}
	
	public Page<Servico> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	public Servico fromDTO(ServicoDTO objDto) {
		return new Servico(objDto.getId(), objDto.getNome(), null, null);
	}
	
	
	private void updateData(Servico newObj, Servico obj) {
		newObj.setNomedoservico(obj.getNomedoservico());
		newObj.setDescricao(obj.getDescricao());
		newObj.setValor(obj.getValor());
	}
}
