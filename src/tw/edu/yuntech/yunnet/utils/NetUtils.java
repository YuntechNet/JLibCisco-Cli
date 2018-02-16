package tw.edu.yuntech.yunnet.utils;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

public class NetUtils {

    public static boolean isInet6Address(String address) {
        try {
            InetAddress addr = InetAddress.getByName(address);
            if(addr instanceof Inet6Address)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isInet4Address(String address) {
        try {
            InetAddress addr = InetAddress.getByName(address);
            if (addr instanceof Inet4Address)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isInetAddress(String address) {
        return isInet4Address(address) ? true : isInet6Address(address) ? true : false;
    }

}
