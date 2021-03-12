package utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * RSA 加解密工具
 *
 */
public class RsaInstanceUtil {

  public static final String ALGORITHM = "RSA";
  public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
  public static final int PRIVATE_KEY_ENCRYPT = 1;
  public static final int PUBLIC_KEY_ENCRYPT = 2;
  public static final int PRIVATE_KEY_DECRYPT = 3;
  public static final int PUBLIC_KEY_DECRYPT = 4;
  public static final int MAX_ENCRYPT_BLOCK = 245;
  public static final int MAX_DECRYPT_BLOCK = 256;
  public static final int KEY_SIZE = 2048;


  public static final String PRIVATE_KEY = "privateKey";

  public static final String PUBLIC_KEY = "publicKey";
  /***
   *  生成密钥对
   * @return
   */
  public static Map<String,String> getRsaKeys() {
    try {
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
      keyPairGen.initialize(KEY_SIZE);
      KeyPair keyPair = keyPairGen.generateKeyPair();
      PublicKey publicKey = keyPair.getPublic();
      String publicKeyString = encodeBASE64(publicKey.getEncoded());
      PrivateKey privateKey = keyPair.getPrivate();
      String privateKeyString = encodeBASE64(privateKey.getEncoded());

      Map<String,String> map= new HashMap<>();
      map.put(PRIVATE_KEY,privateKeyString);
      map.put(PUBLIC_KEY,publicKeyString);
      return map;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }



  public static byte[] encryptByPrivateKey (byte[] content, String privateKey) {
    return encrypt(content, privateKey, PRIVATE_KEY_ENCRYPT);
  }

  public static byte[] encryptByPublicKey (byte[] content, String publicKey) {
    return encrypt(content, publicKey, PUBLIC_KEY_ENCRYPT);
  }

  public static byte[] decryptByPrivateKey (byte[] content, String privateKey) {
    return decrypt(content, privateKey, PRIVATE_KEY_DECRYPT);
  }

  public static byte[] decryptByPublicKey (byte[] content, String publicKey) {
    return decrypt(content, publicKey, PUBLIC_KEY_DECRYPT);
  }

  private static byte[] encrypt(byte[] content, String keyStr, int model) {
    try {
      Cipher cipher = Cipher.getInstance(ALGORITHM);// java默认"RSA"="RSA/ECB/PKCS1Padding"
      Key key = null;
      if (model == PRIVATE_KEY_ENCRYPT) {
        key = getPrivateKey(keyStr);
      } else {
        key = getPublicKey(keyStr);
      }
      int offset = 0;
      int i = 0;
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      cipher.init(Cipher.ENCRYPT_MODE, key);
      while (content.length > offset) {
        byte[] encryptedByte;
        if (content.length - offset > MAX_ENCRYPT_BLOCK) {
          encryptedByte = cipher.doFinal(content, offset, MAX_ENCRYPT_BLOCK);
        } else {
          encryptedByte = cipher.doFinal(content, offset, content.length - offset);
        }
        out.write(encryptedByte);
        i++;
        offset = i * MAX_ENCRYPT_BLOCK;
      }
      out.close();
      return out.toByteArray();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

    /**
     *  解密内容
     * @param content
     * @param keyStr
     * @param model
     * @return
     */
  private static byte[] decrypt(byte[] content, String keyStr, int model) {
    try {
      Cipher cipher = Cipher.getInstance(ALGORITHM);// java默认"RSA"="RSA/ECB/PKCS1Padding"
      Key key = null;
      if (model == PRIVATE_KEY_DECRYPT) {
        key = getPrivateKey(keyStr);
      } else {
        key = getPublicKey(keyStr);
      }
      cipher.init(Cipher.DECRYPT_MODE, key);

      byte[] data = content;
      int offset = 0;
      int i = 0;
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      while (data.length > offset) {
        byte[] cache;
        if (data.length - offset > MAX_DECRYPT_BLOCK) {
          cache = cipher.doFinal(data, offset, MAX_DECRYPT_BLOCK);
        } else {
          cache = cipher.doFinal(data, offset, data.length - offset);
        }
        out.write(cache, 0, cache.length);
        i++;
        offset = MAX_DECRYPT_BLOCK * i;
      }
      out.close();
      return out.toByteArray();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

   /**
   * <p>
   * 用私钥对信息生成数字签名
   * </p>
   *
   * @param data
   * @param privateKey 私钥(BASE64编码)
   *
   * @return
   * @throws Exception
   */
  public static String sign(byte[] data, String privateKey) throws Exception {
    byte[] keyBytes = decodeBase64(privateKey);
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
    PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
    Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
    signature.initSign(privateK);
    signature.update(data);
    return encodeBASE64(signature.sign());
  }

  /**
   * <p>
   * 校验数字签名
   * </p>
   *
   * @param data
   * @param publicKey 公钥(BASE64编码)
   * @param sign 数字签名
   *
   * @return
   * @throws Exception
   *
   */
  public static boolean verify(byte[] data, String publicKey, String sign)
      throws Exception {
    byte[] keyBytes = decodeBase64(publicKey);
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
    PublicKey publicK = keyFactory.generatePublic(keySpec);
    Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
    signature.initVerify(publicK);
    signature.update(data);
    return signature.verify(decodeBase64(sign));
  }

  // 将base64编码后的公钥字符串转成PublicKey实例
  public static PublicKey getPublicKey(String publicKey) throws Exception {
    byte[] keyBytes = new BASE64Decoder().decodeBuffer(publicKey);
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
    return keyFactory.generatePublic(keySpec);
  }

  // 将base64编码后的私钥字符串转成PrivateKey实例
  public static PrivateKey getPrivateKey(String privateKey) throws Exception {
    byte[] keyBytes = new BASE64Decoder().decodeBuffer(privateKey);
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
    return keyFactory.generatePrivate(keySpec);
  }

  public static String encodeBASE64(byte[] content){
    return new String(new BASE64Encoder().encode(content).getBytes()).replace("\n", "");
  }

  public static byte[] decodeBase64 (String content) throws IOException {
    return new BASE64Decoder().decodeBuffer(content);
  }



  public static void main (String[] args) throws Exception {

      Map<String,String> map = RsaInstanceUtil.getRsaKeys();


      String publicKey = map.get("publicKey");
      String privateKey = map.get("privateKey");

    /*  String content2 = "{ \"username\":\"tet\" }";
      String contentCypher2 = RsaInstanceUtil.encodeBASE64(RsaInstanceUtil.encryptByPublicKey(content2.getBytes(), publicKey));
      System.out.println("公钥加密内容  ："+contentCypher2);
      String ddd2 = new String(RsaInstanceUtil.decryptByPrivateKey(decodeBase64(contentCypher2), privateKey));
      System.out.println("私钥解密内容 ："+ddd2);
*/

    String content = "{ \"username\":\"test\" }";
    String sign = RsaInstanceUtil.sign(content.getBytes(),privateKey);
    System.out.println("私钥加签内容  ："+sign);
   boolean isTrue =  RsaInstanceUtil.verify(content.getBytes(),publicKey,sign);
    System.out.println("公钥验签内容 ："+isTrue);


  }
}
