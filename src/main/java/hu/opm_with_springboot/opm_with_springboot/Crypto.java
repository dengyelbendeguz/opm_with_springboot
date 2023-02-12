package hu.opm_with_springboot.opm_with_springboot;

public class Crypto {
    private String hashing(String Password){
        return Password;
    }
    public boolean hashCompare(String InputHash, String OriginalHash){
        return true;
    }
    public String encryption(String Input){
        //aes (vagy valami psk encryption)
        return Input;
    }
}
