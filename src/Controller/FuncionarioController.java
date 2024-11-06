package Controller;

import Model.FuncionarioModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FuncionarioController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioModel> lista = new ArrayList<>();

    public ResultSet autenticacaoUsuario(FuncionarioModel funcionarioModel) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT * FROM usuario WHERE nomeUsuario = ? AND senhaUsuario = ? AND activo = ? AND disp = ?";

        try {

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, funcionarioModel.getNome());
            pstm.setString(2, funcionarioModel.getSenhaFuncionario());
            pstm.setBoolean(3, funcionarioModel.getStatus());
            pstm.setBoolean(4, funcionarioModel.getDisp());

            ResultSet rs = pstm.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("Nenhum usuário encontrado com essas credenciais.");
            }
            return rs;

        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro na autenticação: " + erro.getMessage());
            return null;
        }
    }

    //Metodo que verifia a existencia de um ususario com mesmos dados
    public boolean usuarioExiste(String nomeUsuario, String email) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT COUNT(*) FROM usuario WHERE nomeUsuario = ? OR emailFuncionario = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, nomeUsuario);
            pstm.setString(2, email);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioController usuarioExiste" + erro);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "UsuarioController usuarioExiste (finally)" + erro);
            }
        }
        return false;
    }

    //METODO PARA CADASTRAR
    public void cadastrarFuncionario(FuncionarioModel funcionarioModel) {
        if (usuarioExiste(funcionarioModel.getNome(), funcionarioModel.getEmail())) {
            JOptionPane.showMessageDialog(null, "Já existe um usuario com os mesmos dados.");
        } else {
            String sql = "insert into usuario (nome, apelidoFuncionario, naturalidadeFuncionario, dataNascimentoFuncionario, emailFuncionario, funcaoFuncionario, nomeUsuario, senhaUsuario, perfil, activo, disp) values (?,?,?,?,?,?,?,?,?,?,?) ";
            conexao = new ConexaoController().conectaBaseDados();

            try {
                pstm = conexao.prepareStatement(sql);

                pstm.setString(1, funcionarioModel.getNome());
                pstm.setString(2, funcionarioModel.getApelido());
                pstm.setString(3, funcionarioModel.getNaturalidade());
                pstm.setString(4, funcionarioModel.getDataNascimento());
                pstm.setString(5, funcionarioModel.getEmail());
                pstm.setString(6, funcionarioModel.getFuncaoFuncionario());
                pstm.setString(7, funcionarioModel.getNome());
                pstm.setString(8, funcionarioModel.getSenhaFuncionario());
                pstm.setString(9, funcionarioModel.getPerfilDeAcesso());
                pstm.setBoolean(10, funcionarioModel.getStatus());
                pstm.setBoolean(11, funcionarioModel.getDisp());

                pstm.execute();
                pstm.close();
                JOptionPane.showMessageDialog(null, "O Cadastro foi efetuado com sucesso");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "FuncionarioController Cadastrar" + erro);

            }
        }
    }

//    //METODO PARA LISTAR
    public ArrayList<FuncionarioModel> PesquisarUsuario() {
        ArrayList<FuncionarioModel> list = new ArrayList<>();
        String sql = "select * from usuario where disp = 1";
        conexao = new ConexaoController().conectaBaseDados();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioModel funcionarioModel = new FuncionarioModel();
                funcionarioModel.setIdFuncionario(rs.getInt("idFuncionario")); // Confirme se o nome da coluna está correto
                funcionarioModel.setNome(rs.getString("nome"));
                funcionarioModel.setApelido(rs.getString("apelidoFuncionario"));
                funcionarioModel.setNaturalidade(rs.getString("naturalidadeFuncionario"));
                funcionarioModel.setDataNascimento(rs.getString("dataNascimentoFuncionario"));
                funcionarioModel.setEmail(rs.getString("emailFuncionario"));
                funcionarioModel.setFuncaoFuncionario(rs.getString("funcaoFuncionario"));
                funcionarioModel.setNome(rs.getString("nomeUsuario"));
                funcionarioModel.setSenhaFuncionario(rs.getString("senhaUsuario"));
                funcionarioModel.setPerfilDeAcesso(rs.getString("perfil"));

                // Verifique se estas colunas existem e têm o nome correto na tabela
                funcionarioModel.setStatus(rs.getBoolean("activo")); // Corrigir o nome da coluna
                funcionarioModel.setDisp(rs.getBoolean("disp")); // Corrigir o nome da coluna

                list.add(funcionarioModel);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioController Pesquisar" + erro);
        }
        return list;
    }

//Metodo para actualizar usuarios
    public void ActualizarUsuario(FuncionarioModel funcionarioModel) {
//        String sql = "update usuario set nome = ?, apelidoFuncionario = ?, naturalidadeFuncionario = ?, dataNascimentoFuncionario = ?, emailFuncionario = ?, funcaoFuncionario = ?, nomeUsuario = ?, senhaUsuario = ?, perfil = ?, activo = ?, disp = ? where idFuncionario = ?";
        String sql = "UPDATE usuario SET nome = ?,apelidoFuncionario = ?, naturalidadeFuncionario = ?, dataNascimentoFuncionario = ?, emailFuncionario = ?, funcaoFuncionario = ?, nomeUsuario = ?, senhaUsuario = ?, perfil = ?, activo = ?, disp = ? WHERE idFuncionario = ?";

        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = new ConexaoController().conectaBaseDados();
            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, funcionarioModel.getNome());
            pstm.setString(2, funcionarioModel.getApelido());
            pstm.setString(3, funcionarioModel.getNaturalidade());
            pstm.setString(4, funcionarioModel.getDataNascimento());
            pstm.setString(5, funcionarioModel.getEmail());
            pstm.setString(6, funcionarioModel.getFuncaoFuncionario());
            pstm.setString(7, funcionarioModel.getNome());
            pstm.setString(8, funcionarioModel.getSenhaFuncionario());
            pstm.setString(9, funcionarioModel.getPerfilDeAcesso());
            pstm.setBoolean(10, funcionarioModel.getStatus());
            pstm.setBoolean(11, funcionarioModel.getDisp());
            pstm.setInt(12, funcionarioModel.getIdFuncionario());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados actualizados com Sucesso.");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Funcionario Controller Atualizar Usuario: " + erro);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + erro);
            }
        }
    }

}

//    //METODO PARA LISTAR APAGADOS STATUS « NAO
//    public ArrayList<FuncionarioModel> ListarUsuarioApagados() {
//        ArrayList<FuncionarioModel> list = new ArrayList<>();
//        String sql = "select * from usuario where disp = 'Não'";
//        conexao = new ConexaoController().conectaBaseDados();
//
//        try {
//            pstm = conexao.prepareStatement(sql);
//            rs = pstm.executeQuery();
//
//            while (rs.next()) {
//                FuncionarioModel funcionarioModel = new FuncionarioModel();
//                funcionarioModel.setId(rs.getInt("idUsuario"));
//                funcionarioModel.SetNome(rs.getString("nome"));
//                funcionarioModel.setApelido(rs.getString("apelido"));
//                funcionarioModel.setNaturalidade(rs.getString("naturalidade"));
//                funcionarioModel.SetDataDeNascimento(rs.getString("dataNascimento"));
//                funcionarioModel.setEmail(rs.getString("email"));
//                funcionarioModel.setFuncaoUsuario(rs.getString("funcao"));
//                funcionarioModel.setNomeUsuario(rs.getString("nomeUsuario"));
//                funcionarioModel.setSenha(rs.getString("senhaUsuario"));
//                funcionarioModel.setPerfilDeAcesso(rs.getString("perfil"));
//                funcionarioModel.setActivo(rs.getString("activo"));
//                funcionarioModel.setDisp(rs.getString("disp"));
//
//                list.add(funcionarioModel);
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "UsuarioController Listar usuarios apagados" + erro);
//        }
//        return list;
//    }
//
//
////    public ArrayList<FuncionarioModel> ListarUsuarioApagados() {
////        ArrayList<FuncionarioModel> list = new ArrayList<>();
////        String sql = "select * from usuario where disp = 'Não'";
////        conexao = new ConexaoController().conectaBaseDados();
////
////        FuncionarioModel usuario = new FuncionarioModel();
////        if (usuario.getPerfilDeAcesso().equals("Administrador")) {
////            int resposta = JOptionPane.showMessageDialog(null, "Tem Certeza que deseja Apagar o Administrador? Depois de apaga-lo, pode não ter acesso ao sistema.");
////            if (resposta == JOptionPane.YES_OPTION) {
////                try {
////                    pstm = conexao.prepareStatement(sql);
////                    rs = pstm.executeQuery();
////
////                    while (rs.next()) {
////                        FuncionarioModel funcionarioModel = new FuncionarioModel();
////                        funcionarioModel.setId(rs.getInt("idUsuario"));
////                        funcionarioModel.SetNome(rs.getString("nome"));
////                        funcionarioModel.setApelido(rs.getString("apelido"));
////                        funcionarioModel.setNaturalidade(rs.getString("naturalidade"));
////                        funcionarioModel.SetDataDeNascimento(rs.getString("dataNascimento"));
////                        funcionarioModel.setEmail(rs.getString("email"));
////                        funcionarioModel.setFuncaoUsuario(rs.getString("funcao"));
////                        funcionarioModel.setNomeUsuario(rs.getString("nomeUsuario"));
////                        funcionarioModel.setSenha(rs.getString("senhaUsuario"));
////                        funcionarioModel.setPerfilDeAcesso(rs.getString("perfil"));
////                        funcionarioModel.setActivo(rs.getString("activo"));
////                        funcionarioModel.setDisp(rs.getString("disp"));
////
////                        list.add(funcionarioModel);
////                    }
////                } catch (SQLException erro) {
////                    JOptionPane.showMessageDialog(null, "UsuarioController Listar usuarios apagados" + erro);
////                }
////                return list;
////
////            }
////        }
////
////    }
/*
create table usuario (
    idUsuario int AUTO_INCREMENT PRIMARY KEY,
    nomeUsuario varchar(45),
    senhaUsuario varchar(45)
    );

create table usuario ( idUsuario int AUTO_INCREMENT PRIMARY KEY, nome varchar(45), apelido varchar(45), 
naturalidade varchar(45), dataNascimento varchar(45), email varchar(45), funcao varchar(45),
nomeUsuario varchar(45), senhaUsuario varchar(45), perfil varchar(45), activo varchar(45), disp varchar(45) );
 */
