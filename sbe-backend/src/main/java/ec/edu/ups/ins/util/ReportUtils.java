package ec.edu.ups.ins.util;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class ReportUtils {


    private final DataSource dataSource;

    public ReportUtils(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public byte[] getReport(InputStream inputStream, Map<String, Object> params, ReportType type) {
        try {
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            SimpleOutputStreamExporterOutput output = new SimpleOutputStreamExporterOutput(byteArray);
            JasperPrint report = generateReport(inputStream, params);

            Exporter exporter = getExporter(type, report, byteArray);
            exporter.exportReport();

            output.close();

            return byteArray.toByteArray();
        } catch (JRException e) {
            Logger.getLogger(ReportUtils.class.getName()).severe(e.getMessage());
        }
        return null;
    }

    private Exporter getExporter(ReportType type, JasperPrint report, ByteArrayOutputStream byteArray) {
        Exporter exporter = null;
        if (type == ReportType.XLS) {
            exporter = new JRXlsExporter();
        } else if (type == ReportType.XLSX) {
            exporter = new JRXlsxExporter();
        } else if (type == ReportType.CSV) {
            exporter = new JRCsvExporter();
        } else {
            exporter = new JRPdfExporter();
        }

        exporter.setExporterInput(new SimpleExporterInput(report));

        ExporterOutput exporterOutput = switch (type) {
            case CSV -> new SimpleWriterExporterOutput(byteArray);
            case PDF, XLS, XLSX -> new SimpleOutputStreamExporterOutput(byteArray);
        };

        exporter.setExporterOutput(exporterOutput);
        return exporter;
    }

    private JasperPrint generateReport(InputStream jrxmlInputStream, Map<String, Object> params) {
        try {
            Connection connection = dataSource.getConnection();

            // Compila el informe Jasper desde el InputStream
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInputStream);

            JasperPrint report = JasperFillManager.fillReport(jasperReport, params, connection);

            connection.close();

            return report;
        } catch (JRException | SQLException e) {
            Logger.getLogger(ReportUtils.class.getName()).severe(e.getMessage());
        }
        return null;
    }
}
