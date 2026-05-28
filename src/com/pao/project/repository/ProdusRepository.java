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
import java.sql.Statement;
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
        String sql = "INSERT INTO produs (denumire, pret, categorie, discount_procent, popularitate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql
                ,Statement.RETURN_GENERATED_KEYS
            )) {
            ps.setString(1, entity.getDenumire());
            ps.setDouble(2, entity.getPret());
            ps.setString(3, entity.getCategorieProdus().toString());
            ps.setDouble(4, entity.getDiscountProcent());
            ps.setInt(5, 0);
            ps.executeUpdate();
            // Preluam ID-ul generat automat de baza de date
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    entity.setId(keys.getLong(1));
                }
            }
        } catch (IOException e) {
            throw new SQLException("Eroare la obtinerea conexiunii: " + e.getMessage(), e);
        }
    }
    @Override
    public Optional<Produs> findById(Long id) throws SQLException {
        String sql = "SELECT denumire, pret, categorie, discount_procent, popularitate FROM produs WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(mapRow(rs));
                return Optional.empty();
            }
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
    @Override
    public void update(Produs entity) throws SQLException {
        String sql = "UPDATE produs SET denumire = ?, pret = ?, categorie = ?, discount_procent = ?, popularitate = ? WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, entity.getDenumire());
            ps.setDouble(2, entity.getPret());
            ps.setString(3, entity.getCategorieProdus().toString());
            ps.setDouble(4, entity.getDiscountProcent());
            ps.setInt(5, entity.getPopularitate());
            ps.setLong(6, entity.getId());
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM produs WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
}
