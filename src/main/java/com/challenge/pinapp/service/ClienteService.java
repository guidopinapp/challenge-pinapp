package com.challenge.pinapp.service;

import com.challenge.pinapp.model.dto.ClienteRequestDTO;
import com.challenge.pinapp.model.dto.ClienteResponseDTO;
import com.challenge.pinapp.model.dto.KPIClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO crearCliente(ClienteRequestDTO cliente);

    KPIClienteDTO getKPIClientes();

    List<ClienteResponseDTO> getClientes();
}
