package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Brinquedo;
import utils.Conexao;
public class BrinquedoDAO implements DAOGenerica{
    
    private Connection conexao;
    public BrinquedoDAO() throws SQLException, ClassNotFoundException{
        this.conexao = new Conexao().abrirConexao(); 
   }

    @Override
    public void gravar(Object objeto) throws SQLException {
        
        Brinquedo brinquedo = (Brinquedo) objeto;
        
        if(brinquedo.getCodigoBrinquedo() == 0){
            this.inserir(brinquedo);
        }else{
            this.alterar(brinquedo);
        }
    }

    @Override
    public void inserir(Object objeto) throws SQLException {
        Brinquedo brinquedo = (Brinquedo) objeto;
        String sql = "insert into brinquedo values (default, ?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, brinquedo.getNomeBrinquedo());
            stmt.execute();
        }
        catch (SQLException ex) {
            throw new SQLException("Erro ao inserir brinquedo");
        }
        finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public void alterar(Object objeto) throws SQLException {
        Brinquedo brinquedo = (Brinquedo) objeto;
        String sql = "update brinquedo set nomebrinquedo = ?"
                + " where codigobrinquedo = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, brinquedo.getNomeBrinquedo());
            stmt.setInt(2, brinquedo.getCodigoBrinquedo());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao alterar brinquedo");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
       
        String sql = "select * from brinquedo where codigobrinquedo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Brinquedo brinquedo = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while(rs.next()){
                brinquedo = new Brinquedo(
                        rs.getInt("codigobrinquedo"),
                        rs.getString("nomebrinquedo"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar brinquedo");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt, rs);
        }
        
        return brinquedo;
        
    }

    @Override
    public List<Object> listar() throws SQLException {
        
        
        String sql = "select * from brinquedo";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Brinquedo brinquedo = new Brinquedo(
                        rs.getInt("codigobrinquedo"),
                        rs.getString("nomebrinquedo"));
                lista.add(brinquedo);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar brinquedo");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt, rs);
        }
        
        return lista;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        
        String sql = "delete from brinquedo"
                + " where codigobrinquedo = ?";
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        }catch (SQLException ex) {
            throw new SQLException("Erro ao excluir brinquedo");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }
    
   
}
