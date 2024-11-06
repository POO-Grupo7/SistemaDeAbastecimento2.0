package Controller;

import Model.HidrometroModel;
import Model.HidrometroModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HidrometroController {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<HidrometroModel> lista = new ArrayList<>();

    //Metodo que verifia a existencia de um Hidrometro com mesmos dados
    public boolean hidrometroExiste(String dataRegisto, String nrHidrometro) {
        conexao = new ConexaoController().conectaBaseDados();
        String sql = "SELECT COUNT(*) FROM hidrometro WHERE dataRegisto = ? OR numeroHidrometro = ?";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, dataRegisto);
            pstm.setString(2, nrHidrometro);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "HidrometroController hidrometroExiste" + erro);
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
                JOptionPane.showMessageDialog(null, "HidrometroController hidrometroExiste (finally)" + erro);
            }
        }
        return false;
    }

    // Metodo de cadastro
    public void cadastrarHidrometro(HidrometroModel hidrometroModel) {
        if (hidrometroExiste(hidrometroModel.getDataRegisto(), hidrometroModel.getNrHidrometro())) {
            JOptionPane.showMessageDialog(null, "O Hidrometro ja existe!");
        } else {
            String sql = "INSERT INTO hidrometro (dataRegisto , numeroHidrometro , estado , apagado) VALUES (?,?,?,?)";

            conexao = new ConexaoController().conectaBaseDados();

            try {
                pstm = conexao.prepareStatement(sql);

                pstm.setString(1, hidrometroModel.getDataRegisto());
                pstm.setString(2, hidrometroModel.getNrHidrometro());
                pstm.setString(3, hidrometroModel.getEstado());
                pstm.setBoolean(4, hidrometroModel.getApagado());

                pstm.execute();
                pstm.close();

                JOptionPane.showMessageDialog(null, "O Cadastro foi efetuado com sucesso");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar hidrometro: " + erro.getMessage());
            }
        }
    }

    // pesquisar hidrometro 
    public ArrayList<HidrometroModel> listarHidrometro() {
        String sql = "SELECT * FROM hidrometro WHERE apagado = 0";  // Ajustado para boolean

        conexao = new ConexaoController().conectaBaseDados();

        try {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados falhou.");
                return lista;
            }

            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                HidrometroModel hidrometroModel = new HidrometroModel();
                hidrometroModel.setIdHidrometro(rs.getInt("idHidrometro"));
                hidrometroModel.setDataRegisto(rs.getString("dataRegisto"));
                hidrometroModel.setNrHidrometro(rs.getString("numeroHidrometro"));
                hidrometroModel.setEstado(rs.getString("estado"));
                hidrometroModel.setApagado(rs.getBoolean("apagado"));

                lista.add(hidrometroModel);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar hidrometro: " + erro.getMessage());
            erro.printStackTrace();  // Para depurar o erro
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
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return lista;
    }

    //Metodo para actualizar hidrometro
    public void actualizarHidrometro(HidrometroModel hidrometroModel) {
        String sql = "update hidrometro set dataRegisto = ?, numeroHidrometro = ?, estado = ?, apagado = ? where idHidrometro = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = new ConexaoController().conectaBaseDados();
            pstm = conexao.prepareStatement(sql);

            // Ordem correta dos parâmetros de acordo com o SQL
            pstm.setString(1, hidrometroModel.getDataRegisto());            // nomeHidrometro
            pstm.setString(2, hidrometroModel.getNrHidrometro());          // bairro
            pstm.setString(3, hidrometroModel.getEstado());;        // activo
            pstm.setBoolean(4, hidrometroModel.getApagado());
            pstm.setInt(5, hidrometroModel.getIdHidrometro());// disp

            pstm.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Hidrometro Controller Atualizar Hidrometro: " + erro);
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


/*

create table hidrometro ( idHidrometro int AUTO_INCREMENT PRIMARY KEY, dataRegisto varchar(45), numeroHidrometro varchar(45),
 estado tinyint, apagado tinyint);

create table hidrometro ( idHidrometro int AUTO_INCREMENT PRIMARY KEY, dataRegisto Date, numeroHidrometro varchar(45), estado varchar(45), apagado tinyint);


 */
