package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleado;
import com.example.demo.services.EmpleadoServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl EmpleadoServideImpl;
	
	@GetMapping("/all")
	public List<Empleado> listarEmpleados(){
		return EmpleadoServideImpl.listarClientes();
	}
	
	
	@PostMapping("/add")
	public Empleado salvarCliente(@RequestBody Empleado cliente) {
		
		return EmpleadoServideImpl.guardarEmpleado(cliente);
	}
	
	
	@GetMapping("/{id}")
	public Empleado clienteXID(@PathVariable(name="id") Integer id) {
		
		Empleado cliente_xid= new Empleado();
		
		cliente_xid=EmpleadoServideImpl.empleadoXID(id);
		
		System.out.println("Empleado XID: "+cliente_xid);
		
		return cliente_xid;
	}
	
	@PutMapping("/{id}")
	public Empleado actualizarCliente(@PathVariable(name="id")Integer id,@RequestBody Empleado cliente) {
		
		Empleado cliente_seleccionado= new Empleado();
		Empleado cliente_actualizado= new Empleado();
		
		cliente_seleccionado= EmpleadoServideImpl.empleadoXID(id);
		
		cliente_seleccionado.setTrabajo(cliente.getTrabajo());
		cliente_seleccionado.setSalario();
		
		cliente_actualizado = EmpleadoServideImpl.actualizarEmpleado(cliente_seleccionado);
		
		System.out.println("El cliente actualizado es: "+ cliente_actualizado);
		
		return cliente_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarCliente(@PathVariable(name="id")Integer id) {
		EmpleadoServideImpl.eliminarEmpleado(id);
		System.out.println("Empleado eliminado");
	}
	
	@GetMapping("/trabajo/{trabajo}")
	public List<Empleado> listarEmpleadoPorTrabajo(@PathVariable(name="trabajo") String trabajo) {
		return EmpleadoServideImpl.listarEmpleadosPorTrabajo(trabajo);
	}
	
	
}
