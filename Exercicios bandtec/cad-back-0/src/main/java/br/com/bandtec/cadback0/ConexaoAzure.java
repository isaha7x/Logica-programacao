package br.com.bandtec.cadback0;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConexaoAzure {

        public BasicDataSource dataSource;

        public ConexaoAzure() {

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:sqlserver://srvgrupo3b.database.windows.net:1433;user=usergrupo3b;password=#Gfgrupo3b;databaseName=bdgrupo3b");

        }

        public BasicDataSource getDataSource() {
            return this.dataSource;
        }

    }

}
