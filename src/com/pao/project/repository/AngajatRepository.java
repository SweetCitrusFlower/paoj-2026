package com.pao.project.repository;

import com.pao.project.model.Angajat;
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

public class AngajatRepository implements Repository<Angajat, Long>{
    
    private Connection getConn() throws SQLException, IOException {
        return DatabaseConnection.getInstance().getConnection();
    }

    static Angajat mapRow(ResultSet rs) throws SQLException {
        Angajat a = new Angajat(rs.getString("nume"), 
                                rs.getString("prenume"),
                                rs.getString("nr_telefon"),
                                rs.getDouble("salariu"), 
                                rs.getBoolean("este_curier"));
        a.setId(rs.getLong("id"));
        return a;
    }
    @Override
    public void save(Angajat entity) throws SQLException {
        String sql = "INSERT INTO angajat (nume, prenume, nr_telefon, salariu, este_curier) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql
                ,Statement.RETURN_GENERATED_KEYS
            )) {
            ps.setString(1, entity.getNume());
            ps.setString(2, entity.getPrenume());
            ps.setString(3, entity.getNrTelefon());
            ps.setDouble(4, entity.getSalariu());
            ps.setInt(5, entity.getClass() == Angajat.class ? 0 : 1);
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
    public Optional<Angajat> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM angajat WHERE id = ?";
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
    public List<Angajat> findAll() throws SQLException {
        String sql = "SELECT * FROM angajat";
        List<Angajat> list = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql);
            ResultSet resultset = ps.executeQuery()) {
            while (resultset.next()) list.add(mapRow(resultset));
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public void update(Angajat entity) throws SQLException {
        String sql = "UPDATE angajat SET nume = ?, prenume = ?, nr_telefon = ?, salariu = ?, este_curier = ? WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, entity.getNume());
            ps.setString(2, entity.getPrenume());
            ps.setString(3, entity.getNrTelefon());
            ps.setDouble(4, entity.getSalariu());
            ps.setInt(5, entity.getClass() == Angajat.class ? 0 : 1);
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM angajat WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
}
