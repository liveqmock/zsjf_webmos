package com.cattsoft.pub.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.log4j.Logger;

import com.cattsoft.pub.ReportBeanList;
import com.cattsoft.pub.exception.SysException;

public class ExcelUtil {

	private static final Logger log = Logger.getLogger(ExcelUtil.class);

	/**
	 * ����rs�е����ݣ���ָ���ļ�filePath�����ɹ�������ΪsheetName��excel�ļ�<br>
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param rs
	 * @throws SysException
	 */
	public static void Generate(String filePath, String sheetName, ReportBeanList beanList)
			throws SysException {

		OutputStream os = null;
		WritableWorkbook book = null;
		try {
			os = new FileOutputStream(filePath);

			book = Workbook.createWorkbook(os);
			WritableSheet sheet = book.createSheet(sheetName, 0);

			WritableFont wf = new WritableFont(WritableFont.COURIER, 10, WritableFont.NO_BOLD,
					false);
			WritableCellFormat wcfTitle = new WritableCellFormat(wf);
			wcfTitle.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wcfTitle.setBackground(Colour.BRIGHT_GREEN);
			wcfTitle.setAlignment(Alignment.CENTRE);

			WritableCellFormat wcfCont = new WritableCellFormat();
			wcfCont.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

			List list = beanList.getBeanList();
			String[] columnName = beanList.getColumnName();
			String[] columnLabel = beanList.getColumnLabel();

			// д�����
			for (int i = 0; i < columnName.length; i++) {

				sheet.addCell(new Label(i, 0, columnLabel[i], wcfTitle));

			}

			// д������
			int j = 1;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Map bean = (HashMap) it.next();

				for (int k = 0; k < columnName.length; k++) {

					String value = (String) bean.get(columnName[k]);
					sheet.addCell(new Label(k, j, value, wcfCont));
				}
				j++;
			}

			book.write();
			book.close();

		} catch (IOException ioe) {

			throw new SysException("", "����Workbook�쳣", ioe);
		} catch (WriteException e) {

			throw new SysException("", "д��Excel�쳣", e);
		} finally {
			try {
				os.close();
			} catch (IOException e) {

				throw new SysException("", "IO�ر��쳣", e);
			}
		}
	}

}
