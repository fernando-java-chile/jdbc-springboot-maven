package InterSystemIrisData.com.example.jdbc_springboot_maven.Tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TableCreatorFHIR_PACIENT_CL_1_9_2 {
    private final Connection connection;

    public TableCreatorFHIR_PACIENT_CL_1_9_2(Connection connection) {
        this.connection = connection;
    }

    /**
     * Verifica si una tabla existe en la base de datos.
     *
     * @param tableName Nombre de la tabla a verificar.
     * @return true si la tabla existe, false en caso contrario.
     */
    private boolean tableExists(String tableName) throws Exception {
        String sql = "SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(sql)) {
            checkStmt.setString(1, tableName);
            try (ResultSet rs = checkStmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    /**
     * Crea la tabla FHIR_PACIENT_CL_1_9_2 si no existe.
     */
    public void createFhirPacientTable() throws Exception {
        String tableName = "FHIR_PACIENT_CL_1_9_2";

        if (tableExists(tableName)) {
            System.out.println("La tabla '" + tableName + "' ya existe.");
            return;
        }

        String createTableSQL = """
        CREATE TABLE FHIR_PACIENT_CL_1_9_2 (
            PATIENT_ID                      INT         NOT NULL,
            ACTIVE                          CHAR(1)     DEFAULT 'Y',
            GENDER                          VARCHAR(10),
            BIRTH_DATE                      DATE,
            DECEASED_BOOLEAN                CHAR(1)     DEFAULT 'N',
            DECEASED_DATETIME               TIMESTAMP,
            NAME_FAMILY                     VARCHAR(100),
            NAME_GIVEN                      VARCHAR(100),
            NAME_PREFIX                     VARCHAR(50),
            NAME_SUFFIX                     VARCHAR(50),
            TELECOM_SYSTEM                  VARCHAR(20),
            TELECOM_VALUE                   VARCHAR(100),
            ADDRESS_LINE                    VARCHAR(200),
            ADDRESS_CITY                    VARCHAR(100),
            ADDRESS_STATE                   VARCHAR(100),
            ADDRESS_POSTAL_CODE             VARCHAR(20),
            ADDRESS_COUNTRY                 VARCHAR(100),
            MARITAL_STATUS                  VARCHAR(50),
            MULTIPLE_BIRTH_BOOLEAN          CHAR(1)     DEFAULT 'N',
            MULTIPLE_BIRTH_INTEGER          INT,
            PHOTO_URL                       VARCHAR(500),
            IDENTIDAD_GENERO_CODE           VARCHAR(50),
            IDENTIDAD_GENERO_DISPLAY        VARCHAR(100),
            SEXO_BIOLOGICO_CODE             VARCHAR(50),
            SEXO_BIOLOGICO_DISPLAY          VARCHAR(100),
            NACIONALIDAD_CODE               VARCHAR(50),
            NACIONALIDAD_DISPLAY            VARCHAR(100),
            IDENTIFIER_USE                  VARCHAR(20),
            IDENTIFIER_TYPE_CODE            VARCHAR(50),
            IDENTIFIER_TYPE_DISPLAY         VARCHAR(100),
            IDENTIFIER_VALUE                VARCHAR(100),
            NOMBRE_OFICIAL_FAMILY           VARCHAR(100),
            NOMBRE_OFICIAL_GIVEN            VARCHAR(100),
            SEGUNDO_APELLIDO                VARCHAR(100),
            NOMBRE_SOCIAL_GIVEN             VARCHAR(100),
            CONTACT_RELATIONSHIP_CODE       VARCHAR(50),
            CONTACT_RELATIONSHIP_DISPLAY    VARCHAR(100),
            CONTACT_NAME_FAMILY             VARCHAR(100),
            CONTACT_NAME_GIVEN              VARCHAR(100),
            COMMUNICATION_LANGUAGE_CODE     VARCHAR(50),
            COMMUNICATION_LANGUAGE_DISPLAY  VARCHAR(100),
            GENERAL_PRACTITIONER_REFERENCE  VARCHAR(500),
            GENERAL_PRACTITIONER_DISPLAY    VARCHAR(100),
            CREATED_DATE                    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
            LAST_UPDATED                    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
            CREATED_BY                      VARCHAR(50) DEFAULT 'SYSTEM',
            LAST_UPDATED_BY                 VARCHAR(50) DEFAULT 'SYSTEM',
            PRIMARY KEY (PATIENT_ID)
        );
        """;

        try (PreparedStatement createStmt = connection.prepareStatement(createTableSQL)) {
            createStmt.execute();
            System.out.println("Tabla '" + tableName + "' creada correctamente.");
        }
    }

}
