package au.org.emii.wps;

import org.geotools.process.ProcessException;
import org.geoserver.wps.gs.GeoServerProcess;
import org.geoserver.wps.process.RawData;
import org.geotools.process.factory.DescribeProcess;
import org.geotools.process.factory.DescribeResult;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

@DescribeProcess(title="Notifier", description="Notify subscribers when a WPS process completes")
public class NotifierProcess implements GeoServerProcess {
    private static final Logger logger = LoggerFactory.getLogger(NotifierProcess.class);

    @DescribeResult(name="result", description="NetCDF file", meta={"mimeTypes=application/x-netcdf"})
    public RawData execute(
        // @DescribeParameter(name="layer", description="WFS layer to query")
        // String layer,
        // @DescribeParameter(name="subset", description="Subset, semi-colon separated")
        // String subset,
        // ProgressListener progressListener
        ) throws ProcessException {

        logger.error("Hello world");

        return new RawData() {
            public String getMimeType() {
                return "text/plain";
            }

            public InputStream getInputStream() throws IOException {
                return new ByteArrayInputStream("wps result FTW".getBytes(java.nio.charset.StandardCharsets.UTF_8));
            }

            public String getFileExtension() {
                return "txt";
            }
        };
    }
}
