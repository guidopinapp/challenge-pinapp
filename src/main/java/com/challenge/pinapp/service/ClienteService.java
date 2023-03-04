package com.challenge.pinapp.service;

import com.challenge.pinapp.model.dto.ClienteRequestDTO;
import com.challenge.pinapp.model.dto.ClienteResponseDTO;
import com.challenge.pinapp.model.dto.KPIClienteDTO;

public interface ClienteService {
    ClienteResponseDTO crearCliente(ClienteRequestDTO cliente);

    KPIClienteDTO getKPIClientes();
}
