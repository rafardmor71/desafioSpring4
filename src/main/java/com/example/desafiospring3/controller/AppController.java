package com.example.desafiospring3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiospring3.entities.Cliente;
import com.example.desafiospring3.service.ClienteServiceI;

@RestController
public class AppController {
	@Autowired
	private ClienteServiceI clienteService;
	

	@RequestMapping(path= "/listarClientes", method = RequestMethod.GET)
	public List<Cliente> listar() {
		return clienteService.listarTodosLosClientes();
	}
	
	@RequestMapping(path= "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		clienteService.borrarClientePorId(id);
		return "Cliente borrado";
	}

	@RequestMapping(path = "/crearClientes", method = RequestMethod.POST)
	public String mostrarCrearClientes(@RequestBody Cliente cliente) {
		clienteService.añadirCliente(cliente);
		return "Cliente creado";
	}

	@RequestMapping(path= "/clientes/{nombre}/{apellidos}", method = RequestMethod.GET)
	public List<Cliente> buscarPorNombre(@PathVariable String nombre, @PathVariable String apellidos) {
		return clienteService.buscarClientePorNombreYApellidos(nombre, apellidos);
	}
	
}
