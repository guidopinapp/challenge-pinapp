package com.challenge.pinapp.controller;

import com.challenge.pinapp.model.dto.ClienteRequestDTO;
import com.challenge.pinapp.model.dto.ClienteResponseDTO;
import com.challenge.pinapp.model.dto.KPIClienteDTO;
import com.challenge.pinapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/creacliente")
    public ResponseEntity creaCliente(
            @Valid @RequestBody ClienteRequestDTO cliente) {
        try {
            ClienteResponseDTO clienteResponseDTO = clienteService.crearCliente(cliente);
            return new ResponseEntity<>(clienteResponseDTO, HttpStatus.CREATED);
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/kpideclientes")
    public ResponseEntity kpiClientes() {
        try {
            KPIClienteDTO kpiClienteDTO = clienteService.getKPIClientes();
            return new ResponseEntity<>(kpiClienteDTO, HttpStatus.OK);
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/listclientes")
    public ResponseEntity listClientes() {
        try {
            List<ClienteResponseDTO> clientes = clienteService.getClientes();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nombreCampo = ((FieldError) error).getField();
            String menajeError = error.getDefaultMessage();
            errores.put(nombreCampo, menajeError);
        });
        return errores;
    }
}
