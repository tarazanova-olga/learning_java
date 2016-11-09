package soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("82.208.99.193");
        assertEquals(geoIP.getCountryCode(), "RUS");
    }

    @Test
    public void testMyInvalideIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("86.208.99.194");
        assertEquals(geoIP.getCountryCode(), "RUS");
    }
}
