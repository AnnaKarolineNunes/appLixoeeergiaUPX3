package com.projeto.projetoupx3.services;

import com.projeto.projetoupx3.enumerator.TipoMaterial;
import com.projeto.projetoupx3.model.MaterialReciclavel;
import com.projeto.projetoupx3.model.dtos.MaterialReciclavelDto;
import com.projeto.projetoupx3.repositories.MaterialReciclavelRepository;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Arrays;

@Service
public class MaterialReciclavelService {

    @Autowired
    MaterialReciclavelRepository materialReciclavelRepository;

    /**
     * Retorna todos os materiais recicláveis do banco de dados.
     * @return ApiResponse contendo a lista de materiais recicláveis ou mensagem de erro.
     */
    public ApiResponse<List<MaterialReciclavelDto>> findAll(){
        try {
            List<MaterialReciclavel> materiaisReciclaveis = this.materialReciclavelRepository.findAll();
            return new ApiResponse<>(200, "Listagem de materiais realizada com sucesso!",
                    materiaisReciclaveis.stream().map(MaterialReciclavelDto::new).collect(Collectors.toList()));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Retorna um material reciclável pelo seu ID.
     * @param id ID do material reciclável a ser buscado.
     * @return ApiResponse contendo o material reciclável encontrado ou mensagem de erro.
     */
    public ApiResponse<MaterialReciclavelDto> findById(Long id) {
        try {
            Optional<MaterialReciclavel> resultado = this.materialReciclavelRepository.findById(id);

            return resultado.map(materialReciclavel -> new ApiResponse<>(200, "Detalhamento de material realizado com sucesso!",
                    new MaterialReciclavelDto(materialReciclavel))).orElseGet(() -> new ApiResponse<>(204, "Material não encontrado!", null));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Obtém a lista de materiais recicláveis definida internamente e a insere no banco de dados,
     * verificando antes se os materiais já existem.
     * @return ApiResponse indicando o sucesso ou falha da operação de inserção.
     */
    public ApiResponse<List<MaterialReciclavel>> getMateriaisReciclaveis() {
        try {
            List<MaterialReciclavel> materiaisReciclaveis = Arrays.asList(
                    new MaterialReciclavel("Garrafa de Vidro",0.8, TipoMaterial.VIDRO),
                    new MaterialReciclavel("Vidro de remédio vazio",0.5 , TipoMaterial.VIDRO),
                    new MaterialReciclavel("Potes de conserva",0.3 , TipoMaterial.VIDRO),
                    new MaterialReciclavel("Vidros especiais",0.5 , TipoMaterial.VIDRO),
                    new MaterialReciclavel("Copo de vidro",0.5 , TipoMaterial.VIDRO),
                    new MaterialReciclavel("Papel de fax",0.2 , TipoMaterial.PAPEL),
                    new MaterialReciclavel("Jornais e Revistas",2.0 , TipoMaterial.PAPEL),
                    new MaterialReciclavel("Envelopes",0.3 , TipoMaterial.PAPEL),
                    new MaterialReciclavel("Listas Telefônicas",2.0 , TipoMaterial.PAPEL),
                    new MaterialReciclavel("Cartazes Velhos",0.5 , TipoMaterial.PAPEL),
                    new MaterialReciclavel("Copo de vidro",0.9 , TipoMaterial.PAPEL),
                    new MaterialReciclavel("Enlatados",0.5 , TipoMaterial.METAL),
                    new MaterialReciclavel("Tampinhas de Garrafas",0.1, TipoMaterial.METAL),
                    new MaterialReciclavel("Chapas",1.5 , TipoMaterial.METAL),
                    new MaterialReciclavel("Latas",0.3 , TipoMaterial.METAL),
                    new MaterialReciclavel("Ferragens",2.0, TipoMaterial.METAL),
                    new MaterialReciclavel("Frascos de produtos",0.6, TipoMaterial.PLASTICO),
                    new MaterialReciclavel("Caneta (Sem a tinta)",0.2, TipoMaterial.PLASTICO),
                    new MaterialReciclavel("Embalagens de produto de limpeza",0.7, TipoMaterial.PLASTICO),
                    new MaterialReciclavel("Brinquedos de plástico",1.5, TipoMaterial.PLASTICO),
                    new MaterialReciclavel("Embalagens Pet",0.7, TipoMaterial.PLASTICO)
                    );

            ApiResponse<Void> insercaoResponse = inserirMateriaisReciclaveis(materiaisReciclaveis);
            if (insercaoResponse.getStatus() != 200) {
                return new ApiResponse<>(500, "Erro ao inserir materiais recicláveis.", null);
            }
            return new ApiResponse<>(200, "Listagem de materiais recicláveis realizada com sucesso!", materiaisReciclaveis);
        } catch (Exception e) {
            return new ApiResponse<>(500, "Erro ao listar materiais recicláveis: " + e.getMessage(), null);
        }
    }

    /**
     * Insere os materiais recicláveis fornecidos no banco de dados,
     * verificando antes se eles já existem.
     * @param materiaisReciclaveis Lista de materiais recicláveis a serem inseridos.
     * @return ApiResponse indicando o sucesso ou falha da operação de inserção.
     */
    public ApiResponse<Void> inserirMateriaisReciclaveis(List<MaterialReciclavel> materiaisReciclaveis) {
        try {
            for (MaterialReciclavel material : materiaisReciclaveis) {
                if (!materialExistsByNome(material.getNome())) {
                    materialReciclavelRepository.save(material);
                }
            }
            return new ApiResponse<>(200, "Materiais inseridos com sucesso!", null);
        } catch (Exception e) {
            return new ApiResponse<>(500, "Erro ao inserir materiais recicláveis: " + e.getMessage(), null);
        }
    }

    /**
     * Verifica se um material reciclável com o nome especificado já existe no banco de dados.
     * @param nome Nome do material reciclável a ser verificado.
     * @return true se o material existir, false caso contrário.
     */
    public boolean materialExistsByNome(String nome) {
        return materialReciclavelRepository.existsByNome(nome);
    }
}
