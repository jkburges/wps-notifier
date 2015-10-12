package au.org.emii.wps;

import org.geotools.process.ProcessException;
import org.geoserver.wps.gs.GeoServerProcess;
import org.geoserver.wps.process.RawData;
import org.geotools.process.factory.DescribeParameter;
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
        @DescribeParameter(name="notifiable", description="NetCDF file")
        RawData notifiableData
        ) throws ProcessException {

        return notifiableData;
    }
}
