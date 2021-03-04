package com.projectbank.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

    import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.projectbank.model.Movimiento;

public class MovimientoExcelExporter {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Movimiento> listMovimientos;

	public MovimientoExcelExporter(List<Movimiento> listMovimientos) {
		this.listMovimientos = listMovimientos;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Movimientos");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "Cuenta", style);
		createCell(row, 1, "Cedula Titular", style);
		createCell(row, 2, "Nombre Titular", style);
		createCell(row, 3, "Fecha", style);
		createCell(row, 4, "Tipo Movimiento", style);
		createCell(row, 5, "Valor", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Movimiento movimiento : listMovimientos) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			System.out.println(movimiento);
			createCell(row, columnCount++, movimiento.getMovimientoPK().getCodigoCta(), style);
			createCell(row, columnCount++, movimiento.getMovimientoPK().getCedulaCli(), style);
			createCell(row, columnCount++,
					(movimiento.getCliente().getApellido() + " " + movimiento.getCliente().getNombre()), style);
			createCell(row, columnCount++, movimiento.getFechaMov().toString(), style);
			createCell(row, columnCount++, movimiento.getTipoMovimiento(), style);
			createCell(row, columnCount++, movimiento.getSaldo().toString(), style);

		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
