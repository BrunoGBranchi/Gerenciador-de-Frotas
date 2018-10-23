package org.controlefrota;

import org.controlefrota.dao.DaoFactory;
import org.controlefrota.dao.JDBCFactory;

public enum TipoPersistencia {

	BANCO(new JDBCFactory());
	
	TipoPersistencia(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	private DaoFactory daoFactory;

	public DaoFactory createFactory() {
		return daoFactory;
	}
}
