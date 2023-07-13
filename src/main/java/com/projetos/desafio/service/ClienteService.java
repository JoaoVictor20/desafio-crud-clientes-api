package com.projetos.desafio.service;

import com.projetos.desafio.dao.ClienteDao;
import com.projetos.desafio.models.entities.Cliente;
import com.projetos.desafio.models.entities.Fisica;
import com.projetos.desafio.models.entities.Juridica;
import com.projetos.desafio.models.requests.ClienteRequest;
import com.projetos.desafio.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Autowired
	private Constantes contantes;

	public Cliente cadastrarCliente(ClienteRequest clienteRequest) throws Exception {

		try {
			if (clienteRequest.getCpf() == "") {
				Juridica juridica = new Juridica();
				montarJuridica(clienteRequest, juridica);
				juridica.setNomeFantasia(clienteRequest.getNomeFantasia());
				juridica.setRazaoSocial(clienteRequest.getRazaoSocial());
				juridica.setCnpj(clienteRequest.getCnpj());
				return clienteDao.save(juridica);
			}
			Fisica fisica = new Fisica();
			montarFisica(clienteRequest, fisica);
			fisica.setNome(clienteRequest.getNome());
			fisica.setDataDeNascimento(converterDataStringEmDate(clienteRequest.getDataDeNascimento()));
			fisica.setCpf(clienteRequest.getCpf());
			return clienteDao.save(fisica);
		} catch (Exception exception) {
			throw new Exception(contantes.getERRO_AO_SALVAR_CLIENTE());
		}
	}

	private Date converterDataStringEmDate(String data) throws ParseException {

		if (data != "") {
			SimpleDateFormat formato = new SimpleDateFormat(contantes.getFORMATO_PADRAO_DE_DATA());
			return formato.parse(data);
		}
		return null;
	}

	private void montarJuridica(ClienteRequest clienteRequest, Juridica juridica) {

		juridica.getUsuario().setId(clienteRequest.getIdUsuario());
		juridica.setTelefone(clienteRequest.getTelefone());
		juridica.setDataCadastro(new Date());
	}

	private void montarFisica(ClienteRequest clienteRequest, Fisica fisica) {

		fisica.getUsuario().setId(clienteRequest.getIdUsuario());
		fisica.setTelefone(clienteRequest.getTelefone());
		fisica.setDataCadastro(new Date());
	}

	public Cliente alterarCliente(ClienteRequest clienteRequest) throws Exception {

		try {
			if (clienteRequest.getCpf() == null) {
				Juridica juridica = (Juridica) clienteDao.findById(clienteRequest.getId()).get();
				juridica.setTelefone(clienteRequest.getTelefone());
				juridica.setNomeFantasia(clienteRequest.getNomeFantasia());
				juridica.setRazaoSocial(clienteRequest.getRazaoSocial());
				juridica.setCnpj(clienteRequest.getCnpj());
				juridica.setDataAlteracao(new Date());
				return clienteDao.save(juridica);
			}
			Fisica fisica = (Fisica) clienteDao.findById(clienteRequest.getId()).get();
			fisica.setTelefone(clienteRequest.getTelefone());
			fisica.setNome(clienteRequest.getNome());
			fisica.setDataDeNascimento(converterDataStringEmDate(clienteRequest.getDataDeNascimento()));
			fisica.setCpf(clienteRequest.getCpf());
			fisica.setDataAlteracao(new Date());
			return clienteDao.save(fisica);
		} catch (Exception exception) {
			throw new Exception(contantes.getERRO_AO_ALTERAR_CLIENTE());
		}
	}

	public Cliente deletarCliente(Long idDoCliente) throws Exception {
		try {
			Cliente cliente = clienteDao.findById(idDoCliente).get();
			clienteDao.delete(cliente);
			return null;
		} catch (Exception exception) {
			throw new Exception(contantes.getERRO_AO_DELETAR_CLIENTE());
		}
	}

	public List<Cliente> buscarClientesDoUsuario(Long usuario_id) throws Exception {
		try {
			return clienteDao.buscarClientesDoUsuario(usuario_id);
		} catch (Exception exception) {
			throw new Exception(contantes.getERRO_AO_LISTAR_CLIENTES());
		}
	}
}