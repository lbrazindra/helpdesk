package br.com.helpdesk.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.helpdesk.dao.ConexaoBancoMySqL;
import br.com.helpdesk.modelo.ModeloRelatorios;

public class TesteDAO {
	public List<ModeloRelatorios> buscar() throws Exception {

		/* Define a SQL */
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  CHAMADO.idChamado, ");
		sql.append("CHAMADO.tituloChamado, "); 
		sql.append("Status.nomeStatus, ");
		sql.append("DEPARTAMENTOCHAMADO.nomeDepartamento, ");
		sql.append("USUARIO.Nome, ");
		sql.append("USUARIO.Telefone, ");
		sql.append("USUARIO.email, ");
		sql.append("(SELECT Nome from Usuario where CHAMADO.idUsuarioAdmChamado = Usuario.idUsuario), ");
		sql.append("(SELECT Telefone from Usuario where CHAMADO.idUsuarioAdmChamado = Usuario.idUsuario), ");
		sql.append("(SELECT email from Usuario where CHAMADO.idUsuarioAdmChamado = Usuario.idUsuario), ");
		sql.append("CHAMADO.dataAbertura, ");
		sql.append("CHAMADO.dataFechamento ");		
		sql.append("FROM CHAMADO ");
		sql.append("INNER JOIN USUARIO ON CHAMADO.IDUSUARIOCLIENTECHAMADO = USUARIO.IDUSUARIO ");
		sql.append("INNER JOIN STATUS ON CHAMADO.STATUS_IDSTATUS = STATUS.idStatus ");
		sql.append("INNER JOIN DEPARTAMENTOCHAMADO ON CHAMADO.DEPARTAMENTOCHAMADO_IDDEPARTAMENTOCHAMADO = DEPARTAMENTOCHAMADO.IDDEPARTAMENTOCHAMADO ");
		sql.append("order by STATUS_IDSTATUS; ");
		/* Abre a conexão que criamos o retorno é armazenado na variavel conn */
		Connection conn = ConexaoBancoMySqL.abrir();

		/* Mapeamento objeto relacional */
		PreparedStatement comando = conn.prepareStatement(sql.toString());

		/* Executa a SQL e captura o resultado da consulta */
		ResultSet resultado = comando.executeQuery();

		/* Cria uma lista para armazenar o resultado da consulta */
		List<ModeloRelatorios> lista = new ArrayList<ModeloRelatorios>();

		/* Percorre o resultado armazenando os valores em uma lista */
		while (resultado.next()) {
			/* Cria um objeto para armazenar uma linha da consulta */
			ModeloRelatorios modeloRelatorios = new ModeloRelatorios();
			/* Armazena a linha lida em uma lista */
			modeloRelatorios.setIdChamado(resultado.getInt("idChamado"));
			modeloRelatorios.setTituloChamado(resultado.getString("tituloChamado"));
			modeloRelatorios.setNomeStatus(resultado.getString("nomeStatus"));
			modeloRelatorios.setNomeDepartamento(resultado.getString("nomeDepartamento"));
			modeloRelatorios.setNome(resultado.getString("nome"));
			modeloRelatorios.setTelefone(Integer.valueOf(resultado.getString("telefone")));
			modeloRelatorios.setEmail(resultado.getString("email"));
			modeloRelatorios.setNomeAdm(resultado.getString(8));
			modeloRelatorios.setTelefoneAdm(resultado.getInt(9));
			modeloRelatorios.setEmailAdm(resultado.getString(10));
			modeloRelatorios.setDataAbertura(resultado.getTimestamp(11));
			modeloRelatorios.setDataFechamento(resultado.getTimestamp(12));
			lista.add(modeloRelatorios);
		}

		/* Fecha a conexão */
		resultado.close();
		comando.close();
		conn.close();
		/* Retorna a lista contendo o resultado da consulta */
		return lista;
	}

}
