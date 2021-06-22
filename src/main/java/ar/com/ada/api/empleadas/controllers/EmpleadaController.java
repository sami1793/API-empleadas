package ar.com.ada.api.empleadas.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.empleadas.entities.Categoria;
import ar.com.ada.api.empleadas.entities.Empleada;
import ar.com.ada.api.empleadas.entities.Empleada.EstadoEmpleadaEnum;
import ar.com.ada.api.empleadas.models.request.InfoEmpleadaNueva;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.CategoriaService;
import ar.com.ada.api.empleadas.services.EmpleadaService;

@RestController
public class EmpleadaController {
    
    @Autowired
    private EmpleadaService service;

    @Autowired
    CategoriaService categoriaService;//lo necesito para el crearEmpleada

    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpleada(@RequestBody InfoEmpleadaNueva empleadaInfo){//void-->ResponseEntity<?>
        GenericResponse respuesta= new GenericResponse();

        //crearEmpleada se usa para un tipo Empleada por eso hago esto:
        Empleada empleada = new Empleada();
        empleada.setNombre(empleadaInfo.nombre);
        empleada.setEdad(empleadaInfo.edad);
        empleada.setSueldo(empleadaInfo.sueldo);
        empleada.setFechaAlta(new Date());//porque no puede ser null

        Categoria categoria= categoriaService.buscarCategoria(empleadaInfo.categoriaId);

        empleada.setCategoria(categoria);

        empleada.setEstado(EstadoEmpleadaEnum.ACTIVO);//tiene que estar sino error

        service.crearEmpleada(empleada); //desde aqui ya uso empleadA

        respuesta.isOk=true;
        respuesta.id=empleada.getEmpleadaId();
        respuesta.message="La empleada fue creada con éxito";

        return ResponseEntity.ok(respuesta);
        
    }
    

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleada>> traerEmpleadas(){
        return ResponseEntity.ok(service.traerEmpleadas());
    }

}