package com.projeto.projetoupx3.services;

import com.projeto.projetoupx3.model.MaterialReciclavel;
import com.projeto.projetoupx3.model.Pesagem;
import com.projeto.projetoupx3.model.dtos.PesagemDto;
import com.projeto.projetoupx3.repositories.MaterialReciclavelRepository;
import com.projeto.projetoupx3.repositories.PesagemRepository;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PesagemService {

    @Autowired
    PesagemRepository pesagemRepository;

    @Autowired
    MaterialReciclavelRepository materialReciclavelRepository;

    public ApiResponse<List<PesagemDto>> findAll(){
        try {
            List<Pesagem> pesagens = this.pesagemRepository.findAll();
            return new ApiResponse<>(200, "Listagem de pesagens realizada com sucesso!",
                    pesagens.stream().map(PesagemDto::new).collect(Collectors.toList()));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    public ApiResponse<PesagemDto> findById(Long id) {
        try {
            Optional<Pesagem> resultado = this.pesagemRepository.findById(id);

            return resultado.map(pesagem -> new ApiResponse<>(200, "Detalhamento de pesagens realizado com sucesso!",
                    new PesagemDto(pesagem))).orElseGet(() -> new ApiResponse<>(204, "Pesagem não encontrada!", null));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    public ApiResponse<Double> calcularPesoTotal(List<Long> idsMateriais) {
        try {
            double pesoTotal = 0.0;

            for (Long id : idsMateriais) {
                Optional<MaterialReciclavel> materialOpt = materialReciclavelRepository.findById(id);
                if (materialOpt.isPresent()) {
                    pesoTotal += materialOpt.get().getPeso();
                } else {
                    System.out.println("Material com ID " + id + " não encontrado.");
                }
            }

            return new ApiResponse<>(200, "Cálculo de peso total realizado com sucesso!", pesoTotal);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "Erro ao calcular peso total: " + e.getMessage(), null);
        }
    }


    public ApiResponse<Void> salvarPesagem(PesagemDto pesagemDto) {
        try {
            // Busca o MaterialReciclavel pelo ID
            Optional<MaterialReciclavel> materialOpt = materialReciclavelRepository.findById(pesagemDto.getMaterialReciclavel());
            if (materialOpt.isPresent()) {
                MaterialReciclavel materialReciclavel = materialOpt.get();

                // Cria a entidade Pesagem a partir do PesagemDto e do MaterialReciclavel encontrado
                Pesagem pesagem = PesagemDto.convert(pesagemDto, materialReciclavel);

                // Salva a Pesagem no banco de dados
                pesagemRepository.save(pesagem);

                return new ApiResponse<>(200, "Pesagem salva com sucesso!", null);
            } else {
                return new ApiResponse<>(404, "Material reciclável não encontrado para o ID fornecido", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "Erro ao salvar pesagem: " + e.getMessage(), null);
        }
    }



}