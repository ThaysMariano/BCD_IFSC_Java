package exemplo03;
import exemplo02.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsandoPreparedStmt {

        private final String DIVISOR = "---------------------------------------------------------------------------------\n";

    public String listarPessoas() throws SQLException {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT * FROM Pessoa";
        try (Connection conexao = ConnectionFactory.getDBConnection();
             PreparedStatement stmt = conexao.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (!rs.next()) {
                sb.append("\nNenhuma pessoa cadastrada no banco\n");
            } else {
                sb.append(DIVISOR);
                sb.append(String.format("|%-5s|%-25s|%-10s|%-10s|%-25s|\n", "ID", "Nome", "Peso", "Altura", " Email"));
                        sb.append(DIVISOR);
                do {
                    sb.append(String.format("|%-5d|%-25s|%-10.2f|%-10d|%-25s|\n",
                            rs.getInt("idPessoa"),
                            rs.getString("Nome"),
                            rs.getDouble("peso"),
                            rs.getInt("altura"),
                            rs.getString("email")));
                } while (rs.next());
                sb.append(DIVISOR);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return sb.toString();
    }

    public String listarDadosDeUmaPessoa(int idPessoa) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT * FROM Pessoa WHERE idPessoa = ?";
        try (Connection conexao = ConnectionFactory.getDBConnection();
             PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, idPessoa);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                sb.append("\nNenhuma pessoa cadastrada no banco\n");
            } else {
                sb.append(DIVISOR);
                sb.append(String.format("|%-5s|%-25s|%-10s|%-10s|%-25s|\n", "ID", "Nome", "Peso", "Altura", " Email"));
                        sb.append(DIVISOR);
                do {
                    sb.append(String.format("|%-5d|%-25s|%-10.2f|%-10d|%-25s|\n",
                            rs.getInt("idPessoa"),
                            rs.getString("Nome"),
                            rs.getDouble("peso"),
                            rs.getInt("altura"),
                            rs.getString("email")));
                } while (rs.next());
                sb.append(DIVISOR);
            }
            rs.close();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return sb.toString();
    }

    public int atualizaEmail(int idPessoa, String email) throws SQLException {
        int totalLinhasModificadas = 0;
        String query = "UPDATE Pessoa SET Email = ? WHERE idPessoa = ?";
        try (Connection conexao = ConnectionFactory.getDBConnection();
             PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setInt(2, idPessoa);
            totalLinhasModificadas = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return totalLinhasModificadas;
    }








}
