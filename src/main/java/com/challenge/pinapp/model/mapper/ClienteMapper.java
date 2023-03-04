package com.challenge.pinapp.model.mapper;

import com.challenge.pinapp.model.Cliente;
import com.challenge.pinapp.model.dto.ClienteRequestDTO;
import com.challenge.pinapp.model.dto.ClienteResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente fromClienteRequestDTOtoCliente(ClienteRequestDTO clienteRequestDTO);

    ClienteResponseDTO fromClientetoClienteResponseDTO(Cliente cliente);
}
