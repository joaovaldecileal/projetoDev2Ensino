/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.Requisicao;

import java.util.Date;
import java.util.List;

import br.edu.ifrs.restinga.requisicoes.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoDAO extends JpaRepository<Requisicao, Long> {
    Iterable<Requisicao> findByDataRequisicaoBetween(Date incio, Date fim);
    Iterable <Requisicao> findByUsuario(Usuario usuario);
    Iterable<Requisicao> findByDisciplinaSolicitada(Disciplina disciplinaSolicitada);
}