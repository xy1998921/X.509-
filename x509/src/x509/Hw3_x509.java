package x509;

import java.security.*;
import java.io.*;
import java.security.cert.*;
import java.security.cert.Certificate;
public class Hw3_x509 {
    public static void main(String args[]) throws IOException {
        CertificateFactory factory ;
        try {     	
            FileInputStream filepath = new FileInputStream("test2.cer") ;
            factory = CertificateFactory.getInstance("X.509") ;
            Certificate certificate = factory.generateCertificate(filepath);
            X509Certificate x509 = (X509Certificate)certificate ;
            filepath.close();
            System.out.println("版本号: " + x509.getVersion()) ;
            System.out.println("序列号: " + x509.getSerialNumber()) ;
            System.out.println("使用的签名算法："+ x509.getSigAlgName()) ;
            System.out.println("颁发者: "+ x509.getIssuerDN()) ;
            System.out.println("有效起始日期："+ x509.getNotBefore()) ;
            System.out.println("有效终止日期："+ x509.getNotAfter()) ;
            System.out.println("主体名称："+ x509.getSubjectDN()) ;
            System.out.println("证书签名："+ x509.getSignature()) ;
            PublicKey key = x509.getPublicKey() ;
            byte [] Key_encode = key.getEncoded() ;  
            System.out.print("公钥: ") ;
            for(int i = 0 ; i < Key_encode.length ; i++) {
                System.out.print(Key_encode[i]+",");
            }
        }
        catch (CertificateException e) {
			e.printStackTrace();
		}
    }
};