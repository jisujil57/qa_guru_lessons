package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@DisplayName("Проверка содержимого ZIP архива")
public class ZipTest {

    // Класс загрузчика ресурсов из JAR файла
    private static final ClassLoader CLASS_LOADER = ZipTest.class.getClassLoader();

    private static final String PDF_FILE = "testPdf.pdf";
    private static final String CSV_FILE = "testCsv.csv";
    private static final String XLSX_FILE = "testXlsx.xlsx";

    @Test
    @DisplayName("Проверка содержимого PDF файла")
    void testPdfContent() throws IOException {
        String expectedText = "съешь ещё этих мягких французских булок";

        try (InputStream inputStream = getInputStreamFromZip(PDF_FILE)) {
            PDF pdf = new PDF(inputStream);
            assertThat(pdf.text, containsString(expectedText));
            Assertions.assertEquals(1, pdf.numberOfPages);
            Assertions.assertEquals("Новый документ", pdf.title);
        }
    }

    @Test
    @DisplayName("Проверка содержимого CSV файла")
    void testCsvContent() throws Exception {
        String expectedValue = "Работник";
        String expectedValue2 = "Должность";

        try (InputStream inputStream = getInputStreamFromZip(CSV_FILE)) {
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            List<String[]> csvRows = reader.readAll();
            String actualValue = csvRows.get(0)[0];
            String actualValue2 = csvRows.get(0)[1];
            Assertions.assertEquals(expectedValue, actualValue);
            Assertions.assertEquals(expectedValue2, actualValue2);
        }
    }

    @Test
    @DisplayName("Проверка содержимого XLSX файла")
    void testXlsxContent() throws IOException {
        String expectedCellValue = "Работник";
        String expectedSheetName = "Лист1";

        try (InputStream inputStream = getInputStreamFromZip(XLSX_FILE)) {
            XLS xls = new XLS(inputStream);

            // Проверка названия листа
            String actualSheetName = xls.excel.getSheetName(0);
            Assertions.assertEquals(expectedSheetName, actualSheetName);

            // Проверка значения конкретной ячейки
            String actualCellValue = xls.excel.getSheetAt(0)
                    .getRow(0).getCell(0)
                    .getStringCellValue();
            Assertions.assertEquals(expectedCellValue, actualCellValue);
        }
    }

    // Метод для получения InputStream из ZIP файла по имени файла
    public InputStream getInputStreamFromZip(String fileName) throws IOException {
        // Открываем ZIP архив как поток данных
        ZipInputStream zipInputStream = new ZipInputStream(
                Objects.requireNonNull(CLASS_LOADER.getResourceAsStream("testedFiles.zip")));
        ZipEntry entry;
        // Перебираем все файлы внутри архива
        while ((entry = zipInputStream.getNextEntry()) != null) {
            // Если имя текущего файла совпадает с искомым именем
            if (entry.getName().equals(fileName)) {
                // Возвращаем поток для чтения этого файла
                return zipInputStream;
            }
        }
        // Если файл не найден, выбрасываем исключение
        throw new IOException("Файл " + fileName + " не найден в ZIP-архиве");
    }
}
