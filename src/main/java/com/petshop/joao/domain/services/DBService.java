package com.petshop.joao.domain.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petshop.joao.domain.Agendamento;
import com.petshop.joao.domain.Servico;
import com.petshop.joao.domain.Usuario;
import com.petshop.joao.enums.Perfil;
import com.petshop.joao.repositories.AgendamentoRepository;
import com.petshop.joao.repositories.ServicoRepository;
import com.petshop.joao.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		
		Servico serv1 = new Servico(null, "tosa", "Tosar o pet", 50.00);
		Servico serv2 = new Servico(null, "banho", "Banhar o pet", 20.00);
		//Servico serv3 = new Servico(null, "escova", "Escovar o pet", 100.00);

		
		Agendamento agend1 = new Agendamento(null, "Felipe Luz", "15 981101741", "Felipe_Feluz@hotmail.com", sdf1.parse("30/10/2018"), sdf2.parse("10:00"), serv2);
		Agendamento agend2 = new Agendamento(null, "Caio Cezar", "15 545365464", "Caio_Cezar@hotmail.com", sdf1.parse("18/04/2018"), sdf2.parse("12:00"), serv1);
		Agendamento agend3 = new Agendamento(null, "Gabriel Todesco", "15 65465464", "GabrielT@hotmail.com", sdf1.parse("05/01/2019"), sdf2.parse("18:00"), serv1);		
		
		serv1.getAgendamentos().addAll(Arrays.asList(agend2, agend3));
		serv2.getAgendamentos().addAll(Arrays.asList(agend1));
		
		servicoRepository.saveAll(Arrays.asList(serv1, serv2));
		agendamentoRepository.saveAll(Arrays.asList(agend1, agend2, agend3));
		
		Usuario user1 = new Usuario(null, "Admnistrador", "Admin", "admin@admin", pe.encode("admin"));
		Usuario user2 = new Usuario(null, "Cliente", "Cli", "cliente@cliente", pe.encode("cliente"));
		user1.addPerfil(Perfil.ADMIN);
		user2.addPerfil(Perfil.CLIENTE);
		
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
	}
}
