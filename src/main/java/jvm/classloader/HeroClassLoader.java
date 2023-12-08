package jvm.classloader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.nio.file.FileSystem;

public class HeroClassLoader extends ClassLoader{
    private String classPath;

    public HeroClassLoader(String classPath){
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //输入流，通过类的全限定名称加载文件到字节数组
        byte[] classDate = getData(name);
        if (classDate != null) {
            //defineClass方法将字节数组数据 转为 字节码对象
            return defineClass(name, classDate, 0, classDate.length);
        }
        return super.findClass(name);
    }

    private byte[] getData(String className){
        String path = classPath + File.separator + className.replace(".", File.separator) + ".class";
        try (InputStream in = new FileInputStream(path);
             ByteOutputStream out = new ByteOutputStream()){
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
