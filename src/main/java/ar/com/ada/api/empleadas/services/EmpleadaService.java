package ar.com.ada.api.empleadas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.empleadas.entities.Categoria;
import ar.com.ada.api.empleadas.entities.Empleada;
import ar.com.ada.api.empleadas.repos.EmpleadaRepository;

@Service
public class EmpleadaService {

    @Autowired
    EmpleadaRepository repo;

    @Autowired
    CategoriaService categoriaService;

    public void crearEmpleada(Empleada empleada){
        repo.save(empleada);
    }

    public List<Empleada> traerEmpleadas(){
        return repo.findAll();
    }

    public Empleada buscarEmpleada(Integer empleadaId){
        Optional <Empleada> resultado =  repo.findById(empleadaId);
        if(resultado.isPresent()){
            return resultado.get();
        }
        else return null;
    }

    public List<Empleada> traerEmpleadasPorCategoria(Integer catId) {
        
        Categoria categoria = categoriaService.buscarCategoria(catId);
        return categoria.getEmpleadas();
    }
    
}
