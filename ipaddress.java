import java.util.*;

class ipaddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip;
        String ipClass;
        System.out.println("Enter an IP address: ");
        ip = sc.next();
        ipClass = getIPClass(ip);

        String mask = "";
        int val = Integer.parseInt(ip.substring(0, ip.indexOf(".")));

        if (val >= 1 && val <= 127)
            mask = "255.0.0.0";
        else if (val >= 128 && val <= 191)
            mask = "255.255.0.0";
        else if (val >= 192 && val <= 223)
            mask = "255.255.255.0";
        else if (val >= 224 && val <= 239)
            mask = "multicast";
        else if (val >= 240 && val <= 255)
            mask = "reserved";

        System.out.println("The Subnet Mask for " + ip + " is " + mask);

        String result = "";
        int count = 0;

        mask = mask + ".";
        ip = ip + ".";

        if (!mask.equals("multicast.") && !mask.equals("reserved.")) {

            int i1, j1, i2, j2;
            int s1, s2;

            j1 = 0;
            j2 = 0;
            i1 = 0;
            i2 = 0;

            while (count <= 3) {
                while (ip.charAt(j1) != '.')
                    j1++;
                while (mask.charAt(j2) != '.')
                    j2++;
                s1 = Integer.parseInt(ip.substring(i1, j1));
                s2 = Integer.parseInt(mask.substring(i2, j2));
                int res = s1 & s2;
                result = result + Integer.toString(res) + ".";
                count++;
                j1++;
                j2++;
                i1 = j1;
                i2 = j2;
            }
        }

        System.out.println("Subnet Address is " + result.substring(0, result.length() - 1));
        System.out.println("Class of IP Address is " + ipClass);
    }

    private static String getIPClass(String ip) {
        int val = Integer.parseInt(ip.substring(0, ip.indexOf(".")));

        if (val >= 1 && val <= 126)
            return "Class A";
        else if (val >= 128 && val <= 191)
            return "Class B";
        else if (val >= 192 && val <= 223)
            return "Class C";
        else if (val >= 224 && val <= 239)
            return "Class D";
        else
            return "Class E";
    }
}

