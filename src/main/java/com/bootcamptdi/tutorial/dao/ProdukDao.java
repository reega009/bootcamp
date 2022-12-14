package com.bootcamptdi.tutorial.dao;

import com.bootcamptdi.tutorial.dto.ProdukDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdukDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<ProdukDTO.ProdukProdusen> findAll(){
        String query = "select \n" +
                "p.id as produkId,\n" +
                "p.nama as produkNama,\n" +
                "p.jenis as produkJenis,\n" +
                "p.berat as produkBerat,\n" +
                "p2.id as produsenId,\n" +
                "p2.nama as produsenNama,\n" +
                "p2.kode as produsenkode,\n" +
                "p2.alamat as produsenAlamat\n" +
                "from produk p left join produsen p2 \n" +
                "on p.produsen_id = p2.id ";
        return jdbcTemplate.query(query, new RowMapper<ProdukDTO.ProdukProdusen>() {
            @Override
            public ProdukDTO.ProdukProdusen mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProdukDTO.ProdukProdusen produk = new ProdukDTO.ProdukProdusen();
                produk.setProdukId(rs.getInt("produkId"));
                produk.setProdukNama(rs.getString("produkNama"));
                produk.setProdukJenis(rs.getString("produkJenis"));
                produk.setProdukBerat(rs.getInt("produkBerat"));
                produk.setProdusenId(rs.getInt("produsenId"));
                produk.setProdusenNama(rs.getString("produsenNama"));
                produk.setProdusenKode(rs.getString("produsenkode"));
                produk.setProdusenAlamat(rs.getString("produsenAlamat"));
                return produk;
            }
        });
    }

    public Optional<ProdukDTO.ProdukProdusen> findById(Integer id) throws EmptyResultDataAccessException {
        String query = "select \n" +
                "p.id as produkId,\n" +
                "p.nama as produkNama,\n" +
                "p.jenis as produkJenis,\n" +
                "p.berat as produkBerat,\n" +
                "p2.id as produsenId,\n" +
                "p2.nama as produsenNama,\n" +
                "p2.kode as produsenkode,\n" +
                "p2.alamat as produsenAlamat\n" +
                "from produk p left join produsen p2 \n" +
                "on p.produsen_id = p2.id where p.id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<Optional<ProdukDTO.ProdukProdusen>>() {
            @Override
            public Optional<ProdukDTO.ProdukProdusen> mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProdukDTO.ProdukProdusen produk = new ProdukDTO.ProdukProdusen();
                produk.setProdukId(rs.getInt("produkId"));
                produk.setProdukNama(rs.getString("produkNama"));
                produk.setProdukJenis(rs.getString("produkJenis"));
                produk.setProdukBerat(rs.getInt("produkBerat"));
                produk.setProdusenId(rs.getInt("produsenId"));
                produk.setProdusenNama(rs.getString("produsenNama"));
                produk.setProdusenKode(rs.getString("produsenkode"));
                produk.setProdusenAlamat(rs.getString("produsenAlamat"));
                return Optional.of(produk);
            }
        });
    }

    public ProdukDTO.New save(ProdukDTO.New produk){
        String query = "INSERT INTO produk\n" +
                "(nama, jenis, berat, produsen_id)\n" +
                "VALUES(:nama, :jenis, :berat, :produsenId);\n";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nama", produk.getNama());
        map.addValue("jenis", produk.getJenis());
        map.addValue("berat", produk.getBerat());
        map.addValue("produsenId", produk.getProdusen());
        jdbcTemplate.update(query,map);
        return produk;
    }

    public ProdukDTO.Update update(ProdukDTO.Update produk){
        String query = "UPDATE produk\n" +
                "SET nama=:nama, jenis=:jenis, berat=:berat, produsen_id=:produsenId\n" +
                "WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", produk.getId());
        map.addValue("nama", produk.getNama());
        map.addValue("jenis", produk.getJenis());
        map.addValue("berat", produk.getBerat());
        map.addValue("produsenId", produk.getProdusen());
        jdbcTemplate.update(query,map);
        return produk;
    }

    public void delete(Integer id){
        String query = "delete from produk where id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query,map);
    }

}
