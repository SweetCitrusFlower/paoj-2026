package com.pao.project.repository;

import com.pao.project.model.Adresa;
import com.pao.project.model.Angajat;
import com.pao.project.model.Client;
import com.pao.project.model.Comanda;
import com.pao.project.model.Produs;
import com.pao.project.util.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ComandaRepository implements Repository<Comanda, Long>{

    private Connection getConn() throws SQLException, IOException {
        return DatabaseConnection.getInstance().getConnection();
    }

    Comanda mapRow(ResultSet rs) throws SQLException {
        AdresaRepository adrRepo = new AdresaRepository();
        ProdusRepository prRepo = new ProdusRepository();
        AngajatRepository angRepo = new AngajatRepository();
        ClientRepository clRepo = new ClientRepository();

        String sql = "SELECT produs_id, cantitate FROM comanda_produs com_pr WHERE com_pr.comanda_id = ?";
        Map<Produs, Integer> mapProduse = new HashMap<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql);
            ResultSet resultset = ps.executeQuery()) {
            while (resultset.next()) 
                mapProduse.put(prRepo.findById(resultset.getLong("produs_id")).stream()
                                .filter(p -> p.getClass() == Produs.class)
                                .findFirst().orElse(null), 
                                (int)resultset.getLong("cantitate"));
        } catch (IOException e) {
            throw new SQLException(e);
        }

        Comanda a = new Comanda(adrRepo.findById(rs.getLong("adresa_livrare_id")).stream()
                                .filter(p -> p.getClass() == Adresa.class)
                                .findFirst().orElse(null),

                                clRepo.findById(rs.getLong("client_id")).stream()
                                .filter(p -> p.getClass() == Client.class)
                                .findFirst().orElse(null),

                                mapProduse,

                                angRepo.findById(rs.getLong("curier_id")).stream()
                                .filter(p -> p.getClass() == Angajat.class)
                                .findFirst().orElse(null),

                                adrRepo.findById(rs.getLong("locatie_id")).stream()
                                .filter(p -> p.getClass() == Adresa.class)
                                .findFirst().orElse(null),

                                ((ResultSet)rs.getDate("data_plasare")).getTimestamp("value").toLocalDateTime()
);
        a.setId(rs.getLong("id"));
        return a;
    }

    @Override
    public void save(Comanda com) throws SQLException {
        String sql = "INSERT INTO comanda (client_id, adresa_livrare_id, curier_id, locatie_id, data_plasare, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql
               ,Statement.RETURN_GENERATED_KEYS
            )) {

            ps.setLong(1, com.getClient().getId());
            ps.setLong(2, com.getAdresaLivrare().getId()); 
            ps.setLong(3, com.getCurier().getId());
            ps.setLong(4, com.getLocatie().getId()); 
            ps.setDate(5, java.sql.Date.valueOf(com.getDataPlasare().toLocalDate()));
            ps.setString(6, com.getStatus().toString());
            ps.executeUpdate();
            // Preluam ID-ul generat automat de baza de date
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    com.setId(keys.getLong(1));
                }
            }
        } catch (IOException e) {
            throw new SQLException("Eroare la obtinerea conexiunii: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Comanda> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM comanda WHERE id = ?";
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
    public List<Comanda> findAll() throws SQLException {
        String sql = "SELECT * FROM comanda";
        List<Comanda> list = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql);
            ResultSet resultset = ps.executeQuery()) {
            while (resultset.next()) list.add(mapRow(resultset));
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public void update(Comanda com) throws SQLException {
        String sql = "UPDATE comanda SET client_id = ?, adresa_livrare_id = ?, curier_id = ?, locatie_id = ?, data_plasare = ?, status WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setLong(1, com.getClient().getId());
            ps.setLong(2, com.getAdresaLivrare().getId()); 
            ps.setLong(3, com.getCurier().getId());
            ps.setLong(4, com.getLocatie().getId()); 
            ps.setDate(5, java.sql.Date.valueOf(com.getDataPlasare().toLocalDate()));
            ps.setString(6, com.getStatus().toString());
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM comanda WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
}
