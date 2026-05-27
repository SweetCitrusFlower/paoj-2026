package com.pao.project.repository;

import com.pao.project.model.CategorieProdus;
import com.pao.project.model.Ingredient;
import com.pao.project.model.Produs;
import com.pao.project.util.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdusRepository implements Repository<Produs, Long>{
    private Connection getConn() throws SQLException, IOException {
        return DatabaseConnection.getInstance().getConnection();
    }

    private Produs mapRow(ResultSet rs) throws SQLException {
        long produsId = rs.getLong("id");
        
        try {
            List<Ingredient> list = this.ListaIngredienteByProdusId(produsId);
            Produs a = new Produs(rs.getString("denumire"), 
                                rs.getDouble("pret"), 
                                CategorieProdus.valueOf(rs.getString("categorie")), 
                                list);
            a.setId(rs.getLong("id"));
            return a;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    private List<Ingredient> ListaIngredienteByProdusId(long id) throws SQLException{
        String sql = "SELECT * FROM ingredient ing " + 
                        "JOIN produs_ingredient pr_ing on pr_ing.ingredient_id = ing.id " +
                        "WHERE pr_ing.produs_id = " + Long.toString(id) +  
                        " ORDER BY pr_ing.produs_id";
        List<Ingredient> list = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                list.add(IngredientRepository.mapRow(rs));
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public List<Produs> findAll() throws SQLException {
        String sql = "SELECT * FROM produs ORDER BY id";
        List<Produs> list = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return list;
    }
    @Override
    public void save(Produs entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    @Override
    public Optional<Produs> findById(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public void update(Produs entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
