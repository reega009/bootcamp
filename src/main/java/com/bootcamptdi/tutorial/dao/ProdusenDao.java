package com.bootcamptdi.tutorial.dao;


import com.bootcamptdi.tutorial.dto.ProdukDTO;
import com.bootcamptdi.tutorial.dto.ProdusenDTO;
import com.bootcamptdi.tutorial.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdusenDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Produsen> findAll(){
        String query = "SELECT id, nama, kode, alamat\n" +
                "FROM public.produsen;\n";
        return jdbcTemplate.query(query, new RowMapper<Produsen>() {
            @Override
            public Produsen mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("id"));
                produsen.setName(rs.getString("nama"));
                produsen.setKode(rs.getString("kode"));
                produsen.setAlamat(rs.getString("alamat"));
                return produsen;
            }
        });
    }

    public Optional<Produsen> findById(Integer id){
        String query = "select id ,nama , kode, alamat from produsen\n" +
                "where id = :idProdusen";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idProdusen", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<Optional<Produsen>>() {
            @Override
            public Optional<Produsen> mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("id"));
                produsen.setName(rs.getString("nama"));
                produsen.setKode(rs.getString("kode"));
                produsen.setAlamat(rs.getString("alamat"));
                return Optional.of(produsen);
            }
        });
    }

    public ProdusenDTO.Save save(ProdusenDTO.Save produsen){
        String query = "INSERT INTO public.produsen\n" +
                "(nama, kode, alamat)\n" +
                "VALUES(:name, :kode, :alamat);\n";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", produsen.getName());
        map.addValue("kode", produsen.getKode());
        map.addValue("alamat", produsen.getAlamat());
        jdbcTemplate.update(query, map);
        return produsen;
    }

    public ProdusenDTO.Update update(ProdusenDTO.Update produsen){
        String query = "UPDATE public.produsen\n" +
                "SET nama=:name, kode=:kode, alamat=:alamat\n" +
                "WHERE id=:id ;\n";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", produsen.getId());
        map.addValue("name", produsen.getName());
        map.addValue("kode", produsen.getKode());
        map.addValue("alamat", produsen.getAlamat());
        jdbcTemplate.update(query, map);
        return produsen;
    }

    public void delete(Integer id){
        String query = "DELETE FROM public.produsen\n" +
                "WHERE id=:id;\n";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query, map);
    }

}
