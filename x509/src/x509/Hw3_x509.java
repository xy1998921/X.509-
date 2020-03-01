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
            System.out.println("�汾��: " + x509.getVersion()) ;
            System.out.println("���к�: " + x509.getSerialNumber()) ;
            System.out.println("ʹ�õ�ǩ���㷨��"+ x509.getSigAlgName()) ;
            System.out.println("�䷢��: "+ x509.getIssuerDN()) ;
            System.out.println("��Ч��ʼ���ڣ�"+ x509.getNotBefore()) ;
            System.out.println("��Ч��ֹ���ڣ�"+ x509.getNotAfter()) ;
            System.out.println("�������ƣ�"+ x509.getSubjectDN()) ;
            System.out.println("֤��ǩ����"+ x509.getSignature()) ;
            PublicKey key = x509.getPublicKey() ;
            byte [] Key_encode = key.getEncoded() ;  
            System.out.print("��Կ: ") ;
            for(int i = 0 ; i < Key_encode.length ; i++) {
                System.out.print(Key_encode[i]+",");
            }
        }
        catch (CertificateException e) {
			e.printStackTrace();
		}
    }
};