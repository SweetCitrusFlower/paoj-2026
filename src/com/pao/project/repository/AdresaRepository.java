package com.pao.project.repository;

import com.pao.project.model.Adresa;
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

public class AdresaRepository implements Repository<Adresa, Long>{
    
    private Connection getConn() throws SQLException, IOException {
        return DatabaseConnection.getInstance().getConnection();
    }

    static Adresa mapRow(ResultSet rs) throws SQLException {
        Adresa a = new Adresa(rs.getString("nume_strada"), 
                                rs.getInt("nr_strada"),
                                rs.getInt("cod_postal"),
                                rs.getInt("nr_apartament"));
        a.setId(rs.getLong("id"));
        return a;
    }
    @Override
    public void save(Adresa entity) throws SQLException {
        String sql = "INSERT INTO adresa (nume_strada, nr_strada, cod_postal, nr_apartament) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql
                ,Statement.RETURN_GENERATED_KEYS
            )) {
            ps.setString(1, entity.getNumeStrada());
            ps.setInt(2, entity.getNrStrada());
            ps.setInt(3, entity.getCodPostal());
            ps.setInt(4, entity.getNrApartament());
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
    public Optional<Adresa> findById(Long id) throws SQLException {
        String sql = "SELECT nume_strada, nr_strada, cod_postal, nr_apartament FROM Adresa WHERE id = ?";
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
    public List<Adresa> findAll() throws SQLException {
        String sql = "SELECT * FROM Adresa";
        List<Adresa> list = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql);
            ResultSet resultset = ps.executeQuery()) {
            while (resultset.next()) list.add(mapRow(resultset));
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public void update(Adresa entity) throws SQLException {
        String sql = "UPDATE adresa SET nume_strada = ?, nr_strada = ?, cod_postal = ?, nr_apartament = ? WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, entity.getNumeStrada());
            ps.setInt(2, entity.getNrStrada());
            ps.setInt(3, entity.getCodPostal());
            ps.setInt(4, entity.getNrApartament());
            ps.setLong(5, entity.getId());
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM adresa WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
}
