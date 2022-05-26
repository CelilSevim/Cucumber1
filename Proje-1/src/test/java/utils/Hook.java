package utils;


import io.cucumber.java.*;
import utils.ParentClass;


import java.util.ArrayList;
import java.util.Arrays;

public class Hook {


    @Before
    public void beforeHook(Scenario scenario) {
        ParentClass.writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList(scenario.getName(), "Başladı", ParentClass.getCurrentTime())));
    }

    @After
    public void afterHook(Scenario scenario) {
        if (scenario.isFailed()) {

            ParentClass.writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList(scenario.getName(), "Başarısız", ParentClass.getCurrentTime())));
        } else {
            ParentClass.writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList(scenario.getName(), "BAŞARILI", ParentClass.getCurrentTime())));
        }

        ParentClass.writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList(scenario.getName(), "BİTTİ", ParentClass.getCurrentTime())));
    }

    @BeforeAll
    public static void beforeAll() {
        ParentClass.writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("SCENARIO ADI", "SENARYO DURUMU", "TARİH VE SAAT")));
    }

    @AfterAll
    public static void afterAll() {

        ParentClass.writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("TEST BİTTİ", "", ParentClass.getCurrentTime())));
    }
}
