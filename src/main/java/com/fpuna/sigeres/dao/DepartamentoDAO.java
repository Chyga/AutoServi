package com.fpuna.sigeres.dao;

import com.fpuna.sigeres.modelo.Ciudades;
import com.fpuna.sigeres.modelo.Departamentos;
import java.util.List;


public interface DepartamentoDAO extends GenericDAO<Departamentos>{
    public List<Ciudades> cityById(Departamentos _id);
}
