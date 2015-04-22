package dao;

import dbConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoObjects {
    protected PreparedStatement psINSERT;
    protected PreparedStatement psDELETE;
    protected PreparedStatement psUPDATE;
    protected PreparedStatement psREAD;
    protected PreparedStatement psREADALL;

    protected Connection conn = new DBConnection().getDBConnection();

    public void closePSifNotNULL(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void psClose() {
        closePSifNotNULL(psINSERT);
        closePSifNotNULL(psREAD);
        closePSifNotNULL(psDELETE);
        closePSifNotNULL(psUPDATE);
        closePSifNotNULL(psREADALL);
    }

}
