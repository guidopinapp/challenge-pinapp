package com.challenge.pinapp.service;

import com.challenge.pinapp.model.Cliente;
import com.challenge.pinapp.model.dto.ClienteRequestDTO;
import com.challenge.pinapp.model.dto.ClienteResponseDTO;
import com.challenge.pinapp.model.mapper.ClienteMapper;
import com.challenge.pinapp.repository.ClienteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO) {
        if(clienteRequestDTO.getEdad() == null){
            Integer edad = repository.obtenerEdad(clienteRequestDTO.getFechaNacimiento());
            clienteRequestDTO.setEdad(edad);
        }

        Cliente cliente = repository.save(Mappers.getMapper(ClienteMapper.class).fromClienteRequestDTOtoCliente(clienteRequestDTO));
        ClienteResponseDTO response = Mappers.getMapper(ClienteMapper.class).fromClientetoClienteResponseDTO(cliente);
        return response;
    }
}
