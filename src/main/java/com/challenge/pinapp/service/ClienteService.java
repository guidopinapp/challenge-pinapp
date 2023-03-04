package com.challenge.pinapp.service;

import com.challenge.pinapp.model.dto.ClienteRequestDTO;
import com.challenge.pinapp.model.dto.ClienteResponseDTO;

public interface ClienteService {
    ClienteResponseDTO crearCliente(ClienteRequestDTO cliente);
}
