package org.example.gtics_lab5.controller;

import jakarta.validation.Valid;
import org.example.gtics_lab5.entity.Technician;
import org.example.gtics_lab5.repository.TecnicoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class TecnicoController {

    final TecnicoRepository tecnicoRepository;

    public TecnicoController(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }
    @GetMapping("/vista_tecnicos")
    public String listaEmployee(Model model){
        model.addAttribute("listaTecnicos", tecnicoRepository.findAll());
        return "inicioTecnico";
    }

    @GetMapping("/nuevo_tecnico")
    public String nuevoProductoFrm(@ModelAttribute("technician") Technician technician) {
        return "nuevoTecnico";
    }

    @PostMapping("/guardar_tecnico")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("technician") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal


                if (technician.getTechnicianId() == 0) {
                    attr.addFlashAttribute("msg", "Producto creado exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
                }
                tecnicoRepository.save(technician);
                return "redirect:/vista_tecnicos";

        } else { //hay al menos 1 error
            return "nuevoTecnico";
        }
    }


    @GetMapping("/editar_tecnico")
    public String editarTransportista(@ModelAttribute("technician") Technician technician,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optProduct = tecnicoRepository.findById(id);

        if (optProduct.isPresent()) {
            technician = optProduct.get();
            model.addAttribute("technician", technician);
            return "nuevoTecnico";
        } else {
            return "redirect:/vista_tecnicos";
        }
    }


}
