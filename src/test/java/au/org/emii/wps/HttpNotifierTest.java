package au.org.emii.wps;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import org.geotools.data.ows.SimpleHttpClient;
import org.geotools.data.ows.HTTPClient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HttpNotifierTest {

    @Test
    public void testNotifyMakeHttpRequest() throws IOException {
        HTTPClient httpClient = mock(SimpleHttpClient.class);
        HttpNotifier notifier = new HttpNotifier(httpClient);

        URL notificationUrl = new URL("http://notifiee");
        URL wpsServiceUrl = new URL("http://notifier");
        String id = "1234";

        String notificationParams = "foo=bar";

        notifier.notify(notificationUrl, wpsServiceUrl, id, notificationParams);

        URL expectedUrl = new URL("http://notifiee?server=http%3A%2F%2Fnotifier&uuid=1234&foo=bar");
        verify(httpClient).get(expectedUrl);
    }
}
