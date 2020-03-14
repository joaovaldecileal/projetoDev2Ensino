/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.RequisicaoCertificacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yk.hjm
 */
public interface RequisicaoCertificacaoDAO extends JpaRepository<RequisicaoCertificacao, Long>{
    @Override
    List<RequisicaoCertificacao> findAll();
}
