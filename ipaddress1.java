import java.util.Scanner;

class ipddress1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ipAddress = scanner.nextLine();
        scanner.close();

        String[] ipParts = ipAddress.split("\\.");
        int firstOctet = Integer.parseInt(ipParts[0]);

        String ipClass;
        String subnetMask;

        if (firstOctet >= 1 && firstOctet <= 126) {
            ipClass = "Class A";
            subnetMask = "255.0.0.0";
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            ipClass = "Class B";
            subnetMask = "255.255.0.0";
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            ipClass = "Class C";
            subnetMask = "255.255.255.0";
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            ipClass = "Class D";
            subnetMask = "Multicast";
        } else {
            ipClass = "Class E";
            subnetMask = "Reserved";
        }

        System.out.println("Class of IP Address is " + ipClass);
        System.out.println("The Subnet Mask for " + ipAddress + " is " + subnetMask);
    }
}
