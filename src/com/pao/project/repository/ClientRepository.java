package com.pao.project.repository;

import com.pao.project.model.Client;
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

public class ClientRepository implements Repository<Client, Long>{

    private Connection getConn() throws SQLException, IOException {
        return DatabaseConnection.getInstance().getConnection();
    }

    static Client mapRow(ResultSet rs) throws SQLException {
        Client a = new Client(rs.getString("nume"), 
                                rs.getString("prenume"), 
                                rs.getString("nrTelefon"), 
                                rs.getString("email"), 
                                rs.getString("parola"));
        a.setId(rs.getLong("id"));
        return a;
    }

    @Override
    public void save(Client entity) throws SQLException {
        String sql = "INSERT INTO client (nume, prenume, nrTelefon, email, parola) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql
               ,Statement.RETURN_GENERATED_KEYS
            )) {
            ps.setString(1, "nume");
            ps.setString(2, "prenume"); 
            ps.setString(3, "nrTelefon"); 
            ps.setString(4, "email");
            ps.setString(5, "parola");
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
    public Optional<Client> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM client WHERE id = ?";
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
    public List<Client> findAll() throws SQLException {
        String sql = "SELECT * FROM client";
        List<Client> list = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql);
            ResultSet resultset = ps.executeQuery()) {
            while (resultset.next()) list.add(mapRow(resultset));
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public void update(Client entity) throws SQLException {
        String sql = "UPDATE client SET nume = ?, prenume = ?, nrTelefon = ?, email = ?, parola = ? WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, entity.getNume());
            ps.setString(2, entity.getPrenume()); 
            ps.setString(3, entity.getNrTelefon()); 
            ps.setString(4, entity.getEmail());
            ps.setString(5, entity.getParola());
            ps.setLong(6, entity.getId());
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

}
