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
// Serviço para operações relacionadas à entidade Pesagem
public class PesagemService {

    @Autowired
    PesagemRepository pesagemRepository;

    @Autowired
    MaterialReciclavelRepository materialReciclavelRepository;

    /**
     * Busca todas as pesagens cadastradas.
     * @return ApiResponse contendo a lista de pesagens encontradas ou mensagem de erro.
     */
    public ApiResponse<List<PesagemDto>> findAll() {
        try {
            List<Pesagem> pesagens = pesagemRepository.findAll();
            List<PesagemDto> pesagemDtos = pesagens.stream()
                    .map(PesagemDto::new)
                    .collect(Collectors.toList());

            return new ApiResponse<>(200, "Listagem de pesagens realizada com sucesso!", pesagemDtos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "Erro ao listar pesagens: " + e.getMessage(), null);
        }
    }

    /**
     * Busca uma pesagem pelo ID.
     * @param id ID da pesagem a ser buscada.
     * @return ApiResponse contendo a pesagem encontrada ou mensagem de erro.
     */
    public ApiResponse<PesagemDto> findById(Long id) {
        try {
            Optional<Pesagem> resultado = pesagemRepository.findById(id);

            return resultado.map(pesagem -> new ApiResponse<>(200, "Detalhamento de pesagem encontrado com sucesso!",
                    new PesagemDto(pesagem))).orElseGet(() -> new ApiResponse<>(404, "Pesagem não encontrada para o ID fornecido", null));
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "Erro ao buscar pesagem: " + e.getMessage(), null);
        }
    }

    /**
     * Calcula o peso total de uma lista de materiais recicláveis.
     * @param idsMateriais Lista de IDs dos materiais recicláveis.
     * @return ApiResponse contendo o peso total calculado ou mensagem de erro.
     */
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

    /**
     * Salva uma nova pesagem.
     * @param pesagemDto Dados da pesagem a serem salvos.
     * @return ApiResponse indicando o sucesso ou falha da operação de salvamento.
     */
    public ApiResponse<Void> salvarPesagem(PesagemDto pesagemDto) {
        try {
            Optional<MaterialReciclavel> materialOpt = materialReciclavelRepository.findById(pesagemDto.getMaterialReciclavel());
            if (materialOpt.isPresent()) {
                MaterialReciclavel materialReciclavel = materialOpt.get();
                Pesagem pesagem = PesagemDto.convert(pesagemDto, materialReciclavel);
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

    /**
     * Deleta uma pesagem pelo ID.
     * @param id ID da pesagem a ser deletada.
     * @return ApiResponse indicando o sucesso ou falha da operação de deleção.
     */
    public ApiResponse<Void> deleteById(Long id) {
        try {
            Optional<Pesagem> pesagemOpt = pesagemRepository.findById(id);
            if (pesagemOpt.isPresent()) {
                pesagemRepository.deleteById(id);
                return new ApiResponse<>(200, "Pesagem deletada com sucesso!", null);
            } else {
                return new ApiResponse<>(404, "Pesagem não encontrada para o ID fornecido", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "Erro ao deletar pesagem: " + e.getMessage(), null);
        }
    }

    /**
     * Calcula e atualiza o desconto para uma pesagem específica.
     * @param id ID da pesagem para calcular o desconto.
     * @return ApiResponse indicando o sucesso ou falha da operação de cálculo e atualização do desconto.
     */
    public ApiResponse<Void> calcularEAtualizarDesconto(Long id) {
        try {
            Optional<Pesagem> pesagemOpt = pesagemRepository.findById(id);
            if (pesagemOpt.isPresent()) {
                Pesagem pesagem = pesagemOpt.get();
                double desconto = pesagem.getPesoTotal() * 10; // Exemplo: Multiplica o peso total
                pesagem.setDesconto(desconto);
                pesagemRepository.save(pesagem);
                return new ApiResponse<>(200, "Desconto calculado e atualizado com sucesso!", null);
            } else {
                return new ApiResponse<>(404, "Pesagem não encontrada para calcular o desconto.", null);
            }
        } catch (Exception e) {
            return new ApiResponse<>(500, "Erro ao calcular e atualizar desconto: " + e.getMessage(), null);
        }
    }

    /**
     * Obtém o desconto de uma pesagem específica.
     * @param id ID da pesagem para recuperar o desconto.
     * @return ApiResponse contendo o desconto da pesagem ou mensagem de erro.
     */
    public ApiResponse<Double> obterDesconto(Long id) {
        try {
            Optional<Pesagem> pesagemOpt = pesagemRepository.findById(id);
            if (pesagemOpt.isPresent()) {
                double desconto = pesagemOpt.get().getDesconto();
                return new ApiResponse<>(200, "Desconto obtido com sucesso!", desconto);
            } else {
                return new ApiResponse<>(404, "Pesagem não encontrada para obter o desconto.", null);
            }
        } catch (Exception e) {
            return new ApiResponse<>(500, "Erro ao obter desconto: " + e.getMessage(), null);
        }
    }

    /**
     * Obtém o peso total de uma pesagem pelo ID.
     * @param id ID da pesagem para recuperar o peso total.
     * @return ApiResponse contendo o peso total da pesagem ou mensagem de erro.
     */
    public ApiResponse<Double> getPesoTotalById(Long id) {
        try {
            Optional<Pesagem> pesagemOpt = pesagemRepository.findById(id);
            if (pesagemOpt.isPresent()) {
                Pesagem pesagem = pesagemOpt.get();
                return new ApiResponse<>(200, "Peso total da pesagem recuperado com sucesso!", pesagem.getPesoTotal());
            } else {
                return new ApiResponse<>(404, "Pesagem não encontrada para o ID fornecido", null);
            }
        } catch (Exception e) {
            return new ApiResponse<>(500, "Erro ao recuperar peso total da pesagem: " + e.getMessage(), null);
        }
    }
}
