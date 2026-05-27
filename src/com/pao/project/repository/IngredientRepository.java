package com.pao.project.repository;

import com.pao.project.model.CategorieIngredient;
import com.pao.project.model.Ingredient;
import com.pao.project.util.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


class IngredientRepository implements Repository<Ingredient, Long>{
    private Connection getConn() throws SQLException, IOException {
        return DatabaseConnection.getInstance().getConnection();
    }

    static Ingredient mapRow(ResultSet rs) throws SQLException {
        Ingredient a = new Ingredient(rs.getString("nume"), 
                                        CategorieIngredient.valueOf(rs.getString("categorie")),
                                    rs.getInt("stoc"));
        a.setId(rs.getLong("id"));
        return a;
    }
    @Override
    public void save(Ingredient entity) throws SQLException {
        String sql = "INSERT INTO ingredient (nume, categorie, stoc) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql
            //    ,Statement.RETURN_GENERATED_KEYS
            )) {
            ps.setString(1, entity.getNume());
            ps.setString(2, entity.getCategorieIngredient().toString());
            ps.setInt(3, entity.getStoc());
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
    public Optional<Ingredient> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM ingredient WHERE id = ?";
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
    public List<Ingredient> findAll() throws SQLException {
        String sql = "SELECT * FROM ingredient";
        List<Ingredient> list = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql);
            ResultSet resultset = ps.executeQuery()) {
            while (resultset.next()) list.add(mapRow(resultset));
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public void update(Ingredient entity) throws SQLException {
        String sql = "UPDATE ingredient SET nume = ?, categorie = ?, stoc = ? WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, entity.getNume());
            ps.setString(2, entity.getCategorieIngredient().toString());
            ps.setInt(3, entity.getStoc());
            ps.setLong(4, entity.getId());
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM ingredient WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

}
