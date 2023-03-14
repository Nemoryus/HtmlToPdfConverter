import com.ironsoftware.ironpdf.License;
import com.ironsoftware.ironpdf.PdfDocument;
import com.ironsoftware.ironpdf.Settings;
import com.ironsoftware.ironpdf.exception.IronPdfNativeException;

import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * Created by Nemoryus 14.3.2023
 *
 * Trieda popisujúca rôzne metódy na konvertovanie do PDF.
 */

public class Convertor {
    private String ironPdfLicenseKey = "IRONPDF.JAVA.2199-FB0B00A868-CF7EZH4BE3CSG-LMGAMZGGIL5M-H2TRFK55EWI5-YWBMFKOW3TGM-BHAQWQGREAM2-CGKLXU-T5KF6NXPDVWJEA-DEPLOYMENT.TRIAL-BRXB67.TRIAL.EXPIRES.10.APR.2023";
    private String ironPdfLogLocation = "ironpdfengine.log";
    private String webPagePrefix = "https://";
    private String storageLocationSuffix = ".pdf";
    private PdfDocument myPdf;

    public Convertor() {
        setLogLocationAndLicenseKey();
    }


    /**
     * Metóda na konvertovanie URL adresy do PDF.
     * (IronPdf library)
     */
    public void convertFromUrlToPdf(String pWebPageName, String pStorageLocation) throws IronPdfNativeException,IOException {
        myPdf = PdfDocument.renderUrlAsPdf(webPagePrefix+pWebPageName);
        myPdf.saveAs(Paths.get(pStorageLocation+storageLocationSuffix));
    }

    /**
     * Metóda na konvertovanie HML súboru do PDF.
     * (IronPdf library)
     * (možné rozšírenie funkcionality)
     */
    public void convertFromHtmlFileToPdf(String pHtlmFileLocation, String pStorageLocation) throws IronPdfNativeException,IOException {
        myPdf = PdfDocument.renderHtmlFileAsPdf(pHtlmFileLocation);
        myPdf.saveAs(Paths.get(pStorageLocation+storageLocationSuffix));
    }

    /**
     * Základná konfigurácia pre IronPdf.
     */
    public void setLogLocationAndLicenseKey(){
        Settings.setLogPath(Paths.get(ironPdfLogLocation));
        License.setLicenseKey(ironPdfLicenseKey);
    }
}
