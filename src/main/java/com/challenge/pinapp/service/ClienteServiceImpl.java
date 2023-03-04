package com.challenge.pinapp.service;

import com.challenge.pinapp.model.Cliente;
import com.challenge.pinapp.model.dto.ClienteRequestDTO;
import com.challenge.pinapp.model.dto.ClienteResponseDTO;
import com.challenge.pinapp.model.dto.DesviacionEstandarClienteDTO;
import com.challenge.pinapp.model.dto.KPIClienteDTO;
import com.challenge.pinapp.model.mapper.ClienteMapper;
import com.challenge.pinapp.repository.ClienteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final static String PORCENTAJE_DEBAJO_MEDIA_EDAD = " % por debajo de la media de edad";
    private final static String PORCENTAJE_ENCIMA_MEDIA_EDAD = " % por encima de la media de edad";


    @Autowired
    private ClienteRepository repository;

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO) {
        if (clienteRequestDTO.getEdad() == null) {
            Integer edad = repository.obtenerEdad(clienteRequestDTO.getFechaNacimiento());
            clienteRequestDTO.setEdad(edad);
        }

        Cliente cliente = repository.save(Mappers.getMapper(ClienteMapper.class).fromClienteRequestDTOtoCliente(clienteRequestDTO));
        ClienteResponseDTO response = Mappers.getMapper(ClienteMapper.class).fromClientetoClienteResponseDTO(cliente);
        return response;
    }

    @Override
    public KPIClienteDTO getKPIClientes() {
        Integer cantidadClientes = repository.getCantidadClientes();
        Integer promedioEdad = repository.obtenerPromedioEdad();

        List<Cliente> clientes = repository.getClientes();

        Integer clientesDebajoMediaEdad = 0;
        Integer clientesEncimaMediaEdad = 0;

        for (Cliente cliente : clientes) {
            if (cliente.getEdad() < promedioEdad)
                clientesDebajoMediaEdad++;
            else {
                clientesEncimaMediaEdad++;
            }
        }

        DesviacionEstandarClienteDTO desviacionEstandar = new DesviacionEstandarClienteDTO((clientesDebajoMediaEdad * 100) / cantidadClientes + PORCENTAJE_DEBAJO_MEDIA_EDAD, (clientesEncimaMediaEdad * 100) / cantidadClientes + PORCENTAJE_ENCIMA_MEDIA_EDAD);

        KPIClienteDTO kpiClienteDTO = new KPIClienteDTO(promedioEdad, desviacionEstandar);
        return kpiClienteDTO;
    }

    @Override
    public List<ClienteResponseDTO> getClientes() {
        List<Cliente> clientes = repository.getClientes();

        List<ClienteResponseDTO> clientesResponseDTO = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clientesResponseDTO.add(Mappers.getMapper(ClienteMapper.class).fromClientetoClienteResponseDTO(cliente));
        }

        return clientesResponseDTO;
    }
}
